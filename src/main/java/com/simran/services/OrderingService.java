package com.simran.services;

import com.simran.models.Order;
import com.simran.abstractions.IOrderCostCalculatingStrategy;
import com.simran.models.Location;
import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderingService
{
    Map<String, Order> OrderMap;
    private IOrderCostCalculatingStrategy orderCostCalculatingStrategy;

    public OrderingService(IOrderCostCalculatingStrategy orderCostCalculatingStrategy) {
        this.orderCostCalculatingStrategy = orderCostCalculatingStrategy;
        this.OrderMap = new HashMap<>();
    }


    public Order placeOrder(@NonNull final List<String> items, @NonNull final Location sourceLocation, @NonNull final Location destinationLocation)
    {
        Order order = new Order(items,sourceLocation,destinationLocation);
        order.setCost(this.orderCostCalculatingStrategy.calculateCost(order));
        OrderMap.put(order.getId(),order);
        return order;
    }

}
