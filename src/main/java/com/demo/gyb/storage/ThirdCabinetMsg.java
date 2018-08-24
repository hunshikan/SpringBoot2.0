package com.demo.gyb.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThirdCabinetMsg {

	 /**
	 * 第三方柜子列表
	 */
	public static List<String> thirdCabinetList = Collections.synchronizedList(new ArrayList<String>()); //设备mac地址列表
}
