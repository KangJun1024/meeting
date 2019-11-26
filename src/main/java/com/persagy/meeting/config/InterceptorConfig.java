package com.persagy.meeting.config;

import com.persagy.meeting.intercepter.LoggerInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: InterceptorConfig
 * @Description: 配置注册拦截器
 * @author kangjun
 * @date 2019年6月13日 上午11:42:01
 */
@Component
public class InterceptorConfig implements WebMvcConfigurer {
	
	/**
	 * 把自定义的拦截器注册到上下文中 (non-Javadoc)
	 * 
	 * @see WebMvcConfigurer#addInterceptors(InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggerInterceptor());
	}

}
