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
public class NaveEspacial implements IListas {

    // Atributos da classe
    protected String idnome;
    protected TipoNave tipo;
    protected PortoEspacial portoAtual;
    protected Transporte transporte;

    // Construtor da classe
    public NaveEspacial(String idnome, TipoNave tipo, PortoEspacial portoAtual) {
        this.idnome = idnome;
        this.tipo = tipo;
        this.portoAtual = portoAtual;
    }

    // Getters e setters para os atributos
    public String getIdnome() {
        return idnome;
    }

    public void setIdnome(String idnome) {
        this.idnome = idnome;
    }

    public PortoEspacial getPortoAtual() {
        return portoAtual;
    }

    public void setPortoAtual(PortoEspacial portoAtual) {
        this.portoAtual = portoAtual;
    }

    public TipoNave getTipo() {
        return tipo;
    }

    public void setTipo(TipoNave tipo) {
        this.tipo = tipo;
    }

    public  Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public void atribuirTransporte(Transporte transporte) {
        this.transporte = transporte;
    }
    
    public boolean temTransporte( Transporte transporte ){
        if(transporte != null){
            return false;
        } else {
            return true;
        }
    }
    
    
         // Sobrescreve o método equals para verificar se dois portos são iguais
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NaveEspacial) {
            NaveEspacial naveEspacial = (NaveEspacial) obj;
            // Compara os atributos para determinar se os transportes são iguais
            if (this.idnome.equals(naveEspacial.idnome)  ) {
                System.out.println("A nave espacial não pode ter o mesmo id nome, crie outro");
                return true;
            } 
        } 
            return false;
        
    }

    // Método toString para representação textual da instância
    @Override
    public String toString() {
        return "NaveEspacial{" + "nome='" + idnome + '\'' + ", tipo=" + tipo + ", transporte=" + (transporte != null ? transporte.toString() : "Nenhum transporte atribuído") + '}'+'\n';
    }

}

