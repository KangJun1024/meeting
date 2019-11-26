package com.persagy.meeting.filter;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.ValueFilter;

public class DataCovertFilter implements ValueFilter {

	@Override
	public Object process(Object object, String name, Object value) {
		if(name.equals("extend_field")) {
			// 如果字段为null则对应的 值 也就是“value”返回 “{}” 否则返回value.toString()
			return JSONObject.parse(value==null?null:value.toString());
//			return JSONObject.parse(value==null?"{}":value.toString());
		}
		return value;
	}

}
