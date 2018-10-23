package com.msa.feignconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;

import com.msa.helloserviceapi.service.HelloService;

/**
 * @author anquan li
 */
@FeignClient(value = "HELLO-SERVICE", configuration=DisabledHystrixConfiguration.class)
public interface RefactorHelloService  extends HelloService {
}
