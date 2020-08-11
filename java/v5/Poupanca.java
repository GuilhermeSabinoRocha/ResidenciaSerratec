package appInternetBanking;

public class Poupanca extends Conta {

	Poupanca(String TipoConta, long CPFDoTitular, int numeroDaConta, int agencia, double saldo) {
		super(TipoConta, CPFDoTitular, numeroDaConta, agencia, saldo);
		// TODO Auto-generated constructor stub
	}


	
	/*
	public void deposito(double valor) {
		this.saldo += valor;
		System.out.println("Depósito realizado com sucesso.\n");
		
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

		@Override
		public double getSaldo() {
			return this.saldo;
		}

		@Override
		public void saque(Movimentacoes c, double valor) {
			// TODO Auto-generated method stub
			
		}
*/
}
