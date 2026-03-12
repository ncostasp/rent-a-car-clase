package model;

import java.util.ArrayList;

public class Car {
    private Long id;
    private String licensePlate;
    private Model model;
    private RentalOffice rentalOffice;
    private ArrayList<Rental> rentals;

    public Car(Long id, String licensePlate, Model model, RentalOffice rentalOffice) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.model = model;
        this.rentalOffice = rentalOffice;
        this.rentals = new ArrayList<>();
    }

    public Car(String licensePlate, Model model, RentalOffice rentalOffice) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.rentalOffice = rentalOffice;
        this.rentals = new ArrayList<>();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public RentalOffice getRentalOffice() {
        return rentalOffice;
    }

    public void setRentalOffice(RentalOffice rentalOffice) {
        this.rentalOffice = rentalOffice;
    }

    public ArrayList<Rental> getRentals() {
        return rentals;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    @Override
    public String toString() {
        return id + " " + licensePlate + " " + model.getName() ;
    }
}
