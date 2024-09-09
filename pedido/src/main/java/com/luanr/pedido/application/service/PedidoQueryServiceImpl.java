package com.luanr.pedido.application.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luanr.pedido.domain.model.Pedido;
import com.luanr.pedido.infra.repository.PedidoRepository;

@Service
public class PedidoQueryServiceImpl implements PedidoQueryService {
    private final EventStore eventStore;
    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoQueryServiceImpl(EventStore eventStore, PedidoRepository pedidoRepository) {
        this.eventStore = eventStore;
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Object> listEventsById(String id) {
        List<Object> retorno = eventStore.readEvents(id, 0)
                .asStream()
                .map(record -> record.getPayload()).collect(Collectors.toList());
        return retorno;
    }

    public Optional<Pedido> getById(String id) {
        return pedidoRepository.findById(id);
    }
}
