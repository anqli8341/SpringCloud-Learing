package com.msa.apigateway.filter;


import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;


/**
 * @author anquan li
 */
public class DidiErrorAttributes extends DefaultErrorAttributes {
  @Override
  public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
    Map<String,Object> result= super.getErrorAttributes(webRequest, includeStackTrace);
    result.remove("exception");
    return result;
  }
}
