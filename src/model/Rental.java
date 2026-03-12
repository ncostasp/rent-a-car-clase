package model;


import java.time.LocalDate;
import java.util.Date;

public class Rental {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Car car;
    private Client client;
    private RentalOffice rentalOffice;


    public Rental(Client client, LocalDate startDate, LocalDate endDate,RentalOffice rentalOffice, Car car ) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.car = car;
        this.client = client;
        this.rentalOffice = rentalOffice;
    }
    public Rental(Long id, Client client, LocalDate startDate, LocalDate endDate,RentalOffice rentalOffice, Car car ) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.car = car;
        this.client = client;
        this.rentalOffice = rentalOffice;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public RentalOffice getRentalOffice() {
        return rentalOffice;
    }

    public void setRentalOffice(RentalOffice rentalOffice) {
        this.rentalOffice = rentalOffice;
    }

    @Override
    public String toString() {
        return id + " " + startDate + " " + endDate + " " + car + " " + client + " " + rentalOffice ;
    }
}
