/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheiros;

import static entidades.IListas.filaTransportes;
import static entidades.IListas.filaTransportesP;
import static entidades.IListas.navesEspaciais;
import static entidades.IListas.portosEspaciais;
import entidades.NaveEspacial;
import entidades.PortoEspacial;
import entidades.Transporte;
import enums.EstadoTransporte;
import static funcoesAuxiliares.Apresentar.printTransF;
import static funcoesAuxiliares.NomeValido.nomeValido;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Funcoesmain;

/**
 *
 * @author Eugenio Domingos
 */
public class GuardarDados {

    public static void escreverDadosTransporte() {

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite o nome do ficheiro que pretende guardar a lista de transportes");
            File arquivo = nomeValido(scanner);

            arquivo.createNewFile();
            FileWriter escrever = new FileWriter(arquivo);

            escrever.write("Historico de transportes:");

            for (Transporte transporte : filaTransportes) {
                printTransF(transporte);

                // Verificar se uma nave espacial foi designada
                NaveEspacial naveDesignada = transporte.getNaveDesignada();
                if (naveDesignada != null) {
                    escrever.write("Nave Espacial Designada: " + naveDesignada.getIdnome());
                } else {
                    escrever.write("Nenhuma Nave Espacial designada");
                }
                escrever.write("\n\n");
            }
            escrever.close();
        } catch (IOException e) {
            Logger.getLogger(Funcoesmain.class.getName()).log(Level.SEVERE, null, e);

            System.out.println("Erro ao calcular distância ou custo: " + e.getMessage());
        }
    }

    //consultar transportes pendentes
    public static void escreverDadosTransportesP() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o nome do ficheiro que pretende guardar a lista de transportes");

            File arquivo = nomeValido(scanner);

            arquivo.createNewFile();
            FileWriter escrever = new FileWriter(arquivo);

            escrever.write("Historico de transportes pendentes");

            for (Transporte transporte : filaTransportes) {
                if (transporte.getEstado() == EstadoTransporte.Pendente) {
                    filaTransportesP.add(transporte);
                    escrever.write("\n");
                    printTransF(transporte);

                    // Verificar se uma nave espacial foi designada
                    NaveEspacial naveDesignada = transporte.getNaveDesignada();
                    if (naveDesignada != null) {
                        escrever.write("Nave Espacial Designada: " + naveDesignada.getIdnome());
                    } else {
                        escrever.write("Nenhuma Nave Espacial designada");
                    }
                    escrever.write("\n\n");
                }
                escrever.close();
            }
        } catch (IOException e) {
            Logger.getLogger(Funcoesmain.class.getName()).log(Level.SEVERE, null, e);

            System.out.println(e.getMessage());
        }

    }

    public static void escreverPorto() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o nome do ficheiro que pretende guardar a lista de portos");

            File arquivo = nomeValido(scanner);

            arquivo.createNewFile();
            FileWriter escrever = new FileWriter(arquivo);
            escrever.write("Portos espaciais disponiveis");
            for (PortoEspacial portoEspacial : portosEspaciais) {
                escrever.write(portoEspacial.toString());
            }
            escrever.close();
        } catch (IOException e) {
            Logger.getLogger(Funcoesmain.class.getName()).log(Level.SEVERE, null, e);

            System.out.println("Erro ao calcular distância ou custo: " + e.getMessage());
        }
    }

    public static void escreverNave() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o nome do ficheiro que pretende guardar a lista de naves");

            File arquivo = nomeValido(scanner);

            arquivo.createNewFile();
            FileWriter escrever = new FileWriter(arquivo);
            escrever.write("Naves espaciais disponiveis");
            for (NaveEspacial naveEspacial : navesEspaciais) {
                escrever.write(naveEspacial.toString());
            }
            escrever.close();
        } catch (IOException e) {
            Logger.getLogger(Funcoesmain.class.getName()).log(Level.SEVERE, null, e);

            System.out.println("Erro ao calcular distância ou custo: " + e.getMessage());
        }
    }

}
