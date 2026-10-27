package com.boundedflow.model;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EventTest {

    @Test
    void viewEventWithoutTransactionIdIsValid() {
        assertDoesNotThrow(() -> new Event("e1", Instant.now(), 1L, EventType.VIEW, 10L, null));
    }

    @Test
    void transactionEventWithoutTransactionIdThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Event("e1", Instant.now(), 1L, EventType.TRANSACTION, 10L, null));
    }

    @Test
    void transactionEventWithBlankTransactionIdThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Event("e1", Instant.now(), 1L, EventType.TRANSACTION, 10L, "  "));
    }

    @Test
    void transactionEventWithTransactionIdIsValid() {
        assertDoesNotThrow(() -> new Event("e1", Instant.now(), 1L, EventType.TRANSACTION, 10L, "t1"));
    }

    @Test
    void nullEventIdThrows() {
        assertThrows(NullPointerException.class,
                () -> new Event(null, Instant.now(), 1L, EventType.VIEW, 10L, null));
    }

    @Test
    void blankEventIdThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Event("  ", Instant.now(), 1L, EventType.VIEW, 10L, null));
    }

    @Test
    void nullTimestampThrows() {
        assertThrows(NullPointerException.class,
                () -> new Event("e1", null, 1L, EventType.VIEW, 10L, null));
    }

    @Test
    void nullTypeThrows() {
        assertThrows(NullPointerException.class,
                () -> new Event("e1", Instant.now(), 1L, null, 10L, null));
    }
}
