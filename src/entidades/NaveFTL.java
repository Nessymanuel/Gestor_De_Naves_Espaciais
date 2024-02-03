/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enums.TipoNave;

/**
 *
 * @author Eugenio Domingos
 */
public class NaveFTL extends NaveEspacial {

    // Atributos adicionais específicos para NaveFTL
    private double velocidadeM;
    private int limiteTransporte;

    // Construtor que inicializa atributos específicos e chama o construtor da superclasse
    public NaveFTL(int limiteTransporte, String idnome, TipoNave tipo, PortoEspacial portoAtual, double velocidadeM) {
        super(idnome, tipo, portoAtual);
        this.velocidadeM = velocidadeM;
        this.limiteTransporte = limiteTransporte;
    }

    // Getters e setters para os atributos específicos de NaveFTL
    public int getLimiteTransporte() {
        return limiteTransporte;
    }

    public void setLimiteTransporte(int limiteTransporte) {
        this.limiteTransporte = limiteTransporte;
    }

    public double getVelocidadeM() {
        return velocidadeM;
    }

    public void setVelocidadeM(double velocidadeM) {
        this.velocidadeM = velocidadeM;
    }

    // Sobrescreve o método toString para fornecer uma representação textual específica de NaveFTL
    @Override
    public String toString() {
        return  "NaveFTL: " +"nome=" + idnome + ", tipo=" + tipo + ", transporte=" + (transporte != null ? transporte.toString() : " Nenhum transporte atribuído") + ",  velocidadeM=" + velocidadeM + ", limiteTransporte=" + limiteTransporte +"\n";
    }
    

}
