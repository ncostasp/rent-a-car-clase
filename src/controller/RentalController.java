package controller;


import model.Rental;
import service.RentalServiceImpl;
import service.IRentalService;

import java.time.LocalDate;
import java.util.ArrayList;

public class RentalController {

    private IRentalService service;
    public RentalController() {
        service = new RentalServiceImpl();
    }

    public void add(Long idClient, LocalDate fecha, LocalDate fecha2, Long idRentalOffice, Long idCar){
        service.add(idClient, fecha, fecha2, idRentalOffice, idCar );

    }

    public Rental findById(Long id){
        return service.findById(id);
    }


    public void deleteById(Long id){
        service.deleteById(id);

    }

    public ArrayList findAll(){
        return service.findAll();
    }


    public void update(Long id, Long idClient, LocalDate fecha, LocalDate fecha2, Long idRentalOffice, Long idCar){
       service.update(id, idClient, fecha, fecha2, idRentalOffice, idCar );
    }


}
