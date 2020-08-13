package appInternetBanking;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Presidente extends AltaAdministracao {

	String cargo = "Presidente";

	public Presidente(String tipoUsuario, long CPF, long senha, String nome, String tipoConta) {
		super(tipoUsuario, CPF, senha, nome, tipoConta);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Presidente [" + (cargo != null ? "cargo=" + cargo + ", " : "")
				+ (tipoUsuario != null ? "tipoUsuario=" + tipoUsuario + ", " : "") + "CPF=" + CPF + ", senha=" + senha
				+ ", " + (nome != null ? "nome=" + nome + ", " : "")
				+ (tipoConta != null ? "tipoConta=" + tipoConta : "") + "]";
	}

	
	//csv do relatorio do presidente
			public static void relCapitalTotal(List<Object> numeroAgencias) throws IOException {
				System.out.println("Capital Total =");
				double capitalTotal = 0;
				for (Object object : numeroAgencias) {
					Conta temp = (Conta)object;
					capitalTotal += temp.getSaldo() + temp.getTarifacao();
				}
				System.out.println(capitalTotal); 
				saidarelContasGerenciadas(capitalTotal);
			}
		
			
			public static void saidarelContasGerenciadas(double capitalTotal) throws IOException
			{
				int max = 1000000000; 
		        int min = 1; 
		        int range = max - min + 1; 
		  
		        
	            int rand = (int)(Math.random() * range) + min; 
		            
	            String temp = "relCapitalTotal" + rand + ".txt";
				
				
				FileWriter csvWriter = new FileWriter("relCapitalTotal.txt");
				csvWriter.append("Relatório - Capital Total do Banco : " + "R$" + capitalTotal);
				csvWriter.flush();
				csvWriter.close();
			}
	
}
