package com.simran;

import com.simran.abstractions.IVehicleOrderMappingStrategy;
import com.simran.exceptions.VehicleUnAvailableException;
import com.simran.models.Order;
import com.simran.models.Vehicle;
import com.simran.models.VehicleStatus;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DefaultVehicleOrderMappingStrategy implements IVehicleOrderMappingStrategy
{

    @Override
    public String mapVehicle(Order order, Map<String, Vehicle> vehicleMap)
    {
      Collection<Vehicle> vehicles = vehicleMap.values();
      List<Vehicle> availableVehicles = vehicles.stream().filter(i->i.getStatus()== VehicleStatus.available).collect(Collectors.toList());
      if(availableVehicles.isEmpty())
      {
          throw new VehicleUnAvailableException();
      }
      Vehicle vehicle = availableVehicles.get(0);
      vehicleMap.get(vehicle.getId()).setStatus(VehicleStatus.occupied);
      return vehicle.getId();
    }
}
