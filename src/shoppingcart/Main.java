package shoppingcart;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main{

    public static void main(String[] args) throws FileNotFoundException, IOException{


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

        ShoppingCartDB shoppingCartDB = new ShoppingCartDB(dbFolder);
        
        // Initialise console
        Console cons = System.console();

        // Intiialise a shopping cart
        ShoppingCart shoppingCart = new ShoppingCart();

        // Print welcome message
        System.out.println("Welcome to your shopping cart");

        while (true) {
            System.out.print("Command: ");
            String input = cons.readLine().trim().toLowerCase();

            // Get the first part as the command
            String[] parts = input.split(" ");

            String command = parts[0];

            if (command.equals("exit")) {
                System.out.println(">>> Exited shopping cart");
                break;
            }

            else if (command.equals("login")) {
                shoppingCart.setItems(shoppingCartDB.login(parts[1], dbFolder));
                shoppingCart.list();
            }

            else if (command.equals("list")) {
                shoppingCart.list();
            }

            else if (command.equals("add")) {
                shoppingCart.add(parts);
            }

            else if (command.equals("delete")) {
                int itemNumber = Integer.parseInt(parts[1].trim());
                shoppingCart.delete(itemNumber);
            }

            else if (command.equals("save")) {
                shoppingCartDB.save(shoppingCart.getItems());
            }

            else if (command.equals("users")) {
                shoppingCartDB.users();
            }
            
            else {
                System.out.println(">>> Command does not exist");
            }

        }
    }
}