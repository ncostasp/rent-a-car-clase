package view;

import controller.CarController;
import controller.ModelController;
import controller.RentalOfficeController;
import model.RentalOffice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CarDialog {

    private CarController carController;
    private ModelController modelController;
    private RentalOfficeController rentalOfficeController;
    private Scanner scanner;

    public CarDialog(){
        carController = new CarController();
        modelController = new ModelController();
        rentalOfficeController = new RentalOfficeController();

    };

    public void getStarted(){
        do {
            System.out.println("\n************************** Car Manager ********************************");
            System.out.println("\n\t1. Create Car.\t\t\t\t4. Search Car.");
            System.out.println("\n\t2. Remove Car.\t\t\t\t5. See All Cars.");
            System.out.println("\n\t3. Update Car.\t\t\t\t0. Back.");
            System.out.println("\n**************************************************************************");
            scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            try {
                if(choice == 1){
                    scanner.nextLine();
                    System.out.println("Enter a LicensePlate: ");
                    String licensePlate = scanner.nextLine();
                    System.out.println(modelController.findAll());
                    System.out.println("Enter a IdModel: ");
                    Long idModel = scanner.nextLong();
                    System.out.println(rentalOfficeController.findAll());
                    System.out.println("Enter a IdRentalOffice: ");
                    Long idRentalOffice = scanner.nextLong();
                    System.out.println("New car created with license plate " + licensePlate +
                            ", model " + modelController.findById(idModel) +
                            ", at rental office " + rentalOfficeController.findById(idRentalOffice));
                    carController.add(licensePlate, idModel, idRentalOffice);
                } else if (choice == 2) {
                    System.out.println("Car ID: ");
                    Long id = scanner.nextLong();
                    carController.deleteById(id);
                } else if (choice == 3) {
                    System.out.println(carController.findAll());
                    System.out.println("Car ID to modify: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Enter new LicensePlate: ");
                    String licensePlate = scanner.nextLine();
                    System.out.println(modelController.findAll());
                    System.out.println("Enter new IdModel: ");
                    Long idModel = scanner.nextLong();
                    System.out.println(rentalOfficeController.findAll());
                    System.out.println("Enter new IdRentalOffice: ");
                    Long idRentalOffice = scanner.nextLong();
                    System.out.println("Car with id " + id +
                            " has been updated with license plate " + licensePlate +
                            ", model " + modelController.findById(idModel) +
                            ", at rental office " + rentalOfficeController.findById(idRentalOffice));
                    carController.update(id, licensePlate, idModel,idRentalOffice);
                } else if (choice == 4) {
                    scanner.nextLine();
                    System.out.println("Id: ");
                    Long id = scanner.nextLong();
                    System.out.println(carController.findById(id));
                } else if (choice == 5) {
                    for (Object car : carController.findAll()) {
                        System.out.println(car);

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

    public void addInitialCars(){
        carController.add("5754497", 1L, 1L);
        carController.add("54546", 2L, 2L);
        carController.add("47446", 3L, 3L);

    }
}
