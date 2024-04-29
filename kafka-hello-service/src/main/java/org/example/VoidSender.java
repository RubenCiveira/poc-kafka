package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VoidSender implements Sender {
  private final Logger logger = LoggerFactory.getLogger(VoidSender.class);
  @Override
  public void send(String key, String val) {
    logger.info("Message send: {} - {}", key, val);
  }
}
