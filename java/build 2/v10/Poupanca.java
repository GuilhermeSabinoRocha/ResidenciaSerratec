package appInternetBanking;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Poupanca extends Conta {

	public Poupanca(String TipoConta, long CPFDoTitular, String nome, String tipoUsuario, int numeroDaConta,
			int agencia, double saldo, double tarifacao) {
		super(TipoConta, CPFDoTitular, nome, tipoUsuario, numeroDaConta, agencia, saldo, tarifacao);
		// TODO Auto-generated constructor stub
	}

	public static void relRendimentosPoup(Conta logada) throws IOException
	{
		System.out.println("Simule no prazo desejado:"
				+ "\n1- 7 dias\n2- 15 dias\n3 - 30 dias");
		Scanner scan = new Scanner(System.in);
		int op = scan.nextInt();			
		
		switch (op) {
		case 1:
			double taxa = 1.0003;
			double simulacao = logada.getSaldo()*taxa;
			System.out.println(simulacao);
			saidaRelRendimentosPoup(simulacao,"7 dias");
			break;
		case 2:
			
			double taxa2 = 1.0006;
			double simulacao2 = logada.getSaldo()*taxa2;
			System.out.println(simulacao2);
			saidaRelRendimentosPoup(simulacao2,"15 dias");
		
			break;
		case 3:
			
			double taxa3 = 1.001303;
			double simulacao3 = logada.getSaldo()*taxa3;
			System.out.println(simulacao3);
			saidaRelRendimentosPoup(simulacao3,"30 dias");
						
			break;
		default:
			break;
		}
	}
	
	//txt do relRendimentosPoup
	
			public static void saidaRelRendimentosPoup(double simulacao, String prazo) throws IOException
			{
				FileWriter csvWriter = new FileWriter("simulacaoRelPoup.txt");
				csvWriter.append("Simulação de rendimento da conta Poupança - "
						+ prazo);
				csvWriter.append("\n");
				csvWriter.append("R$" + simulacao);
				csvWriter.flush();
				csvWriter.close();
			}
}


