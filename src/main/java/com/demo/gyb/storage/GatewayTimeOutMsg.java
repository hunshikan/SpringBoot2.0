package com.demo.gyb.storage;

import com.demo.gyb.memory.ItsBo;

import java.util.List;

public class GatewayTimeOutMsg {
	private String networkId;
	private Boolean timeOutFlag;//true超时，false没有超时
    private Boolean akFlag;//是否需要ak确认，true是需要，false是不需要
    private Integer iSign;//设备指令的随机数
    private Integer itsId; //指令Id
    private Integer commandDataId;//发送指令ID
    private Integer itsConfigId; //指令配置ID
    private Integer type; //1:整个网络 2:单个分组 3:单个网关 4:单个设备
    private Integer priority;// 优先级,0:特殊指令下发,1:设备参数指令，2:iBeacon下发
    private List<ItsBo> itsBo;
	public Boolean getTimeOutFlag() {
		return timeOutFlag;
	}
	public void setTimeOutFlag(Boolean timeOutFlag) {
		this.timeOutFlag = timeOutFlag;
	}
	public Boolean getAkFlag() {
		return akFlag;
	}
	public void setAkFlag(Boolean akFlag) {
		this.akFlag = akFlag;
	}
	public Integer getiSign() {
		return iSign;
	}
	public void setiSign(Integer iSign) {
		this.iSign = iSign;
	}
	public String getNetworkId() {
		return networkId;
	}
	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}
	public Integer getCommandDataId() {
		return commandDataId;
	}
	public void setCommandDataId(Integer commandDataId) {
		this.commandDataId = commandDataId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
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
	public List<ItsBo> getItsBo() {
		return itsBo;
	}
	public void setItsBo(List<ItsBo> itsBo) {
		this.itsBo = itsBo;
	}	
}
