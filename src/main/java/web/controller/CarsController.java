package web.controller;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.CarServiceImp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class CarsController {

    private boolean carsCreated = false;

    public void addCars() {
        Car car = new Car();
        car.add(new Car("mersedes", 23, 24000));
        car.add(new Car("bmv", 40, 30000));
        car.add(new Car("lada", 123, 10000));
        car.add(new Car("mersedes", 24, 25000));
        car.add(new Car("kia", 100, 20000));
        carsCreated = true;
    }

   @GetMapping(value = "/cars")
    public String printCarsCount(ModelMap model, @RequestParam(value = "count", required = false) String count) {
       if (!carsCreated) {
           addCars();
       }
       if (count != null) {
           CarServiceImp carServiceImp = new CarServiceImp();
           if (Integer.parseInt(count) > Car.getCarsList().size()) {
               model.addAttribute("cars", Car.getCarsList());
           }
           else {
               model.addAttribute("cars", carServiceImp.getCarsLimit(Integer.parseInt(count)));
           }
       }
       else {
           model.addAttribute("cars", Car.getCarsList());
       }
        return "cars";
    }
}
