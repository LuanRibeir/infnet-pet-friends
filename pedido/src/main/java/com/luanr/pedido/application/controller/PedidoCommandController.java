package com.luanr.pedido.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luanr.pedido.application.service.PedidoCommandService;
import com.luanr.pedido.domain.model.Pedido;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/pedidos")
public class PedidoCommandController {

    private final PedidoCommandService PCService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Pedido pedido) {
        try {
            return new ResponseEntity<>(PCService.createPedido(pedido), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
