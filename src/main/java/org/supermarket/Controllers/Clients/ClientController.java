package org.supermarket.Controllers.Clients;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.supermarket.Entities.Clients.Client;
import org.supermarket.Exceptions.ClientException;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientController {

    private ArrayList<Client> clients = new ArrayList<>();
    private Client client;

    public ClientController() {
        this.init();
    }

    public ClientController(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    private void setClient(Client client) {
        this.client = client;
    }

    private void init() {
        Client client1 = new Client(
            "43743508885", "Marcus Rolemberg", "vinnie.nsts@gmail.com", "12345"
        );
        this.clients.add(client1);
    }

    private Client getSingleClient(String cpf) throws ClientException {
        if(this.clients.isEmpty()) throw new ClientException("Clients: client list empty on controller.");
        for(Client c: this.clients) if(c.getCpf().equals(cpf)) return c;
        return null;
    }

    public Client run() throws ClientException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Já é cliente? (s/n) ");
        String yOrN = sc.next();

        if(yOrN.equals("s")) this.isClient();
        if(yOrN.equals("n")) this.isntClient();

        if(this.client == null) throw new ClientException("Client: client equals null on controller.");

        return this.client;
    }

    private void isClient() throws ClientException {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nCPF: ");
        String cpf = sc.next();

        if(this.getSingleClient(cpf) == null) throw new ClientException("\nClient: cpf not found");

        System.out.print("Senha: ");
        String password = sc.next();

        BCrypt.Result res = BCrypt.verifyer().verify(password.toCharArray(), getSingleClient(cpf).getPassword());

        if(res.verified) {
            this.setClient(this.getSingleClient(cpf));
            System.out.println("\nBem vindo ao supermarket, " + this.client.getName() + "!");
        } else throw new ClientException("\nClient: wrong password.");
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

        String bcryptHashString = BCrypt.withDefaults().hashToString(5, pass.toCharArray());

        this.clients.add(new Client(cpf, name, email, bcryptHashString));

        System.out.println("\n--------- Faça o login abaixo ---------");

        this.isClient();
    }
}


//String password = "1234";
//String bcryptHashString = BCrypt.withDefaults().hashToString(10, password.toCharArray());

//System.out.println(bcryptHashString);

//BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
//System.out.println(result.verified);

