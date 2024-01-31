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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Funcoesmain;

/**
 *
 * @author Eugenio Domingos
 */
public class CarregarDados {

    public static void carregarDadosTransporte() {

        try {

            File arquivo = new File("Arquivo_Transportes.txt");

            arquivo.createNewFile();
            FileWriter escrever = new FileWriter(arquivo);

            escrever.write("Historico de transportes:");

            for (Transporte transporte : filaTransportes) {
                escrever.write("\n");
                escrever.write("Identificador: " + transporte.getId() + "\n");
                escrever.write("Estado: " + transporte.getEstado() + "\n");
                escrever.write("Origem: " + transporte.getOrigem() + "\n");
                escrever.write("Destino: " + transporte.getDestino() + "\n");
                escrever.write("Distância:  " + transporte.calculaDistancia() + " ano-luz/hora \n");
                escrever.write("Custo:  " + transporte.calculaCusto() + " Z$ \n");

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
    public static void carregarDadosTransportesP() {
        try {

            File arquivo = new File("Arquivo_Transportes_P.txt");

            arquivo.createNewFile();
            FileWriter escrever = new FileWriter(arquivo);

            escrever.write("Historico de transportes pendentes");

            for (Transporte transporte : filaTransportes) {
                if (transporte.getEstado() == EstadoTransporte.Pendente) {
                    filaTransportesP.add(transporte);
                    escrever.write("\n");
                    escrever.write("Identificador: " + transporte.getId() + "\n");
                    escrever.write("Estado: " + transporte.getEstado() + "\n");
                    escrever.write("Origem: " + transporte.getOrigem() + "\n");
                    escrever.write("Destino: " + transporte.getDestino() + "\n");
                    escrever.write("Distância:  " + transporte.calculaDistancia() + " ano-luz/hora \n");
                    escrever.write("Custo:  " + transporte.calculaCusto() + " Z$ \n");

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

            System.out.println("Erro ao calcular distância ou custo: " + e.getMessage());
        }

    }

    public static void carregarPorto() {
        try {

            File arquivo = new File("Arquivo_Porto.txt");

            arquivo.createNewFile();
            FileWriter escrever = new FileWriter(arquivo);
            escrever.write("Portos espaciais disponiveis");
            for (PortoEspacial portoEspacial : portosEspaciais) {
                escrever.write(portoEspacial.toString());
            }
        } catch (IOException e) {
            Logger.getLogger(Funcoesmain.class.getName()).log(Level.SEVERE, null, e);

            System.out.println("Erro ao calcular distância ou custo: " + e.getMessage());
        }
    }

    public static void carregarNave() {
        try {

            File arquivo = new File("Arquivo_Nave.txt");

            arquivo.createNewFile();
            FileWriter escrever = new FileWriter(arquivo);
            escrever.write("Naves espaciais disponiveis");
            for (NaveEspacial naveEspacial : navesEspaciais) {
                escrever.write(naveEspacial.toString());
            }
        } catch (IOException e) {
            Logger.getLogger(Funcoesmain.class.getName()).log(Level.SEVERE, null, e);

            System.out.println("Erro ao calcular distância ou custo: " + e.getMessage());
        }
    }

}
