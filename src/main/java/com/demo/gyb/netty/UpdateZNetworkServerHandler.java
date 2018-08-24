package com.demo.gyb.netty;

import com.demo.gyb.config.SpringBeanUtil;
import com.demo.gyb.constant.FirmwareConstant;
import com.demo.gyb.service.FirmwareUpdateService;
import com.demo.gyb.storage.FirmwareSocketMgr;
import com.demo.gyb.util.StringUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import org.apache.log4j.Logger;
import org.json.JSONObject;

public class UpdateZNetworkServerHandler extends ChannelInboundHandlerAdapter {
	Logger logger =  Logger.getLogger("firmware");
	FirmwareUpdateService firmwareUpdateService;
	private boolean boo = true;
	private int length;
	StringBuffer buff= new StringBuffer();
	private int surplusLength = 0;

	UpdateZNetworkServerHandler() {
		// 从Spring中获取bean
		firmwareUpdateService = (FirmwareUpdateService) SpringBeanUtil.getBean("firmwareUpdateService");
		System.out.println("firmwareUpdateService获取成功======================"+firmwareUpdateService);
	}

	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		ByteBuf in = (ByteBuf) msg;
		try {
			byte[] req = new byte[in.readableBytes()];
			in.readBytes(req);
			String strRecv = new String(req, "UTF-8");
			System.out.println("固件发送信息："+strRecv);
			logger.info("####:"+strRecv+",boo:"+boo);
			analysisMessage(ctx,strRecv);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReferenceCountUtil.release(msg); // (2)
		}
	}
	public void analysisMessage(ChannelHandlerContext ctx,String strRecv) throws Exception{
		try{
			if(boo){
				buff.delete(0, buff.length());
				surplusLength = 0;
				boo = false;
				String fourPre = strRecv.substring(0, 4);
//				System.out.println("fourPre======================"+fourPre);
				length = Integer.parseInt(fourPre);
//				System.out.println("length======================"+length);
				if(length >1000){
					logger.error("包长度大于1000,包长度:"+fourPre);
					boo = true;
					surplusLength = 0;
					throw new Exception("包长度大于1000,包长度:"+fourPre);
				}
				String fourAfter = strRecv.substring(4);
				if(length == fourAfter.length()){
					buff.delete(0,buff.length());
					boo = true;
					surplusLength = 0;
					HandleRecvData(ctx, fourAfter);
				}else if (length > fourAfter.length()){
					buff.append(fourAfter);
					surplusLength = length - fourAfter.length();
				}else{
					String content = strRecv.substring(4,4+length);
					boo = true;
					surplusLength = 0;
					buff.delete(0,buff.length());
					HandleRecvData(ctx, content);
					String nextContent = strRecv.substring(4+length,strRecv.length());
					analysisMessage(ctx,nextContent);
				}
			}else{
				if(strRecv.length() == surplusLength){
					buff = buff.append(strRecv);
					boo = true;
					surplusLength = 0;
					HandleRecvData(ctx, buff.toString());
					buff.delete(0,buff.length());
				}else if(strRecv.length() < surplusLength){
					buff = buff.append(strRecv);
					surplusLength = surplusLength - strRecv.length();
				}else{
					String content = strRecv.substring(0,surplusLength);
					boo = true;
					String nextContent = strRecv.substring(surplusLength);
					surplusLength = 0;
					buff.append(content);
					HandleRecvData(ctx, buff.toString());
					buff.delete(0,buff.length());
					analysisMessage(ctx,nextContent);
				}
			}
		}catch (Exception e) {
			throw e;
		}
	}
	public void channelReadComplete(ChannelHandlerContext ctx) {
		// ctx.writeAndFlush(Unpooled.EMPTY_BUFFER) //flush掉所有写回的数据
		// .addListener(ChannelFutureListener.CLOSE); //当flush完成后关闭channel
	}

	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
//		ZBeaconSocketMgr m_BSocketMgr=(ZBeaconSocketMgr)ZCore.Get("BeaconSocketCenter");
//		if(m_BSocketMgr!=null)
//		{
//			String strBeaconID=m_BSocketMgr.DeleteOneSocketContext(ctx);
//
//			if (strBeaconID!=null) {
//				m_BSocketMgr.AddOneDisconnect(HandlerType.H_TYPE_BEACON+strBeaconID, ZApi.GetUnixstamp());
//				ZLogModule.pl("Disconnect Beacon: "+strBeaconID);
//			}
//		}
		String uuid = "";
		try{
			uuid = ctx.channel().id().asShortText();
			if(!StringUtil.isBlank(uuid)){
				String  deviceMacId = FirmwareSocketMgr.update_channelIdToMacId.get(uuid);
				if(!StringUtil.isBlank(deviceMacId)){
					FirmwareSocketMgr.updateFileMap.remove(uuid+","+deviceMacId);
				}
			}
		}catch (Exception e) {
			logger.error("捕捉链接异常后的操作失败,原因:"+e);
		}finally {
//			cause.printStackTrace();// 捕捉异常信息
//			logger.error("uuid:"+uuid+",链接异常中断，原因:"+cause);
//			ctx.close();// 出现异常时关闭channel
			if (ctx.channel().isActive()) {
				String uid = ctx.channel().id().asShortText();
				cause.printStackTrace();// 捕捉异常信息
				logger.error("uuid:"+uid+",链接异常中断，原因:"+cause);
				ctx.close();// 出现异常时关闭channel
			}else{
				logger.error("客户端断开了链接,"+ ctx.channel().id().asShortText());
			}
		}
	}

	// ----------Handle Network Data---------

	public void HandleRecvData(ChannelHandlerContext ctx, String strRecv) {
		try {
			logger.info("iot update firmware send msg :"+strRecv);
			String uuid = ctx.channel().id().asShortText();
			JSONObject tJson = new JSONObject(strRecv);
			if(!tJson.has("msg_type") || !tJson.has("msg_time")){
				logger.error("iot update firmware send msg header error");
				return;
			}
			String strOP  = tJson.getString("msg_type");
			//登录的处理
			if(FirmwareConstant.IOT_FIRMWARE_MSG_TYPE_R30001.equals(strOP)){
				firmwareUpdateService.login(ctx,strRecv);
				return;
			}
			if(FirmwareSocketMgr.update_channelIdToMacId.containsKey(uuid)){
				String  deviceMacId = FirmwareSocketMgr.update_channelIdToMacId.get(uuid);
				if(FirmwareSocketMgr.update_m_SocketChannel.containsKey(deviceMacId)){
					firmwareUpdateService.handleMessage(strRecv, strOP, uuid);
				}else{
					logger.info("固件包传入的设备mac地址有误");
				}
			}else{
				logger.info("通过uuid:"+uuid+",未找到对应的mac链接");
				return ;
			}
		} catch (Exception e) {
			e.printStackTrace();
			ctx.close();
			ctx = null;
			logger.error("解析固件包失败,原因:"+e);
		}
	}

}
