// package org.acme;


// import jakarta.inject.Inject;
// import jakarta.ws.rs.POST;
// import jakarta.ws.rs.Path;
// import jakarta.ws.rs.QueryParam;
// import jakarta.ws.rs.core.Response;

// @Path("/kafka")
// public class KafkaResource {

//     @Inject
//     KafkaProducer producer;

//     @POST
//     @Path("/send")
//     public Response sendMessage(@QueryParam("message") String message) {
//         producer.sendToKafka(message);
//         return Response.ok().build();
//     }
// }
