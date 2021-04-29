package com.simran.abstractions;

import com.simran.models.Order;
import com.simran.models.Vehicle;

import java.util.Map;

public interface IVehicleOrderMappingStrategy
{
    String mapVehicle(Order order, Map<String, Vehicle> vehicleMap);
}
