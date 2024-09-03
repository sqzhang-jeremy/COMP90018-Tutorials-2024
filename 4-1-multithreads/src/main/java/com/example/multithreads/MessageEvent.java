package com.example.multithreads;

// Message class for implementing EventBus library
public class MessageEvent {
    public final String message;
    public final int clickCount;

    public MessageEvent(String message, int clickCount) {
        this.message = message;
        this.clickCount = clickCount;
    }
}
