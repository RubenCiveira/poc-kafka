package org.example;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloConsumer {

  @Incoming("hello-channel")
  public void consume(String price) {
      // process your price.
    System.err.println( "INCOMING= " + price );
  }
}
