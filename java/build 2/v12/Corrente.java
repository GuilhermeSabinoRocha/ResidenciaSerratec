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

	

	
	
	
	public double getTarifacao() {
		return tarifacao;
	}

	public void setTarifacao(double tarifacao) {
		this.tarifacao = tarifacao;
	}

	

}
