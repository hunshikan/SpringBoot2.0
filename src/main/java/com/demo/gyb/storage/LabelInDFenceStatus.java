package com.demo.gyb.storage;

import java.util.Map;

/**
 * 定位标签在电子围栏的信息类
 * 
 * @author jianglong 2018年6月29日
 */
public class LabelInDFenceStatus {
	/**
	 * 上次计算的时间
	 */
	private Long lastLocateTime;
	/**
	 * 计算中的信息
	 */
	private CalIngFenceInfo calIngFenceInfo;
	/**
	 * 当前所在的电子围栏Id
	 */
	private Integer nowFenceId;
	/**
	 * 当前所在的电子围栏Id的信号强弱
	 * 
	 * @return
	 */
	private Double nowFenceRss;
	/**
	 * 标签连续几次被判断不在当前围栏
	 * 
	 * @return
	 */
	private int leaveCount;
	/**
	 * 进入时间
	 */
	private int enterTime;

	public Long getLastLocateTime() {
		return lastLocateTime;
	}

	public void setLastLocateTime(Long lastLocateTime) {
		this.lastLocateTime = lastLocateTime;
	}

	public Integer getNowFenceId() {
		return nowFenceId;
	}

	public void setNowFenceId(Integer nowFenceId) {
		this.nowFenceId = nowFenceId;
	}

	public CalIngFenceInfo getCalIngFenceInfo() {
		return calIngFenceInfo;
	}

	public void setCalIngFenceInfo(CalIngFenceInfo calIngFenceInfo) {
		this.calIngFenceInfo = calIngFenceInfo;
	}

	public Double getNowFenceRss() {
		return nowFenceRss;
	}

	public void setNowFenceRss(Double nowFenceRss) {
		this.nowFenceRss = nowFenceRss;
	}

	public int getLeaveCount() {
		return leaveCount;
	}

	public void setLeaveCount(int leaveCount) {
		this.leaveCount = leaveCount;
	}

	public int getEnterTime() {
		return enterTime;
	}

	public void setEnterTime(int enterTime) {
		this.enterTime = enterTime;
	}

	// 存入redis格式转换
	public String toRedis(String labelMacId) {
		return "{\"labelMacId\":\"" + labelMacId + "\",\"fenceId\":" + nowFenceId + ",\"rss\":" + nowFenceRss
				+ ",\"time\":" + lastLocateTime + ",\"enterTime\":" + enterTime + "}";
	}

	// 从redis读出
	public void setFromRedis(Map<String, Object> redisData) {
		this.nowFenceId = (Integer) redisData.get("fenceId");
		this.nowFenceRss = (Double) redisData.get("rss");
		this.lastLocateTime = (Long) redisData.get("time");
		this.enterTime = (Integer) redisData.get("enterTime");
	}
}
