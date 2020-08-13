package appInternetBanking;

import java.util.*;

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
			return tipoUsuario + " [tipoUsuario=" + tipoUsuario + ", CPF=" + CPF + ", senha=" + senha + ", nome=" + nome
					+ ", TipoConta=" + TipoConta + ", numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo="
					+ saldo + "]";
		}
		
				
			
		
		

		public String getTipoUsuario() {
			return tipoUsuario;
		}

		public void setTipoUsuario(String tipoUsuario) {
			this.tipoUsuario = tipoUsuario;
		}

		public long getCPF() {
			return CPF;
		}

		public long getSenha() {
			return senha;
		}

		public String getNome() {
			return nome;
		}

		public String getTipoConta() {
			return TipoConta;
		}

		public int getNumeroConta() {
			return numeroConta;
		}

		public int getAgencia() {
			return agencia;
		}

		public double getSaldo() {
			return saldo;
		}

		public boolean verificaValor(double valorASacar) {
			// TODO Auto-generated method stub
			return false;
		}

		public void saque(Usuario c, double valorASacar) {
			// TODO Auto-generated method stub
			
		}

		public void deposito(double valorADepositar) {
			// TODO Auto-generated method stub
			
		}
		
		
		

		

		
		
		
} 
