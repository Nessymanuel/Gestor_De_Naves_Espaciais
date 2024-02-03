/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package entidades;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Eugenio Domingos
 */
public interface IListas {

// Fila de transportes para armazenar instâncias de transporte
public static Queue<Transporte> filaTransportes = new LinkedList<>();

// Fila de transportes para armazenar instâncias de transporte pendentes
public static Queue<Transporte> filaTransportesP = new LinkedList<>();

// Lista de portos espaciais para armazenar instâncias de PortoEspacial
public static List<PortoEspacial> portosEspaciais = new ArrayList<>();

// Lista de naves espaciais para armazenar instâncias de NaveEspacial
public static List<NaveEspacial> navesEspaciais = new ArrayList<>();

// Lista de naves espaciais para armazenar instâncias de NaveEspacial disponiveis
public static List<NaveEspacial> navesEspaciaisD = new ArrayList<>();


  

}
