package controller;


import service.IRentalOfficeService;
import service.RentalOfficeServiceImpl;

import java.util.ArrayList;

public class RentalOfficeController {

    private IRentalOfficeService service;
    public RentalOfficeController() {
        service = new RentalOfficeServiceImpl();
    }

    public void add(String address, int feeForDelivery){
        service.add(address, feeForDelivery);

    }

    public void deleteById(Long id){
        service.deleteById(id);

    }

    public ArrayList findAll(){
        return service.findAll();
    }


    public void update(Long id, String address, int feeForDelivery){
        service.update(id, address, feeForDelivery);
    }


}
