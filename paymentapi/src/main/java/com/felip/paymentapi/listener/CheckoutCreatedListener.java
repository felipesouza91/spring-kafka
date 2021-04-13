package com.felip.paymentapi.listener;

import java.util.UUID;

import com.felip.paymentapi.checkout.event.CheckoutCreatedEvent;
import com.felip.paymentapi.payment.event.PaymentCreatedEvent;
import com.felip.paymentapi.streaming.CheckoutProcessor;


import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CheckoutCreatedListener {


  private final CheckoutProcessor processor;
  
  @StreamListener(CheckoutProcessor.INPUT)
  public void handle(CheckoutCreatedEvent body) {
    final PaymentCreatedEvent event = PaymentCreatedEvent.newBuilder()
      .setCheckoutCode(body.getCheckoutCode())
      .setPaymentCode(UUID.randomUUID().toString())
      .build();
    processor.output().send(MessageBuilder.withPayload(event).build());
  }
}
