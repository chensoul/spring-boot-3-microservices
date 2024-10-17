package com.chensoul.ecommerce.product;

import com.chensoul.ecommerce.order.OrderConfirmation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import static org.springframework.kafka.support.KafkaHeaders.TOPIC;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * TODO Comment
 *
 * @author <a href="mailto:ichensoul@gmail.com">chensoul</a>
 * @since TODO
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class kafkaOrderProducer implements OrderProducer {
  private final KafkaTemplate<String, OrderConfirmation> kafkaTemplate;

  public void sendNotification(OrderConfirmation orderConfirmation) {
    log.info("Sending order confirmation");
    Message<OrderConfirmation> message = MessageBuilder
            .withPayload(orderConfirmation)
            .setHeader(TOPIC, "order-topic")
            .build();

    kafkaTemplate.send(message);
  }
}
