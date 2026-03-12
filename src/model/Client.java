package model;

import java.util.ArrayList;

public class Client {
    private Long id;
    private String dni;
    private String name;
    private String surname;
    private ArrayList<Rental> rentals;

    public Client(Long id, String dni, String name, String surname) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.rentals = new ArrayList<>();
    }

    public Client(String dni, String name, String surname) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.rentals = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public ArrayList<Rental> getRentals() {
        return rentals;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname;
    }
}
