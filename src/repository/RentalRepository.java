package repository;

import model.Rental;

import java.util.ArrayList;

public class RentalRepository implements IRentalRepository {

    private ArrayList<Rental> rentals;
    private static RentalRepository rentalRepository;

    private RentalRepository() {
        rentals = new ArrayList<>();
    }

    public static RentalRepository getRentalRepository() {
        if(rentalRepository == null){
            rentalRepository = new RentalRepository();
        }
        return rentalRepository;
    }

    public void add(Rental rental){
        rental.setId(nextIdAvailable());
        rentals.add(rental);
    }

    public void update(Rental rental){
        rentals.set(rentals.indexOf(findById(rental.getId())), rental);
    }

    public ArrayList findAll(){
        return rentals;
    }

    public void deleteById(Long id){
        for (Rental rental : rentals) {
            if (rental.getId() == id) {
                rentals.remove(rental);
                break;
            }
        }
    }

    public Long nextIdAvailable(){
        if(!rentals.isEmpty()){
            return rentals.get(rentals.size()-1).getId() + 1;
        }
        else{
            return (long)1;
        }
    }

    public Rental findById(Long id) {
        for (Rental rental : rentals) {
               if(rental.getId() == id){
                   return rental;
               }
        }
        return null;
    }


}
