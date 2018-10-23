package com.msa.demoservice.services;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.msa.demoservice.entity.Cat;

/**
 * @author anquan li
 */
@RepositoryRestResource
public interface CatRepository extends JpaRepository<Cat, Long> {
}
