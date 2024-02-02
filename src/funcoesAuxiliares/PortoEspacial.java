/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcoesAuxiliares;

import static entidades.IListas.portosEspaciais;

/**
 *
 * @author Eugenio Domingos
 */
public class PortoEspacial {

// Método estático para obter um PortoEspacial por ID
    public static entidades.PortoEspacial obterPorto(int id) {
        for (entidades.PortoEspacial porto : portosEspaciais) {
            if (porto.getId() == id) {
                return porto;
            }
        }
        System.out.println("Porto espacial não encontrado.");
        return null;
    }
}
