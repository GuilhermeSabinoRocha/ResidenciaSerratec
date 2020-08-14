package appInternetBanking;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Diretor extends AltaAdministracao  {
	
	String cargo = "Diretor";

	public Diretor(String tipoUsuario, long CPF, long senha, String nome, String tipoConta) {
		super(tipoUsuario, CPF, senha, nome, tipoConta);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Diretor [" + (cargo != null ? "cargo=" + cargo : "") + "]";
	}
	
	

	
	
	

}
