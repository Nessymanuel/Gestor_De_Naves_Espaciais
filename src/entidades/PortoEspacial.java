/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Eugenio Domingos
 */
public class PortoEspacial implements IListas {

    // Atributos da classe
    int id;
    String nome;
    private double x;
    private double y;
    private double z;

    // Construtor padrão que inicializa valores padrão
    public PortoEspacial() {
        this.id = 1;
        this.nome = "Terra";
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    // Construtor que permite a inicialização personalizada 
    public PortoEspacial(int id, String nome, double x, double y, double z) {
        this.id = id;
        this.nome = nome;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Getters e setters para os atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    // Método estático para obter um PortoEspacial por ID
    public static PortoEspacial obterPorto(int id) {
        for (PortoEspacial porto : portosEspaciais) {
            if (porto.getId() == id) {
                return porto;
            } else {
                // Mensagem de aviso caso o porto não seja encontrado
                System.out.println("Porto espacial não encontrado. Foi adicionado o porto espacial padrão.");
                break; // Encerra o loop após a primeira iteração
            }
        }
        // Retorna um novo PortoEspacial padrão se nenhum for encontrado
        PortoEspacial portoPadrao = new PortoEspacial();
        return portoPadrao;
    }

    // Sobrescreve o método toString para fornecer uma representação textual da instância
    @Override
    public String toString() {
        return "PortoEspacial{" + "id=" + id + ", nome=" + nome + ", x=" + x + ", y=" + y + ", z=" + z + '}';
    }

}


