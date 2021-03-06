package appInternetBanking;

public class Conta {
private static int totalDeContas = 0;
	
	Conta(String titular, int numeroDaConta, int agencia) {
		this.titular = titular;
		this.numeroDaConta =numeroDaConta;
		this.agencia = agencia;
		this.saldo = 0;
		Conta.totalDeContas += 1;
		this.id = Conta.totalDeContas;			
	}

	private String titular;
	private int numeroDaConta;
	private int agencia;
	private double saldo;
	private int id;

	//getSaldo
	public double getSaldo() {
		return Math.floor(this.saldo);
	}
	
	// método saque

	void saca(double valor) {
		this.saldo -= valor;
		System.out.println("Saque realizado com sucesso.\n");
		
	}
	
	// método deposito

	void deposito(double valor) {
		this.saldo += valor;
		System.out.println("Depósito realizado com sucesso.\n");
		
	}
	
	//Informaçoes da conta
	@Override
	public String toString() {
	return ("Titular = " + titular + "\nNúmero da Conta = " + numeroDaConta + 
			"\nAgência = " + agencia + "\nId = " + id);
	}
	
	// verifica se valor é positivo
	public boolean verificaValor(double valor) {
		if (valor > 0.0) {
			return true;
		}
		else {
			return false;
		}
	}


}
