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

	public static void main(String[] args) throws IOException  {

	String linha;
	Conta conta;
	Map<Long, Conta> mapContas = new HashMap<>();
	
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
	
		
	
	// método saque

	
	
	// método deposito
	
	
	// método transferencia


	//Informaçoes da conta
	
	
	}
}

