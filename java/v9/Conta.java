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
	static Map<Long, Conta> mapContas = new HashMap<>();
	
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
	
	//leitura do .csv e criação do HashMap de contas
	public static void main(String[] args) throws IOException  {

	String linha;
	Conta conta;
	
	BufferedReader csvReader = new BufferedReader(new FileReader("Accounts.csv"));
	
	linha = csvReader.readLine();
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
		saldo = Double.parseDouble(data[7]);			
		
		switch (TipoConta) {
		
		case "Corrente":
			
			conta = new Corrente(TipoConta,CPF, numeroConta, agencia, saldo);				
			mapContas.put(CPF, conta);
			break;
			
		case "Poupanca":
			
			conta = new Poupanca(TipoConta,CPF, numeroConta, agencia, saldo);				
			mapContas.put(CPF, conta);
			break;	

		}
	}
	csvReader.close();
	
	}

	
	
	public static void movimentacoes(Usuario c)
	{
		boolean sair = false;
		
		do {
			//Menu inicial
			System.out.println("Escolha a operação desejada:"
					+ "\n1- saque\n2- depósito\n3- voltar ");
			Scanner scan = new Scanner(System.in);
			int op = scan.nextInt();			
			
			switch (op) {		
						
				
				//para saque
			case 1:
				System.out.println("Digite o valor do saque:");
				double valorASacar = new Scanner(System.in).nextDouble();
				saque(valorASacar);
				
				/*if (c.verificaValor(valorASacar) && valorASacar <= c.getSaldo()) {
					c.saque(c, valorASacar);				
				}
				else {
					System.out.println("Não foi possível realizar a operação. Digite um valor válido.\n");
				}*/
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
				if (c.verificaValor(valorADepositar)) {
					//c.deposito(valorADepositar);				
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
				
				
				break;
				
				//para Voltar	
			case 4:
				System.out.println("Obrigado por utilizar o Internet Banking.");
				sair = true;
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
			
			if (input1 ==2) {
				return true;
			}
			else {
				
				
				return false;
			}
		}
	
	public static void saque(double valorASacar)
	{
		
		if (verificaValor(valorASacar) && valorASacar <= getSaldo()) {
			;				
		}
	}
	
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
	
	



