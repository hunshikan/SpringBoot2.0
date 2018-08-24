package com.demo.gyb.constant;

public class DictionaryConstant {    
	/**
     * 随机码类型 1:注册码 2:修改密码 3:找回密码 
     */
    public static final byte IOT_MAIL_CODE_TYPE_1 = 1;
    public static final byte IOT_MAIL_CODE_TYPE_2 = 2;
    public static final byte IOT_MAIL_CODE_TYPE_3 = 3;
    /**
     * 用户角色ID, 1:普通用户 2:管理员 3:超级管理员
     */
    public static final byte IOT_ROLE_ID_1 = 1;
    public static final byte IOT_ROLE_ID_2 = 2;
    public static final byte IOT_ROLE_ID_3 = 3;
    /**
     * 注册方式 1:邮箱
     */
    public static final byte IOT_REGISTER_TYPE_1 = 1;
    /**
     * 请求来源  1:web 2:app,3:第三方
     */
    public static final int IOT_REQUEST_ORIGIN_TYPE_1 = 1;
    public static final int IOT_REQUEST_ORIGIN_TYPE_2 = 2;
    public static final int IOT_REQUEST_ORIGIN_TYPE_3 = 3;
    /**
     * redis中token的前缀
     */
    public static final String IOT_TOKEN_PRE_WEB = "web_";
    public static final String IOT_TOKEN_PRE_APP = "app_";
    public static final String IOT_TOKEN_PRE_THIRD = "third_";
    /**
     * 设备状态  0：在线 1：不在线 
     */
    public static final byte IOT_DEVICE_STATIC_0 = 0;
    public static final byte IOT_DEVICE_STATIC_1 = 1;
    /**
     * 该条配置是否已执行 0：未执行，1：已执行,2:执行中,3:网关执行失败,4:网关执行失败,5:网关执行成功
     */
    public static final byte IOT_NETWORK_GROUP_COMMAND_0 = 0;
    public static final byte IOT_NETWORK_GROUP_COMMAND_1 = 1;
    public static final byte IOT_NETWORK_GROUP_COMMAND_2 = 2;
    public static final byte IOT_NETWORK_GROUP_COMMAND_3 = 3;
    public static final byte IOT_NETWORK_GROUP_COMMAND_4 = 4;
    public static final byte IOT_NETWORK_GROUP_COMMAND_5 = 5;
    /**
     * 网络配置是否已执行 0：未执行，1：已执行,2:执行中,3:网关执行失败,4:网关执行失败,5:网关执行成功
     */
    public static final byte IOT_INSTRUCTIONS_STATUS_0 = 0;
    public static final byte IOT_INSTRUCTIONS_STATUS_1 = 1;
    public static final byte IOT_INSTRUCTIONS_STATUS_2 = 2;
    public static final byte IOT_INSTRUCTIONS_STATUS_3 = 3;
    public static final byte IOT_INSTRUCTIONS_STATUS_4 = 4;
    public static final byte IOT_INSTRUCTIONS_STATUS_5 = 5;
    /**
     * sign签名校验的失效时间(秒)
     */
    public static final int IOT_SIGN_LOSE_EFFICACY_TIME = 20;
    /**
     * 一个账号最多创建几个网络
     */
    public static final int IOT_CREATE_NETWORK_MAX_COUNT = 15;
    /**
     * 网络管理员的类型  0:网络管理员 1:网络创建者 
     */
    public static final byte IOT_NETWORK_MANAGER_TYPE_0 = 0;
    public static final byte IOT_NETWORK_MANAGER_TYPE_1 = 1;
    /**
     * 网络分组类型  1:灯
     */
    public static final byte IOT_NETWORK_GROUP_TYPE_1 = 1;
    /**
     * 邮件校验码的状态 0:未使用 1:已使用
     */
    public static final byte IOT_MAIL_CODE_FLAG_0 = 0;
    public static final byte IOT_MAIL_CODE_FLAG_1 = 1;
    /**
     * 网络分组配置开启开关的标识  0:关闭 1:开启
     */
    public static final byte IOT_GROUP_CONFIG_ONOFF_0 = 0;
    public static final byte IOT_GROUP_CONFIG_ONOFF_1 = 1;
    /**
     * 设备是否预安装  0:预安装 1:安装
     */
    public static final byte IOT_DEVICE_IS_PREINSTALL_0 = 0;
    public static final byte IOT_DEVICE_IS_PREINSTALL_1 = 1;
    /**
     * 设备预警类型  1:安防预警
     */
    public static final byte IOT_DEVICE_WARNING_TYPE_1 = 1;
    /**
     * 消息类型 1:公告，2:账号信息，3:报警信息 ，4:其他
     */
    public static final byte IOT_USERMESSAGE_TYPE_1 = 1;
    public static final byte IOT_USERMESSAGE_TYPE_2 = 2;
    public static final byte IOT_USERMESSAGE_TYPE_3 = 3;
    public static final byte IOT_USERMESSAGE_TYPE_4 = 4;
    /**
     * 消息类型 阅读状态 0 未读， 1 已读
     */
    public static final byte IOT_USERMESSAGE_ISREAD_0 = 0;
    public static final byte IOT_USERMESSAGE_ISREAD_1 = 1;
    /**
     * 网关预警阅读状态 0 未未预警， 1 已预警
     */
    public static final byte IOT_GATEWAY_INFO_ISWARNING_0 = 0;
    public static final byte IOT_GATEWAY_INFO_ISWARNING_1 = 1;
    /**
     * 今日计划的消息类型 0:分组感应时间    1:安防时间
     */
    public static final int DUE_TODAY_MESSAGE_TYPE_0 = 0;
    public static final int DUE_TODAY_MESSAGE_TYPE_1 = 1;
    /**
     * 固件类型 1 设备升级  2 独立版本//
     */
    public static final byte IOT_FIRMWARE_INFO_FRIMWARE_TYPE_1 = 1;
    public static final byte IOT_FIRMWARE_INFO_FRIMWARE_TYPE_2 = 2;
    /**
     * 第三方的设备是否在线 0:在线,1:离线
     */
    public static final int IOT_THIRD_DEVICE_ONLINE_STATUS_0 = 0;
    public static final int IOT_THIRD_DEVICE_ONLINE_STATUS_1 = 1;
    /**
     * 网络类型 1:标准网络,2:简易网络
     */
    public static final int IOT_NETWORK_TYPE_1 = 1;
    public static final int IOT_NETWORK_TYPE_2 = 2;
    /**
     * 网络apiKey的长度
     */
    public static final int NETWORK_API_KEY_LENGTH = 32;
    /**
     * 用户登录令牌的长度
     */
    public static final int IOT_USER_TOKEN_LENGTH = 32;
    /**
     * 网络指令随机数的长度
     */
    public static final int NETWORK_COMMAND_SIGN_LENGTH = 24;
    /**
     * 设备类型type   1:网关  2:设备  3:第三方设备
     */
    public static final int HARDWARE_INFO_TYPE_1 = 1;
    public static final int HARDWARE_INFO_TYPE_2 = 2;
    public static final int HARDWARE_INFO_TYPE_3 = 3;
    /**
     * 硬件版本号
     */
    public static final byte HARDWARE_INFO_BUILD = 1;
    /**
     * 用户ApiKey的前缀
     */
    public static final String USER_API_KEY_PRE = "pre_";
    /**
     * websocket的用户属性标识
     */
    public static final String WEBSOCKET_USERID = "websocket_userId";
    /**
     * 请求来源
     */
    public static final String IOT_REQUEST_ORIGIN_TYPE_WEB = "web";
    public static final String IOT_REQUEST_ORIGIN_TYPE_APP = "app";
    /**
     * 网络状态  0:在线  1:离线 2:未安装网关 3:未安装设备 4:网关离线
     */
    public static final int IOT_NETWORK_STATUS_0 = 0 ;
    public static final int IOT_NETWORK_STATUS_1 = 1 ;
    public static final int IOT_NETWORK_STATUS_2 = 2 ;
    public static final int IOT_NETWORK_STATUS_3 = 3 ;
    public static final int IOT_NETWORK_STATUS_4 = 4 ;
    /**
     * 指令下发的类型,1:整个网络 2:单个分组 3:单个网关 4:单个设备
     */
    public static final int IOT_INSTRUCTION_TYPE_1 = 1;
    public static final int IOT_INSTRUCTION_TYPE_2 = 2;
    public static final int IOT_INSTRUCTION_TYPE_3 = 3;
    public static final int IOT_INSTRUCTION_TYPE_4 = 4;
    /**
     * 指令优先级  0:指令下发 ,1:灯参数下发 2:ibeacon下发
     */
    public static final int IOT_INSTRUCTION_PRIORITY_0 = 0;
    public static final int IOT_INSTRUCTION_PRIORITY_1 = 1;
    public static final int IOT_INSTRUCTION_PRIORITY_2 = 2;
    /**
     * rest回调的数据类型
     */
    public static final String REST_RES_TYPE_300 = "res300";
    public static final String REST_RES_TYPE_301 = "res301";
    /**
     * 单个设备配置的状态 1:实时 2:过期 
     */
    public static final int IOT_DEVICE_STATUS_1 = 1;
    public static final int IOT_DEVICE_STATUS_2 = 2;
   
    /**
     * 设备是否在其他地图上  1:是    0:否
     */
    public static final int IOT_INOTHER_MAP_1 = 1 ;
    public static final int IOT_INOTHER_MAP_0 = 0 ;
    /**
     * 服务器中地图的相对路径 ：/iot_file/image/
     */
    public static final String IOT_SERVER_MAP_URL = "/iot_file/image/";
    /**
     * 上传图片最大值
     */
    public static final int MAP_SIZE = 10 *1024 *1024 ;
    /**
     * ibeacon 绑定状态 1 绑定    0未绑定   
     */
    public static final int IBEACON_BIND_STATU_1 = 1;
    public static final int IBEACON_BIND_STATU_0 = 0;
    /**
     * ibeacon下发命令的类型 1：绑定 2：解绑
     */
    public static final byte IBEACON_COMMAND_TYPE_1 = 1;
    public static final byte IBEACON_COMMAND_TYPE_2 = 2;
    /**
     * 上传ibeacon ids文件excel 的最大值 1M
     */
    public static final int IBEACON_ID_SIZE = 1 *1024 *1024 ;
    /**
     * 消息类别type2   1:设备离线预警  2：安防预警
     */
    public static final byte IOT_USERMESSAGE_TYPE2_1 = 1;
    public static final byte IOT_USERMESSAGE_TYPE2_2 = 2;
    /**
     * ibeacon下发成功失败的标识 
     */
    public static final int IBEACON_SEND_SUCCESS = 1;
    public static final int IBEACON_SEND_FAIL = 0;
    /**
     * 发布公告的接收对象  0：所有人 , 1：指定人
     */
    public static final int IOT_MESSAGE_RECEIVE_TYPE_0 = 0;
    public static final int IOT_MESSAGE_RECEIVE_TYPE_1 = 1;
    /**
     * 网络是否具有 对应的网络功能 flag   0：不具备   1:具备
     */
    public static final int IOT_NETWORK_FUNCTION_FLAG_0 = 0;
    public static final int IOT_NETWORK_FUNCTION_FLAG_1 = 1;

    /**
     * 安防报警状态type   1:进入,2:持续中,3:离开
     */
    public static final int SAFETY_INFO_TYPE_1 = 1;
    public static final int SAFETY_INFO_TYPE_2 = 2;
    public static final int SAFETY_INFO_TYPE_3 = 3;
    /**
     * 电子围栏事件类型 1:进入 2:离开
     */
    public static final byte FENCE_EVENT_TYPE_ENTER = 1;
    public static final byte FENCE_EVENT_TYPE_LEAVE = 2;
    /**
     * 电子围栏顶点坐标个数范围(3 ~ 12), 构成电子围栏 设备最大个数 50
     */
    public static final int FENCE_POINTS_COUNT_MIN = 3;
    public static final int FENCE_POINTS_COUNT_MAX = 12;
    public static final int FENCE_POINTS_DEVICE_COUNT_MAX = 50;
    /**
    /**
     * 电子围栏类型 1:多边形 2:设备    0：全部类型
     */
    public static final int FENCE_TYPE_0 = 0;
    public static final int FENCE_TYPE_1 = 1;
    public static final int FENCE_TYPE_2 = 2;
    /**
     * 第三方设备(柜子) 设备类型
     */
    public static final int THIRD_CABINET_DEVICETYPE_7009 = 7009;
    /**
     * 是否开启标签定位  0：关闭      1：开启
     */
    public static final int LABLE_LOACATE_OFF = 0;
    public static final int LABLE_LOACATE_ON = 1;
    /**
     * 电子围栏的离开阀值  默认 10s
     */
    public static final int DEVICE_LEAVE_LIMIT = 10;
    /**
     * 电子围栏的离开阀值 最大值 1800s
     */
    public static final int DEVICE_LEAVE_LIMIT_MAX = 1800;
    /**
     * 电子围栏的时间类型 1 进入  2 离开   0:全部事件类型
     */
    public static final int FENCE_WARNING_TYPE_0 = 0;
    public static final int FENCE_WARNING_TYPE_1 = 1;
    public static final int FENCE_WARNING_TYPE_2 = 2;
    
}
