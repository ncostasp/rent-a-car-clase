package view;

import controller.RentalOfficeController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RentalOfficeDialog {

    private RentalOfficeController rentalOfficeController;
    private Scanner scanner;

    public RentalOfficeDialog(){
        rentalOfficeController = new RentalOfficeController();
    };

    public void getStarted(){
        do {
            System.out.println("\n************************** RentalOffice Manager ********************************");
            System.out.println("\n\t1. Create RentalOffice.\t\t\t\t4. Cars in RentalOffice.");
            System.out.println("\n\t2. Remove RentalOffice.\t\t\t\t5. See All RentalOffices.");
            System.out.println("\n\t3. Update RentalOffice.\t\t\t\t0. Back.");
            System.out.println("\n**************************************************************************");
            scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            try {
                if(choice == 1){
                    scanner.nextLine();
                    System.out.println("Enter an Address: ");
                    String address = scanner.nextLine();
                    System.out.println("Enter a FeeForDelivery: ");
                    int feeForDelivery = scanner.nextInt();
                    rentalOfficeController.add(address, feeForDelivery);
                    System.out.println("New rental office created with address " + address +
                            " and delivery fee " + feeForDelivery);
                } else if (choice == 2) {
                    System.out.println("Enter a RentalOffice ID: ");
                    Long id = scanner.nextLong();
                    rentalOfficeController.deleteById(id);
                } else if (choice == 3) {
                    System.out.println(rentalOfficeController.findAll());
                    System.out.println("RentalOffice ID to modify: ");
                    long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Enter new Address: ");
                    String address = scanner.nextLine();
                    System.out.println("Enter new FeeForDelivery: ");
                    int feeForDelivery = scanner.nextInt();
                    System.out.println("Rental office with id " + id +
                            " has been updated with address " + address +
                            " and delivery fee " + feeForDelivery);
                    rentalOfficeController.update(id, address, feeForDelivery);
                } else if (choice == 4) {
                    scanner.nextLine();
                    System.out.println("Enter an Id: ");
                    Long id = scanner.nextLong();
                    System.out.println(rentalOfficeController.findById(id).getCars());
                } else if (choice == 5) {
                    for (Object rentalOffice : rentalOfficeController.findAll()) {
                        System.out.println(rentalOffice);

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

    public void addInitialRentalOffices(){
        rentalOfficeController.add("Cambados", 60);
        rentalOfficeController.add("Vigo", 100);
        rentalOfficeController.add("Teis", 130);

    }
}
