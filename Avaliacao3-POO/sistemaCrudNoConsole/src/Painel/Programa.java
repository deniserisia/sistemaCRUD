package Painel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entidades.Funcionario;


public class Programa {
	
	public static void main(String[] args) {
		
		try {
		
			int id, opcao;
			
			Locale.setDefault(Locale.US); //Separador de decimais
			Scanner entrada = new Scanner(System.in);
			
			List<Funcionario> list = new ArrayList<>(); //Lista de dados
			
			
			do {
				
				System.out.println("\nBem-Vindo ao nosso sistema!\n");
				
				System.out.println("Digite 1 - Para cadastrar funcionário;\n"
						+ "Digite 2 - Para editar o salário de um funcionário;\n"
						+ "Digite 3 - Para excluir um funcionário;\n"
						+ "Digite 4 - Para listar os funcionários;\n"
						+ "Digite 5 - Para sair do programa\n");
				opcao = entrada.nextInt();
				
				switch(opcao) {
				
					case 1:
						
						System.out.println("ID: ");
						id = entrada.nextInt();
						
						while(noId(list, id)) {
							System.out.println("Esse ID já existe, digite novamente:");
							id = entrada.nextInt();
						}
						
						System.out.println("Nome do funcionário(a): ");
						entrada.nextLine();
						String nomeDoFuncionario = entrada.nextLine();
						
						System.out.println("Salário: ");
						Double salarioDoFuncionario = entrada.nextDouble();
						
						Funcionario funcionario = new Funcionario(id, nomeDoFuncionario, salarioDoFuncionario);	
						
						if(list.add(funcionario)) {
							System.out.println("Funcionário cadastrado com sucesso!\n");
						}else {
							System.out.println("Erro ao realizar cadastro\n");
						}
					
						break;
						
					case 2:
						
						if(list.size() == 0) {
							System.out.println("A lista está vazia, tente primeiro cadastrar um funcionário!\n");
						}else {
							System.out.println("Por favor, entre com o ID do funcionário que terá o seu salário aumentado: ");
							int idSalario = entrada.nextInt();
							
							Integer posicaoDoID = posicaoDoIdNaLista(list, idSalario);
							
							if (posicaoDoID == null) {
								System.out.println("Esse ID não existe ou não foi cadastrado!\n");
							}else {
								System.out.print("Entre com a porcentagem de aumento no salário: ");
								double percentualDeAumento = entrada.nextDouble();
								list.get(posicaoDoID).aumentarSalario(percentualDeAumento);
							}
							
							System.out.println();
							System.out.println("A sua lista atualizada de funcionarios(as) é essa:");
							System.out.println("A sequência é ID | Nome do funcionário | Salário");
							
							for (Funcionario fun : list) {
								System.out.println(fun);
							}
						}
						
						break;
						
					case 3: 
						
						if(list.size() == 0) {
							System.out.println("Nenhum funcionário cadastrado!\n");
						}else{
							
							System.out.println("Por favor, entre com o ID do funcionário que você deseja excluir: ");
							id = entrada.nextInt();
							
							Integer posicaoDoID = posicaoDoIdNaLista(list, id);
							
							if (posicaoDoID == null) {
								System.out.println("Esse ID não existe ou não foi cadastrado!\n");
							}else {
							    for(int i = 0; i < list.size(); i++){
							        Funcionario p = list.get(i);
	
							        if(p.getId() == id){
							            if(list.remove(p)) {
							            	System.out.println("Funcionário excluído com sucesso!\n");
							            }
							            
							            break;
							        }
							    }
								
							}	
						}
					
						break;
					
					case 4:
						
						if(list.size() == 0) {
							System.out.println("Nenhum funcionário cadastrado!\n");
						}else{
							Funcionario funcionarios = new Funcionario();
							for(int i = 0; i < list.size(); i++) {
								System.out.println("ID: " + list.get(i).getId() + " | Nome: " + list.get(i).getNomeDoFuncionario() + " | Salário: " + list.get(i).getSalarioDoFuncionario());
							}	
						}
						
						break;
						
					case 5: 
						System.out.println(0);
						break;
						
					default:
						System.out.println("Opção inválida! \n");
				
				}
				
			}while(opcao != 5);
			
			for (Funcionario fun : list) {
				System.out.println(fun);
			}
			
			entrada.close();
		
		// Tratamento de Exceções GERAL 
		} catch (InputMismatchException e) {
				System.err.println("Não é permitido letras, informe apenas numeros inteiros" + e.toString());
				
		} catch (NumberFormatException e) {
			System.out.println("Não é permitido inserir letras, informe apenas números interios" + e.getMessage());
		}
		
	}
	
	// Função para procurar um elemento na lista 
	public static Integer posicaoDoIdNaLista(List<Funcionario> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}	
		return null;
	}
	// Função auxiliar para ver se esse ID já existe na lista
	public static boolean noId(List<Funcionario> list, int id) {
		Funcionario funcionario = list.stream().filter( x -> x.getId() == id).findFirst().orElse(null);
		return funcionario != null;
	}

}