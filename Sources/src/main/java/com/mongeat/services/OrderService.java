package com.mongeat.services;

import com.mongeat.converters.OrderConverter;
import com.mongeat.entities.OrderEntity;
import com.mongeat.models.Order;
import com.mongeat.repositories.OrderRepository;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class OrderService extends GenericService<Order, OrderEntity> {

    @Inject
    OrderRepository orderRepository;

    @PostConstruct
    public void init() {
        setRepository(orderRepository);
        setConverter(new OrderConverter());
    }
}
