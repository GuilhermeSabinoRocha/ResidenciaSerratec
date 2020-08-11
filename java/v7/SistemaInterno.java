package appInternetBanking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class SistemaInterno  {

	public static void main(String[] args) throws IOException   {
		
		//criação do HashMap de contas
		Conta.main(args);
		
		//leitura do .csv e criação do HashMap de usuários
		Usuario.main(args);
		
		//entra tela inicial
		//espera
		//limpa tel(?)		
		
		//LOGIN///
		System.out.println("Digite seu CPF");
		Scanner scan = new Scanner(System.in); 
		long CPFParaLogar = scan.nextLong(); 
		Usuario logado = Usuario.login(CPFParaLogar);
		
		//tela inicial
		
		if (logado != null) {
			
			primeiroMenu(logado);
		}
		
		
	//	System.out.println(mapUsers.keySet().toString());
		
		/*
		 * System.out.println("Escolha a operação desejada:"
				+ "\n1- Consultar Saldo\n2- Saque\n3- Depósito em Conta"
				+ "\n4- Informações da Conta \n5- Sair ");
				*/
				//realiza a operação escolhida
				//verificaOperacao(c);
				
	}
	
public static void primeiroMenu(Usuario c) {
		
		boolean sair = false;
		
			do {
				//Primeiro Menu 
				System.out.println("Escolha a operação desejada:"
						+ "\n1- Movimentações\n2- Relatórios\n3- Sair ");
				Scanner scan = new Scanner(System.in);
				int op = scan.nextInt();			
				
				switch (op) {
				
				//para Movimentações
				case 1:
					
							do {
								//SegundoMenu 
								System.out.println("1- Saque\n2- Depósito\n3- Transferência\n4- Sair ");
								Scanner scan2 = new Scanner(System.in);
								int op2 = scan.nextInt();			
								
								switch (op2) {
								
								//para Saque
								case 1:
									System.out.println("Digite o valor do saque:");						
									
									//realizar outra operação ou sair
									if (verificaSairDoMenu()) {
										System.out.println("Obrigado por utilizar o Internet Banking.");
										sair = true;
									}
															
									break;					
									
									//para Depósito
								case 2:
									
									System.out.println("Digite o valor a depositar em sua conta");
									
//									else {
//										System.out.println("Não foi possível realizar a operação. Digite um valor válido.\n");
//									}
									//realizar outra operação ou sair
									if (verificaSairDoMenu()) {
										System.out.println("Obrigado por utilizar o Internet Banking.");
										sair = true;
									}
									break;
									
									//para Transferência	
								case 3:
									System.out.println("Digite o valor da transferência");
									
									
//									else {
//										System.out.println("Não foi posível realizar a operação. Digite um valor válido.\n");
//									}
									//realizar outra operação ou sair
									if (verificaSairDoMenu()) {
										System.out.println("Obrigado por utilizar o Internet Banking.");
										sair = true;
									}
									
									break;
									
									//para Sair
								case 4:
									
									System.out.println("Obrigado por utilizar o Internet Banking.");
									sair = true;
									break;			
									
								default:
									System.out.println("Opção inválida.\n");
									break;
								}
							} while (!sair);
							
							
					
					
					
					
					
					
					//realizar outra operação ou sair
					if (verificaSairDoMenu()) {
						System.out.println("Obrigado por utilizar o Internet Banking.");
						sair = true;
					}
											
					break;					
					
					//para Relatórios
				case 2:			
		
							do {
								//TerceiroMenu 
								System.out.println("1- Saldo\n2- Relatório de tarifação\n3- Informações sobre tarifas\4- Rendimentos da poupança\n"
										+ "5- Relatório de contas gerenciadas\n" + 
										"6- Sair ");
								Scanner scan3 = new Scanner(System.in);
								int op3 = scan.nextInt();			
								
								switch (op3) {
								
								//para Saldo
								case 1:
									System.out.println();						
									
									//realizar outra operação ou sair
									if (verificaSairDoMenu()) {
										System.out.println("Obrigado por utilizar o Internet Banking.");
										sair = true;
									}
															
									break;					
									
									//para Relatório de tarifação
								case 2:
									
									System.out.println("Digite o valor a depositar em sua conta");
									
									
									//realizar outra operação ou sair
									if (verificaSairDoMenu()) {
										System.out.println("Obrigado por utilizar o Internet Banking.");
										sair = true;
									}
									break;
									
									//para Informações sobre tarifas	
								case 3:
									System.out.println("Para cada saque será cobrado o valor de R$0.10 (dez centavos);\n" + 
											 
											"Para cada depósito realizado será cobrado o valor de R$0.10 (dez centavos);\n" + 
											"Para cada transferência realizada será cobrado o valor de R$0.20 (vinte centavos)\n" + 
											"Operações realizadas na conta poupança estão isentas de tarifas.");
									
									
									
									//realizar outra operação ou sair
									if (verificaSairDoMenu()) {
										System.out.println("Obrigado por utilizar o Internet Banking.");
										sair = true;
									}
									
									break;
									
									//para Rendimentos da poupança
									//para Informações sobre tarifas	
								case 4:
									
									
									//realizar outra operação ou sair
									if (verificaSairDoMenu()) {
										System.out.println("Obrigado por utilizar o Internet Banking.");
										sair = true;
									}
									
									break;
								
									//Relatório de contas gerenciadas
								case 5:
									
									
									//realizar outra operação ou sair
									if (verificaSairDoMenu()) {
										System.out.println("Obrigado por utilizar o Internet Banking.");
										sair = true;
									}
									
									break;
								
									//sair
								case 6:
									
									System.out.println("Obrigado por utilizar o Internet Banking.");
									sair = true;
									break;			
									
								default:
									System.out.println("Opção inválida.\n");
									break;
								}
							} while (!sair);
					
					
										

					//realizar outra operação ou sair
					if (verificaSairDoMenu()) {
						System.out.println("Obrigado por utilizar o Internet Banking.");
						sair = true;
					}
					break;					
							
					//para sair	
				case 3:
					System.out.println("Obrigado por utilizar o Internet Banking.");
					sair = true;
					break;			
					
				default:
					System.out.println("Opção inválida.\n");
					break;
				}
			} while (!sair);
			
		}
	//realizar outra operação ou sair
	public static boolean verificaSairDoMenu() {
		int input1;
		do {
			System.out.println("Deseja realizar outra operação? Digite 1 para SIM e 2 para NÃO\n");
			input1 = new Scanner(System.in).nextInt();
		} while (input1<1 || input1>2);
		
		if (input1 ==2) {
			return true;
		}
		else {
			
			
			return false;
		}
	}

	

}