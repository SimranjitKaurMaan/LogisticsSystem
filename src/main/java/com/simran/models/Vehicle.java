package com.simran.models;

import com.simran.models.Location;
import com.simran.models.VehicleStatus;
import com.simran.models.VehicleType;

import java.util.UUID;

public class Vehicle
{
    private String id;
    private VehicleType vehicleType;
    private Location location;
    private VehicleStatus status;

    public void setId(String id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public Vehicle(VehicleType vehicleType, Location location) {
        this.id = UUID.randomUUID().toString();
        this.vehicleType = vehicleType;
        this.location = location;
        this.status = VehicleStatus.available;
    }

}
