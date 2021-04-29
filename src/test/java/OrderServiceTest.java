import com.simran.*;
import com.simran.models.*;
import com.simran.services.OrderingService;
import com.simran.services.ShippingService;
import com.simran.services.TrackingService;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OrderServiceTest
{
    @Test
    public void defaultTest()
    {
        OrderingService orderingService = new OrderingService(new DefaultOrderCostCalculatingStrategy());
        Order order = orderingService.placeOrder(Arrays.asList("A","B","C","D","E"), new Location(0,0), new Location(10,10));
        System.out.println(order);
        Map<String, Vehicle> vehicleMap = new HashMap<>();
        Vehicle vehicle = new Vehicle(VehicleType.van,new Location(0,0));
        Vehicle vehicle1 = new Vehicle(VehicleType.truck,new Location(10,10));
        vehicleMap.put(vehicle.getId(),vehicle);
        vehicleMap.put(vehicle1.getId(),vehicle1);
        ShippingService shippingService = new ShippingService(vehicleMap,orderingService,new DefaultVehicleOrderMappingStrategy());
        Shipment shipment = shippingService.ShipOrder(order.getId());
        System.out.println(shipment);
        shippingService.updateLocation(order.getId(),new Location(5,5));
        TrackingService trackingService = new TrackingService(orderingService,shippingService);
        TrackOrder trackOrder = trackingService.trackOrder(order.getId());
        System.out.println(trackOrder);
        shippingService.deliverOrder(order.getId());
        System.out.println(order);
        trackOrder = trackingService.trackOrder(order.getId());
        System.out.println(trackOrder);
        order = orderingService.placeOrder(Arrays.asList("A","B","C"), new Location(0,0), new Location(10,10));
        shipment = shippingService.ShipOrder(order.getId());
//        order = orderingService.placeOrder(Arrays.asList("A","B","C","D"), new Location(0,0), new Location(30,30));
//        shipment = shippingService.ShipOrder(order.getId());

    }
}
