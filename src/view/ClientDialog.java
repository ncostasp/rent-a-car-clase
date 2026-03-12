package view;

import controller.ClientController;
import model.Client;


import java.util.InputMismatchException;
import java.util.Scanner;

public class ClientDialog {

    private ClientController clientController;
    private Scanner scanner;

    public ClientDialog(){
        clientController = new ClientController();
    };

    public void getStarted(){
        do {
            System.out.println("\n************************** Client Manager ********************************");
            System.out.println("\n\t1. Create Client.\t\t\t\t4. Search Client.");
            System.out.println("\n\t2. Remove Client.\t\t\t\t5. See All Clients.");
            System.out.println("\n\t3. Update Client.\t\t\t\t0. Back.");
            System.out.println("\n**************************************************************************");
            scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            try {
                if(choice == 1){
                    scanner.nextLine();
                    System.out.println("Enter a Dni: ");
                    String dni = scanner.nextLine();
                    System.out.println("Enter a Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter a Surname: ");
                    String surname = scanner.nextLine();
                    System.out.println("New client created with DNI " + dni +
                            ", name " + name +
                            ", surname " + surname) ;
                    clientController.add(dni, name, surname);
                } else if (choice == 2) {
                    System.out.println("Client ID: ");
                    Long id = scanner.nextLong();
                    clientController.deleteById(id);
                } else if (choice == 3) {
                    System.out.println(clientController.findAll());
                    System.out.println("Client ID to modify: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Enter new Dni: ");
                    String dni = scanner.nextLine();
                    System.out.println("Enter new Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter new Surname: ");
                    String surname = scanner.nextLine();
                    System.out.println("Client with id " + id +
                            " has been updated with DNI " + dni +
                            ", name " + name +
                            ", surname " + surname);
                    clientController.update(id, dni, name, surname);
                } else if (choice == 4) {
                    scanner.nextLine();
                    System.out.println("Dni: ");
                    String dni = scanner.nextLine();
                    System.out.println(clientController.findByDni(dni));
                } else if (choice == 5) {
                    for (Object client : clientController.findAll()) {
                        System.out.println(client);

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

    public void addInitialClients(){
        clientController.add("87896685P", "Sergio", "Rodríguez");
        clientController.add("99687554K", "Aurelio", "Fernández");
        clientController.add("12345678A", "María", "González");
        clientController.add("56789012B", "Lucía", "López");
        clientController.add("34567890C", "Carlos", "Martínez");
        clientController.add("78901234D", "Ana", "Sánchez");
    }
}
