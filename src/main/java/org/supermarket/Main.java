package org.supermarket;

import org.supermarket.Controllers.Clients.ClientController;
import org.supermarket.Entities.Clients.Client;
import org.supermarket.Entities.UIs.UI;
import org.supermarket.Exceptions.ClientException;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //try {
           // UI ui = new UI();
          //  ui.run();
        //} catch(Exception e)  {
          //  System.err.println("\n" + e.getMessage());
        //}

        try {
            Client client = new Client("12345", "marcus", "vini", "12345");
            Client client1 = new Client("6789", "xarmander", "lucas", "12345");

            ArrayList<Client> clients = new ArrayList<>();
            clients.add(client);
            clients.add(client1);

            ClientController clientController = new ClientController(clients);
            clientController.run();
        } catch (ClientException e) {
            System.err.println(e.getMessage());
        }
    }
}


