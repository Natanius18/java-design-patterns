package example.natanius.builders;

import example.natanius.cars.CarType;
import example.natanius.components.Engine;
import example.natanius.components.GPSNavigator;
import example.natanius.components.Transmission;
import example.natanius.components.TripComputer;

/**
 * Builder interface defines all possible ways to configure a product.
 */
public interface Builder {
    void setCarType(CarType type);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setTransmission(Transmission transmission);

    void setTripComputer(TripComputer tripComputer);

    void setGPSNavigator(GPSNavigator gpsNavigator);
}
