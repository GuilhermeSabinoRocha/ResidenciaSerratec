package appInternetBanking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public abstract class Conta {

	String TipoConta;
	long CPFDoTitular;
	int numeroDaConta;
	int agencia;
	double saldo;
	
	
	
	Conta(String TipoConta, long CPFDoTitular, int numeroDaConta, int agencia, double saldo) {
		this.TipoConta = TipoConta;
		this.CPFDoTitular = CPFDoTitular;
		this.numeroDaConta =numeroDaConta;
		this.agencia = agencia;
		this.saldo = saldo;					
		
	}
	
	@Override
	public String toString() {
		return "[TipoConta=" + TipoConta+", CPFDoTitular=" + CPFDoTitular + ", numeroDaConta=" + numeroDaConta + ", agencia=" + agencia
				+ ", saldo=" + saldo + "]";
	}
	
	
	
	public static void movimentacoes(long c, Conta logada)
	{
		boolean sair = false;
		
		do {
			//Menu inicial
			System.out.println("Escolha a operação desejada:"
					+ "\n1- saque\n2- depósito\n3- transferencia\n 4-voltar ");
			Scanner scan = new Scanner(System.in);
			int op = scan.nextInt();			
			
			switch (op) {		
						
				
				//para saque
			case 1:
				System.out.println("Digite o valor do saque:");
				double valorASacar = new Scanner(System.in).nextDouble();
				//saque(valorASacar);
				
				if (verificaValor(valorASacar) && valorASacar <= logada.getSaldo()) {
					saque(valorASacar, logada);				
				}
				else {
					System.out.println("Não foi possível realizar a operação. Digite um valor válido.\n");
				}
				
				//realizar outra operação ou sair
				if (verificaSairDoSegundoMenu()) {
					System.out.println("Obrigado por utilizar o Internet Banking.");
					sair = true;
				}
				break;
				
				//para depósito	
			case 2:
				System.out.println("Digite o valor a depositar em sua conta");
				double valorADepositar = new Scanner(System.in).nextDouble();
				
				if (verificaValor(valorADepositar)) {
					deposito(valorADepositar, logada);				
				}
				else {
					System.out.println("Não foi posível realizar a operação. Digite um valor válido.\n");
				}
				
				//realizar outra operação ou sair
				if (verificaSairDoSegundoMenu()) {
					System.out.println("Obrigado por utilizar o Internet Banking.");
					sair = true;
				}
				
				break;
				
				//para Transferencia
			case 3:
				
				System.out.println("Digite a conta de destino");
				int contaDestino = new Scanner(System.in).nextInt();
				
				System.out.println("Digite o valor a transferir");
				double valorATransferir = new Scanner(System.in).nextDouble();
				
				//transferencia (valorATransferir, contaDestino);
				
				break;
				
				//para Voltar	
			case 4:
				
				if (verificaSairDoSegundoMenu()) {
					
					sair = true;
				}				
				
				break;			
				
			default:
				System.out.println("Opção inválida.\n");
				break;
			}
		} while (!sair);
	}
	
	//realizar outra operação ou voltar
	public static boolean verificaSairDoSegundoMenu() {
		int input1;
		do {
			System.out.println("Deseja realizar outra operação? Digite 1 para SIM e 2 para NÃO\n");
			input1 = new Scanner(System.in).nextInt();
		} while (input1 < 1 || input1 > 2);
		
		if (input1 == 2) {
			return true;
		}
		else {
			
			
			return false;
		}
	}
	
	
	public static void saque(double valorASacar, Conta logada)
	{
		
		logada.saldo -= valorASacar;
	}
	
	public static void deposito(double valorASacar, Conta logada)
	{
		
		logada.saldo += valorASacar;
	}
	
	/*public static void transferencia (double valor, int CPFDestino)
	{
		mapContas.get(CPFDestino);
	}*/
	
	public static boolean verificaValor(double valor) {
		if (valor > 0.0) {
			return true;
		}
		else {
			return false;
		}
	}
	
//	//para saldo
//case 1:
//	System.out.println(c.getSaldo() + "\n");						
//	
//	//realizar outra operação ou sair
//	if (verificaSairDoMenu()) {
//		System.out.println("Obrigado por utilizar o Internet Banking.");
//		sair = true;
//	}
							
		
	
	public String getTipoConta() {
		return TipoConta;
	}

	public int getNumeroDaConta() {
		return numeroDaConta;
	}

	public int getAgencia() {
		return agencia;
	}

	public double getSaldo() {
		return saldo;
	}
	
	
	
	
	/*
	 * 
			*/
	 
	// método saque

	
	
	// método deposito
	
	
	// método transferencia


	//Informaçoes da conta
	
	
	

}	
	
	



