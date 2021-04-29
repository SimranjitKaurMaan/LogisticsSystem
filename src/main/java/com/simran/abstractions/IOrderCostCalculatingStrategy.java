package com.simran.abstractions;

import com.simran.models.Order;

public interface IOrderCostCalculatingStrategy
{
    double calculateCost(Order order);
}
