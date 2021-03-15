package dao;

import model.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoImp implements CarDao{

    @Override
    public List<Car> getCarsLimit(int count) {
        return Car.getCarsList().subList(0, count);
    }
}
