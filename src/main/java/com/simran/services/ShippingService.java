package com.simran.services;

import com.simran.models.*;
import com.simran.abstractions.IVehicleOrderMappingStrategy;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class ShippingService
{
    Map<String, Vehicle> vehicleMap;
    Map<String, Shipment> shipmentMap;

    private OrderingService orderingService;
    private IVehicleOrderMappingStrategy vehicleOrderMappingStrategy;


    public ShippingService(Map<String, Vehicle> vehicleMap, OrderingService orderingService,IVehicleOrderMappingStrategy vehicleOrderMappingStrategy ) {
        this.vehicleMap = vehicleMap;
        this.orderingService = orderingService;
        this.vehicleOrderMappingStrategy = vehicleOrderMappingStrategy;
        this.shipmentMap = new HashMap<>();
    }


    public Shipment ShipOrder(@NonNull final String orderId)
    {
        Order order = orderingService.OrderMap.get(orderId);
        order.setStatus(OrderStatus.shipped);
        String vehicleId = this.vehicleOrderMappingStrategy.mapVehicle(order,vehicleMap);
        Shipment shipment = new Shipment(orderId,vehicleId,order.getSourceLocation());
        shipmentMap.put(orderId,shipment);
        return shipment;
    }

    public void deliverOrder(@NonNull final String orderId)
    {
        Order order = orderingService.OrderMap.get(orderId);
        order.setStatus(OrderStatus.delivered);
        shipmentMap.get(orderId).setCurrentLocation(order.getDestinationLocation());
    }

    public String updateLocation(@NonNull final String orderId, @NonNull final Location currentLocation)
    {
        Shipment shipment = shipmentMap.get(orderId);
        shipment.setCurrentLocation(currentLocation);
        return shipment.getId();
    }

}
