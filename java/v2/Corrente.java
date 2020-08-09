package appInternetBanking;

public class Corrente extends Conta implements Movimentacoes {

	String tipo;
	
	Corrente(int CPFDoTitular, String tipo, int numeroDaConta, int agencia, double saldo) {
		
		super(CPFDoTitular, numeroDaConta, agencia, saldo);
		this.tipo = tipo;
		
	}

	@Override
	public void saca(Movimentacoes c, double valor) {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public void transferencia(Conta c, double valor) {
		// TODO Auto-generated method stub
		
	}*/

	@Override
	public void deposito(double valor) {
		// TODO Auto-generated method stub
		
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

	
	
	

}
