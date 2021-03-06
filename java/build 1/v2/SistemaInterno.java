package appInternetBanking;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SistemaInterno  {

	public static void main(String[] args)  {
		//instancia a conta do correntista c/ nome, numeroDaConta e agencia
				Movimentacoes c = new Corrente(123457899, "corrente", 123456, 123456, 1200);
				//realiza a operação escolhida
				verificaOperacao(c);
				
	}
	
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
						c.saca(c, valorASacar);				
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

	

}
