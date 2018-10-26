package com.msa.openfeignproducer.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msa.commonapi.dto.Instance;


/**
 * @author anquan li
 */
@RestController
@RequestMapping("/feign-service")
public class FeignServiceController {
  @RequestMapping(value="/instance/{serviceId}",method = RequestMethod.GET)
  public Instance getInstanceByServiceId(@PathVariable("serviceId") String serviceId){
    return new Instance(serviceId);
  }
}
