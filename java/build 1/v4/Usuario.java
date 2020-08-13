package appInternetBanking;

public class Usuario {
	
	String tipoUsuario;
	long CPF;
	long senha;
	String nome;
	String TipoConta;
	int numeroConta;
	int agencia;
	double saldo;
		
		Usuario(String tipoUsuario, long CPF, long senha, String nome, String TipoConta, int numeroConta, int agencia,double saldo) {
			
			this.tipoUsuario = tipoUsuario;
			this.CPF= CPF;
			this.senha = senha;
			this.nome = nome;
			this.TipoConta = TipoConta;
			this.numeroConta = numeroConta;
			this.agencia = agencia;
			this.saldo = saldo;
						
		}

		@Override
		public String toString() {
			return "Usuario [tipoUsuario=" + tipoUsuario + ", CPF=" + CPF + ", senha=" + senha + ", nome=" + nome
					+ ", TipoConta=" + TipoConta + ", numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo="
					+ saldo + "]";
		}	
		
		
} 
