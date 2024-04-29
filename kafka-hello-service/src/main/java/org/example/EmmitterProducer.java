package org.example;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import io.quarkus.arc.properties.IfBuildProperty;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class EmmitterProducer {
  @Produces
  @ApplicationScoped
  @IfBuildProperty(name = "kafka.enabled", stringValue = "true")
  public Sender osender(@Channel("hello-channel") Emitter<String> emitter) {
    return new KafkaSender( emitter );
  }
  
  @Produces
  @ApplicationScoped
  @IfBuildProperty(name = "kafka.enabled", stringValue = "false", enableIfMissing = true)
  public Sender sender() {
    return new VoidSender();
  }
}
