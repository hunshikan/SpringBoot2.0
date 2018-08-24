package com.demo.gyb.constant;

public class IotConstant {

	/**
	 * 接口返回错误码定义
	 */
	public static final int RESULT_CODE_SUCCESS = 0; // 成功
	public static final int RESULT_CODE_TOKEN_NULL = -1; // token为空
	public static final int RESULT_CODE_INVALID_TOKEN = 100; // token失效
	public static final int RESULT_USER_NAME_WRONG = 101; // 用户名错误
	public static final int RESULT_USER_PWD_WRONG = 102; // 密码错误
	public static final int RESULT_USER_NOT_EXIST = 103; // 用户不存在
	public static final int RESULT_USER_NO_IDENTICAL_TOKEN = 104; // 用户号和token不一致
	public static final int RESULT_CODE_DATA_NOT_FIND = 201; // 请求数据不存在
	public static final int RESULT_CODE_IMAGE_UPLOAD__FIND = 202; // 上传图片失败
	public static final int RESULT_CODE_DATA_ADD__FIND = 203; // 新增数据失败
	public static final int RESULT_CODE_DATA_UPDATE__FIND = 204; // 更新数据失败
	public static final int RESULT_CODE_DATA_DELETE_FIND = 205; // 删除数据失败
	
	public static final int RESULT_CODE_PARAM_ERROR = 400; // 请求参数有误
	public static final int RESULT_CODE_SIGN_ERROR = 403; // 请求参数签名错误
	public static final int RESULT_CODE_OP_NOT_FOUND = 404; // 请求地址不存在
	public static final int RESULT_CODE_SIGN_VALIDATE_ERROR = 405; // 签名验证失败
	public static final int RESULT_CODE_PASSWORD_NOT_CHANGE = 410; // 新密码与旧密码相同

	public static final int RESULT_CODE_INTERNAL_ERROR = 500; // 内部异常
	
	
	public static final int RESULT_CODE_NOT_SUPPORT = 600; // 该业务不支持
	public static final int RESULT_CODE_OP_NOT_ALLOWED = 601; // 操作不允许
	public static final int RESULT_CODE_SUBSCRIPTIONS_FAIL = 602; // 订阅失败
	public static final int RESULT_CODE_USER_NO_AUTHORITY = 666; // 用户没有操作权限
	public static final int RESULT_CODE_THIRDPARTY_ERROR = 700; // 第三方服务错误
	
	/**
	 *  第三方接入物联平台的错误码,范围800-900
	 */
	public static final int RESULT_CODE_THIRD_VALIDATE_ERROR = 800; // 第三方身份验证失败
	public static final int RESULT_CODE_THIRD_TIME_OUT = 801; // 接受指令失败
	public static final int RESULT_CODE_THIRD_DEVICE_UN_ONLINE = 802; // 设备离线
	public static final int RESULT_CODE_THIRD_DEVICE_NO_EXIST = 803; // 设备不存在
	public static final int RESULT_CODE_THIRD_GATEWAY_NO_ONLINE = 804; // 网关离线
	public static final int RESULT_CODE_THIRD_GATEWAY_NO_EXIST = 805; // 未找到设备对应的网关
	public static final int RESULT_CODE_CURRENT_DEVICE_TYPE_UNSUPPORTED = 1101; // 当前硬件类型不支持
	
	public static final int RESULT_CODE_CODE_NO_EXIST = 1200; // 校验码不存在
	public static final int RESULT_CODE_CODE_INVALID = 1201; // 校验码已失效
	/**
	 * 物联接入第三方的错误码，范围800-900，其他业务勿用
	 */
	
	/**
    * 校验码有效期,毫秒
    */
	public static final int CODE_INVALID_TIME = 1000*60*60*24;
	/**
	 * 网络指令的开始随机数
	 */
	public static final int NETWORK_COM_NEXT_SIGN_START = 32768;
	/**
	 * 网络指令的结束随机数
	 */
	public static final int NETWORK_COM_NEXT_SIGN_END = 65534;
	/**
	 * 网关获取新指令的延迟时间(毫秒)
	 */
	public static final int GATEWAY_GAIN_DELAY_TIME = 2 * 1000;
	/**
	 *  网关获取新指令的延迟的信息，放入redis的前缀
	 */
	public static final String GATEWAY_GAIN_DELAY_REDIS_PRE = "command_";
	/**
	 *  网关获取特殊指令的延迟的信息，放入redis的前缀
	 */
	public static final String GATEWAY_GAIN_DELAY_SPECIAL_REDIS_PRE = "special_command_";
	/**
	 * 每个网络最多设置几条安防信息
	 */
	public static final int NETWORK_SAFETY_ADD_MAX = 5;
	/**
	 * 每个组最多有几条安防信息
	 */
	public static final int NETWORK_GROUP_SAFETY_MAX = 3;
	/**
	 * 同一个安防信息的预警时间间隔(毫秒)
	 */
	public static final long SAFETY_WARNING_INTERVAL_TIME = 60 * 1000; 
	/**
	 *  一天安防信息的安防时间最多划分成几块
	 */
	public static final int SAFETY_TIME_DIVIDE_AREA_MAX = 5;
	/**
	 * 时间戳的格式，1是到毫秒,1000是到秒
	 */
	public static final int UNIT_TIME_FORMAT = 1000;
	/**
	 * 网络中地图序号初始值 ：1
	 */
	public static final int MAP_SERNUM_INITIAL_VALUE = 1;
	/**
	 * 地图原点坐标 (0.0,0.0)
	 */
	public static final double ORIGINCOORDINATE_X = 0.0 ;
	public static final double ORIGINCOORDINATE_Y = 0.0 ;
	/**
	 * 一天的时间值  毫秒
	 */
	public static final long ONE_DAY_TIME = 1000 * 60 * 60 * 24;
	/**
	 * 一周的时间值  毫秒
	 */
	public static final long ONE_WEEK_TIME = 1000 * 60 * 60 * 24 * 7;
	/**
	 * ibeacon uuid最大长度
	 */
	public static final int IBEACON_UUID_LENGTH_MAX = 32;
	/**
	 * ibeacon major minjor  最大值 65535 最小值 0
	 */
	public static final int IBEACON_MAJOR_MAX = 65535;
	public static final int IBEACON_MAJOR_MIN = 0;
	/**
	 * websocket的token验证超时时间(毫秒)
	 */
	public static final int WEBSOCKET_TOKEN_VALIDATE_TIME_OUT = 3 * 1000;
	/**
	 * 地图比例尺最大值 9999.9999 最小值 0
	 */
	public static final double MAP_SCALE_MAX = 9999.9999;
	public static final double MAP_SCALE_MIN = 0;
	/**
	 * 用户名字的最长字符 30
	 */
	public static final double USER_NAME_MAX = 30;
	/**
	 * log文件名称
	 */
	public static final String LOG_NAME_THIRD = "third";
	public static final String LOG_NAME_LOCATE = "locate";
	public static final String LOG_NAME_FIRMWARE = "firmware";
	/**
	 * 设备电子围栏的最小定位时间(毫秒)
	 */
	public static final Long DEVICE_FENCE_LOCATE_MIN_TIME = 6000l;
	/**
	 * 设备电子围栏的最小定位时间(毫秒)
	 */
	public static final Long DEVICE_FENCE_LOCATE_MAX_TIME = 12000l;
	/**
	 * 设备电子围栏权重差值
	 */
	public static final double DEVICE_FENCE_WEIGHT = 3;
	/**
	 * 设备电子围栏单个标签累积多少条数据就计算一次定位
	 */
	public static final int DEVICE_FENCE_LOCATE_MAX_NUM = 10;
	/**
	 * 灯感应范围 单位：米
	 */
	public static final int INTERACTION_RANGE_MAX = 100;
	public static final int INTERACTION_RANGE_MIN = 10;
	public static final int INTERACTION_RANGE_DEFAULT = 20;
	/**
	 * 灯渐变时间 unit： ms
	 */
	public static final int DEVICE_BRIGHTEN_DARKEN_MAX = 300000;
	public static final int DEVICE_BRIGHTEN_DARKEN_MIN = 500;
	public static final int DEVICE_BRIGHTEN_DARKEN_DEFAULT = 500;
	/**
	 * ms 转 s
	 */
	public static final double TURN_SENCOND = 1000;
	/**
	 * 单个网络下可以创建电子围栏最大的个数 ：20个
	 */
	public static final int FENCE_MAX_COUNT = 20;
	
}
