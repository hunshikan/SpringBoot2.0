package com.demo.gyb.storage;

import java.util.concurrent.locks.Lock;

public class NetworkSign {
    private Integer networkNextSign;
    private Lock lock;
	public Integer getNetworkNextSign() {
		return networkNextSign;
	}
	public void setNetworkNextSign(Integer networkNextSign) {
		this.networkNextSign = networkNextSign;
	}
	public Lock getLock() {
		return lock;
	}
	public void setLock(Lock lock) {
		this.lock = lock;
	}
    
}
