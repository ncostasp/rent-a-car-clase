package service;

import model.RentalOffice;

import java.util.ArrayList;

public interface IRentalOfficeService {
    RentalOffice findById(Long id);
    void add(String address, int feeForDelivery);
    void deleteById(Long id);
    ArrayList findAll();
    void update(Long id, String address, int feeForDelivery);

}
