package com.luanr.pedido;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;

@SpringBootApplication
public class PedidoApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(PedidoApplication.class);

	@Autowired
	private StreamBridge streamBridge;

	public static void main(String[] args) {
		SpringApplication.run(PedidoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String mensagem = "Somente uma mensagem";
		LOG.info("Enviando mensagem: " + mensagem);
		streamBridge.send("sendMessage-out-0", mensagem);
	}
}
