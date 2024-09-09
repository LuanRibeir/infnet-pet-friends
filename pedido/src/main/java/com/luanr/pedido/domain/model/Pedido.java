package com.luanr.pedido.domain.model;

import java.io.Serializable;
import java.util.Objects;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.luanr.pedido.infra.commands.CreatePedidoCommand;
import com.luanr.pedido.infra.events.PedidoCreated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Aggregate
@Getter
@Setter
@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {

    @AggregateIdentifier
    @Id
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "estado")
    private String estado;

    public Pedido() {

    }

    @CommandHandler
    public Pedido(CreatePedidoCommand command) {
        AggregateLifecycle.apply(new PedidoCreated(command.id, command.nome));
    }

    @EventSourcingHandler
    protected void on(PedidoCreated event) {
        this.id = event.id;
        this.nome = event.nome;
        this.estado = String.valueOf(Estado.NOVO);
    }

    @Override
    public boolean equals(Object objeto) {
        Pedido outro = (Pedido) objeto;
        return Objects.equals(nome, outro.nome);
    }

}