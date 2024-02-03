/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enums.EstadoTransporte;

/**
 *
 * @author Eugenio Domingos
 */
public abstract class Transporte implements IListas {

    // Atributos protegidos da classe
    protected int id;
    protected PortoEspacial origem;
    protected PortoEspacial destino;
    protected EstadoTransporte estado;
    protected NaveEspacial naveDesignada;

    // Construtor que inicializa atributos comuns a todos os tipos de transporte
    public Transporte(int id, PortoEspacial origem, PortoEspacial destino) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.estado = EstadoTransporte.Pendente;
    }



    // Getters e setters para os atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PortoEspacial getOrigem() {
        return origem;
    }

    public void setOrigem(PortoEspacial origem) {
        this.origem = origem;
    }

    public PortoEspacial getDestino() {
        return destino;
    }

    public void setDestino(PortoEspacial destino) {
        this.destino = destino;
    }

    public EstadoTransporte getEstado() {
        return estado;
    }

    public NaveEspacial getNaveDesignada() {
        return naveDesignada;
    }

    public void setNaveDesignada(NaveEspacial naveDesignada) {
        this.naveDesignada = naveDesignada;
    }

    public void setEstado(EstadoTransporte estado) {
        this.estado = estado;
    }

    // Funções abstratas, conforme indicado no enunciado
    public abstract double calculaDistancia();

    public abstract double calculaCusto();

    // Sobrescreve o método equals para verificar se dois transportes são iguais
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Transporte) {
            Transporte transporte = (Transporte) obj;
            // Compara os atributos para determinar se os transportes são iguais
            if (this.id == transporte.id) {
                System.out.println("Esse id ja existe na lista de transportes, crie outro ");
                return true;
            }
        }
        return false;
    }

}
