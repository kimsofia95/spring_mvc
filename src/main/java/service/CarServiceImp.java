package service;

import dao.CarDaoImp;
import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImp implements CarService{

    private CarDaoImp carDaoImp = new CarDaoImp();
    private boolean carsCreated = false;

    public void addCars() {
        if (!carsCreated) {
            Car car = new Car();
            car.add(new Car("mersedes", 23, 24000));
            car.add(new Car("bmv", 40, 30000));
            car.add(new Car("lada", 123, 10000));
            car.add(new Car("mersedes", 24, 25000));
            car.add(new Car("kia", 100, 20000));
        }
        carsCreated = true;
    }

    @Override
    public List<Car> getCarsLimit(int count) {
        return carDaoImp.getCarsLimit(count);
    }
}
