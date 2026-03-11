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

    public void add(LocalDate fecha1, LocalDate fecha2, Long idCar, Long idClient, Long idRentalOffice){
        service.add(fecha1, fecha2, idCar, idClient, idRentalOffice);

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


    public void update(Long id,String licensePlate, Long idModel, Long idRentalOffice){
       // service.update(id, licensePlate, idModel, idRentalOffice);
    }


}
