package web.CarList;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarList {
    public static final List<Car> cars = List.of(
            new Car("Lada", 7, "Baklajan"),

            new Car("Shkoda", 40, "Green"),


            new Car("WV", 2, "Blue"),

            new Car("BMW", 6, "Black"),

            new Car("Porsche", 911, "Orange"));
    public List<Car> getCars() {
        return cars;
    }
}
