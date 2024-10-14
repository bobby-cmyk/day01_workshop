package shoppingcart;

import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;


public class ShoppingCartDB {
    private String dbFolder;
    private String currentUser;
    
    public ShoppingCartDB (String dbFolder) {
        this.dbFolder = dbFolder;
    }

    public ArrayList<String> login(String name, String dbFolder) throws FileNotFoundException, IOException {
        
        ArrayList<String> shoppingCart = new ArrayList<>();
        
        File dbFile = new File(dbFolder + "/" + name + ".db");

        if (!dbFile.exists()) {
            dbFile.createNewFile();
        }

        BufferedReader br = new BufferedReader(new FileReader(dbFile));
        while(true) {
            String item = br.readLine();
            if (item == null) {
                break;
            }
            shoppingCart.add(item);
        }

        br.close();

        this.currentUser = name;

        return shoppingCart;
    }

    public void save(ArrayList<String> shoppingCart) throws IOException {
        if (this.currentUser.isBlank()) {
            System.out.println(">>> To save shopping cart, please login first!");
        }

        else {
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.dbFolder + "/" + this.currentUser + ".db"));
            for (String item : shoppingCart) {
                bw.write(item);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            System.out.println(">>> Your cart has been saved");
        }
    }

    public void users() {
        File dbFolder = new File(this.dbFolder);
        File[] files = dbFolder.listFiles();
        System.out.println("The following users are registered");
        int userCounter = 1;
        for (File file : files) {
            String user = file.toString().replaceAll("db/|.db", "");
            System.out.printf("%s. %s\n", userCounter, user);
            userCounter++;
        }
    }




}
