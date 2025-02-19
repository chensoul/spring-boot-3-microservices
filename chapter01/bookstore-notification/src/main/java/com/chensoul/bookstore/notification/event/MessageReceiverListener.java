package com.chensoul.bookstore.notification.event;

import com.chensoul.bookstore.api.event.BookstoreEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageReceiverListener implements MessageListener {
    private final OrderEventHandler orderEventHandler;
    private final ObjectMapper mapper;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            BookstoreEvent bookstoreEvent = mapper.readValue(message.toString(), BookstoreEvent.class);
            orderEventHandler.handleEvent(bookstoreEvent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
