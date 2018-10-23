package com.msa.apigateway.filter;


import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author anquan li
 */
public class DidiFilterProcessor extends FilterProcessor {
  @Override
  public Object processZuulFilter(ZuulFilter zuulFilter) throws ZuulException{
    try {
      return super.processZuulFilter(zuulFilter);
    }catch(ZuulException e){
      RequestContext requestContext=RequestContext.getCurrentContext();
      requestContext.set("failed.filter",zuulFilter);
      throw  e;
    }
  }
}
