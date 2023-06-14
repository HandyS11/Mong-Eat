package com.mongeat.stub;

import com.mongeat.entities.OrderEntity;

import java.util.ArrayList;
import java.util.List;

public class OrderStub {
    public final List<OrderEntity> orders = new ArrayList<>();

    public OrderStub() {
        OrderEntity order1 = new OrderEntity("64799a8ec40b7a7aad35ac40", "Done", 13.99, 0, 0, 1.5, List.of("64705dda1fe1d56fab1b17b2"), "647063c7e4314fe5feca99f2", LocationStub.location1);

        orders.add(order1);
    }
    public List<OrderEntity> getOrders() {
        return orders;
    }
}
