package com.boot.study;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.boot.study.filter.HelloFilter;
import com.boot.study.filter.HelloFilter2;

@Configuration
public class FilterConfig {
	
	
	@Bean
	@Order(Integer.MAX_VALUE)
	public FilterRegistrationBean myFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new HelloFilter());
		registration.addUrlPatterns("/*");
		registration.setName("helloFilter");
		//registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
		return registration;
	}
	@Bean
	@Order(Integer.MAX_VALUE-1)
	public FilterRegistrationBean myFilter2() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new HelloFilter2());
		registration.addUrlPatterns("/hello");
		registration.setName("helloFilter2");
		//registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
		return registration;
	}
}
