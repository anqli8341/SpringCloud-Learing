package com.msa.feignconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.msa.feignconsumer.entity.User;

/**
 * @author anquan li
 */
@FeignClient(name = "HELLO-SERVICE",configuration =FullLogConfiguration.class,fallback = HelloServiceFallback.class)
public interface HelloService {
  @RequestMapping("/hello")
  String hello();
  @RequestMapping(value="/hello1",method = RequestMethod.GET)
  String hello(@RequestParam("name") String name);
  @RequestMapping(value="/hello2",method = RequestMethod.GET)
  User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);
  @RequestMapping(value="/hello3",method = RequestMethod.POST)
  String hello(@RequestBody User user);
}
