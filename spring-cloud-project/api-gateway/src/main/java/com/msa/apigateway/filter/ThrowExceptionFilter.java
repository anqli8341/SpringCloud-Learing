package com.msa.apigateway.filter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;



/**
 * @author anquan li
 */
@Component
public class ThrowExceptionFilter extends ZuulFilter {
  private static Logger logger= LoggerFactory.getLogger(ThrowExceptionFilter.class);
  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 0;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run(){
    logger.info(" This is a pre filter,it will throw a RuntimeException");
    RequestContext requestContext=RequestContext.getCurrentContext();
    try {
      doSomething();
    }catch(Exception e){
      requestContext.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      requestContext.set("error.exception",e);
      requestContext.set("error.message",e.getMessage());
      throw e;
    }
    return null;
  }

  private void doSomething() {

    throw new RuntimeException("Exist som errors...");
  }
}
