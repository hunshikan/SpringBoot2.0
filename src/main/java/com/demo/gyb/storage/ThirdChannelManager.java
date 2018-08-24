package com.demo.gyb.storage;

public class ThirdChannelManager {
    private Thread thread;
    private boolean isTimeOut;
    private String resultStr;
	public Thread getThread() {
		return thread;
	}
	public void setThread(Thread thread) {
		this.thread = thread;
	}
	public boolean isTimeOut() {
		return isTimeOut;
	}
	public void setTimeOut(boolean isTimeOut) {
		this.isTimeOut = isTimeOut;
	}
	public String getResultStr() {
		return resultStr;
	}
	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
	}
    
}
