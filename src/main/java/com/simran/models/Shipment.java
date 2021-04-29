package com.simran.models;

import java.util.UUID;

public class Shipment
{
    private String id;
    private String orderId;
    private String vehicleId;
    private Location currentLocation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Shipment(String orderId, String vehicleId,Location currentLocation)
    {
        this.orderId = orderId;
        this.vehicleId = vehicleId;
        this.currentLocation = currentLocation;
        this.id= UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id='" + id + '\'' +
                ", orderId='" + orderId + '\'' +
                ", vehicleId='" + vehicleId + '\'' +
                '}';
    }
}
