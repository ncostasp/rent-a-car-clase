package service;

import model.RentalOffice;
import repository.IRentalOfficeRepository;
import repository.RentalOfficeRepository;

import java.util.ArrayList;

public class RentalOfficeServiceImpl implements IRentalOfficeService{

    private IRentalOfficeRepository repository;
    public RentalOfficeServiceImpl() {
        repository = RentalOfficeRepository.getRentalOfficeRepository();
    }

    public void add(String address, int feeForDelivery) {
        RentalOffice rentalOffice = new RentalOffice(address, feeForDelivery);
        repository.add(rentalOffice);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public ArrayList findAll() {
        return repository.findAll();
    }


    public RentalOffice findById(Long id) {
        return repository.findById(id);
    }


    public void update(Long id, String address, int feeForDelivery) {
        RentalOffice rentalOffice = new RentalOffice(id, address, feeForDelivery);
        repository.update(rentalOffice);
    }


}
