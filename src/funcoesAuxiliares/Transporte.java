/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcoesAuxiliares;

import static entidades.IListas.filaTransportes;

/**
 *
 * @author Eugenio Domingos
 */
public class Transporte {
    // Método estático para obter um Transporte por ID

    public static entidades.Transporte obterTransporte(int id) {
        for (entidades.Transporte transporte : filaTransportes) {
            if (transporte.getId() == id) {
                return transporte;
            }
        }
        // Mensagem de aviso caso o transporte não seja encontrado
        return null;
    }
}
