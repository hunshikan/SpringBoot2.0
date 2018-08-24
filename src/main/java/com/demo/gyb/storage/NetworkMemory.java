package com.demo.gyb.storage;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NetworkMemory {
	public static Map<String, Integer> networkDisconnectMap = new ConcurrentHashMap<String, Integer>();// key:网络Id,value:判断离线时间;
	/**
	 *  网络开关设置状态
	 *  0 都关闭
	 *  1 被动关  围栏开
	 *  2 被动开  围栏关
	 *  3 都开启
     */
    public static Map<String,Integer> networkConfigMap = new ConcurrentHashMap<String,Integer>(); //key:网络Id,value:开关设置状态
	public static Map<String, String> networkGatewayMap = new ConcurrentHashMap<String, String>();// key:网关Id,value:网络Id;
	/**
	 * 网关获取网络指令的状态,map中有，说明正在取
	 */
	public static Map<String, Object> getItsStatusMap = new HashMap<String, Object>();//
}
