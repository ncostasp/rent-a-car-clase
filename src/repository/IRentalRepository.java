package repository;

import model.Rental;

import java.util.ArrayList;

public interface IRentalRepository {
    void add(Rental rental);
    void deleteById(Long id);
    ArrayList findAll();
    Rental findById(Long id);
    void update(Rental rental);
}
