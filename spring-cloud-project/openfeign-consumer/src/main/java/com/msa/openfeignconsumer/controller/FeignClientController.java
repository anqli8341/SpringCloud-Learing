package com.msa.openfeignconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.msa.commonapi.dto.Instance;
import com.msa.openfeignconsumer.service.FeignServiceClient;

/**
 * @author anquan li
 */
@RestController
@RequestMapping("/feign-client")
public class FeignClientController {
  @Autowired
  FeignServiceClient feignServiceClient;

  @RequestMapping(value = "/instance/{serviceId}", method = RequestMethod.GET)
  public Instance getInstanceByServiceId(@PathVariable("serviceId") String serviceId) {
    return feignServiceClient.getInstanceByServiceId(serviceId);
  }

  @RequestMapping(value = "/instance/{serviceId}", method = RequestMethod.DELETE)
  public String deleteInstanceByServiceId(@PathVariable("serviceId") String serviceId) {
    return feignServiceClient.deleteInstanceByServiceId(serviceId);
  }

  @RequestMapping(value = "/instance", method = RequestMethod.POST)
  public String createInstance(@RequestBody Instance instance) {
    return feignServiceClient.createInstance(instance);
  }

  @RequestMapping(value = "/instance/{serviceId}", method = RequestMethod.PUT)
  public String updateInstanceByServiceId(@RequestBody Instance instance, @PathVariable("serviceId") String serviceId) {
    return feignServiceClient.updateInstanceByServiceId(instance, serviceId);
  }
}
