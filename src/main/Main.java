/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import static main.Menu.menu;

/**
 *
 * @author Eugenio Domingos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            menu();
        } catch (Exception e) {
            System.out.println(e.getMessage()
            );
        }

    }
}
