package appInternetBanking;

public class Usuario {
	
	String id;
	int CPF;
	String senha;
	String nome;
	String tipoConta;
	int numeroDaConta;
	int agencia;
	double saldo;
		
		Usuario(String id, int CPF, String senha, String nome, String tipoConta, int numeroDaConta, int agencia, double saldo) {
			
			this.id = id;
			this.CPF = CPF;
			this.senha = senha;
			this.nome =nome;
			this.tipoConta = tipoConta;
			this.numeroDaConta = numeroDaConta;
			this.agencia = agencia;
			this.saldo = saldo;
						
		}		
}
