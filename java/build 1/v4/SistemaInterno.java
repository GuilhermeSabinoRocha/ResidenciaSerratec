package appInternetBanking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



public class SistemaInterno  {

	public static void main(String[] args) throws IOException {
		
		String linha;
		Usuario user;
		List<Usuario> todos = new ArrayList<>();
		
		BufferedReader csvReader = new BufferedReader(new FileReader("Accounts.csv"));
		
		while ((linha = csvReader.readLine()) != null) {
			
			String tipoUsuario;
			long CPF;
			long senha;
			String nome;
			String TipoConta;
			int numeroConta;
			int agencia;
			double saldo;
			
			String[] data = linha.split(",");
			tipoUsuario = data[0];
			CPF = Long.parseLong(data[1]);
			senha = Long.parseLong(data[2]);
			nome = data[3];
			TipoConta = data[4];
			numeroConta = Integer.parseInt(data[5]);
			agencia = Integer.parseInt(data[6]);
			saldo = Integer.parseInt(data[7]);	
			
			switch (tipoUsuario) {
			
			case "Cliente":
				
				user = new Cliente(tipoUsuario, CPF, senha, nome, TipoConta, numeroConta, agencia, saldo);				
				todos.add(user);
				break;
				
			case "Gerente":
				
				user = new Gerente(tipoUsuario, CPF, senha, nome, TipoConta, numeroConta, agencia, saldo);				
				todos.add(user);
				break;
				
			case "Diretor":
	
				user = new Diretor(tipoUsuario, CPF, senha, nome, TipoConta, numeroConta, agencia, saldo);				
				todos.add(user);
				break;
	
			case "Presidente":
	
				user = new Presidente(tipoUsuario, CPF, senha, nome, TipoConta, numeroConta, agencia, saldo);				
				todos.add(user);
				break;
	
			}
					
			
		}
		
		//Cliente primeiro = (Cliente) todos.get(9);
		
		System.out.println(todos.get(6).toString());
		
		csvReader.close();
		

				//realiza a operação escolhida
				//verificaOperacao(c);
				
	}
/*	
public static void verificaOperacao(Movimentacoes c) {
		
		boolean sair = false;
		
			do {
				//Menu inicial
				System.out.println("Escolha a operação desejada:"
						+ "\n1- Consultar Saldo\n2- Saque\n3- Depósito em Conta"
						+ "\n4- Informações da Conta \n5- Sair ");
				Scanner scan = new Scanner(System.in);
				int op = scan.nextInt();			
				
				switch (op) {
				
				//para saldo
				case 1:
					System.out.println(c.getSaldo() + "\n");						
					
					//realizar outra operação ou sair
					if (verificaSairDoMenu()) {
						System.out.println("Obrigado por utilizar o Internet Banking.");
						sair = true;
					}
											
					break;
					
					
					//para saque
				case 2:
					System.out.println("Digite o valor do saque:");
					double valorASacar = new Scanner(System.in).nextDouble();
					if (c.verificaValor(valorASacar) && valorASacar <= c.getSaldo()) {
						c.saque(c, valorASacar);				
					}
					else {
						System.out.println("Não foi possível realizar a operação. Digite um valor válido.\n");
					}
					//realizar outra operação ou sair
					if (verificaSairDoMenu()) {
						System.out.println("Obrigado por utilizar o Internet Banking.");
						sair = true;
					}
					break;
					
					//para depósito	
				case 3:
					System.out.println("Digite o valor a depositar em sua conta");
					double valorADepositar = new Scanner(System.in).nextDouble();
					if (c.verificaValor(valorADepositar)) {
						c.deposito(valorADepositar);				
					}
					else {
						System.out.println("Não foi posível realizar a operação. Digite um valor válido.\n");
					}
					//realizar outra operação ou sair
					if (verificaSairDoMenu()) {
						System.out.println("Obrigado por utilizar o Internet Banking.");
						sair = true;
					}
					
					break;
					
					//para info
				case 4:
					System.out.println(c.toString() + "\n");
					break;
					
					//para sair	
				case 5:
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

	*/

}
