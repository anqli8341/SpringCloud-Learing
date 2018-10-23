package com.msa.filterlogstarter.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author anquan li
 */

public class LogFilter implements Filter {

  private Logger logger = LoggerFactory.getLogger(LogFilter.class);

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

    logger.info("logFilter init ...");

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    logger.info("uri () is working. ", request.getRequestURI());
    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy() {
    logger.info(" logFilter destroy....");
  }
}
