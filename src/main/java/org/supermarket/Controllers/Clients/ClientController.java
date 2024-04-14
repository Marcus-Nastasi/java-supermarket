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

    public Client run() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Já é cliente? (s/n) ");
        String yOrN = sc.next();

        if(yOrN.equals("s")) this.isClient();
        if(yOrN.equals("n")) this.isntClient();

        sc.close();

        if(this.client != null) return this.client;

        return null;
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

        sc.close();
    }

    private void isntClient() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nDigite os dados:");
        System.out.print("CPF: ");
        String cpf = sc.next();
        System.out.print("Nome: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("E-mail: ");
        String email = sc.next();
        System.out.print("Senha: ");
        String pass = sc.next();

        this.clients.add(new Client(cpf, name, email, pass));

        System.out.println("\n--------- faça o login abaixo ---------");

        this.isClient();

        sc.close();
    }
}


//String password = "1234";
//String bcryptHashString = BCrypt.withDefaults().hashToString(10, password.toCharArray());

//System.out.println(bcryptHashString);

//BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
//System.out.println(result.verified);

