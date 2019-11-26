/**
 * @包名称 com.sagacloud.common
 * @文件名 ToolsUtil.java
 * @创建者 wanghailong
 * @邮箱 wanghailong@persagy.com  
 * @修改描述 
 */

package com.persagy.meeting.common.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.UUID;

/** 
 * 功能描述： 常用工具方法
 * @类型名称 ToolsUtil
 * @创建者 wanghailong
 * @邮箱 wanghailong@persagy.com  
 * @修改描述 
 */
public class ToolsUtil {
    //返回项-缺少必填项
    public final static String return_error_json = "{\"Result\":\"failure\",\"ResultMsg\":\"缺少必填项\"}";

    public static String errorJsonMsg(String msg) {
        JSONObject jsonRes = new JSONObject();
        jsonRes.put("Result", "failure");
        jsonRes.put("ResultMsg", msg);
        return jsonRes.toString();
    }

    /**
     * 缺少必填项参数
     * @param msg
     * @return
     */
    public static String lackParamErrorJsonMsg(String msg) {
        JSONObject jsonRes = new JSONObject();
        jsonRes.put("Result", "failure");
        jsonRes.put("ResultMsg", MessageFormat.format("缺少必填项【{0}】", msg));
        return jsonRes.toString();
    }

    public static String errorJsonMsgForMissFiled(JSONArray lackFields) {
        JSONObject jsonRes = new JSONObject();
        jsonRes.put("Result", "failure");
        jsonRes.put("ResultMsg", "缺少必填项:" + lackFields.toJSONString());
        return jsonRes.toString();
    }

    public static String successJsonMsg(JSONArray array) {
        JSONObject jsonRes = new JSONObject();
        jsonRes.put("Result", "success");
        jsonRes.put("Content", array);
        jsonRes.put("Count", array.size());
        return jsonRes.toJSONString();
    }

    public static String successJsonMsg(JSONArray array,int count) {
        JSONObject jsonRes = new JSONObject();
        jsonRes.put("Result", "success");
        jsonRes.put("Content", array);
        jsonRes.put("Count", count);
        return jsonRes.toString();
    }

    public static String successJsonMsg(JSONObject object) {
        JSONObject jsonRes = new JSONObject();
        jsonRes.put("Result", "success");
        jsonRes.put("Item", object);
        return jsonRes.toJSONString();
    }

    public static String successJsonMsg(String resultMsg) {
        JSONObject jsonRes = new JSONObject();
        jsonRes.put("Result", "success");
        jsonRes.put("ResultMsg", resultMsg);
        return jsonRes.toJSONString();
    }

    public static String successJsonMsg(JSONObject object, String resultMsg) {
        JSONObject jsonRes = new JSONObject();
        jsonRes.put("Result", "success");
        jsonRes.put("Item", object);
        jsonRes.put("ResultMsg", resultMsg);
        return jsonRes.toJSONString();
    }

    public static String getUuid() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid;
    }

    public static String getRecordId(String prefix) {
        String recordId = "";
        if (!StringUtil.isNull(prefix)) {
            recordId = prefix;
        }
        recordId = recordId + UUID.randomUUID().toString().replace("-", "");
        return recordId;
    }

    /**
     * 判断当前记录是否在分页的页码记录内
     * @param isPage
     * @param startIndex
     * @param endIndex
     * @param index
     * @return
     */
    public static boolean isInPage(boolean isPage, int startIndex, int endIndex, int index) {
        if (!isPage) {
            return true;
        }
        if (index >= startIndex && index < endIndex) {
            return true;
        }
        return false;
    }

    /**
     * Description:保留两位小数
     * @return double
     * @author lijie
     * @since 2018年8月22日: 下午3:45:30
     * Update By lijie 2018年8月22日: 下午3:45:30
     */
    public static double holdTwoDecimal(double srcData) {
        return new BigDecimal(srcData).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
