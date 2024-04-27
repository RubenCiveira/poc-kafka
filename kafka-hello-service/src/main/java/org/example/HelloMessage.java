package org.example;

public class HelloMessage {
    private String key; // Esto actuará como la clave del mensaje en Kafka
    private String payload;

    public HelloMessage(String key, String payload) {
        this.key = key;
        this.payload = payload;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
