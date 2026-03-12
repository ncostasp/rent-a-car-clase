package model;

import java.util.ArrayList;

public class Model {
    private Long id;
    private String name;
    private int pricePerDay;
    private ArrayList<Car> cars;

    public Model(Long id, String name, int pricePerDay) {
        this.id = id;
        this.name = name;
        this.pricePerDay = pricePerDay;
        this.cars = new ArrayList<>();
    }

    public Model(String name, int pricePerDay) {
        this.name = name;
        this.pricePerDay = pricePerDay;
        this.cars = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getpricePerDay() {
        return pricePerDay;
    }

    public void setpricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }



    @Override
    public String toString() {
        return id + " " + name + " " + pricePerDay;
    }
}
