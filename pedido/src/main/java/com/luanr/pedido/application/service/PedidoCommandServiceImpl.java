package com.luanr.pedido.application.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luanr.pedido.domain.model.Pedido;
import com.luanr.pedido.infra.commands.CreatePedidoCommand;

@Service
public class PedidoCommandServiceImpl implements PedidoCommandService {

    @Autowired
    private final CommandGateway commandGateway;

    public PedidoCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<String> createPedido(Pedido pedido) {
        return commandGateway.send(new CreatePedidoCommand(UUID.randomUUID().toString(), pedido.getNome()));
    }

}
