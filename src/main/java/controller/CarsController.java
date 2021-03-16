package controller;

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

   @GetMapping(value = "/cars")
    public String printCarsCount(ModelMap model, @RequestParam(value = "count", required = false) String count) {
       CarServiceImp carServiceImp = new CarServiceImp();
       carServiceImp.addCars();
       if (count != null) {
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
