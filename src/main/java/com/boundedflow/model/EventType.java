package com.boundedflow.model;

public enum EventType {
    VIEW,
    ADDTOCART,
    TRANSACTION;

    public static EventType fromCsv(String raw) {
        if (raw == null) {
            throw new IllegalArgumentException("event type must not be null");
        }
        try {
            return EventType.valueOf(raw.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("unknown event type: " + raw);
        }
    }
}
