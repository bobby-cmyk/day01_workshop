package shoppingcart;

import java.io.Console;
import java.io.File;

public class Main{

    public static void main(String[] args) {


        String dbFolder = "";

        if (args.length == 0) {
            dbFolder = "db";
        }

        else if (args[0].equals("cartdb")) {
            dbFolder = "cartdb";
        }

        else {
            dbFolder = args[0];
            File dir = new File(dbFolder);
            if (!dir.exists()) {
                dir.mkdir();
            }
        }

        System.out.printf(">>> Database is set to '%s'\n", dbFolder);
        

        // Initialise console
        Console cons = System.console();

        // Intiialise a shopping cart
        ShoppingCart shoppingCart = new ShoppingCart();

        // Print welcome message
        System.out.println("Welcome to your shopping cart");

        while (true) {
            System.out.print("Command: ");
            String command = cons.readLine().trim().toLowerCase();

            if (command.equals("exit")) {
                System.out.println(">>> Exited shopping cart");
                break;
            }

            else if (command.equals("list")) {
                shoppingCart.list();
            }

            else if (command.equals("add")) {
                System.out.print("Item(s) to add: ");
                String toAdd = cons.readLine();
                shoppingCart.add(toAdd);
            }

            else if (command.equals("delete")) {
                System.out.print("Delete Item Number: ");
                int itemNumber = Integer.parseInt(cons.readLine());
                shoppingCart.delete(itemNumber);
            }
            
            else {
                System.out.println(">>> Command does not exist");
            }

        }
    }
}