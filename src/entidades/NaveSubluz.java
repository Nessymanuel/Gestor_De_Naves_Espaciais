/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enums.Combustivel;
import enums.TipoNave;

/**
 *
 * @author Eugenio Domingos
 */
public class NaveSubluz extends NaveEspacial {

    // Atributos específicos para NaveSubluz
    private double velocidadeM;
    private Combustivel combustivel;

    // Construtor que inicializa atributos específicos e chama o construtor da superclasse
    public NaveSubluz(Combustivel combustivel, String idnome, TipoNave tipo, PortoEspacial portoAtual, double velocidade) {
        super(idnome, tipo, portoAtual);
        this.combustivel = combustivel;
        if (velocidade > 0.3) {
            System.out.println("A nave Subluz tem velocidade maxima de 3 trek, então foi atribuido velocidade de 3 trek");
            this.velocidadeM = 0.3;
        } else {
            this.velocidadeM = velocidade;
        }
    }

    // Getters e setters para os atributos específicos de NaveSubluz
    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    public double getVelocidadeM() {
        return velocidadeM;
    }

    public void setVelocidadeM(double velocidadeM) {
        this.velocidadeM = velocidadeM;
    }

    // Sobrescreve o método toString para fornecer uma representação textual específica de NaveSubluz
    @Override
    public String toString() {
        return "NaveSubluz: " + "nome=" + idnome + ", tipo=" + tipo + ", transporte=" + (transporte != null ? transporte.toString() : "Nenhum transporte atribuído") + ",  velocidadeM=" + velocidadeM + ", combustivel=" + combustivel +"\n";
    }

}
