package appInternetBanking;

import java.io.IOException;
import java.util.*;

public class Menu {
	
	public static long[] menuBoasVindas() {
      
		Scanner scan = new Scanner(System.in);
		
        System.out.println("|=====================================================================================|");
        System.out.println("|=======                    Seja Bem Vindo ao Banco Do Raul                    =======|");
        System.out.println("|=====================================================================================|");
        System.out.println("|                                                                                     |");
        System.out.println("|                                                                     Banco do Raul   |");
        System.out.println("|_____________________________________________________________________________________|");
        System.out.println("|                                                                                     |");
        System.out.println("|   Digite seu CPF:                                                                   |");
        System.out.println("|                                                                                     |");
        long cpf = scan.nextLong();
        
       
        System.out.println("|                                                                                     |");
        System.out.println("|   Digite sua senha                                                                  |");
        long senha = scan.nextLong();
        return new long[] {cpf, senha};
    }
	                            
	
	public static void menuConta(Usuario usuarioLogado, Conta contaLogada, Map<Long, Conta> mapContas, List<Object> numeroAgencias, Map<Integer, Conta> mapContasNumeroConta) throws IOException {
		Scanner scan = new Scanner(System.in);

		while(true) {
			System.out.println("|                                                                                     |");
		    System.out.println("|                             " + usuarioLogado.getNome() +"  ");  
			System.out.println("|                                                                                     |");
			System.out.println("|   O que deseja fazer?                                                               |");
			System.out.println("|_____________________________________________________________________________________|");
			System.out.println("|                                                                                     |");
			System.out.println("|   [1] Movimentacoes                [2] Relatorios                [3] Sair           |");
			System.out.println("|_____________________________________________________________________________________|");
			int input = scan.nextInt();

			switch (input) {
				case 1:
					menuMovimentacoes(usuarioLogado, contaLogada, mapContas, numeroAgencias, mapContasNumeroConta);
					break;
				case 2:					
					
					if (usuarioLogado.getTipoUsuario().equals("Cliente")) {
					
						
						if (usuarioLogado.getTipoConta().equals("Corrente")) {
							relatorioDeUsuarioCorrente(usuarioLogado, contaLogada);
							menuNovaOp(usuarioLogado, contaLogada, mapContas, numeroAgencias, mapContasNumeroConta);
							
						} 
						//poupanca Cliente
						else
						{
							relatorioDeUsuarioPoupanca(usuarioLogado, contaLogada, mapContas, numeroAgencias, mapContasNumeroConta);
						}
						
					} else {
						//chama escolhe empresa
						relatorioDaAdiministracao(usuarioLogado, contaLogada, mapContas, numeroAgencias, mapContasNumeroConta);
					}
					
					break;
				case 3:
					menuSair();
					break;
			}
		}
	}

	public static void menuMovimentacoes(Usuario usuarioLogado, Conta contaLogada, Map<Long, Conta> mapContas, List<Object> numeroAgencias, Map<Integer, Conta> mapContasNumeroConta) throws IOException {
		Scanner scan = new Scanner(System.in);

		System.out.println("|_____________________________________________________________________________________|");
		System.out.println("|                                                                                     |");
		System.out.println("|              [1] Sacar                                   [2] Depositar              |");
		System.out.println("|                                                                                     |");
		System.out.println("|              [3] Transferir                              [4] Voltar                 |");
		System.out.println("|_____________________________________________________________________________________|");
		int input = scan.nextInt();

		switch (input) {
			case 1:
				// Sacar
				System.out.println("|_____________________________________________________________________________________|");
				System.out.println("|                                                                                     |");
				System.out.println("|   Digite o valor para o saque                                                       |");
				int saque = scan.nextInt();
				System.out.println("|_____________________________________________________________________________________|");
				System.out.println("|                                                                                     |");
				System.out.println("|   Voce confirma o saque de R$" + saque + "? [S/N]                                  |");
				String r1 = scan.next();

				if (r1.equals("S") || r1.equals("s")) {
					Conta.saque(saque, contaLogada);
					System.out.println("|   Saque realizado com sucesso!                                                   |");
				} else {
					System.out.println("|   Operacao cancelada!                                                               |");
				}

				System.out.println("|_____________________________________________________________________________________|");
				
				break;
			case 2:
				// Depositar
				System.out.println("|   Qual valor deseja depositar?                                                      |");
				System.out.println("|                                                                                     |");
				int depositar = scan.nextInt();
				System.out.println("|   Voce confirma o deposito de R$" + depositar + "? [S/N]                              |");
				String r2 = scan.next();

				if (r2.equals("S") || r2.equals("s")) {
					Conta.deposito(depositar, contaLogada);
					System.out.println("|   Deposito realizado com sucesso!                                                   |");
				} else {
					System.out.println("|   Operacao cancelada!                                                               |");
				}

				System.out.println("|_____________________________________________________________________________________|");

				break;
			case 3:
				// Transferir
                System.out.println("|   Qual valor deseja transferir?                                                     |");
                System.out.println("|                                                                                     |");
                double transfValor = scan.nextDouble();
                System.out.println("|   Qual a conta deseja transferir?                                                      |");
                System.out.println("|                                                                                     |");
                int transfConta = scan.nextInt();
                System.out.println("|   Voce confirma a transferência de R$" + transfValor + " para conta " + transfConta + "? [S/N]   |");
                String r3 = scan.next();
                
                if (r3.equals("S") || r3.equals("s")) {
                    Conta.transferencia(transfValor, transfConta, contaLogada, mapContas, mapContasNumeroConta);
                    System.out.println("|   Transferencia realizada com sucesso!                                                   |");
                } else {
                    System.out.println("|   Operacao cancelada!                                                               |");
                }
                break;
			case 4:
				menuConta(usuarioLogado, contaLogada, mapContas, numeroAgencias, mapContasNumeroConta);
				break;
		}
	}

	//menus relatorio
	
	
	public static void relatorioDeUsuarioCorrente(Usuario usuarioLogado, Conta contaLogada) throws IOException 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("|_____________________________________________________________________________________|");
		System.out.println("|                                                                                     |");
		System.out.println("|          [1] Saldo                                 [2] Relatorio Tarifacao          |");
		System.out.println("|                                                                                     |");
		System.out.println("|          [3] Informaçoes de Tarifas                [4] Voltar                       |");
		System.out.println("|_____________________________________________________________________________________|");
		int escolha4 = scan.nextInt();
				
		switch (escolha4) {
		case 1:
			
			System.out.println("|                      Saldo Atual:                       ");
			System.out.println("|                      R$" + contaLogada.getSaldo()+"                       ");
			contaLogada.saidaRelSaldo(contaLogada);
			break;
			
		case 2:
			System.out.println("|                      R$" + contaLogada.getTarifacao()+"                       ");
			Conta.saidaRelTarifacao(contaLogada);
			break;
			
		case 3:
			contaLogada.relInfoTarifacao();			
	
			break;
	
		case 4:
			menuSair();
			break;

		}
	}
	
	public static void relatorioDeUsuarioPoupanca(Usuario usuarioLogado, Conta contaLogada, Map<Long, Conta> mapContas, List<Object> numeroAgencias, Map<Integer, Conta> mapContasNumeroConta) throws IOException
	{
		System.out.println("|_____________________________________________________________________________________|");
		System.out.println("|                                                                                     |");
		System.out.println("|       [1] Saldo               [2] Rendimento Poupanca              [3] Voltar       |");
		System.out.println("|_____________________________________________________________________________________|");
		
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		
		switch (input) {
		case 1:
			System.out.println("|                      R$" + contaLogada.getSaldo()+"                       ");
			System.out.println("R$" + contaLogada.getSaldo());
			contaLogada.saidaRelSaldo(contaLogada);
			break;

		case 2:
			contaLogada.relRendimentosPoup(contaLogada);
		
		
		case 3:
			 menuConta(usuarioLogado, contaLogada, mapContas, numeroAgencias, mapContasNumeroConta);
			break;
	}
	}

	
	
	public static void relatorioDaAdiministracao(Usuario usuarioLogado, Conta contaLogada, Map<Long, Conta> mapContas, 
			List<Object> numeroAgencias, Map<Integer, Conta> mapContasNumeroConta) throws IOException
	{
		
		System.out.println("|_____________________________________________________________________________________|");
		System.out.println("|                                                                                     |");
		System.out.println("|           [1] Pessoal                [2] Empresa               [3] Voltar           |");
		System.out.println("|_____________________________________________________________________________________|");
		
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		
		switch (input) {
		case 1:
			if (usuarioLogado.getTipoConta().equals("Corrente")) {
				relatorioDeUsuarioCorrente(usuarioLogado, contaLogada);
				
			}
			else
			{
				relatorioDeUsuarioPoupanca(usuarioLogado, contaLogada, mapContas, numeroAgencias, mapContasNumeroConta);
				
			}
			break;
			
		case 2:
			
			if (usuarioLogado.getTipoUsuario().equals("Gerente")) {
				Gerente.relContasGerenciadas(contaLogada, numeroAgencias);
			}
			else if (usuarioLogado.getTipoUsuario().equals("Diretor")) {
				Diretor.relinfoClientes(contaLogada, numeroAgencias);
			}
			
			else
			{
				Presidente.relCapitalTotal(numeroAgencias);
			}
			
			break;

		
		}
	}
	
	
	
	
	
	/*
	private static void relatorioGerenteEmpresa(Usuario usuarioLogado, Conta contaLogada, Map<Long, Conta> mapContas) {
		
		
	}
*/

	public static void menuNovaOp(Usuario usuarioLogado, Conta contaLogada, Map<Long, Conta> mapContas, List<Object> numeroAgencias, Map<Integer, Conta> mapContasNumeroConta) throws IOException {
        Scanner scan = new Scanner(System.in);

 

        System.out.println("|_____________________________________________________________________________________|");
        System.out.println("|                                                                                     |");
        System.out.println("|                       Deseja realizar outra operacao? [S / N]                       |");
        System.out.println("|_____________________________________________________________________________________|");
        String escolhaNova = scan.next();

 

        switch(escolhaNova) {
            case "S":
                menuConta(usuarioLogado, contaLogada, mapContas, numeroAgencias, mapContasNumeroConta);
                
 

                break;
            case "N":
                menuSair();

 

                break;
        }
    }
	
	public static void menuSeguro(Usuario usuarioLogado, Conta contaLogada) {
        Scanner scan = new Scanner(System.in); 

        System.out.println("|=====================================================================================|");
        System.out.println("|=======                 * Seguro de Vida - Banco do Raul *                    =======|");
        System.out.println("|=====================================================================================|");
        System.out.println("|                                                                                     |");
        System.out.println("|   CONTRATACAO - Apolice para Fulano                                                 |");
        System.out.println("|_____________________________________________________________________________________|");
        System.out.println("|                                                                                     |");
        System.out.println("|   Qual valor deseja segurar?                                                        |");
        double valSeg = scan.nextInt();

 

        System.out.println("|_____________________________________________________________________________________|");
        System.out.println("|                                                                                     |");
        System.out.println("|   Voce confirma a contratacao do seguro no valor de R$" + valSeg + "? [S/N]         |");
        String confSeg = scan.next();

 
/*
        if (confSeg.equals("S") || confSeg.equals("s")) {
            if(SeguroVida.contrata(valSeg, usuarioLogado, contaLogada) == true) {
                System.out.println("|   Seguro contratado com sucesso!                                                    |");
            } else {
                System.out.println("|   Ocorreu um erro ao tentar contratar o seguro. Tente novamente.                    |");
            }
        } else {
            System.out.println("|   Operacao cancelada!                                                               |");
        }
*/
 

        System.out.println("|_____________________________________________________________________________________|");
    }
	
	public static void menuSair() {
		
		
		
		System.out.println("|=====================================================================================|");
		System.out.println("|=======             Obrigado por utilizar o Internet Banking ;)               =======|");
		System.out.println("|=====================================================================================|");

		System.exit(0);
	}

}
