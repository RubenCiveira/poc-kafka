package org.example;

import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;
import io.smallrye.reactive.messaging.kafka.api.OutgoingKafkaRecordMetadata;

class KafkaSender implements Sender {
  private final Emitter<String> emitter;
  
  public KafkaSender(Emitter<String> emitter) {
    this.emitter = emitter;
  }
  
  @Override
  public void send(String key, String val) {
    emitter.send( Message.of(val).addMetadata(OutgoingKafkaRecordMetadata.<String>builder()
        .withKey(key)
        .withTopic("my_compacted_topic")
        .build()) );
  }
}
