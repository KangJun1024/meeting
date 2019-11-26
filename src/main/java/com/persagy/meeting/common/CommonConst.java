package com.persagy.meeting.common;

public class CommonConst {

    //时间格式-年月天
    public final static String date_format_day = "yyyyMMdd";
    //时间格式-存储
    public final static String date_format_save = "yyyyMMddHHmmss";
    //时间格式-显示
    public final static String date_format_show = "yyyy-MM-dd HH:mm:ss";

    //标识-项目
    public final static String tag_project = "Pj";
    //字段名称-数据平台
    public final static String info_name_datas = "infos";
    //字段名称-本地名称-项目
    public final static String info_name_local_name_project = "ProjLocalName";

    //一个特殊岗位的信息
    /**
     * 特殊岗位id-systemPosition
     */
    public static final String SPECIAL_POSITION_ID = "systemPosition";
    /**
     * 特殊岗位名称-系统岗位
     */
    public static final String SPECIAL_POSITION_NAME = "系统岗位";
    /**
     * 特殊岗位下的人员id-systemId
     */
    public static final String SPECIAL_PERSON_ID = "systemId";
    /**
     * 特殊岗位id-系统人员
     */
    public static final String SPECIAL_PERSON_NAME = "系统人员";
    /**
     * 中心部门
     */
    public static final String CENTER_DEPT = "中心部门";
    /**
     * 通用部门
     */
    public static final String COMMON_DEPT = "通用部门";
    /**
     * 其他岗位
     */
    public static final String OTHER_POSITION = "其他";

    /**
     * 消息推送，消息类型-待执行任务节点
     */
    public static final String MSG_TYPE_EXECUTE_NODE = "tk_execute";
    /**
     * 消息推送，消息类型-待执行任务节点
     */
    public static final String MSG_TYPE_AUDIT_NODE = "tk_audit";
    /**
     * 消息推送 -节点控制编码control_code：execute-执行
     */
    public static final String CONTROL_CODE_EXECUTE = "execute";
    /**
     * 消息推送 -节点控制编码control_code：audit-审核
     */
    public static final String CONTROL_CODE_AUDIT = "audit";

    /**
     * ES-查询前缀-分组
     */
    public final static String es_group_field_prefix = "by_";
    /**
     * ES-查询后缀-全词匹配
     */
    public final static String es_group_field_end = ".keyword";

    /**
     * Excel模板目录
     */
    public final static String template_dir = "template";
}
