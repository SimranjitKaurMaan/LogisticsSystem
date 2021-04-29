package com.simran.models;

import com.simran.models.Location;
import com.simran.models.OrderStatus;

import java.util.UUID;

public class TrackOrder
{
    private String id;
    private String orderId;
    private Location currentLocation;
    private OrderStatus orderStatus;

    public String getId() {
        return id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public TrackOrder(String orderId, Location currentLocation, OrderStatus status)
    {
        this.id = UUID.randomUUID().toString();
        this.orderId = orderId;
        this.currentLocation = currentLocation;
        this.orderStatus = status;
    }

    @Override
    public String toString() {
        return "TrackOrder{" +
                "id='" + id + '\'' +
                ", orderId='" + orderId + '\'' +
                ", currentLocation=" + currentLocation +
                ", orderStatus=" + orderStatus +
                '}';
    }

}
