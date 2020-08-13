package appInternetBanking;

import java.util.*;

public class Menu {
	
	public static void menuBoasVindas() {
		System.out.println("|=======                    Seja bem Vindo ao Banco Do Raul                    =======|");
		System.out.println("|_____________________________________________________________________________________|");
		System.out.println("|                                                                                     |");
		System.out.println("|                                                                     Banco do Raul   |");
		System.out.println("|_____________________________________________________________________________________|");
	}

	public static void menuConta(Usuario usuarioLogado, Conta contaLogada) {
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("|                                                                                     |");
			System.out.println("|   O que deseja fazer?                                                               |");
			System.out.println("|_____________________________________________________________________________________|");
			System.out.println("|                                                                                     |");
			System.out.println("|   [1] Movimentacoes                [2] Relatorios                [3] Sair           |");
			System.out.println("|_____________________________________________________________________________________|");
			int input = scan.nextInt();

			switch (input) {
				case 1:
					menuMovimentacoes(usuarioLogado, contaLogada);
					break;
				case 2:
					menuRelatorios(usuarioLogado, contaLogada);
					break;
				case 3:
					menuSair();
					break;
			}
		}
	}

	public static void menuMovimentacoes(Usuario usuarioLogado, Conta contaLogada) {
		Scanner scan = new Scanner(System.in);

		System.out.println("|_____________________________________________________________________________________|");
		System.out.println("|                                                                                     |");
		System.out.println("|              [1] Sacar                                   [2] Depositar              |");
		System.out.println("|                                                                                     |");
		System.out.println("|              [3] Transferir                              [4] Voltar                 |");
		System.out.println("|_____________________________________________________________________________________|");
		int input = scan.nextInt();
		System.out.println("|                                                                                     |");

		switch (input) {
			case 1:
				// Sacar
				System.out.println("|   Qual valor deseja sacar?                                                          |");
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
				int transferir = scan.nextInt();
				System.out.println("|   Voce confirma o saque de R$" + transferir + "? [S/N]                              |");
				String r3 = scan.next();
				if (r3.equals("S") || r3.equals("s")) {
					System.out.println("|   Deposito realizado com sucesso!                                                   |");
				} else {
					System.out.println("|   Operacao cancelada!                                                               |");
				}

				System.out.println("|_____________________________________________________________________________________|");

				break;
			case 4:
				// Voltar
				break;
		}
	}

	public static void menuRelatorios(Usuario usuarioLogado, Conta contaLogada) {
		System.out.println("Relatorios ;)");
	}

	public static void menuSair() {
		System.out.println("Obrigado por utilizar o Internet Banking.");

		System.exit(0);
	}


}
