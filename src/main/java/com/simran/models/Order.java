package com.simran.models;

import java.util.List;
import java.util.UUID;

public class Order
{
    private String id;
    private Location sourceLocation;
    private Location destinationLocation;

    public void setId(String id) {
        this.id = id;
    }

    public void setSourceLocation(Location sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public void setDestinationLocation(Location destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Location getSourceLocation() {
        return sourceLocation;
    }

    public Location getDestinationLocation() {
        return destinationLocation;
    }

    public List<String> getItems() {
        return items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public double getCost() {
        return cost;
    }

    private List<String> items;
    private OrderStatus status;
    private double cost;

    public Order(List<String> items,Location sourceLocation, Location destinationLocation)
    {
        this.id = UUID.randomUUID().toString();
        this.sourceLocation = sourceLocation;
        this.destinationLocation = destinationLocation;
        this.items = items;
        this.status = OrderStatus.created;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", sourceLocation=" + sourceLocation +
                ", destinationLocation=" + destinationLocation +
                ", items=" + items +
                ", status=" + status +
                ", cost=" + cost +
                '}';
    }

    public String getId() {
        return id;
    }

}
