package com.persagy.meeting.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.persagy.meeting.common.General;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;



@Service
public class LoggerInterceptor implements HandlerInterceptor{
	
	Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Long start = null;
		String ip = General.getIpAddr();
		String uri = request.getRequestURI();
		
		start = System.currentTimeMillis();
		logger.error("【IP:" + ip + "_timeStart:" + start + "】访问URI：" + uri + " 开始...");
		request.setAttribute("RequestStartTime", start);

		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		String ip = General.getIpAddr();
		String uri = request.getRequestURI();
		Long start = (Long)request.getAttribute("RequestStartTime");
		if(null!=start&&start>0L) {
			long end = System.currentTimeMillis();
			long timeInterval = (end - start) / 1000;
			logger.error("【IP:" + ip + "_timeStart:" + start + "】访问URI：" + uri + " 结束-成功！历时："
					+ timeInterval + " 秒");
			if (timeInterval > 4) {
				logger.error("【IP:" + ip + "_timeStart:" + start + "】访问参数："	+ request.getParameterMap());
			}
		}
		request.removeAttribute("RequestStartTime");
	}
}
