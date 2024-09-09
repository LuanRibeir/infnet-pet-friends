package com.luanr.pedido.infra.events;

public class PedidoCreated extends BaseEvent<String> {
    public final String nome;

    public PedidoCreated(String id, String nome) {
        super(id);
        this.nome = nome;
    }
}
