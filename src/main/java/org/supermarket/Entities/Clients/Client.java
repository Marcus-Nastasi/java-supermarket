package org.supermarket.Entities.Clients;

import org.supermarket.Exceptions.ClientException;

public class Client {

    private final String cpf;
    private String name;
    private String email;
    private String password;

    public Client(String cpf, String name, String email, String password) throws ClientException {
        if(cpf==null|name==null|email==null|password==null) throw new ClientException("Client: missing information.");
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return(
            "Name: " + this.name + "\n"
            + "E-mail: " + this.email + "\n"
            + "CPF: " + this.cpf + "\n"
        );
    }
}

