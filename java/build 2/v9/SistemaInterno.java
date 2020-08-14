package appInternetBanking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SistemaInterno  {

	public static void main(String[] args) throws IOException   {
		
		//criação do HashMap de usuários e contas
		
		Map<Long, Usuario> mapUsers = new HashMap<>();
		Map<Long, Conta> mapContas = new HashMap<>();
		Map<Integer, Conta> mapContasNumeroConta = new HashMap<>();
		//Map<Long, Conta> mapAgencias = new HashMap<>();
		List<Object> numeroAgencias = new ArrayList<>();
		
		
		String linha;
		Usuario user = null;
		Conta conta = null;
			
		BufferedReader csvReader = new BufferedReader(new FileReader("Accounts.csv"));
		
		linha = csvReader.readLine();
		while ((linha = csvReader.readLine()) != null) {
			String tipoUsuario;
			long CPF;
			long senha;
			String nome;
			String TipoConta;
			int numeroConta;
			int agencia;
			double saldo;
			double tarifacao;
			
			String[] data = linha.split(",");
			tipoUsuario = data[0];
			CPF = Long.parseLong(data[1]);
			senha = Long.parseLong(data[2]);
			nome = data[3];
			TipoConta = data[4];
			numeroConta = Integer.parseInt(data[5]);
			agencia = Integer.parseInt(data[6]);
			saldo = Double.parseDouble(data[7]);	
			tarifacao = Double.parseDouble(data[8]);
		
			switch (tipoUsuario) {
			
			case "Cliente":
				
				user = new Cliente(tipoUsuario, CPF, senha, nome, TipoConta);				
				mapUsers.put(CPF, user);
				
				break;
				
			case "Gerente":
				
				user = new Gerente(tipoUsuario, CPF, senha, nome, TipoConta, agencia);				
				mapUsers.put(CPF, user);
				break;
				
			case "Diretor":
	
				user = new Diretor(tipoUsuario, CPF, senha, nome, TipoConta);				
				mapUsers.put(CPF, user);
				break;
	
			case "Presidente":
	
				user = new Presidente(tipoUsuario, CPF, senha, nome, TipoConta);				
				mapUsers.put(CPF, user);
				break;
	
			}
			
			switch (TipoConta) {
			
			case "Corrente":
				
				conta = new Corrente(TipoConta, CPF,nome, tipoUsuario, numeroConta, agencia, saldo, tarifacao);
				mapContas.put(CPF, conta);
			
			mapContasNumeroConta.put(numeroConta, conta);
				numeroAgencias.add(conta);
				break;
				
			case "Poupanca":
				
				conta = new Poupanca(TipoConta, CPF, nome,tipoUsuario, numeroConta, agencia, saldo, tarifacao);
				mapContas.put(CPF, conta);			
				mapContasNumeroConta.put(numeroConta, conta);
				numeroAgencias.add(conta);
				break;
			}
			
		}		
			
		csvReader.close();
		
		Usuario logado = login(mapUsers);
		Conta logada = mapContas.get(logado.getCPF());	
		
		Menu.menuConta(logado, logada, mapContas);
		
		
		//primeiroMenu(logado.getCPF(), logada, mapContas, mapContasNumeroConta, numeroAgencias);
	
		}
	
//LOGIN///
		public static Usuario login(Map<Long, Usuario> mapUsers) {					
		
			//System.out.println(Arrays.toString(Menu.menuBoasVindas()));
			long[] loginSenha = Menu.menuBoasVindas();			
			
			Usuario logado = mapUsers.get(loginSenha[0]);			
			if (mapUsers.get(loginSenha[0]) != null) {
								
				if (loginSenha[1] == logado.getSenha()) {
					
					return logado;
					
				}
				else {
					System.out.println("Usuário e/ou senha incorreto. Inicie novamente");
					return null;
				}
					
			}
			else {
				System.out.println("Inicie novamente");
				return null;
			}
			
			 
		}
	
		
}
				
				
				
				
				
