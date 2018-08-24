package com.demo.gyb.storage;

public class DeviceTimeOutMsg {
	private String networkId;
    private Boolean timeOutFlag;//true超时，false没有超时
    private Integer itsId;//指令Id
    private Integer commandDataId;//发送指令ID
    private Integer itsConfigId;//指令配置Id
    private Integer priority;// 优先级,0:特殊指令下发,1:设备参数指令，2:iBeacon下发
    
	public String getNetworkId() {
		return networkId;
	}
	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}
	public Boolean getTimeOutFlag() {
		return timeOutFlag;
	}
	public void setTimeOutFlag(Boolean timeOutFlag) {
		this.timeOutFlag = timeOutFlag;
	}
	public Integer getCommandDataId() {
		return commandDataId;
	}
	public void setCommandDataId(Integer commandDataId) {
		this.commandDataId = commandDataId;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getItsConfigId() {
		return itsConfigId;
	}
	public void setItsConfigId(Integer itsConfigId) {
		this.itsConfigId = itsConfigId;
	}
	public Integer getItsId() {
		return itsId;
	}
	public void setItsId(Integer itsId) {
		this.itsId = itsId;
	}	
}
