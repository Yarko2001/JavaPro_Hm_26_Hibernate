package com.example.javapro_hm_26_hibernate.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yaroslav Dehtiar on 24.02.2023
 */
@Configuration
public class AppConfiguration {

  @Bean
  ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

}
