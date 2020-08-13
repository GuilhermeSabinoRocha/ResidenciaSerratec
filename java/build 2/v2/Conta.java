package appInternetBanking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public abstract class Conta {

	String TipoConta;
	long CPFDoTitular;
	String nome;
	String tipoUsuario;
	int numeroDaConta;
	int agencia;
	double saldo;
	public double tarifacao;
	
	
	Conta(String TipoConta, long CPFDoTitular, String nome, String tipoUsuario, int numeroDaConta, int agencia, double saldo, double tarifacao) {
		this.TipoConta = TipoConta;
		this.CPFDoTitular = CPFDoTitular;
		this.nome = nome;
		this.tipoUsuario = tipoUsuario;
		this.numeroDaConta =numeroDaConta;
		this.agencia = agencia;
		this.saldo = saldo;					
		this.tarifacao = tarifacao;
	}
	
	@Override
	public String toString() {
		return "[TipoConta=" + TipoConta+", CPFDoTitular=" + CPFDoTitular + ", numeroDaConta=" + numeroDaConta + ", agencia=" + agencia
				+ ", saldo=" + saldo + "]";
	}
	
	
	
	public static void movimentacoes(long c, Conta logada, Map<Long, Conta> mapContas, Map<Integer, Conta> mapContasNumeroConta)
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
				
				if (verificaValor(valorASacar) && valorASacar <= logada.getSaldo() && logada.getTipoConta().equals("Corrente")) {
					saque(valorASacar, logada);	
					logada.saldo = logada.saldo - 0.1;
					logada.tarifacao += 0.1;
					System.out.println(logada.tarifacao);
					
				}
				else if (verificaValor(valorASacar) && valorASacar <= logada.getSaldo() && logada.getTipoConta().equals("Poupanca")) {
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
				
				if (verificaValor(valorADepositar) && logada.getTipoConta().equals("Corrente")) {
					deposito(valorADepositar, logada);
					logada.saldo = logada.saldo - 0.1;
					logada.tarifacao += 0.1;
					System.out.println(logada.tarifacao);
				}
				else if (verificaValor(valorADepositar) && logada.getTipoConta().equals("Poupanca")) {
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
				
				if (mapContasNumeroConta.get(contaDestino) != null) {
					Conta temporaria = mapContasNumeroConta.get(contaDestino); 
					System.out.println("Digite o valor a transferir");
					double valorATransferir = new Scanner(System.in).nextDouble();
					
					if (verificaValor(valorATransferir) && valorATransferir <= logada.getSaldo() && logada.getTipoConta().equals("Corrente")) {
												
						logada.saldo -= valorATransferir;
						temporaria.saldo += valorATransferir;
						
						logada.saldo = logada.saldo - 0.2;
						logada.tarifacao += 0.2;
															
					}
					else if(verificaValor(valorATransferir) && valorATransferir <= logada.getSaldo() && logada.getTipoConta().equals("Poupanca"))
					{
						logada.saldo -= valorATransferir;
						temporaria.saldo += valorATransferir;
						
					}
					else {
						System.out.println("Não foi possível realizar a operação. Digite um valor válido.\n");
					}
					
				}
				
				
				
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
	
	protected static void relatorios(long c, Conta logada, Map<Long, Conta> mapContas,
			Map<Integer, Conta> mapContasNumeroConta, List<Object> numeroAgencias) {
		
		
		
		if (logada.getTipoUsuario().equals("Cliente"))
		{
			if (logada.getTipoConta().equals("Corrente"))
			{
				System.out.println("Escolha a operação desejada:"
						+ "\n1- Saldo\n2- Relatório de Tarifação da Conta Corrente\n3- Informações sobre tarifas ");
				Scanner scan = new Scanner(System.in);
				int op = scan.nextInt();			
				
				switch (op) {
				case 1:
					logada.getSaldo();
					break;
				case 2:
					logada.getTarifacao();
					break;
					
				case 3:
					System.out.println("Para cada saque será cobrado o valor de R$0.10 (dez centavos);\n" + 
							"Para cada depósito será cobrado o valor de R$0.10 (dez centavos);\n" + 
							"Para cada transferência será cobrado o valor de R$0.20 (vinte centavos)+"
							+ "Valores válidos para conta corrente. Conta poupança não será tarifada");	
					break;
				default:
					break;
				}
			}
			else if (logada.getTipoConta().equals("Poupanca"))
			{
				System.out.println("Escolha a operação desejada:"
						+ "\n1- Saldo\n2- Relatório de de Rendimentos da Poupança");
				Scanner scan = new Scanner(System.in);
				int op = scan.nextInt();			
				
				switch (op) {
				case 1:
					logada.getSaldo();
					break;
				case 2:
					relRendimentosPoup(logada);
					break;
					
				
				default:
					break;
				}
			}
		}
			
		
			
		
		if (logada.getTipoUsuario().equals("Gerente"))
		{
			if (logada.getTipoConta().equals("Corrente"))
			{
				System.out.println("Escolha a operação desejada:"
						+ "\n1- Saldo\n2- Relatório de Tarifação da Conta Corrente\n3- Informações sobre tarifas "
				+ "\n4- Relatório de contas gerenciadas");
				Scanner scan = new Scanner(System.in);
				int op = scan.nextInt();			
				
				switch (op) {
				case 1:
					logada.getSaldo();
					break;
				case 2:
					logada.getTarifacao();
					break;
					
				case 3:
					System.out.println("Para cada saque será cobrado o valor de R$0.10 (dez centavos);\n" + 
							"Para cada depósito será cobrado o valor de R$0.10 (dez centavos);\n" + 
							"Para cada transferência será cobrado o valor de R$0.20 (vinte centavos)+"
							+ "Valores válidos para conta corrente. Conta poupança não será tarifada");	
					break;
					
				case 4:
					System.out.println("Número de contas gerenciadas na mesma agência:");
					int contador = 0;
					/*
					Iterator itr = numeroAgencias.iterator();
					while(itr.hasNext()){  
		                Conta st=(Conta)itr.next();  
		                if(st.getAgencia() == logada.getAgencia())
		                {
		                	contador++;
		                }
					}
					*/
					for (Object object : numeroAgencias) {
						Conta temp = (Conta)object;
						 if(temp.getAgencia() == logada.getAgencia())
			                {
			                	contador++;
			                }
					}
					
					System.out.println(contador);
					
					
					break;
				default:
					break;
				}
			}
			else if (logada.getTipoConta().equals("Poupanca"))
			{
				System.out.println("Escolha a operação desejada:"
						+ "\n1- Saldo\n2- Relatório de de Rendimentos da Poupança"
						+ "\n3- Relatório de contas gerenciadas");
				Scanner scan = new Scanner(System.in);
				int op = scan.nextInt();			
				
				switch (op) {
				case 1:
					logada.getSaldo();
					break;
				case 2:
					relRendimentosPoup(logada);
					break;
				case 3:
					System.out.println("Número de contas gerenciadas na mesma agência:");
					int contador = 0;
					/*
					Iterator itr = numeroAgencias.iterator();
					while(itr.hasNext()){  
		                Conta st=(Conta)itr.next();  
		                if(st.getAgencia() == logada.getAgencia())
		                {
		                	contador++;
		                }
					}
					*/
					for (Object object : numeroAgencias) {
						Conta temp = (Conta)object;
						 if(temp.getAgencia() == logada.getAgencia())
			                {
			                	contador++;
			                }
					}
					
					System.out.println(contador);
					break;
				default:
					break;
				}
			}
		}
			
				
				
				
				
					
				
						
						
						
						
						
		if (logada.getTipoUsuario().equals("Diretor"))
		{
			if (logada.getTipoConta().equals("Corrente"))
			{
				System.out.println("Escolha a operação desejada:"
						+ "\n1- Saldo\n2- Relatório de Tarifação da Conta Corrente\n3- Informações sobre tarifas "
				+ "\n4- Informações dos Clientes do Sistema");
				Scanner scan = new Scanner(System.in);
				int op = scan.nextInt();			
				
				switch (op) {
				case 1:
					logada.getSaldo();
					break;
				case 2:
					logada.getTarifacao();
					break;
					
				case 3:
					System.out.println("Para cada saque será cobrado o valor de R$0.10 (dez centavos);\n" + 
							"Para cada depósito será cobrado o valor de R$0.10 (dez centavos);\n" + 
							"Para cada transferência será cobrado o valor de R$0.20 (vinte centavos)+"
							+ "Valores válidos para conta corrente. Conta poupança não será tarifada");	
					break;
					
				case 4:
					System.out.println("Informações dos Clientes do Sistema:");
					for (Object object : numeroAgencias) {
						Conta temp = (Conta)object;
						System.out.println(temp.getNome() + temp.getCPFDoTitular()+ temp.getAgencia()); 
					}
					break;
				default:
					break;
				}
			}
			else if (logada.getTipoConta().equals("Poupanca"))
			{
				System.out.println("Escolha a operação desejada:"
						+ "\n1- Saldo\n2- Relatório de de Rendimentos da Poupança"
						+ "\n3- Relatório de contas gerenciadas");
				Scanner scan = new Scanner(System.in);
				int op = scan.nextInt();			
				
				switch (op) {
				case 1:
					logada.getSaldo();
					break;
				case 2:
					relRendimentosPoup(logada);
					break;
				case 3:
					System.out.println("Número de contas gerenciadas na mesma agência:");
					break;
				
				default:
					break;
				}
			}
		}
			
	
			
			
			
		
		
			
		
				
		
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
	

	
	public static void relRendimentosPoup(Conta logada)
	{
		System.out.println("Simule no prazo desejado:"
				+ "\n1- 7 dias\n2- 15 dias\n3 - 30 dias");
		Scanner scan = new Scanner(System.in);
		int op = scan.nextInt();			
		
		switch (op) {
		case 1:
			System.out.println(logada.getSaldo()*1.0003);
			break;
		case 2:
			System.out.println(logada.getSaldo()*1.0006);
			break;
		case 3:
			System.out.println(logada.getSaldo()*1.001303);	
			break;
		default:
			break;
		}
	}
	

	

	
	public long getCPFDoTitular() {
		return CPFDoTitular;
	}

	public String getNome() {
		return nome;
	}

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
	
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	
	public double getTarifacao() {
		return tarifacao;
	}

	
}	
	
	



