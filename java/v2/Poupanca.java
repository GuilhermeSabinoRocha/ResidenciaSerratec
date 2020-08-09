package appInternetBanking;

public class Poupanca extends Conta implements Movimentacoes {

	String tipo;
		
	Poupanca(int CPFDoTitular, String tipo, int numeroDaConta, int agencia, double saldo) {
			
			super(CPFDoTitular, numeroDaConta, agencia, saldo);
			this.tipo = tipo;
			
		}
	
	
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
		public void saca(Movimentacoes c, double valor) {
			// TODO Auto-generated method stub
			
		}

}
