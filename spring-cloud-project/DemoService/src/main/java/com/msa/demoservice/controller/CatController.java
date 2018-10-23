package com.msa.demoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msa.demoservice.entity.Cat;
import com.msa.demoservice.services.CatRepository;

/**
 * @author anquan li
 */
@RestController
public class CatController {
  @Autowired
  CatRepository catRepository;

  @RequestMapping(name = "/save", method = RequestMethod.POST)
  public String save(@RequestParam String name) {
    Cat cat = new Cat(name);
    catRepository.save(cat);
    return cat.getName();
  }
}
