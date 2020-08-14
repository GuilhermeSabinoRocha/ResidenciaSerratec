package appInternetBanking;

public class SeguroVida {
			 

	    public static boolean contrata(double valSeguro, Usuario usuarioLogado, Conta contaLogada) {
	        
	    	
	    	double tarifaSeguro = valSeguro*0.2;
	    	
	    	if(!(Conta.verificaValor(tarifaSeguro) && tarifaSeguro <= contaLogada.getSaldo()))
			{
	    		return false;
		
			}
	    	
	    	else
	    	{
	    		contaLogada.saldo -= tarifaSeguro;
	    		contaLogada.tarifacao += tarifaSeguro;
	    		return true;
	    	}
	    }
 

	
}
