package com.luanr.pedido.application.service;

import java.util.List;
import java.util.Optional;

import com.luanr.pedido.domain.model.Pedido;

public interface PedidoQueryService {

    public Optional<Pedido> getById(String id);

    public List<Object> listEventsById(String id);
}
