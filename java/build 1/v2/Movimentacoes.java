package appInternetBanking;

public interface Movimentacoes {
	
	void saca(Movimentacoes c, double valor);
	void deposito(double valor);
	//void transferencia (Conta c, double valor);
	double getSaldo();
	// verifica se valor é positivo
	public boolean verificaValor(double valor);


}
