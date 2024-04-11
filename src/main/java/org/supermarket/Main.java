package org.supermarket;

import org.supermarket.Entities.UIs.UI;

public class Main {
    public static void main(String[] args) {
        UI ui = new UI();
        ui.runUI();
    }
}

//String password = "1234";
//String bcryptHashString = BCrypt.withDefaults().hashToString(10, password.toCharArray());

//System.out.println(bcryptHashString);

//BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
//System.out.println(result.verified);

