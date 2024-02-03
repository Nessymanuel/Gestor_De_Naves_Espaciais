/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcoesAuxiliares;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Eugenio Domingos
 */
public class NomeValido {

    public static File nomeValido(Scanner scanner) throws IOException {

        String nome = scanner.nextLine();
        File arquivo;
        if (nome.endsWith(".txt")) {
            arquivo = new File(nome);
            arquivo.createNewFile();
        } else {
            arquivo = new File(nome + ".txt");
            arquivo.createNewFile();
        }
        return arquivo;
    }
}
