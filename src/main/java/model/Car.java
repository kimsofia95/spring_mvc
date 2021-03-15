package model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private int serial;
    private int price;
    private static List<Car> cars = new ArrayList<>();

    public Car() {
    }

    public Car(String model, int serial, int price) {
        this.model = model;
        this.serial = serial;
        this.price = price;
    }

    public void add(Car car) {
        this.cars.add(car);
    }

    public static List<Car> getCarsList() {
        return cars;
    }

    public String getModel() {
        return model;
    }

    public int getSerial() {
        return serial;
    }

    public int getPrice() {
        return price;
    }
}
