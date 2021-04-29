package com.simran;

import com.simran.abstractions.IOrderCostCalculatingStrategy;
import com.simran.models.Order;

public class DefaultOrderCostCalculatingStrategy implements IOrderCostCalculatingStrategy
{
    @Override
    public double calculateCost(Order order)
    {
        return order.getItems().size()*100;
    }
}
