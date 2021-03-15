package service;

import dao.CarDaoImp;
import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImp implements CarService{

    private CarDaoImp carDaoImp = new CarDaoImp();

    @Override
    public List<Car> getCarsLimit(int count) {
        return carDaoImp.getCarsLimit(count);
    }
}
