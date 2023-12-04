package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import livro.Livro;

public class Main {
	
	static Scanner le = new Scanner(System.in);
	ArrayList<Livro> listaDeLivros = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Main main = new Main();
		
		main.menu();
		le.close();
		System.out.println("Sistema finalizado com sucesso.");
	}
	
	public void menu() {
		int variavelDeEscolha = 1;
		
		while (variavelDeEscolha != 0) {
			System.out.println("\nGerenciamento de Livros");
			System.out.println("1 - Cadastrar novo livro");
			System.out.println("2 - Editar livro");
			System.out.println("3 - Listar livro");
			System.out.println("4 - Avaliar livro");
			System.out.println("0 - Sair");
			System.out.print("\nEscolha: ");
			variavelDeEscolha = le.nextInt();
			le.nextLine();
			
			switch (variavelDeEscolha) {
			case 1:
				cadastrarLivro();
				break;
			case 2:
				editarLivro();
				break;
			case 3:
				listarLivro();
				break;
			case 4:
				avaliarLivro();
				break;
			case 0:
				System.out.println("Finalizando sistema...");
				continue;
			default:
				System.out.println("Erro! Você digitou uma opção inválida, tente novamente.");
				break;
			}
		}
	}

	public void cadastrarLivro() {
		System.out.println("\nCadastro De livro");
		System.out.print("\nDigite o nome do livro: ");
		String nomeDoLivro = le.nextLine();
		System.out.print("Digite o autor do Livro: ");
		String autorDoLivro = le.nextLine();
		System.out.print("Digite o valor do livro: ");
		double valorDoLivro = le.nextDouble();
			
		Livro livro = new Livro(nomeDoLivro, autorDoLivro, valorDoLivro);
		listaDeLivros.add(livro);
	}

	public void editarLivro() {
		boolean variavelGerenciaLivro = true;
		
		do {
			System.out.println("\nEditor de Livros");
			System.out.println("1 - Editar dados de livro");
			System.out.println("2 - Excluir livro");
			System.out.println("0 - Voltar");
			System.out.print("\nEscolha: ");
			int varEditaLivro = le.nextInt();
			le.nextLine();
			
			switch (varEditaLivro) {
			case 1:
				System.out.print("\nNome do livro que deseja editar: ");
				String varNomeLivroEditar = le.nextLine();
				
				for (Livro livro : listaDeLivros) {
					if (livro.getTitulo().equalsIgnoreCase(varNomeLivroEditar)) {
						
						boolean editaDadoDoLivro = true;
						
						do {
							System.out.println("\n1 - Alterar Título");
							System.out.println("2 - Alterar Autor");
							System.out.println("3 - Alterar Valor");
							System.out.println("0 - Voltar");
							System.out.print("\nEscolha: ");
							int varEscolhaEdicaoLivro = le.nextInt();
							le.nextLine();
							
							switch (varEscolhaEdicaoLivro) {
							case 1:
								System.out.print("Nome atualizado do livro: ");
								String novoTituloLivro = le.nextLine();
								livro.setTitulo(novoTituloLivro);
								editaDadoDoLivro = true;
								break;
							case 2:
								System.out.print("Nome atualizado do autor: ");
								String novoAutorLivro = le.nextLine();
								livro.setAutor(novoAutorLivro);
								editaDadoDoLivro = true;
								break;
							case 3:
								System.out.print("Digite o valor atualizado do livro ");
								double novoValorLivro = le.nextDouble();
								livro.setValor(novoValorLivro);
								editaDadoDoLivro = true;
								break;
							case 0:
								editaDadoDoLivro = false;
								break;
							default:
								System.out.println("Erro! Você digitou uma opção inválida, tente novamente.");
								editaDadoDoLivro = true;
								break;								
							}							
						} while (editaDadoDoLivro == true);
					} else {
						System.out.println("Este livro não existe!");
						variavelGerenciaLivro = true;
					}
				}
				break;
			case 2:
				System.out.print("\nNome do livro que deseja excluir: ");
				String varNomeLivroExcluir = le.nextLine();
				
				for (Livro livro : listaDeLivros) {
					if (livro.getTitulo().equalsIgnoreCase(varNomeLivroExcluir)) {
						listaDeLivros.remove(livro);
						System.out.println("O livro " + livro.getTitulo() + " foi excluído com sucesso.");
						variavelGerenciaLivro = false;
						break;
					} else {
						System.out.println("Este livro não existe!");
						variavelGerenciaLivro = true;
					}
				}
				break;
			case 0:
				variavelGerenciaLivro = false;
				break;
			default:
				System.out.println("Erro! Você digitou uma opção inválida, tente novamente.");
				variavelGerenciaLivro = true;
				break;
			}
		} while (variavelGerenciaLivro == true);
		
	}
	
	public void listarLivro() {
		boolean varListarLivro = true;
		if (!listaDeLivros.isEmpty()) {
			do {
				System.out.println("\n1 - Listar todos livros");
				System.out.println("2 - Top 3 Livros");
				System.out.println("0 - Voltar");
				System.out.print("Escolha: ");
				int numeroEscolhaListaLivro = le.nextInt();
				le.nextLine();
				
				switch (numeroEscolhaListaLivro) {
				case 0:
					varListarLivro = false;
					break;
				case 1:
					for (Livro livro : listaDeLivros) {
						System.out.println(livro.toString());
					}
					break;
				case 2:
					ArrayList<Livro> listaOrdenadaPorAvaliacao = new ArrayList<>(listaDeLivros);
					Collections.sort(listaOrdenadaPorAvaliacao);
					for (int i = 0; i < 1; i++) {
						System.out.println(listaOrdenadaPorAvaliacao.get(i));
					}
					break;
				default:
					System.out.println("Você digitou uma opção inválida. Tente novamente!");
					break;
				}			
			} while (varListarLivro == true);		
		} else {
			System.out.println("Não há livros registrados.");
		}
	}
	
	public void avaliarLivro() {
		boolean varAvalia = true;
		if (listaDeLivros.isEmpty()) {
			System.out.println("Não há livros registrados.");
		} else {
			do {
				System.out.print("Digite o nome do livro que deseja avaliar: ");
				String varNomeLivroAvaliar = le.nextLine();
				Iterator<Livro> iterator = listaDeLivros.iterator();
				boolean livroEncontrado = false;
				
				while (iterator.hasNext()) {
				    Livro livro = iterator.next();
				    if (livro.getTitulo().equalsIgnoreCase(varNomeLivroAvaliar)) {
				        System.out.print("Digite a nota do livro: ");
				        Double notaDeAvaliacao = le.nextDouble();
				        le.nextLine();
				        if (notaDeAvaliacao > 10) {
				            System.out.println("Você deve avaliar uma nota de 0 a 10.");
				        } else {
				            livro.avaliar(notaDeAvaliacao);
				            varAvalia = false;
				        }
				        livroEncontrado = true;
				        break;
				    } 
				}
				if (!livroEncontrado) {
					System.out.println("O livro não existe.");
					varAvalia = false;
				}
			} while (varAvalia == true);
		
		}
	}
}
