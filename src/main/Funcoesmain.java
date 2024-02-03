/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import entidades.*;
import enums.*;
import java.util.*;
import static ficheiros.GuardarDados.*;
import static funcoesAuxiliares.Apresentar.*;
import static funcoesAuxiliares.PortoEspacial.*;
import static funcoesAuxiliares.Transporte.obterTransporte;

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
        System.out.println("8. Designar transportes");
        System.out.println("9. Carregar dados iniciais");
        System.out.println("10.Guardar dados no ficheiro");
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

            //condição para verificar se ja contem uma porto com os mesmos atributos na lista de naves.
            if (portosEspaciais.contains(novoPorto)) {
                return null;
            }
            novoPorto.equals(portosEspaciais);
            portosEspaciais.add(novoPorto);

            System.out.println("Porto espacial registrado com sucesso.\n" + novoPorto.toString());
            return novoPorto;

        } catch (InputMismatchException e) {
            System.out.println(" Por favor, insira um valor numérico válido.");
            scanner.nextLine();  // Consumir a entrada inválida
            return null;

        } catch (NoSuchElementException e) {
            System.out.println(" Entrada esperada não fornecida.");
            scanner.nextLine();  // Consumir a entrada inválida
            return null;

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public static NaveEspacial registrarNaveEspacial(Scanner scanner) {

        try {
            System.out.println("Digite o nome da nave espacial:");
            String nome = scanner.nextLine();

            consultarPorto();
            System.out.println("Insira o id do porto espacial de origem:");
            PortoEspacial origem;
            int id = scanner.nextInt();
            origem = obterPorto(id);
            if (origem != null) {

                origem = obterPorto(id);
            } else {
                // Retorna um novo PortoEspacial padrão se nenhum for encontrado
                entidades.PortoEspacial portoPadrao = new entidades.PortoEspacial();
                origem = portoPadrao;
                System.out.println("\nFoi atribuido o porto padrão.");
            }

            System.out.println("Escolha o tipo da nave espacial:");
            System.out.println("1- Subluz");
            System.out.println("2- FTL");
            TipoNave tipo;

            int op = scanner.nextInt();
            switch (op) {
                case 1:
                    tipo = TipoNave.Subluz;
                    System.out.println("Digite a velocidade da nave espacial em trek");
                    System.out.println("A velocidade maxima da nave Subluz é de 0.3 trek, se colocar uma superior terá a velocidade padrão.");
                    double vs = scanner.nextDouble();
                    NaveEspacial ns = new NaveSubluz(Combustivel.nuclear, nome, tipo, origem, vs);

                    //condição para verificar se ja contem uma nave com o mesmo id na lista de naves.
                    if (navesEspaciais.contains(ns)) {
                        return null;
                    }
                    navesEspaciais.add(ns);
                    navesEspaciaisD.add(ns);

                    System.out.println("Nave espacial registrada com sucesso.\n" + ns.toString());

                    return ns;

                case 2:
                    tipo = TipoNave.FTL;
                    System.out.println("Digite a quantidade de transporte");
                    int qnt = scanner.nextInt();
                    System.out.println("Digite a velocidade da nave espacial em trek");
                    double vf = scanner.nextDouble();
                    NaveEspacial nf = new NaveFTL(qnt, nome, tipo, origem, vf);

                    if (navesEspaciais.contains(nf)) {
                        return null;
                    }
                    navesEspaciais.add(nf);
                    navesEspaciaisD.add(nf);
                    System.out.println("Nave espacial registrada com sucesso.\n" + nf.toString());

                    return nf;
                default:
                    System.out.println("Opção invalida");
                    return null;

            }

        } catch (InputMismatchException e) {
            System.out.println(" Por favor, insira um valor numérico válido.");
            scanner.nextLine();  // Consumir a entrada inválida
            return null;  // Ou lançar exceção ou retornar um valor padrão, dependendo do caso

        } catch (NoSuchElementException e) {
            System.out.println(" Entrada esperada não fornecida.");
            scanner.nextLine();  // Consumir a entrada inválida
            return null;  // Ou lançar exceção ou retornar um valor padrão, dependendo do caso
        }

    }

    public static Transporte registrarTransporte(Scanner scanner) {
        try {
            int id;
            Transporte idT;

            //Verificar se o id do transporte existe 
            do {
                System.out.println("Digite o id do transporte:");
                id = scanner.nextInt();

                idT = obterTransporte(id);
            } while (idT != null);

            int idOrigem;
            PortoEspacial origem;

            //Verificar se o id do porto existe 
            do {
                consultarPorto();

                System.out.println("Insira o id do porto espacial de origem:");
                idOrigem = scanner.nextInt();

                origem = obterPorto(idOrigem);
            } while (origem == null);

            int idDestino;
            PortoEspacial destino;

            //Verificar se o id do porto existe e se o porto espacial de destino e o mesmo que o do origem.
            do {
                consultarPorto();

                System.out.println("Insira o id do porto espacial de destino:");
                idDestino = scanner.nextInt();
                destino = obterPorto(idDestino);
                if (destino.equals(origem)) {
                    System.out.println("O porto espacial de origem não pode ser o mesmo que o porto espacial de destino, insira outro.");
                }
            } while (destino == null || destino.equals(origem));

            System.out.println(" Insira o tipo de transporte ");
            System.out.println(" 1- Transporte para Materias ");
            System.out.println(" 2- Transporte para Pessoas ");
            TipoTransporte tipo;

            int op = scanner.nextInt();
            switch (op) {
                case 1:
                    tipo = TipoTransporte.transporteMateriais;
                    System.out.println("Digite a descrição do material");
                    String descricao = scanner.next();
                    System.out.println("Digite a quantidade de carga");
                    int qntM = scanner.nextInt();
                    TransporteMaterial tm = new TransporteMaterial(descricao, qntM, id, origem, destino);

                    //condição para verificar se ja contem um  transporte com o mesmo id na lista de transportes.
                    if (filaTransportes.contains(tm)) {
                        System.out.println("faz parte da lista de transportes");
                        break;
                    }
                    filaTransportes.add(tm);
                    System.out.println("Transporte registrado com sucesso.\n" + tm.toString());

                    return tm;

                case 2:
                    tipo = TipoTransporte.transportePessoas;
                    System.out.println("Digite a quantidade de pessoas no transporte");
                    int qntP = scanner.nextInt();
                    TransportePessoa tp = new TransportePessoa(qntP, id, origem, destino);

                    //condição para verificar se ja contem um  transporte com o mesmo id na lista de transportes.
                    if (filaTransportes.contains(tp)) {
                        System.out.println("faz parte da lista de transportes");
                        break;
                        //return null;
                    }
                    filaTransportes.add(tp);
                    System.out.println("Nave espacial registrado com sucesso.\n" + tp.toString());

                    return tp;
                default:
                    System.out.println("Opção invalida");
                    return null;
            }
        } catch (InputMismatchException e) {
            System.out.println(" Por favor, insira um valor numérico válido.");
            scanner.nextLine();  // Consumir a entrada inválida
            return null;  // Ou lançar exceção ou retornar um valor padrão, dependendo do caso

        } catch (NoSuchElementException e) {
            System.out.println(" Entrada esperada não fornecida.");
            scanner.nextLine();  // Consumir a entrada inválida
            return null;  // Ou lançar exceção ou retornar um valor padrão, dependendo do caso
        }
        return null;

    }

    //consultar transportes pendentes e historico de transportes pendentes 
    public static void consultarTransporte(boolean pendente) {
        try {
            if (pendente) {
                System.out.println("\tFila de Transportes Pendentes:\n");

                if (filaTransportesP.isEmpty()) {
                    System.out.println("A fila escontra-se vazia");
                }
                for (Transporte transporte : filaTransportes) {
                    if (transporte.getEstado() == EstadoTransporte.Pendente) {
                        filaTransportesP.add(transporte);
                        printTransp(transporte);
                    }
                }
            } else {
                System.out.println("\tHistorico de transportes\n");

                if (filaTransportes.isEmpty()) {
                    System.out.println("A fila escontra-se vazia");
                }

                for (Transporte transporte : filaTransportes) {
                    printTransp(transporte);

                    // Verificar se uma nave espacial foi designada
                    NaveEspacial naveDesignada = transporte.getNaveDesignada();
                    if (naveDesignada != null) {
                        System.out.println("Nave Espacial Designada: " + naveDesignada.getIdnome());
                    } else {
                        System.out.println("Nenhuma Nave Espacial designada");
                    }
                }

            }

            System.out.println("\n\n");

        } catch (Exception e) {

            System.out.println("Erro ao calcular distância ou custo: " + e.getMessage());
        }
    }

    public static void consultarPorto() {
        System.out.println(" \tPortos espaciais disponiveis\n");

        if (portosEspaciais.isEmpty()) {
            System.out.println("A lista escontra-se vazia");
        }

        for (PortoEspacial portoEspacial : portosEspaciais) {
            System.out.println(portoEspacial.toString());
        }
    }

    public static void consultarNave(boolean disponivel) {

        if (disponivel) {
            System.out.println("\tLista de Naves Disponiveis:\n");

            if (navesEspaciaisD.isEmpty()) {
                System.out.println("A lista escontra-se vazia");
            }

            for (NaveEspacial naveEspacial : navesEspaciaisD) {
                System.out.println(naveEspacial.toString());
            }
        } else {

            System.out.println("\tHistorico de Naves\n");

            if (navesEspaciais.isEmpty()) {
                System.out.println("A lista escontra-se vazia");
            }

            for (NaveEspacial naveEspacial : navesEspaciais) {
                System.out.println(naveEspacial.toString());

            }

        }
    }

    // Método para alterar o estado de um transporte
    public static void alterarEstadoTransporte(Scanner scanner) {

        consultarTransporte(false);
        Transporte idT;
        int id;

        //Verificar se o id do transporte existe 
        do {
            System.out.println("Digite o id do transporte:");
            id = scanner.nextInt();

            idT = obterTransporte(id);
        } while (idT == null);

        System.out.println("1-Cancelar \n 2- Finalizar ");
        int op = scanner.nextInt();

        for (Transporte transporte : filaTransportes) {
            if (transporte.getId() == id) {
                if (transporte.getEstado() == EstadoTransporte.Pendente || transporte.getEstado() == EstadoTransporte.Transportando) {
                    switch (op) {
                        case 1:
                            transporte.setEstado(EstadoTransporte.Cancelado);
                            System.out.println("Estado do transporte alterado para " + EstadoTransporte.Cancelado);
                            break;
                        case 2:
                            if (transporte.getEstado() == EstadoTransporte.Transportando) {
                                transporte.setEstado(EstadoTransporte.Finalizado);
                                System.out.println("Estado do transporte alterado para " + EstadoTransporte.Finalizado);

                            } else {
                                System.out.println("Não pode finalizar um transporte Pendente ou a Finalizado");
                            }
                            break;
                        default:
                            System.out.println("Opção invalida");
                            break;
                    }
                    System.out.println(transporte.toString());
                } else {
                    System.out.println("Não é possível alterar o estado de um transporte que ja esteja no estado cancelado ou finalizado.");
                }
            }
        }
    }

    public static void carregarDadosIniciais(Scanner scanner) {

    }

    public static void designarNave(Scanner scanner) {

        //consultarTransportesP();
        consultarTransporte(true);

        int id;
        Transporte idT;

        //Verificar se o id do transporte existe 
        do {
            System.out.println("Digite o id do transporte:");
            id = scanner.nextInt();
            idT = obterTransporte(id);
        } while (idT == null);

        Transporte transporte = obterTransporte(id);
        for (NaveEspacial naves : navesEspaciaisD) {
            if (naves instanceof NaveFTL) {
                NaveFTL naveF = (NaveFTL) naves;
                if (transporte instanceof TransporteMaterial) {

                    if (naveF.getLimiteTransporte() >= ((TransporteMaterial) transporte).getCarga() && transporte.getOrigem() == naveF.getPortoAtual()) {
                        transporte.setNaveDesignada(naves);
                        naves.setTransporte(transporte);
                        transporte.setEstado(EstadoTransporte.Transportando);
                        filaTransportesP.remove(transporte);
                        navesEspaciaisD.remove(naveF);
                        return;
                    }
                } else if (transporte instanceof TransportePessoa) {
                    if (naveF.getLimiteTransporte() >= ((TransportePessoa) transporte).getQntPessoas() && transporte.getOrigem() == naveF.getPortoAtual()) {
                        transporte.setNaveDesignada(naves);
                        naves.setTransporte(transporte);

                        transporte.setEstado(EstadoTransporte.Transportando);
                        filaTransportesP.remove(transporte);
                        navesEspaciaisD.remove(naveF);

                        return;
                    }
                }
            } else {
                if (naves instanceof NaveSubluz) {
                    NaveSubluz naveS = (NaveSubluz) naves;
                    if ((transporte instanceof TransporteMaterial || transporte instanceof TransportePessoa) && transporte.getOrigem() == naveS.getPortoAtual()) {
                        transporte.setNaveDesignada(naveS);
                        naves.setTransporte(transporte);
                        transporte.setEstado(EstadoTransporte.Transportando);
                        filaTransportesP.remove(transporte);
                        navesEspaciaisD.remove(naveS);

                        return;

                    }
                }
            }

        }
        System.out.println("Naves indisponiveis");
        // filaTransportesP.add(transporte);

    }

    public static void guardarF() {
        escreverDadosTransporte();
        escreverDadosTransportesP();
        escreverNave();
        escreverPorto();
    }

    public static void sair() {

        System.out.println("Encerrando o sistema...");
        System.exit(0);
    }

}
