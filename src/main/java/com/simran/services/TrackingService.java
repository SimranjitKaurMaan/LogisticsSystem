package com.simran.services;

import com.simran.models.*;
import lombok.NonNull;

public class TrackingService
{
    private OrderingService orderingService;
    private ShippingService shippingService;

    public TrackingService(OrderingService orderingService, ShippingService shippingService) {
        this.orderingService = orderingService;
        this.shippingService = shippingService;
    }

    public TrackOrder trackOrder(@NonNull final String orderId)
    {
        Order order = this.orderingService.OrderMap.get(orderId);
        Shipment shipment = this.shippingService.shipmentMap.get(orderId);
        TrackOrder trackOrder = new TrackOrder(orderId, shipment.getCurrentLocation(), order.getStatus());
        return trackOrder;
    }
}
