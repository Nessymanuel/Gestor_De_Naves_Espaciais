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

    // Método estático para obter um Transporte por ID
    public static Transporte obterTransporte(int id) {
        for (Transporte transporte : filaTransportesP) {
            if (transporte.getId() == id) {
                return transporte;
            } else {
                // Mensagem de aviso caso o transporte não seja encontrado
                System.out.println("Transporte não encontrado. Registre esse transporte.");
            }
        }
        return null;
    }

    // Funções abstratas, conforme indicado no enunciado
    public abstract double calculaDistancia();

    public abstract double calculaCusto();

    // Sobrescreve o método toString para fornecer uma representação textual da instância
    @Override
    public String toString() {
        return "Transporte{" + "id=" + id + ", origem=" + origem.toString() + ", destino=" + destino + ", estado=" + estado + '}';
    }

    // Sobrescreve o método equals para verificar se dois transportes são iguais
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Transporte) {
            Transporte transporte = (Transporte) obj;
            // Compara os atributos para determinar se os transportes são iguais
            if (this.id == transporte.id && this.destino == transporte.destino && this.origem == transporte.origem) {
                System.out.println("Os transportes são iguais");
                return true;
            } else {
                System.out.println("ERRO!! \n Os transportes não são iguais");
                return false;
            }
        } else {
            System.out.println("Não é uma instância de transporte ");
            return false;
        }
    }

}
