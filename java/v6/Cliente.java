package appInternetBanking;

public class Cliente extends Usuario implements RelatoriosComuns {

	

	public Cliente(String tipoUsuario, long CPF, long senha, String nome, String TipoConta, int numeroConta,
			int agencia, double saldo) {
		super(tipoUsuario, CPF, senha, nome, TipoConta, numeroConta, agencia, saldo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cliente [tipoUsuario=" + tipoUsuario + ", CPF=" + CPF + ", senha=" + senha + ", nome=" + nome
				+ ", TipoConta=" + TipoConta + ", numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo="
				+ saldo + "]";
	}

	
	/*@Override
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
	*/

}
