package com.nisum.configuration;


import org.springframework.boot.web.servlet.FilterRegistrationBean;

import com.nisum.configuration.AppConfigFilter;
import com.nisum.filter.MyFilter;

public class AppConfigFilter {
	public FilterRegistrationBean  myFilterBean() {
		  final FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
		  filterRegBean.setFilter(new MyFilter());
		  filterRegBean.addUrlPatterns("/*");
		  filterRegBean.setEnabled(Boolean.TRUE);
		  filterRegBean.setName("Meu Filter");
		  filterRegBean.setAsyncSupported(Boolean.TRUE);
		  return filterRegBean;
		}
}
