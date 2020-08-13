package appInternetBanking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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
	
	
	
	public static void saque(double valorASacar, Conta logada)
	{
		
		logada.saldo -= valorASacar;
	}
	
	public static void deposito(double valorASacar, Conta logada)
	{
		
		logada.saldo += valorASacar;
	}
	
	public static String transferencia (double transfValor, int transfConta, Conta logada, Map<Long, Conta> mapContas)
	{
		
		String retorno = "";
		
		if (mapContas.get(transfConta) != null) {
			Conta temporaria = mapContas.get(transfConta); 
			System.out.println("Digite o valor a transferir");
			double valorATransferir = new Scanner(System.in).nextDouble();
			
			if (verificaValor(valorATransferir) && valorATransferir <= logada.getSaldo() && logada.getTipoConta().equals("Corrente")) {
										
				logada.saldo -= valorATransferir;
				temporaria.saldo += valorATransferir;
				
				logada.saldo = logada.saldo - 0.2;
				logada.tarifacao += 0.2;
				return ("|   Transferencia realizada com sucesso!                                                   |");
													
			}
			else if(verificaValor(valorATransferir) && valorATransferir <= logada.getSaldo() && logada.getTipoConta().equals("Poupanca"))
			{
				logada.saldo -= valorATransferir;
				temporaria.saldo += valorATransferir;
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
	

	public static void relSaldo(Conta logada) throws IOException
	{
		FileWriter csvWriter = new FileWriter("simulacaoRelSaldo.txt");
		csvWriter.append("Saldo Atual: ");
		csvWriter.append("\n");
		csvWriter.append("R$" + logada.getSaldo());
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
	
	



