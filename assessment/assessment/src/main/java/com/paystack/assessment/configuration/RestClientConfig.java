package com.paystack.assessment.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {
   @Value("${payStack.url}")
    private String payStackUrl;

   @Bean
    public RestClient build(){
       return RestClient.create(payStackUrl);
   }
}
