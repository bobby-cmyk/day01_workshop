package shoppingcart;

import java.io.Console;

public class Main{

    public static void main(String[] args) {
        

        // Initialise console
        Console cons = System.console();

        // Intiialise a shopping cart
        ShoppingCart shoppingCart = new ShoppingCart();

        // Print welcome message
        System.out.println("Welcome to your shopping cart");

        while (true) {

            String command = cons.readLine().trim().toLowerCase();

            if (command.equals("exit")) {
                System.out.println("Exited shopping cart");
                break;
            }

            else if (command.equals("list")) {
                shoppingCart.list();
            }

            else if (command.equals("add")) {
                String toAdd = cons.readLine();
                shoppingCart.add(toAdd);
            }

            else if (command.equals("delete")) {
                int itemNumber = Integer.parseInt(cons.readLine());
                shoppingCart.delete(itemNumber);
            }
            
            else {
                System.out.println("Command does not exist");
            }

        }
    }
}