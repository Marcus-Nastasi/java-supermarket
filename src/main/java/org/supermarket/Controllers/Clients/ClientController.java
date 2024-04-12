package org.supermarket.Controllers.Clients;

import org.supermarket.Entities.Clients.Client;
import org.supermarket.Exceptions.ClientException;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientController {

    private ArrayList<Client> clients = new ArrayList<>();
    private Client client;

    public ClientController() {}

    public ClientController(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    private void setClient(Client client) {
        this.client = client;
    }

    private Client getSingleClient(String cpf) throws ClientException {
        if(this.clients.isEmpty()) throw new ClientException("Clients: client list empty on controller.");
        for(Client c: this.clients) if(c.getCpf().equals(cpf)) return c;
        return null;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Já é cliente? (s/n) ");
        String yOrN = sc.next();

        if(yOrN.equals("s")) this.isClient();
        if(yOrN.equals("n")) this.isntClient();

        sc.close();
    }

    private void isClient() throws ClientException {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nCPF: ");
        String cpf = sc.next();

        if(this.getSingleClient(cpf) == null) throw new ClientException("\nClient: cpf not found");

        System.out.print("Senha: ");
        String password = sc.next();

        if(this.getSingleClient(cpf).getPassword().equals(password)) {
            this.setClient(this.getSingleClient(cpf));
        } else throw new ClientException("\nClient: wrong password.");

        System.out.println("\n"+this.client);

        sc.close();
    }

    private void isntClient() {
        Scanner sc = new Scanner(System.in);

        sc.close();
    }
}


//String password = "1234";
//String bcryptHashString = BCrypt.withDefaults().hashToString(10, password.toCharArray());

//System.out.println(bcryptHashString);

//BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
//System.out.println(result.verified);

