package service;

import model.Rental;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IRentalService {
    Rental findById(Long id);
    void add(Long idClient, LocalDate startDate, LocalDate endDate, Long idRentalOffice, Long idCar);
    void deleteById(Long id);
    ArrayList findAll();
    void update(Long id,Long idClient, LocalDate startDate, LocalDate endDate, Long idRentalOffice, Long idCar);

}
