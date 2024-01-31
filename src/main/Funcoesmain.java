/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import entidades.*;
import static entidades.PortoEspacial.obterPorto;
import static entidades.Transporte.obterTransporte;
import enums.Combustivel;
import enums.EstadoTransporte;
import java.util.*;
import enums.TipoNave;
import enums.TipoTransporte;
import static ficheiros.CarregarDados.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eugenio Domingos
 */
public class Funcoesmain implements IListas {

    public static void exibirMenu() {
        System.out.println("----------- Menu -----------");
        System.out.println("1. Registar portos espaciais");
        System.out.println("2. Registar naves espaciais");
        System.out.println("3. Registar transportes");
        System.out.println("4. Consultar todos os transportes");
        System.out.println("5. Consultar todos os portos espaciais disponiveis");
        System.out.println("6. Consultar todos as naves espaciais");
        System.out.println("7. Alterar estado de um transporte");
        System.out.println("8. Carregar dados iniciais");
        System.out.println("9. Designar transportes");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static PortoEspacial registrarPortoEspacial(Scanner scanner) {
        try {
            System.out.println("Digite o id do porto espacial:");
            int id = scanner.nextInt();

            //limpando o buffer
            scanner.nextLine();

            System.out.println("Digite o nome do porto espacial:");
            String nome = scanner.nextLine();

            System.out.println("Digite as coordenadas X, Y, Z do porto espacial \n separadas por espaços:");
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            double z = scanner.nextDouble();

            PortoEspacial novoPorto = new PortoEspacial(id, nome, x, y, z);
            portosEspaciais.add(novoPorto);

            System.out.println("Porto espacial registrado com sucesso.");
            return novoPorto;

        } catch (InputMismatchException e) {
            System.out.println("Erro: Por favor, insira um valor numérico válido.");
            scanner.nextLine();  // Consumir a entrada inválida
            return null;  // Ou lançar exceção ou retornar um valor padrão, dependendo do caso

        } catch (NoSuchElementException e) {
            System.out.println("Erro: Entrada esperada não fornecida.");
            scanner.nextLine();  // Consumir a entrada inválida
            return null;  // Ou lançar exceção ou retornar um valor padrão, dependendo do caso

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;  // Ou lançar exceção ou retornar um valor padrão, dependendo do caso
        }
    }

    public static NaveEspacial registrarNaveEspacial(Scanner scanner) {

        try {
            System.out.println("Digite o nome da nave espacial:");
            String nome = scanner.nextLine();

            consultarNave();
            System.out.println("Insira o id do porto espacial de origem:");
            int id = scanner.nextInt();
            PortoEspacial origem;
            origem = obterPorto(id);

            System.out.println("Escolha o tipo da nave espacial:");
            System.out.println("1- Subluz");
            System.out.println("2- FTL");
            TipoNave tipo = null;

            int op = scanner.nextInt();
            switch (op) {
                case 1:
                    tipo = TipoNave.Subluz;
                    System.out.println("Digite a velocidade da nave espacial em trek");
                    System.out.println("A velocidade maxima da nave Subluz é de 0.3 trek, se colocar uma superior terá a velocidade padrão.");
                    double vs = scanner.nextDouble();

                    NaveEspacial ns = new NaveSubluz(Combustivel.nuclear, nome, tipo, origem, vs);
                    navesEspaciais.add(ns);

                    return ns;

                case 2:
                    tipo = TipoNave.FTL;
                    System.out.println("Digite a quantidade de transporte");
                    int qnt = scanner.nextInt();
                    System.out.println("Digite a velocidade da nave espacial em trek");
                    double vf = scanner.nextDouble();
                    NaveEspacial nf = new NaveFTL(qnt, nome, tipo, origem, vf);
                    navesEspaciais.add(nf);

                    return nf;
                default:
                    System.out.println("Opção invalida");
                    return null;

            }

        } catch (InputMismatchException e) {
            System.out.println("Erro: Por favor, insira um valor numérico válido.");
            scanner.nextLine();  // Consumir a entrada inválida
            return null;  // Ou lançar exceção ou retornar um valor padrão, dependendo do caso

        } catch (NoSuchElementException e) {
            System.out.println("Erro: Entrada esperada não fornecida.");
            scanner.nextLine();  // Consumir a entrada inválida
            return null;  // Ou lançar exceção ou retornar um valor padrão, dependendo do caso
        }
    }

    public static Transporte registrarTransporte(Scanner scanner) {
        try {
            System.out.println("Digite o id do transporte:");
            int id = scanner.nextInt();

            System.out.println("\tPortos Espaciais Disponíveis:");
            consultarPorto();

            System.out.println("Insira o id do porto espacial de origem:");
            int idOrigem = scanner.nextInt();
            PortoEspacial origem = obterPorto(idOrigem);

            System.out.println("Insira o id do porto espacial de destino:");
            int idDestino = scanner.nextInt();
            PortoEspacial destino = obterPorto(idDestino);

            System.out.println(" Insira o tipo de transporte ");
            System.out.println(" 1- Transporte para Materias ");
            System.out.println(" 2- Transporte para Pessoas ");
            TipoTransporte tipo = null;

            int op = scanner.nextInt();
            switch (op) {
                case 1:
                    tipo = TipoTransporte.transporteMateriais;
                    System.out.println("Digite a descrição do material");
                    String descricao = scanner.next();
                    System.out.println("Digite a quantidade de carga");

                    int qntM = scanner.nextInt();
                    TransporteMaterial tm = new TransporteMaterial(descricao, qntM, id, origem, destino);
                    filaTransportes.add(tm);

                    return tm;

                case 2:
                    tipo = TipoTransporte.transportePessoas;
                    System.out.println("Digite a quantidade de pessoas no transporte");
                    int qntP = scanner.nextInt();
                    TransportePessoa tp = new TransportePessoa(qntP, id, origem, destino);
                    filaTransportes.add(tp);

                    return tp;
                default:
                    System.out.println("Opção invalida");
                    return null;
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro: Por favor, insira um valor numérico válido.");
            scanner.nextLine();  // Consumir a entrada inválida
            return null;  // Ou lançar exceção ou retornar um valor padrão, dependendo do caso

        } catch (NoSuchElementException e) {
            System.out.println("Erro: Entrada esperada não fornecida.");
            scanner.nextLine();  // Consumir a entrada inválida
            return null;  // Ou lançar exceção ou retornar um valor padrão, dependendo do caso
        }

    }

// Método para consultar todos os transportes
    public static void consultarTransportes() {
        try {
            System.out.println("Historico de transportes:");

            for (Transporte transporte : filaTransportes) {
                System.out.println("Identificador: " + transporte.getId());
                System.out.println("Estado: " + transporte.getEstado());
                System.out.println("Origem: " + transporte.getOrigem());
                System.out.println("Destino: " + transporte.getDestino());
                System.out.printf("Distância:  " + "%.1f" + " ano-luz/hora \n", transporte.calculaDistancia());
                System.out.printf("Custo: " + "%.1f" + " Z$ \n", transporte.calculaCusto());

                // Verificar se uma nave espacial foi designada
                NaveEspacial naveDesignada = transporte.getNaveDesignada();
                if (naveDesignada != null) {
                    System.out.println("Nave Espacial Designada: " + naveDesignada.getIdnome());
                } else {
                    System.out.println("Nenhuma Nave Espacial designada");
                }

                System.out.println("\n\n");
            }
        } catch (Exception e) {

            System.out.println("Erro ao calcular distância ou custo: " + e.getMessage());
        }
    }

    //consultar transportes pendentes
    public static void consultarTransportesP() {
        try {
            System.out.println("Fila de Transportes Pendentes:\n");

            for (Transporte transporte : filaTransportes) {
                if (transporte.getEstado() == EstadoTransporte.Pendente) {
                    filaTransportesP.add(transporte);
                    System.out.println("Identificador: " + transporte.getId());
                    System.out.println("Estado: " + transporte.getEstado());
                    System.out.println("Origem: " + transporte.getOrigem());
                    System.out.println("Destino: " + transporte.getDestino());
                    System.out.printf("Distância:  " + "%.1f" + " ano-luz/hora \n", transporte.calculaDistancia());
                    System.out.printf("Custo: " + "%.1f" + " Z$ \n", transporte.calculaCusto());

                }
            }
        } catch (Exception e) {

            System.out.println("Erro ao calcular distância ou custo: " + e.getMessage());
        }
    }

    public static void consultarPorto() {
        System.out.println("Portos espaciais disponiveis");
        for (PortoEspacial portoEspacial : portosEspaciais) {
            System.out.println(portoEspacial.toString());
        }
    }

    public static void consultarNave() {
        System.out.println("Naves espaciais disponiveis");
        for (NaveEspacial naveEspacial : navesEspaciais) {
            System.out.println(naveEspacial.toString());
        }
    }

    public static void alterarEstadoTransporte(Scanner scanner) {
        System.out.println("Digite o id do Transporte");
        int id = scanner.nextInt();

        // Método para alterar o estado de um transporte
        for (Transporte transporte : filaTransportesP) {
            if (transporte.getId() == id) {
                if (transporte.getEstado() == EstadoTransporte.Pendente || transporte.getEstado() == EstadoTransporte.Transportando) {
                    transporte.setEstado(EstadoTransporte.Cancelado);
                    System.out.println("Estado do transporte alterado para " + EstadoTransporte.Cancelado);
                    System.out.println(transporte.toString());
                } else {
                    System.out.println("Erro: Não é possível alterar o estado de um transporte cancelado ou finalizado.");
                }
            }
        }
        System.out.println("Erro: Transporte não encontrado, registre esse transporte.");
    }

    public static void carregarDadosIniciais(Scanner scanner) {
        carregarDadosTransporte();
        carregarDadosTransportesP();
        carregarNave();
        carregarPorto();

    }

    public static void consultarTransportesP(FileWriter escreverNoArquivo) {
        try {
            // Certifique-se de que o FileWriter foi fornecido
            if (escreverNoArquivo != null) {
                escreverNoArquivo.write("Fila de Transportes Pendentes:\n");

                for (Transporte transporte : filaTransportesP) {
                    escreverNoArquivo.write("Identificador: " + transporte.getId() + "\n");
                    escreverNoArquivo.write("Estado: " + transporte.getEstado() + "\n");
                    escreverNoArquivo.write("Origem: " + transporte.getOrigem() + "\n");
                    escreverNoArquivo.write("Destino: " + transporte.getDestino() + "\n");
                    escreverNoArquivo.write(String.format("Distância: %.1f ano-luz/hora \n", transporte.calculaDistancia()));
                    escreverNoArquivo.write(String.format("Custo: %.1f Z$ \n", transporte.calculaCusto()));
                    escreverNoArquivo.write("\n");
                }

                escreverNoArquivo.write("\n"); // Adiciona uma linha em branco para separar as consultas

                System.out.println("Consultas foram escritas no arquivo com sucesso.");
            } else {
                System.out.println("FileWriter não fornecido. Não é possível escrever no arquivo.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    private static <T> List<T> lerLista(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        return (List<T>) inputStream.readObject();
    }

    public static void designarNave(Scanner scanner) {
        System.out.println("\t Digite o id do transporte");
        consultarTransportesP();
        int id = scanner.nextInt();
        if (obterTransporte(id) != null) {
            Transporte transporte = obterTransporte(id);

            for (NaveEspacial naves : navesEspaciais) {
                if (!naves.temTransporte(transporte)) {
                    if (naves instanceof NaveFTL) {
                        NaveFTL naveF = (NaveFTL) naves;
                        if (transporte instanceof TransporteMaterial) {

                            if (naveF.getLimiteTransporte() >= ((TransporteMaterial) transporte).getCarga()) {
                                transporte.setNaveDesignada(naves);
                                naves.setTransporte(transporte);
                                transporte.setEstado(EstadoTransporte.Transportando);
                                return;
                            }
                        } else if (transporte instanceof TransportePessoa) {
                            if (naveF.getLimiteTransporte() >= ((TransportePessoa) transporte).getQntPessoas()) {
                                transporte.setNaveDesignada(naves);
                                naves.setTransporte(transporte);
                                transporte.setEstado(EstadoTransporte.Transportando);

                                return;
                            }
                        }
                    } else {
                        if (naves instanceof NaveSubluz) {
                            NaveSubluz naveS = (NaveSubluz) naves;
                            if (transporte instanceof TransporteMaterial || transporte instanceof TransportePessoa) {
                                transporte.setNaveDesignada(naveS);
                                naves.setTransporte(transporte);
                                transporte.setEstado(EstadoTransporte.Transportando);
                                filaTransportesP.remove(transporte);

                                return;

                            }
                        }
                    }

                } // transporte.setEstado(EstadoTransporte.Transportando);
                else {
                    System.out.println("A nave ja foi designada.");
                    return;
                }
            }
            System.out.println("Naves indisponiveis");
            filaTransportesP.offer(transporte);
        }
    }

    public static void sair() {
        System.out.println("Encerrando o sistema...");
        System.exit(0);
    }

}
