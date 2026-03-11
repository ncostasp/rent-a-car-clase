package service;

import model.Rental;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public interface IRentalService {
    Rental findById(Long id);
    void add(LocalDate startDate, LocalDate endDate, Long idCar, Long idClient, Long idRentalOffice);
    void deleteById(Long id);
    ArrayList findAll();
    void update(LocalDate startDate, LocalDate endDate, Long idCar, Long idClient, Long idRentalOffice);

}
