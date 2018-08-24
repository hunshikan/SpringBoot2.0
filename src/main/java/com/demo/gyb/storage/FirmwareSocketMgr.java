package com.demo.gyb.storage;

import com.demo.gyb.constant.FirmwareConstant;
import com.demo.gyb.constant.IotConstant;
import com.demo.gyb.memory.SocketChannelInit;
import com.demo.gyb.memory.ThirdInstructionsBo;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FirmwareSocketMgr{
	public static Logger logger =  Logger.getLogger("firmware");
	//链接管理
	public static Map<String, ChannelManage> m_SocketChannel = new HashMap<String,ChannelManage>();//key值:网关Mac地址,value:链接通道的信息
	public static Map<String, ChannelManage> update_m_SocketChannel = new HashMap<String,ChannelManage>();
	public static Map<String, String> channelIdToMacId = new HashMap<String,String>();//key值:链接ID,value:网关Mac地址
	public static Map<String, String> update_channelIdToMacId = new HashMap<String,String>();
	//signToken管理
	public static Map<String, String> firmwareSignToken = new HashMap<String,String>();
	//token映射channelId的管理Map,key:登录token,value:链接通道uuid
	public static Map<String, String> loginTokenToUUidMap = new ConcurrentHashMap<String,String>();
	//心跳包管理   key:网关Mac地址    value:上次心跳包的时间
	public static Map<String, Integer> heartbeatMap = new HashMap<String,Integer>();
	public static Map<String, Long> updateFirmwareTimeMap = new HashMap<String,Long>();
	//升级文件管理
	public static Map<String, Object> updateFileMap = new HashMap<String, Object>();
	//网络状态缓存 在线或者离线(该网络下所有网关都离线)
	public static Map<String, Object> networkStatusMap = new HashMap<String, Object>();//key为网络id,value为网络状态
	//第三方请求链接是否超时的管理
	public static Map<String, ThirdChannelManager> thirdTimeOutMap = new HashMap<String, ThirdChannelManager>();
	//第三方等待的线程池   key:前缀+网络Id+随机数,value:第三方线程实例
	public static Map<String, Thread> thirdWaitMap = new HashMap<String, Thread>();
	//网络中 判断是否有其他人操作该网络下ibeacon信息 	格式:key：networkId  value:绑定进度信息
	public static Map<String, IBeaconInstruction> netIBeaconMap  = new ConcurrentHashMap<String, IBeaconInstruction>();
	//发送给网关的指令,回复是否超时,key:网关指令的随机数,value:true是超时,false是没有超时
	public static Map<String, GatewayTimeOutMsg> gatewayTimeOutMap = new HashMap<String, GatewayTimeOutMsg>();
	//发送给设备的指令,回复是否超时,key:网络ID+_+指令的随机数
	public static Map<String, DeviceTimeOutMsg> deviceTimeOutMap = new HashMap<String, DeviceTimeOutMsg>();
	//网络随机数管理
	public static Map<String, NetworkSign> networkSignMap = new ConcurrentHashMap<String, NetworkSign>();
	// 新的链接初始管理
	public static Map<String, SocketChannelInit> init_SocketChannel = new ConcurrentHashMap<String,SocketChannelInit>();//key值:uuid,value:链接初始化实例
	//
	public static Map<String, Lock> socketChannelLock = new ConcurrentHashMap<String,Lock>();//key值:uuid,value:链接初始化实例
	// 第三方请求的管理Map key:网络Id,value:第三方请求列表(指令随机数)
	public static Map<String, List<String>> thirdRequestMap = new ConcurrentHashMap<String,List<String>>();
	// 第三方指令内容管理Map key:前缀+网络Id+指令随机数,value:指令内容
	public static Map<String, ThirdInstructionsBo> thirdContentMap = new ConcurrentHashMap<String,ThirdInstructionsBo>();
	// 当前正在执行的第三方指令,key:网络Id+指令随机数，value:空
//	public static Map<String, Object> thirdExecutingMap = new ConcurrentHashMap<String,Object>();
	public FirmwareSocketMgr() {
	}
//	public synchronized static boolean isExecutingThird(String key) throws Exception{
//		boolean boo = true;
//		try{
//			if(thirdExecutingMap.isEmpty()){
//				thirdExecutingMap.put(key, "");
//			}else{
//				if(thirdExecutingMap.containsKey(key)){
//					thirdExecutingMap.remove(key);
//				}else{
//					return false;
//				}
//			}
//			return boo;
//		}catch (Exception e) {
//			logger.error("第三方下发指令失败,原因:",e);
//			throw e;
//		}
//	}
	public synchronized static Map<String, Object> isEmptyByNetworkId(String networkId) throws Exception {
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		try{
			if(thirdRequestMap.containsKey(networkId)){
				if(!FirmwareSocketMgr.thirdRequestMap.get(networkId).isEmpty()){
					int instructionsSign = FirmwareSocketMgr.getNetworkSign(networkId);
					FirmwareSocketMgr.thirdRequestMap.get(networkId).add(instructionsSign+"");
					map.put("sign", instructionsSign);
					map.put("flag", false);
					return map;
				}else{
					int instructionsSign = FirmwareSocketMgr.getNetworkSign(networkId);
					FirmwareSocketMgr.thirdRequestMap.get(networkId).add(instructionsSign+"");
					map.put("sign", instructionsSign);
					map.put("flag", true);
					return map;
				}
			}else{
				List<String> thirdList = Collections.synchronizedList(new ArrayList<String>());
				int instructionsSign = FirmwareSocketMgr.getNetworkSign(networkId);
				thirdList.add(instructionsSign+"");
				FirmwareSocketMgr.thirdRequestMap.put(networkId, thirdList);
				map.put("sign", instructionsSign);
				map.put("flag", true);
				return map;
			}
		}catch (Exception e) {
			logger.error("第三方下发指令失败,原因:",e);
			throw e;
		}
	}
	
	/**
	 * 通过uuid获取网络Id
	 * @param key
	 * @param ctx
	 * @return
	 */
	public static String getNetworkIdByUUid(String uuid){
		String networkId = null;
		if(channelIdToMacId.containsKey(uuid)){
			String gatewayMacId = channelIdToMacId.get(uuid);
			if(m_SocketChannel.containsKey(gatewayMacId)){
				networkId = m_SocketChannel.get(gatewayMacId).getNetworkId();
			}
		}
		return networkId;
	}
	public static boolean addOneSocketContext(String key , ChannelManage ctx)
	{
		try{
			ChannelManage oldctx = m_SocketChannel.get(key);
			if(oldctx!=null)
			{
				ChannelHandlerContext oldChannel = oldctx.getChannel();
				oldChannel.close();
				oldChannel = null;
				m_SocketChannel.remove(key);
			}
			m_SocketChannel.put(key,ctx);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("add one socker error,cause:"+e);
			return false;
		}
		return true;
	}
	public static boolean addUpdateOneSocketContext(String key , ChannelManage ctx)
	{
		try{
			ChannelManage oldctx = update_m_SocketChannel.get(key);
			if(oldctx!=null)
			{
				ChannelHandlerContext oldChannel = oldctx.getChannel();
				oldChannel.close();
				oldChannel = null;
				update_m_SocketChannel.remove(key);
			}
			update_m_SocketChannel.put(key,ctx);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("add one socker error,cause:"+e);
			return false;
		}
		return true;
	}
	
	public static boolean deleteOneSocketContext(String key)
	{
		try
		{   
			ChannelManage oldctx = m_SocketChannel.get(key);
			if(oldctx!=null)
			{
				ChannelHandlerContext oldChannel = oldctx.getChannel();
				oldChannel.close();
				oldChannel = null;
				loginTokenToUUidMap.remove(oldctx.getToken());
				channelIdToMacId.remove(oldctx.getUuid());
			}
			m_SocketChannel.remove(key);
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.error("delete one socker error,cause:"+e);
			return false;
		}
		return true;
	}
	public static boolean deleteUpdateOneSocketContext(String key)
	{
		try
		{   
			ChannelManage oldctx = update_m_SocketChannel.get(key);
			if(oldctx!=null)
			{
				ChannelHandlerContext oldChannel = oldctx.getChannel();
				oldChannel.close();
				oldChannel = null;
			}
			update_m_SocketChannel.remove(key);
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.error("delete one socker error,cause:"+e);
			return false;
		}
		return true;
	}
	
	public static void clearSocketContext()
	{
		m_SocketChannel.clear();
	}	
	/**
	 * 操作网络随机数Map
	 */
	public static int getNetworkSign(String networkId){
		int sign = 0;
		NetworkSign networkSign = networkSignMap.get(networkId);
		if(null != networkSign){
			try{				
				networkSign.getLock().lock();
				sign = networkSign.getNetworkNextSign() + FirmwareConstant.NETWORK_COMMAND_NEXT;
				if(sign >= IotConstant.NETWORK_COM_NEXT_SIGN_END){
					sign = IotConstant.NETWORK_COM_NEXT_SIGN_START;
				}
				networkSign.setNetworkNextSign(sign);
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("获取网络随机数失败,networkId:"+networkId+",原因:"+e);
			}finally {
				networkSign.getLock().unlock();
			}
		}else{
			networkSign = new NetworkSign();
			Lock lock = new ReentrantLock();
			networkSign.setLock(lock);
			networkSign.setNetworkNextSign(IotConstant.NETWORK_COM_NEXT_SIGN_START);
			networkSignMap.put(networkId, networkSign);
			sign = IotConstant.NETWORK_COM_NEXT_SIGN_START;
		}
		return sign;
	}
	
//	public static boolean addSignToken(String key,String token) 
//	{
//		try{
//			String oldToken = firmwareSignToken.get(key);
//			if(!StringUtil.isBlank(oldToken))
//			{
//				firmwareSignToken.remove(key);
//			}
//			firmwareSignToken.put(key,token);
//		}catch (Exception e) {
//			e.printStackTrace();
//			logger.error("add sign token error,cause:"+e);
//			return false;
//		}
//		return true;
//	}
//	public static boolean deleteSignToken(String key)
//	{
//		try
//		{   
//			m_SocketChannel.remove(key);
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//			logger.error("delete sign token error,cause:"+e);
//			return false;
//		}
//		return true;
//	}
}
















