package controller;

import model.Car;
import model.Client;
import service.ClientServiceImpl;
import service.IClientService;

import java.util.ArrayList;

public class ClientController {

    private IClientService service;
    public ClientController() {
        service = new ClientServiceImpl();
    }

    public void add(String dni, String name, String surname){
        service.add(dni, name, surname);

    }


    public Client findById(Long id){
        return service.findById(id);
    }

    public void deleteById(Long id){
        service.deleteById(id);

    }

    public ArrayList findAll(){
        return service.findAll();
    }



    public Client findByDni(String dni){
        return service.findByDni(dni);
    }

    public void update(Long id, String dni, String name, String surname){
        service.update(id, dni, name, surname);
    }


}
