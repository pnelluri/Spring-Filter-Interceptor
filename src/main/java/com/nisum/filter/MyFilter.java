package com.nisum.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;

@Component
@Order(1)
public class MyFilter implements Filter {

	  private final static Logger LOGGER = LoggerFactory.getLogger(MyFilter.class);

	  @Override
	  public void init(final FilterConfig filterConfig) throws ServletException {
	    LOGGER.info("Iniciando filtro de logging");
	    System.out.println("in Filter init");
	  }

	  @Override
	  public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
	    Integer personId = ServletRequestUtils.getIntParameter(request, "personId", 0);
		
	    System.out.println("in Filter start doFilter");
	    if(personId<15) {
	    	chain.doFilter(request, response);
	    }
	    System.out.println("in Filter doFilter");
	  }

	  @Override
	  public void destroy() {
	    LOGGER.warn("Destruindo o filtro de logging");
	    System.out.println("in Filter destroy");
	  }

}
