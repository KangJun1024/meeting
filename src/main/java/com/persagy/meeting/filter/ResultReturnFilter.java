package com.persagy.meeting.filter;

import com.alibaba.fastjson.serializer.PropertyFilter;
/**
 * Description:   返回结果进行过滤，在WebConfigurer中使用
 * 当WebConfigurer 中 SerializerFeature.WriteMapNullValue设置后，为空的字段会显示，此时增加该字段可以过滤掉为null的属性，
 * 当WebConfigurer 中 SerializerFeature.WriteMapNullValue 没有设置是，默认过滤掉所有为空的，此处的过滤就重复了，可以去掉
 * Company: Persagy 
 * @author luoguangyi 
 * @version 1.0
 * @since: 2019年9月3日: 下午6:28:05
 * Update By luoguangyi 2019年9月3日: 下午6:28:05
 */
public class ResultReturnFilter implements PropertyFilter {

	@Override
	public boolean apply(Object object, String name, Object value) {
		if("Content".equals(name)&&null==value) {
			return false;
		}
		if("Item".equals(name)&&null==value) {
			return false;
		}
		if("ResultMsg".equals(name)&&null==value) {
			return false;
		}
		if("Count".equals(name)&&null==value) {
			return false;
		}
		return true;
	}

}
