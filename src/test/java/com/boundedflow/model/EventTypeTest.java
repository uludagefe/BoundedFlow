package com.boundedflow.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EventTypeTest {

    @Test
    void fromCsvParsesKnownValuesCaseInsensitively() {
        assertEquals(EventType.VIEW, EventType.fromCsv("view"));
        assertEquals(EventType.ADDTOCART, EventType.fromCsv("AddToCart"));
        assertEquals(EventType.TRANSACTION, EventType.fromCsv("TRANSACTION"));
    }

    @Test
    void fromCsvRejectsUnknownValue() {
        assertThrows(IllegalArgumentException.class, () -> EventType.fromCsv("click"));
    }

    @Test
    void fromCsvRejectsNull() {
        assertThrows(IllegalArgumentException.class, () -> EventType.fromCsv(null));
    }
}
