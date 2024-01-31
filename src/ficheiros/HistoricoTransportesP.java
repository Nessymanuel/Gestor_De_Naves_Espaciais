/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheiros;

import static entidades.IListas.filaTransportesP;
import entidades.Transporte;
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
public class HistoricoTransportesP {
     /*  File arquivo = new File("arquivo.txt");
        try {
           try {
               arquivo.createNewFile();
           } catch (IOException ex) {
               Logger.getLogger(HistoricoTransportesP.class.getName()).log(Level.SEVERE, null, ex);
           }
            FileWriter escrever = null;
        try {
            escrever = new FileWriter(arquivo);
        } catch (IOException ex) {
            Logger.getLogger(HistoricoTransportesP.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
                

                escrever.write("Fila de Transportes Pendentes:\n");
                
            if (filaTransportesP.isEmpty()) {
                System.out.println("A fila de transportes está vazia. Nenhum conteúdo será escrito no arquivo.");
                return;
            }
            
                for (Transporte transporte : filaTransportesP) {
                    escrever.write("Identificador: " + transporte.getId() + "\n");
                    escrever.write("Estado: " + transporte.getEstado() + "\n");
                    escrever.write("Origem: " + transporte.getOrigem() + "\n");
                    escrever.write("Destino: " + transporte.getDestino() + "\n");
                    escrever.write(String.format("Distância: %.1f ano-luz/hora \n", transporte.calculaDistancia()));
                    escrever.write(String.format("Custo: %.1f Z$ \n", transporte.calculaCusto()));
                    escrever.write("\n");
                }

                escrever.write(" teste\n\n"); 

                 escrever.flush();
            } catch (IOException e) {
                System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
            }

            System.out.println("Conteúdo foi escrito no arquivo com sucesso.");

            //Apagar ficheiro
            // arquivo.delete();
        } catch (IOException e) {
            Logger.getLogger(Funcoesmain.class.getName()).log(Level.SEVERE, null, e);

        }*/
    
}
