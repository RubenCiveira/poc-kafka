package org.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

  @Inject
  private final Sender sender;

  public HelloResource(Sender sender) {
    this.sender = sender;
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello(@QueryParam("key") String key, @QueryParam("val") String val) {
    sender.send(key, val);
    return "Message sent to Kafka!";
  }
}
