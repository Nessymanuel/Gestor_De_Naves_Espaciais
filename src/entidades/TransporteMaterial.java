/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;


/**
 *
 * @author Eugenio Domingos
 */
public class TransporteMaterial extends Transporte {

    // Atributos específicos para TransporteMaterial
    private String descricao;
    private int carga;

    // Construtor que inicializa atributos específicos e chama o construtor da superclasse
    public TransporteMaterial(String descricao, int carga, int id, PortoEspacial origem, PortoEspacial destino) {
        super(id, origem, destino);
        this.descricao = descricao;
        this.carga = carga;
    }

    // Getters e setters para os atributos específicos de TransporteMaterial
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    // Sobrescreve o método calculaCusto para fornecer uma lógica específica para TransporteMaterial
    @Override
    public double calculaCusto() {
        double distancia;
        
        // Calcula a distância entre origem e destino usando o método da superclasse
        distancia = this.calculaDistancia();
        
        // Lógica para calcular o custo baseado na distância e na carga
        if (distancia < 0.5) {
            return distancia * 1000000 * this.carga * 500;
        } else {
            return distancia * 100 * this.carga * 500;
        }
    }

    @Override
    public String toString() {
        return "TransporteMaterial{" + "id=" + id + ", origem=" + origem.toString() + ", destino=" + destino + ", estado=" + estado + "descricao=" + descricao + ", carga=" + carga + '}'+'\n';
    }
    
    

    // Sobrescreve o método calculaDistancia para fornecer uma lógica específica para TransporteMaterial
    @Override
    public double calculaDistancia() {
        double distancia = Math.sqrt(Math.pow(destino.getX() - origem.getX(), 2)
                + Math.pow(destino.getY() - origem.getY(), 2)
                + Math.pow(destino.getZ() - origem.getZ(), 2));
        return distancia;
    }

}
