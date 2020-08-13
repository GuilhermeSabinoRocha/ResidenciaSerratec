package appInternetBanking;

public abstract class Conta {

	long CPFDoTitular;
	int numeroDaConta;
	int agencia;
	double saldo;
	
	Conta(long CPFDoTitular, int numeroDaConta, int agencia, double saldo) {
		this.CPFDoTitular = CPFDoTitular;
		this.numeroDaConta =numeroDaConta;
		this.agencia = agencia;
		this.saldo = saldo;
					
	}

	
	
	// método saque

	
	
	// método deposito
	
	
	// método transferencia

	
	/*
	//Informaçoes da conta
	@Override
	public String toString() {
	return ("Titular = " + CPFDoTitular + "\nNúmero da Conta = " + numeroDaConta + 
			"\nAgência = " + agencia);
	}
	*/
	

}
