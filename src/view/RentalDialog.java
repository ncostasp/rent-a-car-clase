package view;

import controller.*;
import model.Car;
import model.Client;
import model.RentalOffice;

import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RentalDialog {

    private RentalController rentalController;
    private ClientController clientController;
    private ModelController modelController;
    private RentalOfficeController rentalOfficeController;
    private CarController carController;
    private Scanner scanner;

    public RentalDialog(){
        rentalController = new RentalController();
        modelController = new ModelController();
        rentalOfficeController = new RentalOfficeController();
        clientController = new ClientController();
        carController = new CarController();

    };

    public void getStarted(){
        do {
            System.out.println("\n************************** Rental Manager ********************************");
            System.out.println("\n\t1. Create Rental.\t\t\t\t4. Search Rental.");
            System.out.println("\n\t2. Remove Rental.\t\t\t\t5. See All Rentals.");
            System.out.println("\n\t3. Update Rental.\t\t\t\t0. Back.");
            System.out.println("\n**************************************************************************");
            scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            try {
                if(choice == 1){
                    scanner.nextLine();
                    System.out.println(clientController.findAll());
                    System.out.println("Enter an IdClient: ");
                    Long idClient = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println(clientController.findById(idClient));
                    System.out.println("Enter a start date (YYYY-MM-DD) ");
                    String texto = scanner.nextLine();
                    LocalDate fecha = LocalDate.parse(texto);
                    System.out.println("Enter an end date (YYYY-MM-DD) ");
                    String texto2 = scanner.nextLine();
                    LocalDate fecha2 = LocalDate.parse(texto2);
                    System.out.println(rentalOfficeController.findAll());
                    System.out.println("Enter an IdRentalOffice: ");
                    Long idRentalOffice = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println(rentalOfficeController.findById(idRentalOffice));
                    System.out.println(carController.findAll());
                    System.out.println("Enter an IdCar: ");
                    Long idCar = scanner.nextLong();
                    System.out.println("Client " + clientController.findById(idClient) +
                            " starts the rental on " + texto +
                            " and finishes it on " + fecha2 +
                            " with vehicle " + carController.findById(idCar) +
                            " at rental office " + rentalOfficeController.findById(idRentalOffice));
                    rentalController.add(idClient,fecha, fecha2, idRentalOffice, idCar );
                } else if (choice == 2) {
                    System.out.println(rentalController.findAll());
                    System.out.println("Enter a Rental ID: ");
                    Long id = scanner.nextLong();
                    rentalController.deleteById(id);
                } else if (choice == 3) {
                    System.out.println(rentalController.findAll());
                    System.out.println("Enter Rental ID to modify: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println(clientController.findAll());
                    System.out.println("Enter new idClient: ");
                    Long idClient = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println(clientController.findById(idClient));
                    System.out.println("Enter a start date (YYYY-MM-DD) ");
                    String texto = scanner.nextLine();
                    LocalDate fecha = LocalDate.parse(texto);
                    System.out.println("Enter an end date (YYYY-MM-DD) ");
                    String texto2 = scanner.nextLine();
                    LocalDate fecha2 = LocalDate.parse(texto2);
                    System.out.println(rentalOfficeController.findAll());
                    System.out.println("Enter new idRentalOffice: ");
                    Long idRentalOffice = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println(rentalOfficeController.findById(idRentalOffice));
                    System.out.println(carController.findAll());
                    System.out.println("Enter new idCar: ");
                    Long idCar = scanner.nextLong();
                    System.out.println("Rental with id " + id +
                            " has been updated: client " + clientController.findById(idClient) +
                            ", from " + fecha +
                            " to " + fecha2 +
                            ", vehicle " + carController.findById(idCar) +
                            ", rental office " + rentalOfficeController.findById(idRentalOffice));
                    rentalController.update( id,idClient,fecha, fecha2, idRentalOffice, idCar  );
                } else if (choice == 4) {
                    scanner.nextLine();
                    System.out.println(rentalController.findAll());
                    System.out.println("Enter an Id: ");
                    Long id = scanner.nextLong();
                    System.out.println(rentalController.findById(id));
                } else if (choice == 5) {
                    for (Object rental : rentalController.findAll()) {
                        System.out.println(rental);

                    }
                } else if(choice==0) {
                    break;
                } else {
                    System.err.println("[ERROR] Your option is incorrect!! Try again!!");
                }

            } catch (InputMismatchException e) {
                System.err.println("[ERROR] You must type a number!!!");
                scanner.next();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }

    public void addInitialRentals(){
        rentalController.add(1L, LocalDate.of(2026,1,2), LocalDate.of(2026,2,10), 1L, 1L);
        rentalController.add(2L, LocalDate.of(2026,3,2), LocalDate.of(2026,4,10), 2L, 2L);
        rentalController.add(1L, LocalDate.of(2026,5,2), LocalDate.of(2026,8,10), 3L, 3L);
    }
}
