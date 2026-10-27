package com.boundedflow.model;

import java.time.Instant;
import java.util.Objects;

public record Event(
        String eventId,
        Instant timestamp,
        long visitorId,
        EventType type,
        long itemId,
        String transactionId
) {
    public Event {
        Objects.requireNonNull(eventId, "eventId must not be null");
        Objects.requireNonNull(timestamp, "timestamp must not be null");
        Objects.requireNonNull(type, "type must not be null");
        if (eventId.isBlank()) {
            throw new IllegalArgumentException("eventId must not be blank");
        }
        if (type == EventType.TRANSACTION && (transactionId == null || transactionId.isBlank())) {
            throw new IllegalArgumentException("transactionId is required for TRANSACTION events");
        }
    }
}
