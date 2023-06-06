package com.mongeat.services;

import com.mongeat.entities.Order;
import com.mongeat.repositories.OrderRepository;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;

public class OrderService extends GenericService<Order> {

    @Inject
    OrderRepository orderRepository;

    @PostConstruct
    public void init() {
        setRepository(orderRepository);
    }
}
