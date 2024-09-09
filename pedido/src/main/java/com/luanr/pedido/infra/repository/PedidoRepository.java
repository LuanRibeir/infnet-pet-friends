package com.luanr.pedido.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luanr.pedido.domain.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, String> {

}
