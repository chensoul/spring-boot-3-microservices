package com.chensoul.bookstore.notification.domain;

import com.chensoul.bookstore.api.order.OrderEventType;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class OrderEventEntity {
    @Id
    private String id;

    private String eventId;

    private OrderEventType type;

    @Version
    private Integer version;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;

    public OrderEventEntity() {}

    public OrderEventEntity(String eventId, OrderEventType type) {
        this.eventId = eventId;
        this.type = type;
    }
}
