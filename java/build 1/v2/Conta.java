package appInternetBanking;

public abstract class Conta {

	int CPFDoTitular;
	int numeroDaConta;
	int agencia;
	double saldo;
	
	Conta(int CPF, int numeroDaConta, int agencia, double saldo) {
		this.CPFDoTitular = CPF;
		this.numeroDaConta =numeroDaConta;
		this.agencia = agencia;
		this.saldo = saldo;
					
	}

	
	
	// método saque

	
	
	// método deposito

	
	
	//Informaçoes da conta
	@Override
	public String toString() {
	return ("Titular = " + CPFDoTitular + "\nNúmero da Conta = " + numeroDaConta + 
			"\nAgência = " + agencia);
	}
	
	

}
