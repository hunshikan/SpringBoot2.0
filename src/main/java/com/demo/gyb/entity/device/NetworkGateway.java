package com.demo.gyb.entity.device;

import java.sql.Timestamp;

public class NetworkGateway {
    private Integer dataId;
    private String networkId;
    private Integer gatewayId;
    private Timestamp createTime;
    private String gateMacId;
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
	public Integer getGatewayId() {
		return gatewayId;
	}
	public void setGatewayId(Integer gatewayId) {
		this.gatewayId = gatewayId;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getGateMacId() {
		return gateMacId;
	}
	public void setGateMacId(String gateMacId) {
		this.gateMacId = gateMacId;
	}
    
}
