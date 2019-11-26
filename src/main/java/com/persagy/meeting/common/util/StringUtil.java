package com.persagy.meeting.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.micrometer.core.instrument.util.StringUtils;

import java.util.Map;
import java.util.UUID;

/**
 * Created by gsc on 17/5/16.
 */

public class StringUtil {
    public static boolean isNull(JSONArray lackFields, JSONObject jsonObject, String... params) {
        lackFields = lackFields == null ? new JSONArray() : lackFields;
        if (jsonObject == null)
            return false;
        Object value;
        for (String param : params) {
            value = jsonObject.get(param);
            if (value instanceof JSONObject) {
                if (value == null || ((JSONObject) value).isEmpty()) {
                    if (!lackFields.contains(param))
                        lackFields.add(param);
                }
            } else if (value instanceof JSONArray) {
                if (value == null || ((JSONArray) value).isEmpty()) {
                    if (!lackFields.contains(param))
                        lackFields.add(param);
                }
            } else {
                if (value == null || "".equals(JSON.toJSON(value))) {
                    if (!lackFields.contains(param))
                        lackFields.add(param);
                }
            }
        }
        return lackFields.size() != 0;
    }

    public static boolean isNull(String... params) {
        for (String param : params) {
            if (param == null || "".equals(param)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNull(JSONObject jsonObject, String... params) {
        for (String param : params) {
            if (isNull(jsonObject.getString(param))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmptyList(JSONObject jsonObject, String... params) {
        JSONArray jsonArray;
        for (String param : params) {
            jsonArray = jsonObject.getJSONArray(param);
            if (jsonArray == null || jsonArray.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param map
     * @param marjors
     * @return
     */
    public static <K, V> boolean containKeys(Map<K, V> map, String... marjors) {
        for (String marjor : marjors) {
            if (!map.containsKey(marjor) || map.get(marjor) == null) {
                return false;
            }
        }
        return true;
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 根据建筑ID获取建筑下空楼层的ID
     * 
     * @param buildId
     * @return
     */
    public static String getEmptyFloorId(String buildId) {
        if (buildId.startsWith("Bd")) {
            return "Fl" + buildId.substring(2) + "000";
        } else {
            return null;
        }
    }

    /**
     * 获取设备或系统的类型
     * 
     * @param id 设备、系统ID
     * @return
     */
    public static String getEquipOrSystemCodeFromId(String id) {
        if (id.startsWith("Eq")) {
            return id.substring(id.length() - 9, id.length() - 3);
        } else if (id.startsWith("Sy")) {
            return id.substring(id.length() - 7, id.length() - 3);
        } else if (id.startsWith("Sop")) {
            return id.substring(13, 17);
        } else {
            return null;
        }
    }

    /**
     * 右侧补齐String长度
     * 
     * @param str
     * @param length
     * @param sign
     * @return
     */
    public static String completLengthFromRight(String str, int length, String sign) {
        while (str.length() < length) {
            str = str + sign;
        }
        return str;
    }

    /**
     * 右侧补齐String长度
     * 
     * @param str
     * @param length
     * @param sign
     * @return
     */
    public static String completLengthFromLeft(String str, int length, String sign) {
        while (str.length() < length) {
            str = sign + str;
        }
        return str;
    }

    /**
     * 得到指定表id
     * @param prefix 前缀
     * @return
     */
    public static String getDesignatedUUID(String prefix) {
        return prefix + getUUID();
    }

    /**
     * 根据key返回字符串  无值则返回"" 有则返回值
     * @param jsObject
     * @param key
     * @return
     */
    public static String getJSONString(JSONObject jsObject, String key) {
        String value = jsObject.getString(key);
        if (StringUtils.isNotEmpty(value)) {
            return value;
        }
        return "";
    }

    /**
     * 过滤null null转化为空字符串
     * @param str
     */
    public static String nullChangeEmptyString(String str) {
        return str == null ? "" : str;
    }

    /**String
    * 用于修改时  根据传参检查是否为null  
    * 不为null 则赋值  否则不赋值
    * @param setObject
    * @param jsObject
    * @param key
    */
    public static void setUpdateStringVal(JSONObject setObject, JSONObject jsObject, String key) {
        String value = jsObject.getString(key);
        if (value != null) {
            setObject.put(key, value);
        }
    }

    /**Jsonarray
     * 用于修改时  根据传参检查是否为null  
     * 不为null 则赋值  否则不赋值
     * @param setObject
     * @param jsObject
     * @param key
     */
    public static void setUpdateArrayVal(JSONObject setObject, JSONObject jsObject, String key) {
        JSONArray value = jsObject.getJSONArray(key);
        if (value != null) {
            setObject.put(key, value);
        }
    }

    /**Jsonarray
     * 用于修改时  根据传参检查是否为null
     * 不为null 则赋值  否则不赋值
     * 执行去重处理
     * @param setObject
     * @param jsObject
     * @param key
     * @param field
     */
    public static void setUpdateArrayValWithoutRepetition(JSONObject setObject, JSONObject jsObject, String key, String field) {
        JSONArray value = jsObject.getJSONArray(key);
        if (value != null) {
            setObject.put(key, JSONUtil.removeRepeatObjectByField(value, field));
        }
    }

    /**Jsonobject
     * 用于修改时  根据传参检查是否为null  
     * 不为null 则赋值  否则不赋值
     * @param setObject
     * @param jsObject
     * @param key
     */
    public static void setUpdateObjectVal(JSONObject setObject, JSONObject jsObject, String key) {
        JSONObject value = jsObject.getJSONObject(key);
        if (value != null) {
            setObject.put(key, value);
        }
    }

}
