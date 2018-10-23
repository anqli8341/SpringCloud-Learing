package com.msa.apigateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;


/**
 * @author anquan li
 */
public class AccessFilter extends ZuulFilter {
  private static Logger logger= LoggerFactory.getLogger(AccessFilter.class);
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
  public Object run() {
    RequestContext requestContext=RequestContext.getCurrentContext();
    HttpServletRequest request=requestContext.getRequest();
    logger.info("send {} request to {}",request.getMethod(),request.getRequestURL().toString());
    Object accessToken=request.getParameter("accessToken");
    logger.info("accessToken ["+accessToken+"]");
    if(accessToken==null){
      logger.warn("access token is empty");
      requestContext.setSendZuulResponse(false);
      requestContext.setResponseStatusCode(401);
      return null;
    }
    logger.info("access  token ok");
    return null;
  }
}
