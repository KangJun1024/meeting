package com.persagy.meeting.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.micrometer.core.instrument.util.StringUtils;
import java.util.*;

public class JSONUtil {
    /**
     * 转换更新参数
     * 
     * @param jsonObject
     *            用户接口参数,除了过滤项，其它项默认为新增项
     * @return 数据平台接口参数
     */
    public static JSONObject getAddParamJson(JSONObject jsonObject) {
        JSONObject paramJson = new JSONObject();
        paramJson.put("insertObject", jsonObject);
        return paramJson;
    }

    /**
     * 转换批量插入参数
     * @return 数据平台接口参数
     */
    public static JSONObject getAddParamJson(JSONArray jsonArray) {
        JSONObject paramJson = new JSONObject();
        paramJson.put("insertObjects", jsonArray);
        return paramJson;
    }

    /**
     * 转换主键查询参数
     * 
     * @param jsonObject
     *            用户接口数据
     * @param majors
     *            主键
     * @return 数据平台接口参数
     */
    public static JSONObject getKeyWithMajors(JSONObject jsonObject, String... majors) {
        JSONObject paramJson = new JSONObject();
        JSONObject keyJson = new JSONObject();
        Object value;
        for (String major : majors) {
            value = jsonObject.get(major);
            if (value != null && !"".equals(value.toString())) {
                keyJson.put(major, value);
            }
        }
        paramJson.put("key", keyJson);
        return paramJson;
    }

    /**
     * 转换更新参数
     * 
     * @param jsonObject
     *            用户接口参数,除了过滤项，其它项默认为修改项
     * @param majors
     *            过滤项
     * @return 数据平台接口参数
     */
    public static JSONObject getUpdateParamJson(JSONObject jsonObject, String... majors) {
        JSONObject paramJson = new JSONObject();
        JSONObject criteriaJson = new JSONObject();
        Object value;
        for (String major : majors) {
            value = jsonObject.get(major);
            if (value != null && !"".equals(value.toString())) {
                criteriaJson.put(major, value);
            }
            jsonObject.remove(major);
        }
        paramJson.put("criteria", criteriaJson);
        paramJson.put("set", jsonObject);

        return paramJson;
    }

    /**
     * 获得除去某些项的条件
     * 
     * @param jsonObject
     *            用户接口参数
     * @param majors
     *            过滤项
     * @return 数据平台接口参数
     */
    public static JSONObject getCriteriaRemoveMajors(JSONObject jsonObject, String... majors) {
        JSONObject paramJson = new JSONObject();
        for (String major : majors) {
            jsonObject.remove(major);
        }
        paramJson.put("criteria", jsonObject);
        return paramJson;
    }

    /**
     * 获得指定项的条件
     * 
     * @param jsonObject
     *            用户接口参数
     * @param majors
     *            过滤项
     * @return 数据平台接口参数
     */
    public static JSONObject getCriteriaWithMajors(JSONObject jsonObject, String... majors) {
        JSONObject paramJson = new JSONObject();
        JSONObject criteria = new JSONObject();
        for (String major : majors) {
            criteria.put(major, jsonObject.get(major));
        }
        paramJson.put("criteria", criteria);
        return paramJson;
    }

    /**
     * 获得指定项的条件-用于批量查询
     * 
     * @param jsonArray
     *            用户接口参数
     * @param key
     *            参数的code码
     * @param code
     *            用户接口参数code码
     * @return 数据平台接口参数
     */
    public static JSONObject getCriteriasWithMajors(JSONArray jsonArray, String key, String code) {
        JSONObject paramJson = new JSONObject();
        JSONArray criterias = new JSONArray();
        JSONObject criteria, json;
        for (int i = 0; i < jsonArray.size(); i++) {
            json = jsonArray.getJSONObject(i);
            criteria = new JSONObject();
            criteria.put(code, json.get(key));
            criterias.add(criteria);
        }
        paramJson.put("criterias", criterias);
        return paramJson;
    }

    /**
     * 获得指定项的条件-用于批量查询
     * 
     * @param jsonObject
     *            用户接口参数
     * @param key
     *            参数的code码
     * @param code
     *            用户接口参数code码
     * @return 数据平台接口参数
     */
    public static JSONObject getCriteriasWithMajors(JSONObject jsonObject, String key, String code) {
        JSONObject paramJson = new JSONObject();
        JSONArray criterias = new JSONArray();
        JSONObject criteria = new JSONObject();
        criteria.put(code, jsonObject.get(key));
        criterias.add(criteria);
        paramJson.put("criterias", criterias);
        return paramJson;
    }

    /**
     * 获得批量查询参数
     * 
     * @param jsonObject
     *            参数
     * @param arrayInfo
     *            批量数组名
     * @param infoName
     *            查询参数
     * @param marjors
     *            非批量参数
     * @return
     */
    public static JSONObject getCriteriasWithMajors(JSONObject jsonObject, String arrayInfo, String infoName, String... marjors) {
        JSONObject paramJson = new JSONObject();
        JSONArray criterias = new JSONArray();
        JSONObject criteria;
        JSONArray infos = jsonObject.getJSONArray(arrayInfo);
        Object marjorObj;
        if (infos != null) {
            for (int i = 0; i < infos.size(); i++) {
                criteria = new JSONObject();
                criteria.put(infoName, infos.get(i));
                for (String marjor : marjors) {
                    if (!marjor.equals(infoName)) {
                        marjorObj = jsonObject.get(marjor);
                        if (marjorObj != null) {
                            if (marjorObj instanceof String) {
                                String marjorValue = marjorObj.toString();
                                if (marjorValue.startsWith("{")) {
                                    criteria.put(marjor, JSONObject.parseObject(marjorValue));
                                } else if (marjorValue.startsWith("[")) {
                                    criteria.put(marjor, JSONArray.parseArray(marjorValue));
                                } else {
                                    criteria.put(marjor, marjorValue);
                                }
                            } else {
                                criteria.put(marjor, marjorObj);
                            }
                        }
                    }
                }
                criterias.add(criteria);
            }
        }
        paramJson.put("criterias", criterias);
        return paramJson;
    }

    /**
     * 获得数据平台查询条件
     * 
     * @param codeName
     * @param jsonObject
     * @param majors
     * @return
     */
    public static JSONObject getDataPlatCriteriaWithMajors(String codeName, JSONObject jsonObject, String... majors) {
        JSONObject paramJson = new JSONObject();
        JSONObject criteria = new JSONObject();
        if (codeName != null) {
            criteria.put("id", jsonObject.get(codeName));
        }
        for (String major : majors) {
            criteria.put(major, jsonObject.get(major));
        }
        paramJson.put("criteria", criteria);
        return paramJson;
    }

    /**
     *
     * 功能描述：处理查询返回结果，将结果中的内容项转化为JsonString
     * 
     * @param queryResult
     * @param majors
     * @return
     * @创建者 wanghailong
     * @邮箱 wanghailong@persagy.com
     * @修改描述
     */
    public static String prossesResultToJsonString(String queryResult, String... majors) {
        if (queryResult.contains("Result") && queryResult.contains("Content")) {
            JSONObject resultJson = JSONObject.parseObject(queryResult);
            JSONArray array = (JSONArray) resultJson.get("Content");
            for (int i = 0; i < array.size(); i++) {
                JSONObject dataJson = array.getJSONObject(i);
                for (String major : majors) {
                    String dataString = dataJson.getString(major);
                    if (!StringUtil.isNull(dataString)) {
                        if (dataString.startsWith("{")) {
                            dataJson.put(major, JSONObject.parseObject(dataJson.getString(major)));
                        } else if (dataString.startsWith("[")) {
                            dataJson.put(major, JSONArray.parseArray(dataJson.getString(major)));
                        }
                    }
                }
                array.set(i, dataJson);
            }
            resultJson.put("Content", array);
            queryResult = resultJson.toString();
        }
        return queryResult;
    }

    /**
     *
     * 功能描述：处理插入参数，将参数中的内容项转化为JsonString
     * 
     * @param jsonObject
     * @param majors
     * @return
     * @创建者 wanghailong
     * @邮箱 wanghailong@persagy.com
     * @修改描述
     */
    public static JSONObject prossesParamToJsonString(JSONObject jsonObject, String... majors) {
        for (String major : majors) {
            if (jsonObject.containsKey(major)) {
                jsonObject.put(major, JSON.toJSONString(jsonObject.get(major)));
            }
        }
        return jsonObject;
    }

    /**
     *
     * 功能描述：返回查询结果中的第一条记录
     * 
     * @param queryResult
     * @return
     * @创建者 wanghailong
     * @邮箱 wanghailong@persagy.com
     * @修改描述
     */
    public static String getFirstRecordfromResult(String queryResult) {
        if (queryResult.contains("Result") && queryResult.contains("Content")) {
            JSONObject resultJson = JSONObject.parseObject(queryResult);
            JSONArray array = (JSONArray) resultJson.get("Content");
            if (array.size() > 0 && null != array.get(0)) {
                resultJson.put("Item", JSONObject.parseObject(array.get(0).toString()));
                resultJson.remove("Content");
                resultJson.remove("Count");
            }

            queryResult = resultJson.toString();
        }
        return queryResult;
    }

    /**
     *
     * 功能描述：返回查询结果中的第一条记录,Json格式
     * 
     * @param queryResult
     * @return
     * @创建者 wanghailong
     * @邮箱 wanghailong@persagy.com
     * @修改描述
     */
    public static JSONObject getFirstRecordfromResultWithJson(String queryResult) {
        JSONObject firstJson = null;
        if (queryResult.contains("Result") && queryResult.contains("Content")) {
            JSONObject resultJson = JSONObject.parseObject(queryResult);
            JSONArray array = (JSONArray) resultJson.get("Content");
            if (array.size() > 0 && null != array.get(0)) {
                firstJson = JSONObject.parseObject(array.get(0).toString());
            }
        }
        return firstJson;
    }

    /**
     * 分页
     * 
     * @param array
     *            分页数据全集
     * @param page
     *            当前页码
     * @param pageSize
     *            每页数据条数
     * @return
     */
    public static JSONArray pagination(JSONArray array, int page, int pageSize) {
        List<Object> list = JSON.parseArray(array.toJSONString(), Object.class);
        int startIndex = (page - 1) * pageSize;
        int endIndex = page * pageSize;
        if (startIndex > list.size()) {
            startIndex = 0;
            endIndex = 0;
        } else if (endIndex > list.size()) {
            endIndex = list.size();
        }
        list = list.subList(startIndex, endIndex);
        return JSON.parseArray(JSON.toJSONString(list));
    }

    /**
     * 排序
     * 
     * @param array
     * @param field
     *            排序的字段
     * @param order
     *            -1:倒序 1:正序
     * @return
     */
    public static JSONArray sortByPositiveDoubleField(JSONArray array, String field, int order) {
        if (array != null) {
            Collections.sort(array, new Comparator<Object>() {
                @Override
                public int compare(Object str1, Object str2) {
                    JSONObject obj1 = JSONObject.parseObject(str1.toString());
                    JSONObject obj2 = JSONObject.parseObject(str2.toString());

                    String order1_Str = obj1.getString(field);
                    String order2_Str = obj2.getString(field);

                    if (StringUtil.isNull(order1_Str) || "-".equals(order1_Str)) {
                        order1_Str = (order == 1) ? Integer.MAX_VALUE + "" : Integer.MIN_VALUE + "";
                    }
                    if (StringUtil.isNull(order2_Str) || "-".equals(order2_Str)) {
                        order2_Str = (order == 1) ? Integer.MAX_VALUE + "" : Integer.MIN_VALUE + "";
                    }

                    Double order1 = Double.valueOf(order1_Str);
                    Double order2 = Double.valueOf(order2_Str);

                    if (Math.abs(order1 - order2) < 0.01) { //判断两个浮点型的差值是否在0.01之内(适用于百分制)
                        return 0;
                    }
                    if (order1 > order2) {
                        return order;
                    }
                    return -1 * order;
                }
            });
        }
        return array;
    }

    /**
     * 排序
     * 
     * @param array
     * @param field
     *            排序的字段
     * @param order
     *            -1:倒序 1:正序
     * @return
     */
    public static JSONArray sortByLongField(JSONArray array, String field, int order) {
        if (array != null) {
            Collections.sort(array, new Comparator<Object>() {
                @Override
                public int compare(Object str1, Object str2) {
                    JSONObject obj1 = JSONObject.parseObject(str1.toString());
                    JSONObject obj2 = JSONObject.parseObject(str2.toString());

                    String order1_Str = obj1.getString(field);
                    String order2_Str = obj2.getString(field);
                    if (StringUtil.isNull(order1_Str)) {
                        order1_Str = Long.MIN_VALUE + "";
                    }
                    if (StringUtil.isNull(order2_Str)) {
                        order2_Str = Long.MIN_VALUE + "";
                    }

                    Long order1 = Long.valueOf(order1_Str);
                    Long order2 = Long.valueOf(order2_Str);

                    if (order1 == order2) {
                        return 0;
                    }
                    if (order1 > order2) {
                        return order;
                    }
                    return -1 * order;
                }
            });
        }
        return array;
    }

    /**
     * 排序
     * 
     * @param array
     * @param field
     *            排序的字段
     * @param order
     *            -1:倒序 1:正序
     * @return
     */
    public static JSONArray sortByStringField(JSONArray array, String field, int order) {
        if (array != null) {
            Collections.sort(array, new Comparator<Object>() {
                @Override
                public int compare(Object str1, Object str2) {
                    JSONObject obj1 = JSONObject.parseObject(str1.toString());
                    JSONObject obj2 = JSONObject.parseObject(str2.toString());

                    String order1 = obj1.getString(field);
                    String order2 = obj2.getString(field);

                    /*if (StringUtil.isNull(order1)) {
                        //通过保证在正序/倒序中的最大/最小值来实现不参与排序的效果
                        order1 = (order == 1) ? Math.pow(Integer.MAX_VALUE, 2) + "" : "";
                    }
                    if (StringUtil.isNull(order2)) {
                        //通过保证在正序/倒序中的最大/最小值来实现不参与排序的效果
                        order2 = (order == 1) ? Math.pow(Integer.MAX_VALUE, 2) + "" : "";
                    }*/

                    if (StringUtil.isNull(order1)) {
                        order1 = "";
                    }
                    if (StringUtil.isNull(order2)) {
                        order2 = "";
                    }

                    if (order1.equals(order2)) {
                        return 0;
                    }
                    if (order1.compareTo(order2) > -1) {
                        return order;
                    }
                    return -1 * order;
                }
            });
        }
        return array;
    }

    /**
     * 排序
     * 
     * @param array
     * @param field
     *            排序的字段
     * @param order
     *            -1:倒序 1:正序
     * @return
     */
    public static JSONArray sortByIntegerField(JSONArray array, String field, int order) {
        if (array != null) {
            Collections.sort(array, new Comparator<Object>() {
                @Override
                public int compare(Object str1, Object str2) {
                    JSONObject obj1 = JSONObject.parseObject(str1.toString());
                    JSONObject obj2 = JSONObject.parseObject(str2.toString());
                    String order1_Str = obj1.getString(field);
                    String order2_Str = obj2.getString(field);
                    if (StringUtil.isNull(order1_Str)) {
                        order1_Str = Integer.MIN_VALUE + "";
                    }
                    if (StringUtil.isNull(order2_Str)) {
                        order2_Str = Integer.MIN_VALUE + "";
                    }

                    Integer order1 = Integer.valueOf(order1_Str);
                    Integer order2 = Integer.valueOf(order2_Str);

                    if (order1 == order2) {
                        return 0;
                    }
                    if (order1 > order2) {
                        return order;
                    }
                    return -1 * order;
                }
            });
        }
        return array;
    }

    /**
     * 处理请求结果为map
     * 
     * @param resultStr
     *            请求结果
     * @param keyCode
     *            map的key的code
     * @param valueCode
     *            map的value的code null表示整个对象为value
     * @param keyClazz
     *            key的数据类型
     * @param valueClazz
     *            value的数据类型
     * @return
     */
    public static <T, V> Map<T, V> proccessResultToMap(String resultStr, String keyCode, String valueCode, Class<T> keyClazz, Class<V> valueClazz) {
        Map<T, V> map = null;
        JSONObject result = JSONObject.parseObject(resultStr);
        if ("success".equals(result.getString("Result"))) {
            map = new HashMap<T, V>();
            JSONArray content = (JSONArray) result.getOrDefault("Content", new JSONArray());
            JSONObject item;
            for (int i = 0; i < content.size(); i++) {
                item = content.getJSONObject(i);
                if (StringUtil.isNull(valueCode)) {
                    map.put(keyClazz.cast(item.get(keyCode)), valueClazz.cast(item));
                } else {
                    map.put(keyClazz.cast(item.get(keyCode)), valueClazz.cast(item.get(valueCode)));
                }
            }
        }
        return map;
    }

    /**
     * 判断数组是否为空
     * 
     * @param jsonArray
     * @return
     */
    public static boolean arrayIsBlank(JSONArray jsonArray) {
        if (jsonArray == null || jsonArray.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断json对象是否为空
     * 
     * @param obj
     * @return
     */
    public static boolean objIsBlank(JSONObject obj) {
        if (null == obj || obj.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 获得数据平台查询条件
     * 
     * @param criteria
     * @return
     */
    public static JSONObject getCriteria(JSONObject criteria) {
        JSONObject paramJson = new JSONObject();
        paramJson.put("criteria", criteria);
        return paramJson;
    }

    /**
     * 根据对象字段，去重
     * 
     * @param array
     * @param field
     * @return
     */
    public static JSONArray removeRepeatObjectByField(JSONArray array, String field) {
        if (arrayIsBlank(array) || array.size() == 1) {
            return array;
        }
        Map<String, String> all = new HashMap<>();
        JSONArray newArray = new JSONArray();
        JSONObject ojb = null;
        for (int i = 0; i < array.size(); i++) {
            ojb = array.getJSONObject(i);

            if (null == ojb || ojb.isEmpty() || StringUtils.isBlank(ojb.getString(field)) || all.containsKey(ojb.getString(field))) {
                continue;
            }
            all.put(ojb.getString(field), ojb.getString(field));
            newArray.add(ojb);
        }
        return newArray;
    }

    /**
     * 过滤null 为空JSONArray
     * 
     * @param array
     * @return
     */
    public static JSONArray nullChangeEmptyArray(JSONArray array) {
        return array == null ? new JSONArray() : array;
    }

    /**
     * 过滤null 为空JSONObject
     * 
     * @param obj
     * @return
     */
    public static JSONObject nullChangeEmptyObj(JSONObject obj) {
        return obj == null ? new JSONObject() : obj;
    }

    /**
     * 根据key返回指定值
     * @param jsObject
     * @param key
     * @return
     */
    public static JSONObject getJSONObject(JSONObject jsObject, String key) {
        JSONObject Obj = jsObject.getJSONObject(key);
        if (Obj != null) {
            return Obj;
        }
        return new JSONObject();
    }

    /**
     * 根据key返回指定值
     * @param jsObject
     * @param key
     * @return
     */
    public static JSONArray getJSONArray(JSONObject jsObject, String key) {
        JSONArray Obj = jsObject.getJSONArray(key);
        if (Obj != null) {
            return Obj;
        }
        return new JSONArray();
    }
}
