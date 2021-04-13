package com.felip.paymentapi.config;

import com.felip.paymentapi.streaming.CheckoutProcessor;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(CheckoutProcessor.class)
public class StreamingConfig {
  
}
