package com.demo.gyb.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class BaseThreadPool {
	public static ScheduledExecutorService scheduledThreadPool = null;
	public static ScheduledExecutorService firewareDataHandlePool = null;
	public static ScheduledExecutorService getScheduledThreadPool(){
		if(null == scheduledThreadPool){
			scheduledThreadPool = Executors.newScheduledThreadPool(50);
		}
		return scheduledThreadPool;
	}
	public static ScheduledExecutorService getFirewareDataHandlePool(){
		if(null == firewareDataHandlePool){
			firewareDataHandlePool = Executors.newScheduledThreadPool(100);
		}
		return scheduledThreadPool;
	}
}
