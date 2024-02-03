/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Eugenio Domingos
 */
public class TransportePessoa extends Transporte {

    // Atributo específico para TransportePessoa
    private int qntPessoas;

    // Construtor que inicializa atributos específicos e chama o construtor da superclasse
    public TransportePessoa(int qntPessoas, int id, PortoEspacial origem, PortoEspacial destino) {
        super(id, origem, destino);
        this.qntPessoas = qntPessoas;
    }

    // Getters e setters para o atributo específico de TransportePessoa
    public int getQntPessoas() {
        return qntPessoas;
    }

    public void setQntPessoas(int qntPessoas) {
        this.qntPessoas = qntPessoas;
    }

    // Sobrescreve o método calculaCusto para fornecer uma lógica específica para TransportePessoa
    @Override
    public double calculaCusto() {
        double distancia;

        // Calcula a distância entre origem e destino usando o método da superclasse
        distancia = this.calculaDistancia();

        // Lógica para calcular o custo baseado na distância e na quantidade de pessoas
        if (distancia < 0.5) {
            return distancia * 1000000 * this.qntPessoas * 100;
        } else {
            return distancia * 100 * this.qntPessoas * 100;
        }
    }

    @Override
    public String toString() {
        return "TransportePessoa: " + "id=" + id + ", origem=" + origem.toString() + ", destino=" + destino + ", estado=" + estado  + "qntPessoas=" + qntPessoas+"\n";
    }

    // Sobrescreve o método calculaDistancia para fornecer uma lógica específica para TransportePessoa
    @Override
    public double calculaDistancia() {
        double distancia = Math.sqrt(Math.pow(destino.getX() - origem.getX(), 2)
                + Math.pow(destino.getY() - origem.getY(), 2)
                + Math.pow(destino.getZ() - origem.getZ(), 2));
        return distancia;
    }

}
