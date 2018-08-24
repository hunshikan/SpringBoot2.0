package com.demo.gyb.entity.device;

import java.sql.Timestamp;

public class NetworkGroupCommand {
    private Integer dataId;
    private String networkId;
    private Integer groupId;
    private Byte onOff;
    private Integer brightness;
    private Byte interactionOnOff;
    private String interactionOpenTime;
    private Integer lowPowerOpenTime;
    private Integer lowPowerBrightness;
    private Integer awaitOpenTime;
    private Integer awaitBrightness;
    private Timestamp createTime;
    private Timestamp modifyTime;
    private Byte isExecute;
    private String sign;
    private Integer onOffSign;
    private Integer brightnessSign;
    private Integer interactionOnOffSign;
    private Integer interactionOpenTimeSign;
    private Integer lowPowerOpenTimeSign;
    private Integer lowPowerBrightnessSign;
    private Integer awaitOpenTimeSign;
    private Integer awaitBrightnessSign;
    private Timestamp gatewayGainTime;
    private String safetyTime;
    private Integer safetyTimeSign;
    private Integer version;
    private String deviceMacId;
    private Integer priority;
    private String ibeaconInstruction;
    private Integer ibeaconInstructionSign;
    private Byte ibeaconType;
	public Byte getIbeaconType() {
		return ibeaconType;
	}
	public void setIbeaconType(Byte ibeaconType) {
		this.ibeaconType = ibeaconType;
	}
	public Integer getDataId() {
		return dataId;
	}
	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}
	public String getNetworkId() {
		return networkId;
	}
	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public Byte getOnOff() {
		return onOff;
	}
	public void setOnOff(Byte onOff) {
		this.onOff = onOff;
	}
	public Integer getBrightness() {
		return brightness;
	}
	public void setBrightness(Integer brightness) {
		this.brightness = brightness;
	}
	public Byte getInteractionOnOff() {
		return interactionOnOff;
	}
	public void setInteractionOnOff(Byte interactionOnOff) {
		this.interactionOnOff = interactionOnOff;
	}
	public String getInteractionOpenTime() {
		return interactionOpenTime;
	}
	public void setInteractionOpenTime(String interactionOpenTime) {
		this.interactionOpenTime = interactionOpenTime;
	}
	public Integer getLowPowerOpenTime() {
		return lowPowerOpenTime;
	}
	public void setLowPowerOpenTime(Integer lowPowerOpenTime) {
		this.lowPowerOpenTime = lowPowerOpenTime;
	}
	public Integer getLowPowerBrightness() {
		return lowPowerBrightness;
	}
	public void setLowPowerBrightness(Integer lowPowerBrightness) {
		this.lowPowerBrightness = lowPowerBrightness;
	}
	public Integer getAwaitOpenTime() {
		return awaitOpenTime;
	}
	public void setAwaitOpenTime(Integer awaitOpenTime) {
		this.awaitOpenTime = awaitOpenTime;
	}
	public Integer getAwaitBrightness() {
		return awaitBrightness;
	}
	public void setAwaitBrightness(Integer awaitBrightness) {
		this.awaitBrightness = awaitBrightness;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Byte getIsExecute() {
		return isExecute;
	}
	public void setIsExecute(Byte isExecute) {
		this.isExecute = isExecute;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public Timestamp getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}	
	public Integer getOnOffSign() {
		return onOffSign;
	}
	public void setOnOffSign(Integer onOffSign) {
		this.onOffSign = onOffSign;
	}
	public Integer getBrightnessSign() {
		return brightnessSign;
	}
	public void setBrightnessSign(Integer brightnessSign) {
		this.brightnessSign = brightnessSign;
	}
	public Integer getInteractionOnOffSign() {
		return interactionOnOffSign;
	}
	public void setInteractionOnOffSign(Integer interactionOnOffSign) {
		this.interactionOnOffSign = interactionOnOffSign;
	}
	public Integer getInteractionOpenTimeSign() {
		return interactionOpenTimeSign;
	}
	public void setInteractionOpenTimeSign(Integer interactionOpenTimeSign) {
		this.interactionOpenTimeSign = interactionOpenTimeSign;
	}
	public Integer getLowPowerOpenTimeSign() {
		return lowPowerOpenTimeSign;
	}
	public void setLowPowerOpenTimeSign(Integer lowPowerOpenTimeSign) {
		this.lowPowerOpenTimeSign = lowPowerOpenTimeSign;
	}
	public Integer getLowPowerBrightnessSign() {
		return lowPowerBrightnessSign;
	}
	public void setLowPowerBrightnessSign(Integer lowPowerBrightnessSign) {
		this.lowPowerBrightnessSign = lowPowerBrightnessSign;
	}
	public Integer getAwaitOpenTimeSign() {
		return awaitOpenTimeSign;
	}
	public void setAwaitOpenTimeSign(Integer awaitOpenTimeSign) {
		this.awaitOpenTimeSign = awaitOpenTimeSign;
	}
	public Integer getAwaitBrightnessSign() {
		return awaitBrightnessSign;
	}
	public void setAwaitBrightnessSign(Integer awaitBrightnessSign) {
		this.awaitBrightnessSign = awaitBrightnessSign;
	}
	public Timestamp getGatewayGainTime() {
		return gatewayGainTime;
	}
	public void setGatewayGainTime(Timestamp gatewayGainTime) {
		this.gatewayGainTime = gatewayGainTime;
	}
	public String getSafetyTime() {
		return safetyTime;
	}
	public void setSafetyTime(String safetyTime) {
		this.safetyTime = safetyTime;
	}
	public Integer getSafetyTimeSign() {
		return safetyTimeSign;
	}
	public void setSafetyTimeSign(Integer safetyTimeSign) {
		this.safetyTimeSign = safetyTimeSign;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getDeviceMacId() {
		return deviceMacId;
	}
	public void setDeviceMacId(String deviceMacId) {
		this.deviceMacId = deviceMacId;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getIbeaconInstruction() {
		return ibeaconInstruction;
	}
	public void setIbeaconInstruction(String ibeaconInstruction) {
		this.ibeaconInstruction = ibeaconInstruction;
	}
	public Integer getIbeaconInstructionSign() {
		return ibeaconInstructionSign;
	}
	public void setIbeaconInstructionSign(Integer ibeaconInstructionSign) {
		this.ibeaconInstructionSign = ibeaconInstructionSign;
	}		
}
