package appInternetBanking;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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
	

	public void relContasGerenciadas(Conta logada, List<Object> numeroAgencias) throws IOException
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
		}*/
		
		for (Object object : numeroAgencias) {
			Conta temp = (Conta)object;
			 if(temp.getAgencia() == logada.getAgencia())
                {
                	contador++;
                }
		}
		
		System.out.println(contador);
		saidarelContasGerenciadas(contador, logada, numeroAgencias); 
	}
	
	public static void saidarelContasGerenciadas(int contador, Conta logada, List<Object> numeroAgencias) throws IOException
	{
		FileWriter csvWriter = new FileWriter("relContasGerenciadas.txt");
		csvWriter.append("Total de contas gerenciadas na mesma agência : " + contador);
		csvWriter.flush();
		csvWriter.close();
	}
	
}