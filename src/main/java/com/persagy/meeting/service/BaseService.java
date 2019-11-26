package com.persagy.meeting.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * 功能描述：
 * 
 * @类型名称 BaseService
 * @创建者 kangjun
 * @邮箱 kangjun@persagy.com
 * @修改描述
 */
@Service("baseService")
public class BaseService {

	public String httpPostRequest(String url, Map<String, Object> params) throws Exception {
		String respContent = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
		// 设置请求的的参数
		JSONObject jsonParam = new JSONObject();
		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			jsonParam.put(key, params.get(key));
		}
		httpPost.setEntity(new StringEntity(jsonParam.toString(), "utf-8"));
		// 执行请求
		respContent = executeHttpRequest(httpclient, httpPost);
		return respContent;
	}

	/**
	 * 执行http请求
	 * @param httpClient
	 * @param httpRequest
	 * @return
	 */
	private String executeHttpRequest(CloseableHttpClient httpClient, HttpUriRequest httpRequest){
		CloseableHttpResponse response = null;
		String respContent = null;
		try {
			response = httpClient.execute(httpRequest);
			respContent = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
		}finally {
			try {
				httpClient.close();
			} catch (IOException e) {
			}
			if(response != null) {
				try {
					response.close();
				} catch (IOException e) {
				}
			}
		}
		return respContent;
	}

	
}
