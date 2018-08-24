package com.demo.gyb.service;

import com.demo.gyb.constant.FirmwareConstant;
import com.demo.gyb.dao.device.GatewayInfoMapper;
import com.demo.gyb.dao.firmware.FirmwareInfoMapper;
import com.demo.gyb.dao.firmware.FirmwareUpdateMapper;
import com.demo.gyb.entity.device.GatewayInfo;
import com.demo.gyb.entity.device.NetworkGateway;
import com.demo.gyb.entity.firmware.FirmwareInfo;
import com.demo.gyb.entity.firmware.FirmwareUpdate;
import com.demo.gyb.storage.ChannelManage;
import com.demo.gyb.storage.FirmwareSocketMgr;
import com.demo.gyb.util.CRCUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 固件升级的实现类
 * @author jianglong
 *2018年1月16日
 * Mod 20180821 GYB
 */
@Service(value="firmwareUpdateService")
public class FirmwareUpdateService {
	@Autowired
	GatewayInfoMapper gatewayInfoMapper;
	@Autowired
	FirmwareUpdateMapper firmwareUpdateMapper;
	@Autowired
	FirmwareInfoMapper firmwareInfoMapper;

	Logger logger =  Logger.getLogger("firmware");
	private Base64 base64 = new Base64();

	public void handleMessage(String strRecv,String msgType,String uuid){
		switch (msgType) {
			case FirmwareConstant.IOT_FIRMWARE_MSG_TYPE_R30002:
				handleMsgTypeF30002(strRecv,uuid);
				break;
			case FirmwareConstant.IOT_FIRMWARE_MSG_TYPE_Q30002:
				handleMsgTypeQF30002(strRecv,uuid);
				break;
			case FirmwareConstant.IOT_FIRMWARE_MSG_TYPE_R30003:
				handleMsgTypeF30003(strRecv,uuid);
				break;
			case FirmwareConstant.IOT_FIRMWARE_MSG_TYPE_Q30003:
				handleMsgTypeQF30003(strRecv,uuid);
				break;
			case FirmwareConstant.IOT_FIRMWARE_MSG_TYPE_R30004:
				handleMsgTypeF30004(strRecv,uuid);
				break;
			default:
				break;
		}
	}
	/**
	 * 固件登录
	 */
	public void login(ChannelHandlerContext ctx, String strRecv){
		JSONObject result = new JSONObject();
		try{
			result.put("res_type", FirmwareConstant.IOT_FIRMWARE_RES_TYPE_F30001);
			result.put("res_time", (int)(System.currentTimeMillis()/1000));
			JSONObject json = new JSONObject(strRecv);
			if(!json.has("m") || !json.has("d") || !json.has("b") || !json.has("n") || !json.has("v")){
				result.put("c", FirmwareConstant.IOT_FIRMWARE_RES_ERROR_CODE_2);
			}else{
//				String token = json.getString("n");
				String macId = json.getString("m");
				int deviceType = json.getInt("d");
				int build = json.getInt("b");
				Integer msgVer = null;
				if(json.has("msg_ver")){
					msgVer = json.getInt("msg_ver");
				}else{
					result.put("c", FirmwareConstant.IOT_FIRMWARE_RES_ERROR_CODE_2);
					netMsgEnterLogin(ctx,result.toString());
					return;
				}
//				if(FirmwareSocketMgr.firmwareSignToken.containsKey(macId+","+deviceType+","+msgVer)){
//					String mapToken = FirmwareSocketMgr.firmwareSignToken.get(macId+","+deviceType+","+msgVer);
					Integer version = json.getInt("v");
					Map<String,Object> param = new HashMap<String,Object>();
					param.put("gateMacId", macId);
					GatewayInfo gatewayInfo = gatewayInfoMapper.queryByMacId(macId);
					if(null == gatewayInfo){
						result.put("c", FirmwareConstant.IOT_FIRMWARE_RES_ERROR_CODE_6);
					}else{
						//判断当前设备是否真的需要升级
						if(msgVer.intValue() <= FirmwareConstant.IOT_FIRMWARE_MSG_VER_MAX && msgVer.intValue() >= FirmwareConstant.IOT_FIRMWARE_MSG_VER_MIN){
							FirmwareUpdate firmwareUpdate = firmwareUpdateMapper.queryByMacId(macId);
							if(null == firmwareUpdate || firmwareUpdate.getVersion().intValue() == version.intValue()){
								result.put("u", 0);
								netMsgEnterLogin(ctx,result.toString());
								return;
							}
						}
						int time = (int)(System.currentTimeMillis()/1000);
						result.put("n", macId+","+deviceType+","+msgVer+","+time);
						ChannelManage channelManage = new ChannelManage();
						channelManage.setChannel(ctx);
						channelManage.setMsgVer(msgVer);
						channelManage.setBuild(build);
						channelManage.setVersion(version);
						channelManage.setDeviceType(deviceType);
						channelManage.setUuid(ctx.channel().id().asShortText());
						channelManage.setNetworkId(gatewayInfo.getNetworkId());
						FirmwareSocketMgr.update_channelIdToMacId.put(ctx.channel().id().asShortText(), macId);
						FirmwareSocketMgr.addUpdateOneSocketContext(macId, channelManage);
						FirmwareSocketMgr.updateFirmwareTimeMap.put(macId, System.currentTimeMillis());
						logger.info("macId:"+macId+"已登录,对应的uuid:"+ctx.channel().id().asShortText());
					}

//				}else{
//					result.put("c", FirmwareConstant.IOT_FIRMWARE_RES_ERROR_CODE_7);
//				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("固件登录失败,原因:"+e);
			result.put("c", FirmwareConstant.IOT_FIRMWARE_RES_ERROR_CODE_1);
		}
		netMsgEnterLogin(ctx,result.toString());
	}
	/**
	 * 返回给固件的信息(登录用)
	 */
	public void netMsgEnterLogin(ChannelHandlerContext ctx,String strMsg) {
		String length = String.format("%4d", strMsg.length()).replace(" ", "0");
		strMsg = length + strMsg;
		logger.info("返回给固件的信息:"+strMsg);
		try{
			if(ctx != null && ! ctx.isRemoved()){
				ByteBuf b = ctx.alloc().buffer(1024*100);
				b.writeBytes(strMsg.getBytes());
				ctx.writeAndFlush(b);
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error("返回给固件信息失败,原因:"+e);
		}
	}
	/**
	 * 固件请求升级文件头信息
	 */
	public void handleMsgTypeF30002(String strRecv,String uuid){
		JSONObject result = new JSONObject();
		String handler = "";
		try{
			result.put("res_type", FirmwareConstant.IOT_FIRMWARE_RES_TYPE_F30002);
			result.put("res_time", (int)(System.currentTimeMillis()/1000));
			JSONObject json = new JSONObject(strRecv);
			if(!json.has("n")){
				result.put("c", FirmwareConstant.IOT_FIRMWARE_RES_ERROR_CODE_2);
			}else{
				String macId = FirmwareSocketMgr.update_channelIdToMacId.get(uuid);
				handler = macId ;
				FirmwareSocketMgr.updateFirmwareTimeMap.put(macId, System.currentTimeMillis());
				ChannelManage channelManage = FirmwareSocketMgr.update_m_SocketChannel.get(macId);
				Integer msgVer = channelManage.getMsgVer();
				Integer version = channelManage.getVersion();
				FirmwareUpdate firmwareUpdate = firmwareUpdateMapper.queryByMacId(macId);
				String filepath = "";
				if(msgVer.intValue() > FirmwareConstant.IOT_FIRMWARE_MSG_VER_MAX || msgVer.intValue() < FirmwareConstant.IOT_FIRMWARE_MSG_VER_MIN){
					if(null == firmwareUpdate){
						//查看当前固件的最新版本
						FirmwareInfo firmwareInfo = firmwareInfoMapper.queryByDtype(channelManage.getDeviceType());
						if(null != firmwareInfo){
							filepath = firmwareInfo.getFirmwareFileUrl();
						}
					}else{
						filepath = firmwareUpdate.getFirmwareFileUrl();
					}
				}else{
					if(null != firmwareUpdate){
						if(firmwareUpdate.getVersion().intValue() != version.intValue()){
							filepath = firmwareUpdate.getFirmwareFileUrl();
						}
					}
				}
				if("".equals(filepath)){
					result.put("crc", 0);
					result.put("l", 0);
				}else{
//					File file = new File(filepath);
//					long filelength = file.length();
//					long crc = CRCUtil.checksumBufferedInputStream(filepath);
//					result.put("crc", crc);
//					result.put("l", filelength);
					URL url = new URL(filepath);
					URLConnection connection = url.openConnection();
					InputStream is = connection.getInputStream();
					long crc = CRCUtil.checksumBufferedInputStream(is);
					//BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
					result.put("crc", crc);
					result.put("l", connection.getContentLength());
					is.close();
                    System.out.println("===================固件请求获取文件大小成功！=======================");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("固件请求升级文件头信息失败,原因:",e);
			result.put("c", FirmwareConstant.IOT_FIRMWARE_RES_ERROR_CODE_1);
		}
		netMsgEnterUpdate(handler,result.toString());
	}
	/**
	 * 固件发送文件头信息的确认包
	 */
	public void handleMsgTypeQF30002(String strRecv,String uuid){
		JSONObject result = new JSONObject();
		String handler = "";
		try{
			result.put("res_type", FirmwareConstant.IOT_FIRMWARE_RES_TYPE_QF30002);
			result.put("res_time", (int)(System.currentTimeMillis()/1000));
			JSONObject json = new JSONObject(strRecv);
			if(!json.has("n")){
				result.put("c", FirmwareConstant.IOT_FIRMWARE_RES_ERROR_CODE_2);
			}else{
				String macId = FirmwareSocketMgr.update_channelIdToMacId.get(uuid);
				handler = macId ;
				FirmwareSocketMgr.updateFirmwareTimeMap.put(macId, System.currentTimeMillis());
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("固件发送文件头信息的确认包失败,原因:"+e);
			result.put("c", FirmwareConstant.IOT_FIRMWARE_RES_ERROR_CODE_1);
		}
		netMsgEnterUpdate(handler,result.toString());
	}
	/**
	 * 固件请求升级文件内容
	 */
	public void handleMsgTypeF30003(String strRecv,String uuid){
		JSONObject result = new JSONObject();
		String handler = "";
		try{
			result.put("res_type", FirmwareConstant.IOT_FIRMWARE_RES_TYPE_F30003);
			result.put("res_time", (int)(System.currentTimeMillis()/1000));
			JSONObject json = new JSONObject(strRecv);
			if(!json.has("n")){
				result.put("c", FirmwareConstant.IOT_FIRMWARE_RES_ERROR_CODE_2);
			}else{
				String macId = FirmwareSocketMgr.update_channelIdToMacId.get(uuid);
				//macId = "E03E9E5223FF";
				handler = macId ;
				FirmwareSocketMgr.updateFirmwareTimeMap.put(macId, System.currentTimeMillis());
				if(FirmwareSocketMgr.updateFileMap.containsKey(uuid+","+macId)){
					byte[] contentByte = (byte[]) FirmwareSocketMgr.updateFileMap.get(uuid+","+macId);
					String str = "";
					if(contentByte.length > FirmwareConstant.FIRMWARE_UPDATE_BYTE_LENGTH){
						result.put("f", 0);
						byte[] bs = new byte[FirmwareConstant.FIRMWARE_UPDATE_BYTE_LENGTH];
						System.arraycopy(contentByte, 0, bs, 0, FirmwareConstant.FIRMWARE_UPDATE_BYTE_LENGTH);
						str = base64.encodeAsString(bs);
						byte[] surplus = Arrays.copyOfRange(contentByte, FirmwareConstant.FIRMWARE_UPDATE_BYTE_LENGTH, contentByte.length);
						FirmwareSocketMgr.updateFileMap.put(uuid+","+macId, surplus);
					}else{
						result.put("f", 1);
						str = base64.encodeAsString(contentByte);
						FirmwareSocketMgr.updateFileMap.remove(uuid+","+macId);
					}
					result.put("b", str);
				}else{
					FirmwareUpdate firmwareUpdate = firmwareUpdateMapper.queryByMacId(macId);
					String filepath = "";
					if(null == firmwareUpdate){
						//查看当前固件的最新版本
						GatewayInfo gatewayInfo = gatewayInfoMapper.queryByMacId(macId);
						FirmwareInfo firmwareInfo = firmwareInfoMapper.queryByDtype(gatewayInfo.getDeviceType());
						if(null != firmwareInfo){
							filepath = firmwareInfo.getFirmwareFileUrl();
						}
					}else{
						filepath = firmwareUpdate.getFirmwareFileUrl();
					}
					//String filepath = firmwareUpdate.getFirmwareFileUrl();
					URL url = new URL(filepath);
					URLConnection connection = url.openConnection();
					InputStream in = connection.getInputStream();
					int length = connection.getContentLength();
					byte[] buffer = new byte[length];
					int offset = 0;
					int numRead = 0;
					while (offset < buffer.length
							&& (numRead = in.read(buffer, offset, buffer.length - offset)) >= 0) {
						offset += numRead;
					}
					// 确保所有数据均被读取
					if (offset != buffer.length) {
						throw new IOException("Could not completely read file "
								+ filepath);
					}
					in.close();
					logger.info("总的文件内容:"+base64.encodeAsString(buffer));
					String str = "";
					if(buffer.length > FirmwareConstant.FIRMWARE_UPDATE_BYTE_LENGTH){
						result.put("f", 0);
						byte[] bs = new byte[FirmwareConstant.FIRMWARE_UPDATE_BYTE_LENGTH];
						System.arraycopy(buffer, 0, bs, 0, FirmwareConstant.FIRMWARE_UPDATE_BYTE_LENGTH);
						str = base64.encodeAsString(bs);
						byte[] surplus = Arrays.copyOfRange(buffer, FirmwareConstant.FIRMWARE_UPDATE_BYTE_LENGTH, buffer.length);
						FirmwareSocketMgr.updateFileMap.put(uuid+","+macId, surplus);
						logger.info("每次的文件内容:"+base64.encodeAsString(surplus));
					}else{
						result.put("f", 1);
						str = base64.encodeAsString(buffer);
						FirmwareSocketMgr.updateFileMap.remove(uuid+","+macId);
					}
					result.put("b", str);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("固件请求升级文件内容失败,原因:",e);
			result.put("c", FirmwareConstant.IOT_FIRMWARE_RES_ERROR_CODE_1);
		}
		netMsgEnterUpdate(handler,result.toString());
	}
	/**
	 * 固件发送获取到升级文件内容的确认包
	 */
	public void handleMsgTypeQF30003(String strRecv,String uuid){
		JSONObject result = new JSONObject();
		String handler = "";
		try{
			result.put("res_type", FirmwareConstant.IOT_FIRMWARE_RES_TYPE_F30003);
			result.put("res_time", (int)(System.currentTimeMillis()/1000));
			JSONObject json = new JSONObject(strRecv);
			if(!json.has("n")){
				result.put("c", FirmwareConstant.IOT_FIRMWARE_RES_ERROR_CODE_2);
			}else{
				String macId = FirmwareSocketMgr.update_channelIdToMacId.get(uuid);
				handler = macId ;
				FirmwareSocketMgr.updateFirmwareTimeMap.put(macId, System.currentTimeMillis());
				byte[] contentByte = (byte[]) FirmwareSocketMgr.updateFileMap.get(uuid+","+macId);
				String str = "";
				if(contentByte.length > FirmwareConstant.FIRMWARE_UPDATE_BYTE_LENGTH){
					result.put("f", 0);
					byte[] bs = new byte[FirmwareConstant.FIRMWARE_UPDATE_BYTE_LENGTH];
					System.arraycopy(contentByte, 0, bs, 0, FirmwareConstant.FIRMWARE_UPDATE_BYTE_LENGTH);
					str = base64.encodeAsString(bs);
					byte[] surplus = Arrays.copyOfRange(contentByte, FirmwareConstant.FIRMWARE_UPDATE_BYTE_LENGTH, contentByte.length);
					logger.info("每次的文件内容:"+base64.encodeAsString(surplus));
					FirmwareSocketMgr.updateFileMap.put(uuid+","+macId, surplus);
				}else{
					result.put("f", 1);
					str = base64.encodeAsString(contentByte);
					FirmwareSocketMgr.updateFileMap.remove(uuid+","+macId);
				}
				result.put("b", str);
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("固件发送获取到升级文件内容的确认包失败,原因:"+e);
			result.put("c", FirmwareConstant.IOT_FIRMWARE_RES_ERROR_CODE_1);
		}
		netMsgEnterUpdate(handler,result.toString());
	}
	/**
	 * 固件发送获取到升级文件内容的确认包
	 */
	public void handleMsgTypeF30004(String strRecv,String uuid){
		JSONObject result = new JSONObject();
		String handler = "";
		try{
			result.put("res_type", FirmwareConstant.IOT_FIRMWARE_RES_TYPE_F30004);
			result.put("res_time", (int)(System.currentTimeMillis()/1000));
			JSONObject json = new JSONObject(strRecv);
			if(!json.has("n")){
				result.put("c", FirmwareConstant.IOT_FIRMWARE_RES_ERROR_CODE_2);
			}else{
				String macId = FirmwareSocketMgr.update_channelIdToMacId.get(uuid);
				handler = macId ;
				FirmwareSocketMgr.updateFirmwareTimeMap.remove(macId);
				FirmwareSocketMgr.updateFileMap.remove(uuid+","+macId);
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("固件发送升级文件已全部获取的确认处理失败,原因:"+e);
			result.put("c", FirmwareConstant.IOT_FIRMWARE_RES_ERROR_CODE_1);
		}
		netMsgEnterUpdate(handler,result.toString());
	}
	/**
	 * 返回给固件的信息
	 */
	public void netMsgEnterUpdate(String handler,String strMsg) {
		String length = String.format("%4d", strMsg.length()).replace(" ", "0");
		strMsg = length + strMsg;
        System.out.println("返回给固件的信息:"+strMsg);
		logger.info("返回给固件的信息:"+strMsg);
		try{
			if(FirmwareSocketMgr.update_m_SocketChannel.containsKey(handler)){
				ChannelHandlerContext ctx = FirmwareSocketMgr.update_m_SocketChannel.get(handler).getChannel();
				if(ctx != null && ! ctx.isRemoved()){
					ByteBuf b = ctx.alloc().buffer(1024*100);
					b.writeBytes(strMsg.getBytes());
					ctx.writeAndFlush(b);
				}else{
					FirmwareSocketMgr.deleteUpdateOneSocketContext(handler);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error("返回给固件信息失败,原因:"+e);
		}
	}

	/**
	 * 固件断链的处理
	 */
	public void disconnectionHandle(String gatewayMac){
		System.out.println("固件断链,但是代码没处理！！！");
//		NetworkGateway networkGateway = networkGatewayMapper.queryByGatewayId(gatewayMac);
//		if(null != networkGateway){
//			List<NetworkGateway> list = networkGatewayMapper.queryByNetworkId(networkGateway.getNetworkId());
//			if(null != list && !list.isEmpty()){
//				for(NetworkGateway bean : list){
//					if(FirmwareSocketMgr.m_SocketChannel.containsKey(bean.getGateMacId())){
//						if(FirmwareSocketMgr.networkStatusMap.containsKey(networkGateway.getNetworkId())){
//							FirmwareSocketMgr.networkStatusMap.remove(networkGateway.getNetworkId());
//						}
//						return;
//					}
//				}
//				FirmwareSocketMgr.networkStatusMap.put(networkGateway.getNetworkId(), "");
//			}
//		}
	}
}
