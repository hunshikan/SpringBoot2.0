package com.demo.gyb.thread;

import com.demo.gyb.memory.SocketChannelInit;
import com.demo.gyb.storage.FirmwareSocketMgr;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

/**
 * 网关链接成功后,判断是否已登录
 * @author jianglong
 *2018年6月11日
 */
public class GatewayInitThread implements Runnable {
    Logger logger = Logger.getLogger("firmware");
    private String uuid;
    private Integer msgVer;
    public GatewayInitThread(String m_uuid, Integer m_msgVer){
    	uuid = m_uuid;
    	msgVer = m_msgVer;
    }
	@Override
	public void run() {
		try {
			FirmwareSocketMgr.socketChannelLock.remove(uuid);
			if(FirmwareSocketMgr.init_SocketChannel.containsKey(uuid)) {
				SocketChannelInit init = FirmwareSocketMgr.init_SocketChannel.get(uuid);
				ChannelHandlerContext channel = init.getChannel();
				channel.close();
				channel = null;
				FirmwareSocketMgr.init_SocketChannel.remove(uuid);
				logger.error("网关链接成功后未登录,链接已断开,uuid:" + uuid);
				System.out.println("网关链接成功后未登录,链接已断开,uuid:" + uuid);
			} else {
				logger.error("网关链接成功后,网关已登录,uuid:" + uuid);
				System.out.println("网关链接成功后,网关已登录,uuid:" + uuid);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("网关链接成功后,判断是否已登录的处理失败,原因:" + e);
		}		
	}
	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Integer getMsgVer() {
		return msgVer;
	}
	public void setMsgVer(Integer msgVer) {
		this.msgVer = msgVer;
	}
}
