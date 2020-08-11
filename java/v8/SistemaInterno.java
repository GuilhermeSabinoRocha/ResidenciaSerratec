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
						+ "\n1- Saque\n2- Depósito\n3- Transferência\n4- Relatório de Saldo\n5- Relatório de Tarifação da Conta Corrente"
						+ "\n6- Informações sobre tarifas\n7- Relatório de Rendimentos da Poupança"
						
						+ "\n8- Sair ");
				Scanner scan = new Scanner(System.in);
				int op = scan.nextInt();			
				
				switch (op) {
				
				//para Saque
				case 1:
							
					
					
					
					//realizar outra operação ou sair
					if (verificaSairDoPrimeiroMenu()) {
						System.out.println("Obrigado por utilizar o Internet Banking.");
						sair = true;
					}
											
					break;					
					
					//para Depósito
				case 2:
					System.out.println("Relatórios");
					

					//realizar outra operação ou sair
					if (verificaSairDoPrimeiroMenu()) {
						System.out.println("Obrigado por utilizar o Internet Banking.");
						sair = true;
					}
					break;					
							
					//para Transferência
				case 3:
					System.out.println("Relatórios");
					

					//realizar outra operação ou sair
					if (verificaSairDoPrimeiroMenu()) {
						System.out.println("Obrigado por utilizar o Internet Banking.");
						sair = true;
					}
					break;		
				
					//para Relatório de Saldo
				case 4:
					System.out.println("Relatórios");
					

					//realizar outra operação ou sair
					if (verificaSairDoPrimeiroMenu()) {
						System.out.println("Obrigado por utilizar o Internet Banking.");
						sair = true;
					}
					break;		
					
					//para Relatório de tarifação da Conta Corrente
				case 5:
					System.out.println("Relatórios");
					

					//realizar outra operação ou sair
					if (verificaSairDoPrimeiroMenu()) {
						System.out.println("Obrigado por utilizar o Internet Banking.");
						sair = true;
					}
					break;		
					
					
					//para Informações sobre tarifas
				case 6:
					System.out.println("Informações sobre tarifas");
					

					//realizar outra operação ou sair
					if (verificaSairDoPrimeiroMenu()) {
						System.out.println("Obrigado por utilizar o Internet Banking.");
						sair = true;
					}
					break;		
					
					
					
					//para Relatório de Rendimentos da poupança
				case 7:
					System.out.println("Relatório de Rendimentos da Poupança");
					

					//realizar outra operação ou sair
					if (verificaSairDoPrimeiroMenu()) {
						System.out.println("Obrigado por utilizar o Internet Banking.");
						sair = true;
					}
					break;		
					
					
					//para sair	
				case 8:
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
	public static boolean verificaSairDoPrimeiroMenu() {
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