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
    private int id;
    private String nome;
    private double x;
    private double y;
    private double z;

    // Construtor padrão que inicializa valores padrão
    public PortoEspacial() {
        this.id = 0;
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

       // Sobrescreve o método equals para verificar se dois portos são iguais
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PortoEspacial) {
            PortoEspacial portoEspacial = (PortoEspacial) obj;
            // Compara os atributos para determinar se os transportes são iguais
            if (this.id == portoEspacial.id && this.nome.equals(portoEspacial.nome) && this.x == portoEspacial.x && this.y == portoEspacial.y && this.z == portoEspacial.z ) {
                System.out.println("O porto espacial ja existe na lista de portos, crie outro");
                return true;
            } else if( this.id == portoEspacial.id){
                System.out.println("Não pode criar um porto espacial com o mesmo id");
                return true;
            }else if( this.x == portoEspacial.x && this.y == portoEspacial.y && this.z == portoEspacial.z){
                System.out.println("Não pode criar um porto espacial com cordenadas iguais");
                return true;
            }
        } 
            return false;
        
    }

    // Sobrescreve o método toString para fornecer uma representação textual da instância
    @Override
    public String toString() {
        return "PortoEspacial{" + "id=" + id + ", nome=" + nome + ", x=" + x + ", y=" + y + ", z=" + z + '}'+'\n';
    }

}
