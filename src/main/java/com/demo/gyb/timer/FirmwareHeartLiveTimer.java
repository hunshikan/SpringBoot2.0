package com.demo.gyb.timer;


import com.demo.gyb.constant.FirmwareConstant;
import com.demo.gyb.service.FirmwareUpdateService;
import com.demo.gyb.storage.ChannelManage;
import com.demo.gyb.storage.FirmwareSocketMgr;
import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.Set;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class FirmwareHeartLiveTimer extends TimerTask {
	Logger logger = Logger.getLogger(FirmwareHeartLiveTimer.class);
	Lock heartLive_lock;
	FirmwareUpdateService firmwareUpdateService;
	public FirmwareHeartLiveTimer(){		
		heartLive_lock = new ReentrantLock();
	}
	@Override
	public void run() {
//		System.out.println("----FirmwareHeartLiveTimer心跳包。。。。。。。。。。。。。。。。");
		try{
			heartLive_lock.lock();
			Set<String> keys = FirmwareSocketMgr.heartbeatMap.keySet();
			for(String key : keys){
				Integer time = FirmwareSocketMgr.heartbeatMap.get(key);
				int currentTime = (int)(System.currentTimeMillis()/1000);
				if(currentTime - time.intValue() > FirmwareConstant.IOT_FIRMWARE_DISCONNECT){
					FirmwareSocketMgr.deleteOneSocketContext(key);
					logger.info("macId:"+key+",的心跳包已超时,链接已断开");
					if(null == firmwareUpdateService){
						WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
						firmwareUpdateService = (FirmwareUpdateService)wac.getBean("firmwareUpdateService");
					}
					firmwareUpdateService.disconnectionHandle(key);
				}
			}
			Set<String> updateMacs = FirmwareSocketMgr.updateFirmwareTimeMap.keySet();
			for(String key : updateMacs){
				Long time = FirmwareSocketMgr.updateFirmwareTimeMap.get(key);
				if(System.currentTimeMillis() - time > FirmwareConstant.IOT_FIRMWARE_UPDATE_DISCONNECT){
					ChannelManage channelManage = FirmwareSocketMgr.update_m_SocketChannel.get(key);
					if(null != channelManage){
						String uuid = FirmwareSocketMgr.update_m_SocketChannel.get(key).getUuid();
						FirmwareSocketMgr.updateFileMap.remove(uuid+","+key);
					}					
					FirmwareSocketMgr.deleteUpdateOneSocketContext(key);
					logger.info("固件升级macId:"+key+",的心跳包已超时,链接已断开");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("计算固件心跳的定时任务执行失败,原因:"+e);
		}finally {
			heartLive_lock.unlock();
		}	
	}
}
