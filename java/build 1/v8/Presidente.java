package appInternetBanking;

public class Presidente extends Administracao implements RelatoriosComuns,  RelatorioGerencia, RelatorioDiretoria, RelatorioPresidencia {

	String cargo = "Presidente";
	
	Presidente(String tipoUsuario, long CPF, long senha, String nome, String TipoConta, int numeroConta, int agencia,
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

	@Override
	public void transferencia(Conta c, double valor) {
		// TODO Auto-generated method stub
		
	} 

	*/
	
}
