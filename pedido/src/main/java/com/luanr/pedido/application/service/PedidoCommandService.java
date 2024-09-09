package com.luanr.pedido.application.service;

import java.util.concurrent.CompletableFuture;

import com.luanr.pedido.domain.model.Pedido;

public interface PedidoCommandService {
    public CompletableFuture<String> createPedido(Pedido pedido);
}
