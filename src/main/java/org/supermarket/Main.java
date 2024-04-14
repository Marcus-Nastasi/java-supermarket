package org.supermarket;

import org.supermarket.Entities.UIs.UI;

public class Main {
    public static void main(String[] args) {
        try {
            UI ui = new UI();
            ui.run();
        } catch(Exception e)  {
            System.err.println(e.getMessage());
        }
    }
}


