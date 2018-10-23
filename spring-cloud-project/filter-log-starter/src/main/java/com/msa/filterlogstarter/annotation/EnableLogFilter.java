package com.msa.filterlogstarter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.msa.filterlogstarter.config.LogFilterAutoConfiguration;

/**
 * @author anquan li
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(LogFilterAutoConfiguration.class)
public @interface EnableLogFilter {
}
