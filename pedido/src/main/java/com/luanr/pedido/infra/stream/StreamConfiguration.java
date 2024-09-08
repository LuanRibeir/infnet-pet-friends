package com.luanr.pedido.infra.stream;

import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

@Configuration
public class StreamConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(StreamConfiguration.class);

    @Bean
    public Consumer<Message<String>> receiveMessage() {
        return message -> {
            LOG.info("Receber Mensagem: " + message.getPayload());
        };
    }

    // @Bean
    // public Supplier<Message<String>> sendMessage() {
    // return () -> MessageBuilder.withPayload("Hello, World!")
    // .setHeader("contentType", "text/plain")
    // .build();
    // }
}
