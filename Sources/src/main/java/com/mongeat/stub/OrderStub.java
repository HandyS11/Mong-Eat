package com.mongeat.stub;

import com.mongeat.entities.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderStub {
    public List<Order> orders = new ArrayList<>();

    public OrderStub() {
        Order order1 = new Order("64799a8ec40b7a7aad35ac40", "Done", 13.99, 0, 0, 1.5, List.of("64705dda1fe1d56fab1b17b2"), "647063c7e4314fe5feca99f2", LocationStub.location1);

        orders.add(order1);
    }
    public List<Order> getOrders() {
        return orders;
    }
}
