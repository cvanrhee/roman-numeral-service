package com.interview.config;

import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


/**
  *  Enables async behavior inside Spring.
  *  This allows us to spin up multiple processes when running conversions.
 */
@Configuration
@EnableAsync
public class AsyncConfiguration {

  private static final Logger log = LoggerFactory.getLogger(AsyncConfiguration.class);

  /**
   * Creates a bean Executor to manage async jobs with @Async.
   *
   * @return Executor an executor to manage async jobs
   */
  @Bean(name = "taskExecutor")
  public Executor taskExecutor() {
    log.info("Creating Async Task Executor");
    final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(10);
    executor.setMaxPoolSize(20);
    executor.setThreadNamePrefix("RomanNumeralThread-");
    executor.initialize();
    return executor;
  }
}