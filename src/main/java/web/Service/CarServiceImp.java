package web.Service;


import org.springframework.stereotype.Service;
import web.CarList.CarList;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImp implements CarService {




    private final CarList carList;

    public CarServiceImp(CarList carList) {
        this.carList = carList;
    }

    public List<Car> getCars(int count) {
        List<Car> cars = carList.getCars();
        return count < 0 || count > cars.size() ? cars : cars.subList(0, count);
    }
}
