package com.msa.apigateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anquan li
 */
@RestController
public class HelloController {


  @RequestMapping("/local/hello")
  public  String hello(){
    return "Hello World Local";
  }
}
