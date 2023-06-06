package com.mongeat.controllers;

import com.mongeat.entities.Order;
import com.mongeat.services.OrderService;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/orders")
public class OrderController extends GenericController<Order> {

    @Inject
    OrderService orderService;

    @PostConstruct
    public void init() {
        setService(orderService);
    }
}
