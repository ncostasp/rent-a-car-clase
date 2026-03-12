package view;

import controller.ClientController;
import model.Client;
import repository.ModelRepository;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dialog {


    private Scanner scanner;
    private ClientDialog clientDialog;
    private ModelDialog modelDialog;
    private RentalOfficeDialog rentalOfficeDialog;
    private RentalDialog rentalDialog;
    private CarDialog carDialog;

    public Dialog() {
        clientDialog = new ClientDialog();
        modelDialog = new ModelDialog();
        rentalOfficeDialog = new RentalOfficeDialog();
        carDialog = new CarDialog();
        clientDialog.addInitialClients();
        modelDialog.addInitialModels();
        rentalOfficeDialog.addInitialRentalOffices();
        carDialog.addInitialCars();
        rentalDialog = new RentalDialog();
        rentalDialog.addInitialRentals();

    }


    public void getStarted(){
        do {
            System.out.println("\n********************** Welcome to Rent A Car *****************************");
            System.out.println("\n\t1. Manage Clients.\t\t\t\t\t4. Manage Models.");
            System.out.println("\n\t2. Manage Cars.\t\t\t\t\t\t5. Manage Rents.");
            System.out.println("\n\t3. Manage Offices.\t\t\t\t\t0. Exit.");
            System.out.println("\n**************************************************************************");
            scanner = new Scanner(System.in);

            try {
                int choice = scanner.nextInt();
                if (choice == 1) {
                    clientManager();
                } else if (choice == 2) {
                    CarManager();
                } else if (choice == 3) {
                    rentalOfficeManager();
                } else if (choice == 4) {
                    modelManager();
                } else if (choice == 5) {
                    rentalManager();
                }else if(choice==0) {
                    System.out.println("Bye!!");
                    System.exit(0);;
                } else {
                    System.err.println("[ERROR] Your option is incorrect!! Try again!!");
                }

            } catch (
            InputMismatchException e) {
                System.err.println("[ERROR] You must type a number!!!");
                scanner.next();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }

    public void clientManager(){
        clientDialog.getStarted();
    }

    public void modelManager(){
        modelDialog.getStarted();
    }

    public void rentalOfficeManager(){

        rentalOfficeDialog.getStarted();
    }

    public void CarManager(){
        carDialog.getStarted();
    }

    public void rentalManager(){
        rentalDialog.getStarted();
    }



}
