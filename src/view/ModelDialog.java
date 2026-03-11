package view;

import controller.ModelController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ModelDialog {

    private ModelController modelController;
    private Scanner scanner;

    public ModelDialog(){
        modelController = new ModelController();
    };

    public void getStarted(){
        do {
            System.out.println("\n************************** Model Manager ********************************");
            System.out.println("\n\t1. Create Model.\t\t\t\t4. Cars in Model.");
            System.out.println("\n\t2. Remove Model.\t\t\t\t5. See All Models.");
            System.out.println("\n\t3. Update Model.\t\t\t\t0. Back.");
            System.out.println("\n**************************************************************************");
            scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            try {
                if(choice == 1){
                    scanner.nextLine();
                    System.out.println("Name: ");
                    String name = scanner.nextLine();
                    System.out.println("PricePerDay: ");
                    int pricePerDay = scanner.nextInt();
                    modelController.add(name, pricePerDay);
                } else if (choice == 2) {
                    System.out.println("Model ID: ");
                    int id = scanner.nextInt();
                    modelController.deleteById((long) id);
                } else if (choice == 3) {
                    System.out.println(modelController.findAll());
                    System.out.println("Model ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Name: ");
                    String name = scanner.nextLine();
                    System.out.println("PricePerDay: ");
                    int pricePerDay = scanner.nextInt();
                    modelController.update((long) id, name, pricePerDay);
                } else if (choice == 4) {
                    scanner.nextLine();
                    System.out.println("Id: ");
                    Long id = scanner.nextLong();
                    System.out.println(modelController.findById(id).getCars());
                } else if (choice == 5) {
                    for (Object model : modelController.findAll()) {
                        System.out.println(model);

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

    public void addInitialModels(){
        modelController.add("Fiesta", 60);
        modelController.add("Tesliña", 100);
        modelController.add("Golf GTI", 130);

    }
}
