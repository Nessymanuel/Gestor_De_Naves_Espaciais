/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcoesAuxiliares;

import entidades.Transporte;

/**
 *
 * @author Eugenio Domingos
 */
public class Main {
    
     public static void printTransp(Transporte transporte) {
        System.out.println("Identificador: " + transporte.getId());
        System.out.println("Estado: " + transporte.getEstado());
        System.out.println("Origem: " + transporte.getOrigem());
        System.out.println("Destino: " + transporte.getDestino());
        System.out.printf("Distância:  " + "%.1f" + " ano-luz/hora \n", transporte.calculaDistancia());
        System.out.printf("Custo: " + "%.1f" + " Z$ \n", transporte.calculaCusto());
    }
     
      public static void printTranspF(Transporte transporte) {
        System.out.println("Identificador: " + transporte.getId());
        System.out.println("Estado: " + transporte.getEstado());
        System.out.println("Origem: " + transporte.getOrigem());
        System.out.println("Destino: " + transporte.getDestino());
        System.out.printf("Distância:  " + "%.1f" + " ano-luz/hora \n", transporte.calculaDistancia());
        System.out.printf("Custo: " + "%.1f" + " Z$ \n", transporte.calculaCusto());
    }
     
    
}
