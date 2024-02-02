/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.InputMismatchException;
import java.util.Scanner;
import static main.Funcoesmain.*;

/**
 *
 * @author Eugenio Domingos
 */
public class Menu {

    public static void menu() {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao = 0;
            do {
                exibirMenu();

                try {
                    opcao = scanner.nextInt();
                    scanner.nextLine();  // Consumir a quebra de linha após o número
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, insira um número inteiro válido.");
                    scanner.nextLine();  // Consumir a entrada inválida
                    continue;  // Reiniciar o loop
                }

                try {
                    switch (opcao) {
                        case 1:
                            registrarPortoEspacial(scanner);
                            break;
                        case 2:
                            registrarNaveEspacial(scanner);
                            break;
                        case 3:
                            registrarTransporte(scanner);
                            break;
                        case 4:
                            System.out.println("Digite 1 para transportes pendentes \n Digite 2 para Historico de transportes");
                            int transporte = scanner.nextInt();
                            boolean valor;

                            if (transporte == 1) {
                                valor = true;
                            } else if (transporte == 2) {
                                valor = false;
                            } else {
                                System.out.println("Por favor, insira um número inteiro válido.");
                                continue;  // Reiniciar o loop
                            }
                            consultarTransporte(valor);
                            break;
                        case 5:
                            consultarPorto();
                            break;
                        case 6:
                            consultarNave();
                            break;
                        case 7:
                            alterarEstadoTransporte(scanner);
                            break;
                        case 8:
                            carregarDadosIniciais(scanner);
                            break;
                        case 9:
                            designarNave(scanner);
                            break;
                        case 0:
                            sair();
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }

                } catch (Error e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            } while (opcao != 8);
            // Fechar o scanner quando não for mais necessário
        }

    }

}
