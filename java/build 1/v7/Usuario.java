package appInternetBanking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Usuario {
	
	String tipoUsuario;
	long CPF;
	long senha;
	String nome;
	String TipoConta;
	int numeroConta;
	int agencia;
	double saldo;
	static Map<Long, Usuario> mapUsers = new HashMap<>();
	
		Usuario(String tipoUsuario, long CPF, long senha, String nome, String TipoConta, int numeroConta, int agencia,double saldo) {
			
			this.tipoUsuario = tipoUsuario;
			this.CPF= CPF;
			this.senha = senha;
			this.nome = nome;
			this.TipoConta = TipoConta;
			this.numeroConta = numeroConta;
			this.agencia = agencia;
			this.saldo = saldo;
						
		}

		@Override
		public String toString() {
			return tipoUsuario + " [tipoUsuario=" + tipoUsuario + ", CPF=" + CPF + ", senha=" + senha + ", nome=" + nome
					+ ", TipoConta=" + TipoConta + ", numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo="
					+ saldo + "]";
		}
		
		//leitura do .csv e criação do HashMap de usuários		
		public static void main(String[] args) throws IOException {
			
			String linha;
			Usuario user = null;
				
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
				
				String[] data = linha.split(",");
				tipoUsuario = data[0];
				CPF = Long.parseLong(data[1]);
				senha = Long.parseLong(data[2]);
				nome = data[3];
				TipoConta = data[4];
				numeroConta = Integer.parseInt(data[5]);
				agencia = Integer.parseInt(data[6]);
				saldo = Double.parseDouble(data[7]);	
			
				switch (tipoUsuario) {
				
				case "Cliente":
					
					user = new Cliente(tipoUsuario, CPF, senha, nome, TipoConta, numeroConta, agencia, saldo);				
					mapUsers.put(CPF, user);
					break;
					
				case "Gerente":
					
					user = new Gerente(tipoUsuario, CPF, senha, nome, TipoConta, numeroConta, agencia, saldo);				
					mapUsers.put(CPF, user);
					break;
					
				case "Diretor":
		
					user = new Diretor(tipoUsuario, CPF, senha, nome, TipoConta, numeroConta, agencia, saldo);				
					mapUsers.put(CPF, user);
					break;
		
				case "Presidente":
		
					user = new Presidente(tipoUsuario, CPF, senha, nome, TipoConta, numeroConta, agencia, saldo);				
					mapUsers.put(CPF, user);
					break;
		
				}					
				
			}		
				
			csvReader.close();
		}
		
		//LOGIN///
		public static Usuario login(long login) {					
		
			Usuario logado = mapUsers.get(login);			
						
			if (mapUsers.get(login) != null) {
				System.out.println("Digite sua senha");
				Scanner scan2 = new Scanner(System.in);
				long senhaDigitada = scan2.nextLong();
				
				if (senhaDigitada == logado.getSenha()) {
					
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

		public String getTipoUsuario() {
			return tipoUsuario;
		}

		public void setTipoUsuario(String tipoUsuario) {
			this.tipoUsuario = tipoUsuario;
		}

		public long getCPF() {
			return CPF;
		}

		public long getSenha() {
			return senha;
		}

		public String getNome() {
			return nome;
		}

		public String getTipoConta() {
			return TipoConta;
		}

		public int getNumeroConta() {
			return numeroConta;
		}

		public int getAgencia() {
			return agencia;
		}

		public double getSaldo() {
			return saldo;
		}

		public boolean verificaValor(double valorASacar) {
			// TODO Auto-generated method stub
			return false;
		}

		public void saque(Usuario c, double valorASacar) {
			// TODO Auto-generated method stub
			
		}

		public void deposito(double valorADepositar) {
			// TODO Auto-generated method stub
			
		}
		
}	
		

		

		
		
		

