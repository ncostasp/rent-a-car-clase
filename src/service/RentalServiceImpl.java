package service;

import model.*;
import repository.RentalRepository;
import repository.IRentalRepository;


import java.time.LocalDate;
import java.util.ArrayList;


public class RentalServiceImpl implements IRentalService{

    private IRentalRepository repository;

    private IRentalOfficeService rentalOfficeService;
    private ICarService carService;
    private IClientService clientService;

    public RentalServiceImpl() {
        repository = RentalRepository.getRentalRepository();
        rentalOfficeService = new RentalOfficeServiceImpl();
        carService = new CarServiceImpl();
        clientService = new ClientServiceImpl();


    }

    public void add(Long idClient, LocalDate startDate, LocalDate endDate, Long idRentalOffice, Long idCar) {
        Rental rental = new Rental(clientService.findById(idClient), startDate, endDate, rentalOfficeService.findById(idRentalOffice), carService.findById(idCar));
        repository.add(rental);
        Car car= carService.findById(idCar);
        car.addRental(rental);
        Client client= clientService.findById(idClient);
        client.addRental(rental);
        RentalOffice rentalOffice= rentalOfficeService.findById(idRentalOffice);
        rentalOffice.addRental(rental);

    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public ArrayList findAll() {
        return repository.findAll();
    }


    public Rental findById(Long id) {
        return repository.findById(id);
    }


    public void update(Long id,Long idClient, LocalDate startDate, LocalDate endDate, Long idRentalOffice, Long idCar) {
        repository.update(new Rental(id, clientService.findById(idClient), startDate, endDate, rentalOfficeService.findById(idRentalOffice), carService.findById(idCar)));
    }

}
