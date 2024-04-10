package org.acme;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PriceConsumer {

    @Incoming("prices")
    public void consume(Prices price) {
        System.out.println("Received price: " + price.getPrice());
        System.out.println("Received name: " + price.getName());
    }

}