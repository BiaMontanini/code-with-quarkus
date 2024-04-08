package org.acme;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class KafkaProducer {

    @Inject
    @Channel("kafka-producer")
    Emitter<String> emitter;

    public void sendToKafka(String message) {
        emitter.send(message);
    }
}
