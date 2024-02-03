/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcoesAuxiliares;

import entidades.Transporte;
import static funcoesAuxiliares.NomeValido.nomeValido;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Eugenio Domingos
 */
public class Apresentar {

    public static void printTransF(Transporte transporte) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileWriter escrever;
        File arquivo = nomeValido(scanner);
        escrever = new FileWriter(arquivo);

        escrever.write("\nIdentificador: " + transporte.getId());
        escrever.write("Estado: " + transporte.getEstado());
        escrever.write("Origem: " + transporte.getOrigem());
        escrever.write("Destino: " + transporte.getDestino());
        escrever.write("Distância:  " + transporte.calculaDistancia() + " ano-luz/hora");
        escrever.write("Custo: " +  transporte.calculaCusto() + " Z$");
         
    }

    public static void printTransp(Transporte transporte) {
        System.out.println("\nIdentificador: " + transporte.getId());
        System.out.println("Estado: " + transporte.getEstado());
        System.out.println("Origem: " + transporte.getOrigem());
        System.out.println("Destino: " + transporte.getDestino());
        System.out.printf("Distância:  " + "%.1f" + " ano-luz/hora", transporte.calculaDistancia());
        System.out.printf("Custo: " + "%.1f" + " Z$", transporte.calculaCusto());
    }

}
