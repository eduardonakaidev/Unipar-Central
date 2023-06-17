/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.pccasa.unipar.central;

import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.Exceptions.TamanhoMaximoDoCampoExcedidoException;
import com.pccasa.unipar.central.Exceptions.ValorInvalidoException;
import com.pccasa.unipar.central.executions.*;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author eduar
 */
public class UniparCentral {

    public static void main(String[] args) throws TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException, TamanhoCampoInvalidoException, SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException {
        
        Agenciaexecution agenciaExecution = new Agenciaexecution();
        BancoExeciton bancoExecution = new BancoExeciton();
        CidadeExecution cidadeExecution = new CidadeExecution();
        ContaExecution contaExecution = new ContaExecution();
        EnderecoExecution enderecoExecution = new EnderecoExecution();
        EstadoExecution estadoExecution = new EstadoExecution();
        PaisExecutio paisExecution = new PaisExecutio();
        PessoaExecution pessoaExecution = new PessoaExecution();
        PessoaFisicaExecution pessoaFisicaExecution = new PessoaFisicaExecution();
        PessoaJuridicaExecution pessoaJuridicaExecution = new PessoaJuridicaExecution();
        TelefoneExecution telefoneExecution = new TelefoneExecution();
        TransacaoExecution transacaoExecution = new TransacaoExecution();

        boolean sair = false;
        boolean sair2 = false;

        Scanner scanner = new Scanner(System.in);

        while (!sair) {
            System.out.println("----------MENU----------");
            System.out.println("1  - AGÊNCIA");
            System.out.println("2  - BANCO");
            System.out.println("3  - CIDADE");
            System.out.println("4  - CONTA");
            System.out.println("5  - ENDERECO");
            System.out.println("6  - ESTADO");
            System.out.println("7  - PAIS");
            System.out.println("8  - PESSOA");
            System.out.println("9  - PESSOA FÍSICA");
            System.out.println("10 - PESSOA JURÍDICA");
            System.out.println("11 - TELEFONE");
            System.out.println("12 - TRANSAÇÃO");
            System.out.println("13 - SAIR");

            int opcao = scanner.nextInt();
            sair2 = false;
            switch (opcao) {

                case 1:
                    while (!sair2) {
                        System.out.println("--------AGÊNCIA--------");
                        System.out.println("1 - INSERIR NOVA AGÊNCIA");
                        System.out.println("2 - VER TODAS AS AGÊNCIAS CADASTRADAS");
                        System.out.println("3 - VER A AGÊNCIA PELO ID");
                        System.out.println("4 - DELETAR UMA AGÊNCIA PELO ID");
                        System.out.println("5 - ATUALIZAR DADOS DA AGÊNCIA PELO ID");
                        System.out.println("6 - RETORNAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                agenciaExecution.Insert();
                                break;
                            case 2:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                agenciaExecution.FindAll();
                                break;
                            case 3:
                                agenciaExecution.FindById();
                                break;
                            case 4:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                agenciaExecution.DeleteById();
                                break;
                            case 5:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                agenciaExecution.Update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                    }
                    break;
                case 2:
                    while (!sair2) {
                        System.out.println("--------BANCO--------");
                        System.out.println("1 - INSERIR NOVO BANCO");
                        System.out.println("2 - VER TODAS OS BANCOS CADASTRADOS");
                        System.out.println("3 - VER O BANCO PELO ID");
                        System.out.println("4 - DELETAR UM BANCO PELO ID");
                        System.out.println("5 - ATUALIZAR DADOS DO BANCO PELO ID");
                        System.out.println("6 - RETORNAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                bancoExecution.Insert();
                                break;
                            case 2:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                bancoExecution.FindAll();
                                break;
                            case 3:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                bancoExecution.FindById();
                                break;
                            case 4:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                bancoExecution.DeleteById();
                                break;
                            case 5:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                bancoExecution.Update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                    }
                    break;
                case 3:
                    while (!sair2) {
                        System.out.println("--------CIDADE--------");
                        System.out.println("1 - INSERIR NOVA CIDADE");
                        System.out.println("2 - VER TODAS AS CIDADES CADASTRADAS ");
                        System.out.println("3 - VER A CIDADE PELO ID");
                        System.out.println("4 - DELETAR UMA CIDADE PELO ID");
                        System.out.println("5 - ATUALIZAR DADOS DE UMA CIDADE PELO ID");
                        System.out.println("6 - RETORNAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                cidadeExecution.Insert();
                                break;
                            case 2:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                cidadeExecution.FindAll();
                                break;
                            case 3:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                cidadeExecution.FindById();
                                break;
                            case 4:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                cidadeExecution.DeleteById();
                                break;
                            case 5:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                cidadeExecution.Update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("opcao invalida");
                        }
                    }
                    break;
                case 4:
                    while (!sair2) {
                        System.out.println("--------CONTA--------");
                        System.out.println("1 - INSERIR NOVA CONTA");
                        System.out.println("2 - VER TODAS AS CONTAS CADASTRADAS");
                        System.out.println("3 - VER A CONTA PELO ID");
                        System.out.println("4 - DELETAR UMA CONTA PELO ID");
                        System.out.println("5 - ATUALIZAR DADOS DE UMA CONTA PELO ID");
                        System.out.println("6 - RETORNAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                contaExecution.Insert();
                                break;
                            case 2:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                contaExecution.FindAll();
                                break;
                            case 3:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                contaExecution.FindById();
                                break;
                            case 4:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                contaExecution.DeleteById();
                                break;
                            case 5:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                contaExecution.Update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("Opcao inválida");
                        }
                    }
                    break;
                case 5:
                    while (!sair2) {
                        System.out.println("------ENDERECO------");
                        System.out.println("1 - INSERIR NOVO ENDEREÇO");
                        System.out.println("2 - VER TODAS OS ENDEREÇOS CADASTRADOS");
                        System.out.println("3 - VER O ENDEREÇO PELO ID");
                        System.out.println("4 - DELETAR UM ENDEREÇO PELO ID");
                        System.out.println("5 - ATUALIZAR DADOS DE UM ENDEREÇO PELO ID");
                        System.out.println("6 - RETORNAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                enderecoExecution.Insert();
                                break;
                            case 2:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                enderecoExecution.FindAll();
                                break;
                            case 3:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                enderecoExecution.FindById();
                                break;
                            case 4:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                enderecoExecution.DeleteById();
                                break;
                            case 5:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                enderecoExecution.Update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                    }
                    break;
                case 6:
                    while (!sair2) {
                        System.out.println("-------ESTADO-------");
                        System.out.println("1 - INSERIR NOVO ESTADO");
                        System.out.println("2 - VER TODAS OS ESTADOS CADASTRADOS");
                        System.out.println("3 - VER O ESTADO PELO ID");
                        System.out.println("4 - DELETAR UM ESTADO PELO ID");
                        System.out.println("5 - ATUALIZAR DADOS DE UM ESTADO PELO ID");
                        System.out.println("6 - RETORNAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                estadoExecution.Insert();
                                break;
                            case 2:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                estadoExecution.FindAll();
                                break;
                            case 3:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                estadoExecution.FindById();
                                break;
                            case 4:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                estadoExecution.DeleteById();
                                break;
                            case 5:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                estadoExecution.Update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                    }
                    break;
                case 7:
                    while (!sair2) {
                        System.out.println("--------PAÍS--------");
                        System.out.println("1 - INSERIR NOVO PAÍS");
                        System.out.println("2 - VER TODAS OS PAÍSES CADASTRADOS");
                        System.out.println("3 - VER O PAÍS PELO ID");
                        System.out.println("4 - DELETAR UM PAÍS PELO ID");
                        System.out.println("5 - ATUALIZAR DADOS DE UM PAÍS PELO ID");
                        System.out.println("6 - RETORNAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                paisExecution.Insert();
                                break;
                            case 2:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                paisExecution.FindAll();
                                break;
                            case 3:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                paisExecution.FindById();
                                break;
                            case 4:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                paisExecution.DeleteById();
                                break;
                            case 5:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                paisExecution.Update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                    }
                    break;
                case 8:
                    while (!sair2) {
                        System.out.println("-------PESSOA-------");
                        System.out.println("1 - INSERIR NOVA PESSOA");
                        System.out.println("2 - VER TODAS AS PESSOAS CADASTRADAS");
                        System.out.println("3 - VER A PESSOA PELO ID");
                        System.out.println("4 - DELETAR UMA PESSOA PELO ID");
                        System.out.println("5 - ATUALIZAR DADOS DE UMA PESSOA PELO ID");
                        System.out.println("6 - RETORNAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                pessoaExecution.Insert();
                                break;
                            case 2:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                pessoaExecution.FindAll();
                                break;
                            case 3:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                pessoaExecution.FindById();
                                break;
                            case 4:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                pessoaExecution.DeleteById();
                                break;
                            case 5:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                pessoaExecution.Update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("Opcao invalida");
                        }
                    }
                    break;
                case 9:
                    while (!sair2) {
                        System.out.println("----PESSOA FÍSICA----");
                        System.out.println("1 - INSERIR NOVA PESSOA FÍSICA");
                        System.out.println("2 - VER TODAS AS PESSOAS FÍSICAS CADASTRADAS");
                        System.out.println("3 - VER A PESSOA FÍSICA PELO CPF");
                        System.out.println("4 - DELETAR UMA PESSOA FÍSICA PELO CPF");
                        System.out.println("5 - ATUALIZAR DADOS DE UMA PESSOA FÍSICA PELO CPF");
                        System.out.println("6 - RETORNAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                pessoaFisicaExecution.Insert();
                                break;
                            case 2:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                pessoaFisicaExecution.FindAll();
                                break;
                            case 3:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                pessoaFisicaExecution.FindById();
                                break;
                            case 4:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                pessoaFisicaExecution.DeleteById();
                                break;
                            case 5:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                pessoaFisicaExecution.Update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                    }
                    break;
                case 10:
                    while (!sair2) {
                        System.out.println("---PESSOA JURÍDICA---");
                        System.out.println("1 - INSERIR NOVA PESSOA JURÍDICA");
                        System.out.println("2 - VER TODAS AS PESSOAS JURÍDICA CADASTRADAS");
                        System.out.println("3 - VER A PESSOA JURÍDICA PELO CNPJ");
                        System.out.println("4 - DELETAR UMA PESSOA JURÍDICA PELO CNPJ");
                        System.out.println("5 - ATUALIZAR DADOS DE UMA PESSOA JURÍDICA PELO CNPJ");
                        System.out.println("6 - RETORNAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                pessoaJuridicaExecution.Insert();
                                break;
                            case 2:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                pessoaJuridicaExecution.FindAll();
                                break;
                            case 3:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                pessoaJuridicaExecution.FindById();
                                break;
                            case 4:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                pessoaJuridicaExecution.DeleteById();
                                break;
                            case 5:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                pessoaJuridicaExecution.Update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("Opcao invalida");
                        }
                    }
                    break;
                case 11:
                    while (!sair2) {
                        System.out.println("------TELEFONE------");
                        System.out.println("1 - INSERIR NOVO TELEFONE");
                        System.out.println("2 - VER TODAS OS TELEFONES CADASTRADAS");
                        System.out.println("3 - VER A TELEFONE PELO ID");
                        System.out.println("4 - DELETAR UM TELEFONE PELO ID");
                        System.out.println("5 - ATUALIZAR DADOS DE UM TELEFONE PELO ID");
                        System.out.println("6 - RETORNAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                telefoneExecution.Insert();
                                break;
                            case 2:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                telefoneExecution.FindAll();
                                break;
                            case 3:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                telefoneExecution.FindById();
                                break;
                            case 4:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                telefoneExecution.DeleteById();
                                break;
                            case 5:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                telefoneExecution.Update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("Opcao inválida");
                        }
                    }
                    break;
                case 12:
                    while (!sair2) {
                        System.out.println("----TRANSAÇÃO----");
                        System.out.println("1 - INSERIR NOVA TRANSAÇÃO");
                        System.out.println("2 - VER TODAS AS TRANSAÇÕES CADASTRADAS");
                        System.out.println("3 - VER A TRANSAÇÃO PELO ID");
                        System.out.println("4 - DELETAR UM TRANSAÇÃO PELO ID");
                        System.out.println("5 - ATUALIZAR DADOS DE UMA TRANSAÇÃO PELO ID");
                        System.out.println("6 - RETORNAR");

                        int opcao2 = scanner.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                transacaoExecution.Insert();
                                break;
                            case 2:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                transacaoExecution.FindAll();
                                break;
                            case 3:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                transacaoExecution.FindById();
                                break;
                            case 4:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                transacaoExecution.DeleteById();
                                break;
                            case 5:
                                System.out.println("-------------------------------------Isso pode demorar mais do que o normal-------------------------------------");
                                transacaoExecution.Update();
                                break;
                            case 6:
                                sair2 = true;
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                    }
                    break;
                case 13:
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
