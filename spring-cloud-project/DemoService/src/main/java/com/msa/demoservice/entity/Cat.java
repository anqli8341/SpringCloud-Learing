package com.msa.demoservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author anquan li
 */

@Entity
public class Cat {
  @Id
  @GeneratedValue
  private Long id;

  private String name;

  public Cat(String name) {
    this.name = name;
  }

  public Cat() {
  }

  @Override
  public String toString() {
    return "Cat{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
