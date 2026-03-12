package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RentalOffice {
    private Long id;
    private String address;
    private int feeForDelivery;
    private ArrayList<Car> cars ;
    private ArrayList<Rental> rentals;

    public RentalOffice(Long id, String address, int feeForDelivery) {
        this.id = id;
        this.address = address;
        this.feeForDelivery = feeForDelivery;
        this.cars = new ArrayList<>();
        this.rentals = new ArrayList<>();
    }

    public RentalOffice(String address, int feeForDelivery) {
        this.address = address;
        this.feeForDelivery = feeForDelivery;
        this.cars = new ArrayList<>();
        this.rentals = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getfeeForDelivery() {
        return feeForDelivery;
    }

    public void setfeeForDelivery(int feeForDelivery) {
        this.feeForDelivery = feeForDelivery;
    }

    public void addCar(Car car){
        this.cars.add(car);
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public ArrayList<Rental> getRentals() {
        return rentals;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    @Override
    public String toString() {
        return id + " " + address + " " + feeForDelivery;
    }
}
