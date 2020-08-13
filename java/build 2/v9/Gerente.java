package appInternetBanking;

import java.io.FileWriter;
import java.io.IOException;

public class Gerente extends Administracao  {

	String cargo = "Gerente";
	int idAgenciaDeResponsabilidade;
	
	int agencia;	

	public Gerente(String tipoUsuario, long CPF, long senha, String nome, String tipoConta, int agencia) {
		super(tipoUsuario, CPF, senha, nome, tipoConta);
		this.agencia = agencia;
		this.idAgenciaDeResponsabilidade = agencia;
	}


	@Override
	public String toString() {
		return "[Cargo = " + cargo + ", CPF = " + CPF + ", nome = " + nome
				+ ", agencia=" + agencia + "]";
	}
	

	public void relContasGerenciadas(Conta logada)
	{
		int contador = 0;
		/*
		Iterator itr = numeroAgencias.iterator();
		while(itr.hasNext()){  
            Conta st=(Conta)itr.next();  
            if(st.getAgencia() == logada.getAgencia())
            {
            	contador++;
            }
		}
		*/
		for (Object object : numeroAgencias) {
			Conta temp = (Conta)object;
			 if(temp.getAgencia() == logada.getAgencia())
                {
                	contador++;
                }
		}
		
		System.out.println(contador);
	}
	
	public static void saidaRelTarifacao(Conta logada) throws IOException
	{
		FileWriter csvWriter = new FileWriter("relTarifacao.txt");
		csvWriter.append("Relatório de contas gerenciadas");
		csvWriter.append("\n");
		csvWriter.append("R$" + logada.getTarifacao());
		csvWriter.flush();
		csvWriter.close();
	}
	
}