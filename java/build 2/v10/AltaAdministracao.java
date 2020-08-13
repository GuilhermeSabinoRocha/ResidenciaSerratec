package appInternetBanking;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AltaAdministracao extends Administracao {

	public AltaAdministracao(String tipoUsuario, long CPF, long senha, String nome, String tipoConta) {
		super(tipoUsuario, CPF, senha, nome, tipoConta);
		// TODO Auto-generated constructor stub
	}

	public void relinfoClientes(Conta logada, List<Object> numeroAgencias) throws IOException
	{
		System.out.println("Informações dos Clientes do Sistema:");
		for (Object object : numeroAgencias) {
			Conta temp = (Conta)object;
			System.out.println(temp.getNome() + "\n" + temp.getCPFDoTitular() + "\n" + temp.getAgencia()+ "\n"); 
		}
		saidaRelinfoClientes(logada, numeroAgencias); 
	}
	
	public static void saidaRelinfoClientes( Conta logada, List<Object> numeroAgencias) throws IOException
	{
		FileWriter csvWriter = new FileWriter("relinfoClientes.txt");
		csvWriter.append("Informações dos Clientes do Sistema: \n");
		for (Object object : numeroAgencias) {
			Conta temp = (Conta)object;
			csvWriter.append(temp.getNome() + "\n" + temp.getCPFDoTitular() + "\n" + temp.getAgencia()+ "\n"); 
		}
		
		csvWriter.flush();
		csvWriter.close();
	}
	

}
