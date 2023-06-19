package com.mongeat.stub;

import com.mongeat.entities.OrderEntity;

import java.util.ArrayList;
import java.util.List;

public class OrderStub {
    public final List<OrderEntity> orders = new ArrayList<>();

    public OrderStub() {
        OrderEntity order1 = new OrderEntity("64799a8ec40b7a7aad35ac40", "Done", 13.99, 0, 0, 1.5, List.of("64705dda1fe1d56fab1b17b2"), "647063c7e4314fe5feca99f2", LocationStub.location1);
        OrderEntity order2 = new OrderEntity("648ffa46ec78d056b34d9dce", "On Going", 19.99, 2, 0, 1.3, List.of("64705dda1fe1d56fab1b17b2", "64705df5278554181000e023"), "6470641c251dad7b4fc1dc00", LocationStub.location1);
        OrderEntity order3 = new OrderEntity("648ffa4daf7b5a03bb322c91", "On Going", 10.99, 5, 0, 3.2, List.of("64705e06ae09d7bf1afc23ff"), "647063e6e6de03f52dff3590", LocationStub.location2);

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
    }
    public List<OrderEntity> getOrders() {
        return orders;
    }
}
