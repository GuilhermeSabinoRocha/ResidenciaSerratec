package appInternetBanking;

public class Diretor extends Administracao implements RelatoriosComuns,  RelatorioGerencia, RelatorioDiretoria  {

	Diretor(String tipoUsuario, long CPF, long senha, String nome, String TipoConta, int numeroConta, int agencia,
			double saldo) {
		super(tipoUsuario, CPF, senha, nome, TipoConta, numeroConta, agencia, saldo);
		// TODO Auto-generated constructor stub
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
