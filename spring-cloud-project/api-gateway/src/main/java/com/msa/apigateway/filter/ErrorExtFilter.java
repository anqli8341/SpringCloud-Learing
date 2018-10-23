package com.msa.apigateway.filter;

import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * @author anquan li
 */
@Component
public class ErrorExtFilter extends  SendErrorFilter{

  @Override
  public int filterOrder() {
    return 30;
  }

  @Override
  public boolean shouldFilter() {
    RequestContext requestContext=RequestContext.getCurrentContext();
    ZuulFilter failedFilter= (ZuulFilter) requestContext.get("failed.filter");
    if(failedFilter!=null&&failedFilter.filterType().equals("post")){
      return true;
    }
    return false;
  }
  @Override
  public String filterType(){
    return "error";
  }

}
