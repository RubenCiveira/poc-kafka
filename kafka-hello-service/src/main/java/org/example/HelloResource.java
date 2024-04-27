package org.example;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;
import io.smallrye.reactive.messaging.kafka.api.OutgoingKafkaRecordMetadata;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

  @Inject
  @Channel("hello-channel")
  Emitter<String> emitter;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello(@QueryParam("key") String key, @QueryParam("val") String val) {
    emitter.send( Message.of(val).addMetadata(OutgoingKafkaRecordMetadata.<String>builder()
        .withKey(key)
        .build()) );
    return "Message sent to Kafka!";
  }
}
