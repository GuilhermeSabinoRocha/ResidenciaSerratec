package appInternetBanking;

import java.io.FileWriter;
import java.io.IOException;

public class Corrente extends Conta {		
	

	public Corrente(String TipoConta, long CPFDoTitular, String nome, String tipoUsuario, int numeroDaConta,
			int agencia, double saldo, double tarifacao) {
		super(TipoConta, CPFDoTitular, nome, tipoUsuario, numeroDaConta, agencia, saldo, tarifacao);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public String toString() {
		return " [" + (TipoConta != null ? "TipoConta=" + TipoConta + ", " : "") + "CPFDoTitular="
				+ CPFDoTitular + ", " + (tipoUsuario != null ? "tipoUsuario=" + tipoUsuario + ", " : "")
				+ "numeroDaConta=" + numeroDaConta + ", agencia=" + agencia + ", saldo=" + saldo + ", tarifacao="
				+ tarifacao + "]";
	}

	public void relTarifacao(Conta logada)
	{
		System.out.println("R$"+ this.getTarifacao());
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
				"Para cada transferência será cobrado o valor de R$0.20 (vinte centavos)+"
				+ "Valores válidos para conta corrente. Conta poupança não será tarifada");
	}

	public static void saidaRelInfoTarifacao( ) throws IOException
	{
		FileWriter csvWriter = new FileWriter("relInfoTarifacao.txt");
		csvWriter.append("Informações sobre tarifas");
		csvWriter.append("\n");
		csvWriter.append("Para cada saque será cobrado o valor de R$0.10 (dez centavos);\n" + 
				"Para cada depósito será cobrado o valor de R$0.10 (dez centavos);\n" + 
				"Para cada transferência será cobrado o valor de R$0.20 (vinte centavos)+"
				+ "Valores válidos para conta corrente. Conta poupança não será tarifada");
		csvWriter.flush();
		csvWriter.close();
	}
	
	public double getTarifacao() {
		return tarifacao;
	}

	public void setTarifacao(double tarifacao) {
		this.tarifacao = tarifacao;
	}

	

}
