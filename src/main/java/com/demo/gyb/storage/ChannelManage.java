package com.demo.gyb.storage;

import io.netty.channel.ChannelHandlerContext;

public class ChannelManage {
    private Integer msgVer;
    private Integer deviceType;
    private Integer build;
    private Integer version;//固件数字版本号
    private ChannelHandlerContext channel;
    private String uuid;
    private String networkId;
    private String token;
	public Integer getMsgVer() {
		return msgVer;
	}
	public void setMsgVer(Integer msgVer) {
		this.msgVer = msgVer;
	}
	public ChannelHandlerContext getChannel() {
		return channel;
	}
	public void setChannel(ChannelHandlerContext channel) {
		this.channel = channel;
	}
	public Integer getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}
	public Integer getBuild() {
		return build;
	}
	public void setBuild(Integer build) {
		this.build = build;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getNetworkId() {
		return networkId;
	}
	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}	
}
