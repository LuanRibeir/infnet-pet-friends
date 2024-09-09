package com.luanr.pedido.infra.commands;

public class CreatePedidoCommand extends BaseCommand<String> {
    public final String nome;

    public CreatePedidoCommand(String id, String nome) {
        super(id);
        this.nome = nome;
    }
}
