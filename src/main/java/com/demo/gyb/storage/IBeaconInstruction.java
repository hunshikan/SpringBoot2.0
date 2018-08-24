package com.demo.gyb.storage;

public class IBeaconInstruction {
	private Integer totalCount;//ibeacon总条数
	private Integer successCount;//执行成功个数
	private Integer failCount;//失败个数
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getSuccessCount() {
		return successCount;
	}
	public void setSuccessCount(Integer successCount) {
		this.successCount = successCount;
	}
	public Integer getFailCount() {
		return failCount;
	}
	public void setFailCount(Integer failCount) {
		this.failCount = failCount;
	}
	
}
