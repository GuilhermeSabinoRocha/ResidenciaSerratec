package appInternetBanking;

public class Cliente extends Usuario implements Movimentacoes implements Login {

	Cliente(String id, int CPF, String senha, String nome, String tipoConta, int numeroDaConta, int agencia,
			double saldo) {
		super(id, CPF, senha, nome, tipoConta, numeroDaConta, agencia, saldo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saca(double valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deposito(double valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferencia(Conta c, double valor) {
		// TODO Auto-generated method stub
		
	}

}
