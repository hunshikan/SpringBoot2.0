package com.demo.gyb.constant;

public class FirmwareConstant {
	/**
	 * 协议请求版本号和返回版本号的差值
	 */
	public static final int IOT_AGREEMENT_NO_DIFFER = 2000;
	/**
	 * 系统支持的最高协议版本号
	 */
	public static final int IOT_FIRMWARE_MSG_VER_MAX = 6000;
	/**
	 * 系统支持的最低协议版本号
	 */
	public static final int IOT_FIRMWARE_MSG_VER_MIN = 5002;
	/**
	 * 灯设备的类型
	 */
	public static final int IOT_FIRMWARE_device_TYPE_7001 = 7001;
	public static final int IOT_FIRMWARE_device_TYPE_7002 = 7002;
	/**
	 * 下发任务指令的类型  1:灯参数
	 */
	public static final int IOT_FIRMWARE_COMMAND_TYPE_1 = 1;
	/**
	 * 判断心跳包断链的时间间隔(秒)
	 */
	public static final int IOT_FIRMWARE_DISCONNECT = 60;
	/**
	 * 判断心跳包断链的时间间隔(毫秒)
	 */
	public static final int IOT_FIRMWARE_UPDATE_DISCONNECT = 1000 * 60;
	/**
	 * 判断设备是否在线的时间间隔(秒)
	 */
	public static final int IOT_DEVICE_DISCONNECT = 60 * 60 * 24;
	/**
	 * 判断设备是否在线的时间间隔基础值(秒)
	 */
	public static final int IOT_DEVICE_DISCONNECT_2 = 2 * 60;
	public static final int IOT_DEVICE_DISCONNECT_3 = 3 * 60;
	public static final int IOT_DEVICE_DISCONNECT_5 = 5 * 60;
	public static final int IOT_DEVICE_DISCONNECT_7 = 7 * 60;
	public static final int IOT_DEVICE_DISCONNECT_8 = 8 * 60;
	public static final int IOT_DEVICE_DISCONNECT_13 = 13 * 60;
	public static final int IOT_DEVICE_DISCONNECT_25 = 25 * 60;
	/**
	 * 默认已使用的网关MacId
	 */
	public static final String IOT_USED_GATEWAY_ID= "4C4D48";
	/**
	 * 固件升级每次读取的字节数
	 */
	public static final int FIRMWARE_UPDATE_BYTE_LENGTH = 1024;
	/**
	 * 请求消息版本
	 */
	public static final int IOT_FIRMWARE_MSG_VER_4000 = 4000;
	/**
	 * 请求消息版本
	 */
	public static final int IOT_FIRMWARE_MSG_VER_5000 = 5000;
	/**
	 * 请求消息版本
	 */
	public static final int IOT_FIRMWARE_MSG_VER_5001 = 5001;
	/**
	 * 请求消息版本
	 */
	public static final int IOT_FIRMWARE_MSG_VER_6000 = 6000;
	/**
	 * 返回消息版本
	 */
	public static final int IOT_FIRMWARE_RES_VER_6000 = 6000;
	/**
	 * 返回消息版本
	 */
	public static final int IOT_FIRMWARE_RES_VER_7000 = 7000;
	/**
	 * 返回消息版本
	 */
	public static final int IOT_FIRMWARE_RES_VER_7001 = 7001;
	/**
	 * 返回消息版本
	 */
	public static final int IOT_FIRMWARE_RES_VER_8000 = 8000;
	/**
	 * 签到请求标识
	 */
	public static final String IOT_FIRMWARE_MSG_TYPE_F10000 = "r10000";
	/**
	 * 签到返回标识
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_F10000 = "f10000";
	/**
	 * 重新签到返回标识
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_F10012 = "f10012";
	/**
	 * 登录请求标识
	 */
	public static final String IOT_FIRMWARE_MSG_TYPE_R10001 = "r10001";
	/**
	 * 固件升级的登录请求标识
	 */
	public static final String IOT_FIRMWARE_MSG_TYPE_R30001 = "r30001";
	/**
	 * 登录返回标识
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_F10001 = "f10001";
	/**
	 * 固件升级的登录返回标识
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_F30001 = "f30001";
	/**
	 * 心跳请求标识
	 */
	public static final String IOT_FIRMWARE_MSG_TYPE_R100 = "r100";
	/**
	 * 心跳请求标识(新)
	 */
	public static final String IOT_FIRMWARE_MSG_TYPE_R200 = "r200";
	/**
	 * 心跳请求标识(新)
	 */
	public static final String IOT_FIRMWARE_MSG_TYPE_R300 = "r300";
	/**
	 * 心跳返回标识
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_F100 = "f100";
	/**
	 * 心跳返回标识
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_F200 = "f200";
	/**
	 * 心跳返回标识
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_F300 = "f300";
	/**
	 * 灯状态上传请求标识
	 */
	public static final String IOT_FIRMWARE_MSG_TYPE_R10002 = "r10002";
	/**
	 * 灯能耗数据上传请求标识
	 */
	public static final String IOT_FIRMWARE_MSG_TYPE_R10003 = "r10003";
	/**
	 * 传感器参数上传
	 */
	public static final String IOT_FIRMWARE_MSG_TYPE_R10004 = "r10004";
	/**
	 * 灯状态上传返回标识
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_F10002 = "f10002";
	/**
	 * 灯能耗数据上传返回标识
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_F10003_5001 = "f10003";
	/**
	 * 传感器参数上传返回标识
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_F10004 = "f10004";
	
	/**
	 * 灯状态上传确认包的请求标识
	 */
	public static final String IOT_FIRMWARE_MSG_TYPE_Q10002 = "q10002";
	/**
	 * 服务端返回灯状态上传确认包的请求标识
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_QF10002 = "qf10002";
	/**
	 * 固件发送灯参数下发的确认
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_Q10003 = "q10003";
	/**
	 * 获取未执行的灯参数命令请求标识(4000)
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_R10004 = "r10004";
	/**
	 * 获取未执行的灯参数命令请求标识(5000)
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_R20004 = "r20004";
	/**
	 *固件上次安防信息的请求标识(5001)
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_R20005 = "r20005";
	/**
	 * 下发未执行的灯参数命令返回标识(4000)
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_F10003 = "f10003";
	/**
	 * 下发未执行的灯参数命令返回标识(5000)
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_F20003 = "f20003";
	/**
	 * 获取未执行的灯参数命令返回标识(5000)
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_F20004 = "f20004";
	/**
	 * 固件上次安防信息的返回标识(5001)
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_F20005 = "f20005";
	/**
	 * 服务器主动下发(单个网关)
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_F20013 = "f20013";
	/**
	 * 服务端主动下发特殊指令
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_F20014 = "f20014";
	/**
	 * 获取未执行的灯参数命令确认标识(4000)
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_Q10004 = "q10004";
	/**
	 * 获取未执行的灯参数命令确认标识
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_Q20004 = "q20004";
	/**
	 * 获取未执行的特殊指令的确认标识
	 */
	public static final String IOT_FIRMWARE_MSG_TYPE_Q20014 = "q20014";
	/**
	 * 服务端发送接收到灯参数命令执行结果的确认标识
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_QF20004 = "qf20004";
	/**
	 * 服务端发送接收到特殊指令执行结果的确认标识
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_QF20014 = "qf20014";
	//固件更新
	/**
	 * 固件请求升级文件头信息
	 */
	public static final String IOT_FIRMWARE_MSG_TYPE_R30002 = "r30002";
	public static final String IOT_FIRMWARE_RES_TYPE_F30002 = "f30002";
	/**
	 * 固件发送文件头信息的确认包
	 */
	public static final String IOT_FIRMWARE_MSG_TYPE_Q30002 = "q30002";
	public static final String IOT_FIRMWARE_RES_TYPE_QF30002 = "qf30002";
	/**
	 * 固件请求升级文件内容
	 */
	public static final String IOT_FIRMWARE_MSG_TYPE_R30003 = "r30003";
	public static final String IOT_FIRMWARE_RES_TYPE_F30003 = "f30003";
	/**
	 * 固件发送获取到升级文件内容的确认包
	 */
	public static final String IOT_FIRMWARE_MSG_TYPE_Q30003 = "q30003";
	/**
	 * 固件发送升级文件已全部获取的确认
	 */
	public static final String IOT_FIRMWARE_MSG_TYPE_R30004 = "r30004";
	public static final String IOT_FIRMWARE_RES_TYPE_F30004 = "f30004";
	/**
	 * 下发第三方的指令（服务端主动下发）
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_F40001 = "f40001";
	public static final String IOT_FIRMWARE_MSG_TYPE_Q40001 = "q40001";
	/**
	 * 网关上传设备指令
	 */
	public static final String IOT_FIRMWARE_MSG_TYPE_R40002 = "r40002";
	/**
	 * 上传定位信息
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_R50001 = "r50001";
	public static final String IOT_FIRMWARE_MSG_TYPE_Q50001 = "q50001";
	/**
	 * 上传设备电子围栏信号强弱定位信息
	 */
	public static final String IOT_FIRMWARE_RES_TYPE_R50002 = "r50002";
	//错误码
	/**
	 * 内部错误
	 */
	public static final int IOT_FIRMWARE_RES_ERROR_CODE_1 = 1;
	/**
	 * 入参有误
	 */
	public static final int IOT_FIRMWARE_RES_ERROR_CODE_2 = 2;
	/**
	 * 签名验证失败
	 */
	public static final int IOT_FIRMWARE_RES_ERROR_CODE_3 = 3;
	/**
	 * token验证失败
	 */
	public static final int IOT_FIRMWARE_RES_ERROR_CODE_4 = 4;
	/**
	 * 链接不存在
	 */
	public static final int IOT_FIRMWARE_RES_ERROR_CODE_5 = 5;
	/**
	 * 设备不存在
	 */
	public static final int IOT_FIRMWARE_RES_ERROR_CODE_6 = 6;
	/**
	 * token失效
	 */
	public static final int IOT_FIRMWARE_RES_ERROR_CODE_7 = 7;
	/**
	 * 灯的工作总寿命(小时)
	 */
	public static final int IOT_DEVICE_LIFT = 15000;
	/**
	 * 灯的能耗统计X轴的个数
	 */
	public static final int IOT_DEVICE_EC_X_COUNT = 12;
	/**
	 * 每度电费(元)
	 */
	public static final double IOT_DEVICE_ELECTRIC_CHARGE = 1.1;
	/**
	 * 第三方等待线程前缀
	 */
	public static final String IOT_THIRD_WAIT_PRE = "third_wait_";
	/**
	 * 第三方发送指令的线程名前缀
	 */
	public static final String IOT_THIRD_THREAD_NAME_PRE = "third_thread_";
	/**
	 * 第三方发送指令的内容的前缀
	 */
	public static final String IOT_THIRD_INSTRUCTIONS_CONTENT = "third_content_";
	/**
	 *  第三方发送指令的超时时间(毫秒)
	 */
	public static final int  IOT_THIRD_RESPONSE_TIME_OUT = 5000;
	/**
	 *  第三方等待超时时间(毫秒)
	 */
	public static final int  IOT_THIRD_WAIT_TIME_OUT = 10000;
	/**
	 * 特殊指令执行的超时时间(毫秒)
	 */
	public static final int  IOT_INSTRUCTION_TIME_OUT = 5000;
	 /**
     * 针对整个网络发指令的分组标识，255
     */
    public static final int IOT_NETWORK_ALL_GROUP_ID = 255;
    /**
     * 网关指令回复的超时时间
     */
    public static final int IOT_GATEWAY_TIMEOUT = 10 * 1000;
    /**
     * 网关链接后,几秒内需要登录
     */
    public static final int IOT_GATEWAY_INIT_LOGIN_TIMEOUT = 3 * 1000;
    /**
     * 设备指令回复的超时时间
     */
    public static final int IOT_DEVICE_TIMEOUT = 30 * 1000;
	/**
	 * 指令是否需要返回ak结果 0:不需要,1:需要
	 */
	public static final int IOT_SEND_AK_TYPE_0 = 0;
	public static final int IOT_SEND_AK_TYPE_1 = 1;
	/**
	 * 传感器参数类型  1:温度,2:湿度,3:CO2浓度,4:TVOC,5:气压  
	 */
	public static final int SENSOR_TYPE_1 = 1;
	public static final int SENSOR_TYPE_2 = 2;
	public static final int SENSOR_TYPE_3 = 3;
	public static final int SENSOR_TYPE_4 = 4;
	public static final int SENSOR_TYPE_5 = 5;
	/**
	 * iBeacon信息 uuid指令前缀：0x0351    major/minor 0x0352 开关：0x0357
	 */
	public static final String IOT_IBEACON_UUID_PRE = "435110";
	public static final String IOT_IBEACON_MAJOR_PRE = "435204";
	public static final String IOT_IBEACON_BUTTON_ON = "43570101";
	public static final String IOT_IBEACON_BUTTON_OFF = "43570100";
	/**
	 * iBeacon信息下发  开关
	 */
	public static final String IOT_IBEACON_ON = "01";
	public static final String IOT_IBEACON_OFF = "00";
	/**
	 * 设备上报状态频率,灯点亮时间上报频率 灯感应次数上报频率
	 */
	public static final String DEVICE_STATU_RATA_PRE = "41B004";
	public static final String DEVICE_LIGHT_TIME_RATA_PRE = "41B104";
	public static final String DEVICE_INTERACTION_RATA_PRE = "41B204";
	/**
	 * 设备上报状态频率默认值:300, 灯点亮时间上报频率：3600,灯感应次数上报频率：43200 
	 * unti：S
	 */
	public static final int DEVICE_STATU_RATA_DEFAULT = 300;
	public static final int DEVICE_LIGHT_TIME_RATA_DEFAULT = 3600;
	public static final int DEVICE_INTERACTION_RATA_DEFAULT = 43200;
	/**
	 * 灯局部Mesh，位置信息设置  
	 */
	public static final String DEVICE_LOCATE_MESH = "45540501";
	/**
	 * 灯局部Mesh，位置信息设置  开  01
	 */
	public static final String DEVICE_LOCATE_ON = "01";
	/**
	 * 灯局部Mesh，位置信息设置  关  00
	 */
	public static final String DEVICE_LOCATE_OFF = "00";
	/**
	 * 指令来源 originType -1：管理平台  
	 */
	public static final byte INTERACTION_ORIGINTYPE_1 = -1;
	/**
	 * 网络指令随机数，每次自增的值
	 */
	public static final int NETWORK_COMMAND_NEXT = 16; 
	/**
	 * 固件编号长度 默认值:  6
	 */
	public static final int FIRMWARE_NO_LENGTH = 6;
	/**
	 * 开关
	 */
	public static final String ITS_SEND_ITS_1 = "450901";
	/**
	 * 亮度
	 */
	public static final String ITS_SEND_ITS_2 = "450101";
	/**
	 * 感应开关
	 */
	public static final String ITS_SEND_ITS_3 = "450801";
	/**
	 * 感应时间段
	 */
	public static final String ITS_SEND_ITS_4 = "450D07";
	/**
	 * 多次秒进入待机模式
	 */
	public static final String ITS_SEND_ITS_5 = "450504";
	/**
	 * 待机模式亮度
	 */
	public static final String ITS_SEND_ITS_6 = "450301";
	/**
	 * 多少秒进入低功耗模式
	 */
	public static final String ITS_SEND_ITS_7 = "450404";
	/**
	 * 低功耗模式亮度
	 */
	public static final String ITS_SEND_ITS_8 = "450201";
	/**
	 * 感应范围指令
	 */
	public static final String ITS_SEND_ITS_9 = "455101";
	/**
	 * 变亮变暗时间指令
	 */
	public static final String ITS_SEND_ITS_10 = "451004";
	/**
	 * ibeacon指令:uuid
	 */
	public static final String ITS_SEND_ITS_11_1 = "435110";
	/**
	 * ibeacon指令:major minor
	 */
	public static final String ITS_SEND_ITS_11_2 = "435204";
	/**
	 * ibeacon指令:开关
	 */
	public static final String ITS_SEND_ITS_11_3 = "435701";
	/**
	 * 设备上报状态频率
	 */
	public static final String ITS_SEND_ITS_12 = "41B004";
	/**
	 * 灯点亮时间上报频率
	 */
	public static final String ITS_SEND_ITS_13 = "41B104";
	/**
	 * 灯感应次数上报频率
	 */
	public static final String ITS_SEND_ITS_14 = "41B204";
	/**
	 * 灯位置信息
	 */
	public static final String ITS_SEND_ITS_15 = "455405";
	/**
	 * 安防时间段
	 */
	public static final String ITS_SEND_ITS_16 = "456207";
	/**
	 * 网络功能设置
	 */
	public static final String ITS_SEND_ITS_17 = "436001";
	/**
	 * 网关功能设置(转发  扫描)
	 */
	public static final String ITS_SEND_ITS_18 = "430601";
	/**
	 * 灯感应范围 
	 */
	public static final int INTERACTION_RANGE_PRE = 455101; 
	/**
	 * 灯渐变 设置
	 */
	public static final int DEVICE_BRIGHTEN_DARKEN_PRE = 451004; 
	/**
	 * 灯渐变 默认值
	 */
	public static final String DEVICE_BRIGHTEN_DARKEN_DEFAULT = "0000";
	
	/**
	 * 网络开启定位指令
	 * 00 都关
	 * 01 开启被动
	 * 02 开启围栏定位 
	 */
	public static final String NETWORK_INSTRUCTION_00 = "00";
	public static final String NETWORK_INSTRUCTION_01 = "01";
	public static final String NETWORK_INSTRUCTION_02 = "02";
	/**
	 * 网关 功能选择指令
	 * 00 都关
	 * 01  	开扫描
	 * 02 	开转发
	 * 03  	都开
	 */
	public static final String GATE_INSTRUCTION_00 = "00";
	public static final String GATE_INSTRUCTION_01 = "01";
	public static final String GATE_INSTRUCTION_02 = "02";
	public static final String GATE_INSTRUCTION_03 = "03";
	
	
	//------------------灯默认参数-----------
	/**
	 * 灯感应启用时间  全天(0~24小时，周一~周日)
	 */
	public static final String INTERACTIO_NOPEN_TIME = "0,86340,127";
	/**
	 * 进入低功耗模式的时间 unit ：s   (10分钟)
	 */
	public static final int LOW_POWER_OPEN_TIME = 10 * 60; 
	/**
	 * 待机模式亮度 0
	 */
	public static final int AWAIT_BRIGHTNESS = 0; 
	/**
	 * 待机模式亮度 百分比  100
	 */
	public static final int BRIGHTNESS = 100; 
	/**
	 * 感应开关	 1:开，0：关
	 */
	public static final byte INTERACTION_ON = 1; 
	public static final byte INTERACTION_OFF = 0;
}
