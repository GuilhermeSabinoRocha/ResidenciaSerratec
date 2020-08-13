package appInternetBanking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class SistemaInterno  {

	public static void main(String[] args) throws IOException   {
		
		//criação do HashMap de contas
		//Conta.main(args);
		
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
		
		/*
		 * if (logado != null) {
		 */
			
			Usuario.primeiroMenu(logado);
		}
		*/
		
	//	System.out.println(mapUsers.keySet().toString());
		
		/*
		 * System.out.println("Escolha a operação desejada:"
				+ "\n1- Consultar Saldo\n2- Saque\n3- Depósito em Conta"
				+ "\n4- Informações da Conta \n5- Sair ");
				*/
				//realiza a operação escolhida
				//verificaOperacao(c);
				
	}
	


	

}