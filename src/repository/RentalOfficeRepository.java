package repository;

import model.RentalOffice;

import java.util.ArrayList;

public class RentalOfficeRepository implements IRentalOfficeRepository {

    private ArrayList<RentalOffice> rentalOffices;
    private static RentalOfficeRepository rentalOfficeRepository;

    private RentalOfficeRepository() {
        rentalOffices = new ArrayList<>();
    }

    public static RentalOfficeRepository getRentalOfficeRepository() {
        if(rentalOfficeRepository == null){
            rentalOfficeRepository = new RentalOfficeRepository();
        }
        return rentalOfficeRepository;
    }

    public void add(RentalOffice rentalOffice){
        rentalOffice.setId(nextIdAvailable());
        rentalOffices.add(rentalOffice);
    }

    public void update(RentalOffice rentalOffice){
        rentalOffices.set(rentalOffices.indexOf(findById(rentalOffice.getId())), rentalOffice);
    }

    public ArrayList findAll(){
        return rentalOffices;
    }

    public void deleteById(Long id){
        for (RentalOffice rentalOffice : rentalOffices) {
            if (rentalOffice.getId() == id) {
                rentalOffices.remove(rentalOffice);
                break;
            }
        }
    }

    public Long nextIdAvailable(){
        if(!rentalOffices.isEmpty()){
            return rentalOffices.get(rentalOffices.size()-1).getId() + 1;
        }
        else{
            return (long)1;
        }
    }

    public RentalOffice findById(Long id) {
        for (RentalOffice rentalOffice : rentalOffices) {
               if(rentalOffice.getId() == id){
                   return rentalOffice;
               }
        }
        return null;
    }


}
