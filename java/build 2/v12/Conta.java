package appInternetBanking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public abstract class Conta {

	String TipoConta;
	long CPFDoTitular;
	String nome;
	String tipoUsuario;
	int numeroDaConta;
	int agencia;
	double saldo;
	double tarifacao;
	
	
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
	
	
	
	public static void saque(double valorASacar, Conta logada) throws IOException
	{
		 
		if (verificaValor(valorASacar) && valorASacar <= logada.getSaldo() && logada.getTipoConta().equals("Corrente")) {
			
						
			try{
				  FileWriter fstream = new FileWriter("aRelMovimentacao.txt",true);
				  BufferedWriter out = new BufferedWriter(fstream);
				  logada.saldo -= 0.1;
					logada.saldo -= valorASacar;			 
					logada.tarifacao += 0.1;
				  
					out.write("Saque de " + appUtil.formataMoeda(valorASacar) + " efetuado. \n");
					out.write("Saldo Atual: \n");
					out.write("R$" + appUtil.formataMoeda(logada.getSaldo()) + "\n\n");
					
				  out.close();
			  }catch (Exception e){
				 System.err.println("Erro ao escrever no arquivo: " +
			          e.getMessage());
			  }
			
			
		}
		else if (verificaValor(valorASacar) && valorASacar <= logada.getSaldo() && logada.getTipoConta().equals("Poupanca")) {
			
			
			try{
				  FileWriter fstream = new FileWriter("aRelMovimentacao.txt",true);
				  BufferedWriter out = new BufferedWriter(fstream);
				  logada.saldo -= valorASacar;	
				  
					out.write("Saque de " + appUtil.formataMoeda(valorASacar) + " efetuado. \n");
					out.write("Saldo Atual: \n");
					out.write("R$" + appUtil.formataMoeda(logada.getSaldo()) + "\n\n");
					
				  out.close();
			  }catch (Exception e){
				 System.err.println("Erro ao escrever no arquivo: " +
			          e.getMessage());
			  }
			
		}			
	
	}
	
	public static void deposito(double valorASacar, Conta logada) throws IOException
	{
		
if (verificaValor(valorASacar) && valorASacar <= logada.getSaldo() && logada.getTipoConta().equals("Corrente")) {
			
	try{
		  FileWriter fstream = new FileWriter("aRelMovimentacao.txt",true);
		  BufferedWriter out = new BufferedWriter(fstream);
		  logada.saldo -= 0.1;
			 logada.saldo += valorASacar;			 
			 logada.tarifacao += 0.1;
		  
			out.write("Depósito de " + appUtil.formataMoeda(valorASacar) + " efetuado. \n");
			out.write("Saldo Atual: \n");
			out.write("R$" + appUtil.formataMoeda(logada.getSaldo()) + "\n\n");
			
		  out.close();
	  }catch (Exception e){
		 System.err.println("Erro ao escrever no arquivo: " +
	          e.getMessage());
	  }
	
	
		}
		else if (verificaValor(valorASacar) && valorASacar <= logada.getSaldo() && logada.getTipoConta().equals("Poupanca")) {
			
			try{
				  FileWriter fstream = new FileWriter("aRelMovimentacao.txt",true);
				  BufferedWriter out = new BufferedWriter(fstream);
					 
					 logada.saldo += valorASacar;
					out.write("Depósito de " + appUtil.formataMoeda(valorASacar) + " efetuado. \n");
					out.write("Saldo Atual: \n");
					out.write("R$" + appUtil.formataMoeda(logada.getSaldo()) + "\n\n");
					
				  out.close();
			  }catch (Exception e){
				 System.err.println("Erro ao escrever no arquivo: " +
			          e.getMessage());
			  }
			
			
		}	
		
	
	}
	
	public static String transferencia (double transfValor, int transfConta, Conta logada, Map<Long, Conta> mapContas, Map<Integer, Conta> mapContasNumeroConta) throws IOException
	{
				
String retorno = "";
		
		if (mapContasNumeroConta.get(transfConta) != null) {
			Conta temporaria = mapContasNumeroConta.get(transfConta); 
						
			if (verificaValor(transfValor) && transfValor <= logada.getSaldo() && logada.getTipoConta().equals("Corrente")) {
										
				
				try{
					  FileWriter fstream = new FileWriter("aRelMovimentacao.txt",true);
					  BufferedWriter out = new BufferedWriter(fstream);
						 
					  logada.saldo -= transfValor;
					  temporaria.saldo += transfValor;
					  
					  logada.saldo = logada.saldo - 0.2;
					  logada.tarifacao += 0.2;
					  
						out.write("Transferência de " + appUtil.formataMoeda(transfValor) + " efetuado. \n");
						out.write("Saldo Atual: \n");
						out.write("R$" + appUtil.formataMoeda(logada.getSaldo()) + "\n\n");
						
					  out.close();
				  }catch (Exception e){
					 System.err.println("Erro ao escrever no arquivo: " +
				          e.getMessage());
				  }
				
			
				return ("|   Transferencia realizada com sucesso!                                                   |");
													
			}
			else if(verificaValor(transfValor) && transfValor <= logada.getSaldo() && logada.getTipoConta().equals("Poupanca"))
			{
				
				
				try{
					  FileWriter fstream = new FileWriter("aRelMovimentacao.txt",true);
					  BufferedWriter out = new BufferedWriter(fstream);
						 
					  logada.saldo -= transfValor;
					  temporaria.saldo += transfValor;
					 
					  
						out.write("Transferência de " + appUtil.formataMoeda(transfValor) + " efetuado. \n");
						out.write("Saldo Atual: \n");
						out.write("R$" + appUtil.formataMoeda(logada.getSaldo()) + "\n\n");
						
					  out.close();
				  }catch (Exception e){
					 System.err.println("Erro ao escrever no arquivo: " +
				          e.getMessage());
				  }
				
			
				return retorno;
			}
			else {
				return retorno;
				
			}
			
		}
		return retorno;
		
	}
	
	public static boolean verificaValor(double valor) {
		if (valor > 0.0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	/*public static void RelMovimentacao(Conta logada) throws IOException
	{
	//BufferedReader csvReader = new BufferedReader(new FileReader("Accounts.csv"));
	
	 BufferedReader br = new BufferedReader(new FileReader("RelMovimentacao.txt"));
	 
	 while (br != null) {
		 
		
	}
	 br.close();
	 

       
	
	
	}*/
	
	public static void saidaRelMovimentacao(Conta logada) throws IOException
	{
		FileWriter csvWriter = new FileWriter("RelMovimentacao.txt");
		csvWriter.append("Saldo Atual: ");
		csvWriter.append("\n");
		csvWriter.append("R$" + logada.getSaldo());
		csvWriter.flush();
		csvWriter.close();
	}
	
	
	public static void saidaRelSaldo(Conta logada) throws IOException
	{
		FileWriter csvWriter = new FileWriter("simulacaoRelSaldo.txt");
		csvWriter.append("Saldo Atual: ");
		csvWriter.append("\n");
		csvWriter.append("R$" + logada.getSaldo());
		csvWriter.flush();
		csvWriter.close();
	}
	
	
	public static void saidaRelTarifacao(Conta logada) throws IOException
	{
		FileWriter csvWriter = new FileWriter("relTarifacao.txt");
		csvWriter.append("Total de tarifas aplicadas na conta Corrente");
		csvWriter.append("\n");
		csvWriter.append("R$" + logada.getTarifacao());
		csvWriter.flush();
		csvWriter.close();
	}
	
	public void relInfoTarifacao()
	{
		System.out.println("Para cada saque será cobrado o valor de R$0.10 (dez centavos);\n" + 
				"Para cada depósito será cobrado o valor de R$0.10 (dez centavos);\n" + 
				"Para cada transferência será cobrado o valor de R$0.20 (vinte centavos)\n"
				+ "Valores válidos para conta corrente. Conta poupança não será tarifada");
	}

	public static void saidaRelInfoTarifacao( ) throws IOException
	{
		FileWriter csvWriter = new FileWriter("relInfoTarifacao.txt");
		csvWriter.append("Informações sobre tarifas");
		csvWriter.append("\n");
		csvWriter.append("Para cada saque será cobrado o valor de R$0.10 (dez centavos);\n" + 
				"Para cada depósito será cobrado o valor de R$0.10 (dez centavos);\n" + 
				"Para cada transferência será cobrado o valor de R$0.20 (vinte centavos)\n"
				+ "Valores válidos para conta corrente. Conta poupança não será tarifada");
		csvWriter.flush();
		csvWriter.close();
	}
	
	
	public static void relRendimentosPoup(Conta logada) throws IOException
	{
		System.out.println("Simule no prazo desejado:"
				+ "\n1- 7 dias\n2- 15 dias\n3 - 30 dias");
		Scanner scan = new Scanner(System.in);
		int op = scan.nextInt();			
		
		switch (op) {
		case 1:
			double taxa = 1.0003;
			double simulacao = (logada.getSaldo()*taxa) - logada.getSaldo();
			System.out.println(simulacao);
			saidaRelRendimentosPoup(simulacao,"7 dias");
			break;
		case 2:
			
			double taxa2 = 1.0006;
			double simulacao2 = logada.getSaldo()*taxa2 - logada.getSaldo();
			System.out.println(simulacao2);
			saidaRelRendimentosPoup(simulacao2,"15 dias");
		
			break;
		case 3:
			
			double taxa3 = 1.001303;
			double simulacao3 = logada.getSaldo()*taxa3 - logada.getSaldo();
			System.out.println(simulacao3);
			saidaRelRendimentosPoup(simulacao3,"30 dias");
						
			break;
		default:
			break;
		}
	}
	
	//txt do relRendimentosPoup
	
			public static void saidaRelRendimentosPoup(double simulacao, String prazo) throws IOException
			{
				FileWriter csvWriter = new FileWriter("simulacaoRelPoup.txt");
				csvWriter.append("Simulação de rendimento da conta Poupança - "
						+ prazo);
				csvWriter.append("\n");
				csvWriter.append("R$" + simulacao);
				csvWriter.flush();
				csvWriter.close();
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
	
	



