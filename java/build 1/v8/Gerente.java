package appInternetBanking;

public class Gerente extends Administracao implements RelatoriosComuns,  RelatorioGerencia {

	String cargo = "Gerente";
	
	Gerente(String tipoUsuario, long CPF, long senha, String nome, String TipoConta, int numeroConta, int agencia,
			double saldo) {
		super(tipoUsuario, CPF, senha, nome, TipoConta, numeroConta, agencia, saldo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "[Cargo = " + cargo + ", CPF = " + CPF + ", nome = " + nome
				+ ", agencia=" + agencia + "]";
	}
	

	



/*
	@Override
	public void saca(double valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deposito(double valor) {
		// TODO Auto-generated method stub
		
	}
*/
	
}