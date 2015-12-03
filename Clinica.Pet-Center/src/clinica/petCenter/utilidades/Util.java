package clinica.petCenter.utilidades;

import clinica.petCenter.negocio.exceptions.IDIException;
import clinica.petCenter.negocio.exceptions.SenhaInvalidaException;

public class Util {
	
	public static final double SALARIO_BASE_OP = 1250.00;
	public static final double SALARIO_BASE_VETERINARIO = 2500.00;
	public static final int HORAS = 40;
	
	private static final String LOGIN = "ADMIN";
	private static final String SENHA = "1234";
	
	public static boolean isADM(String login, String senha) throws IDIException, SenhaInvalidaException {
		boolean r = false;
		if(!login.equals(LOGIN))
			throw new IDIException(login);
		else if(!senha.equals(SENHA))
			throw new SenhaInvalidaException(login);
		else
			r = true;
		
		return r;
	}
	
	public static boolean isID(String id) {
		boolean r = false;
		if(id != null && !id.isEmpty())
			r = id.startsWith("ANM") || id.startsWith("CL") || id.startsWith("OP") || id.startsWith("VT") || id.startsWith("CONSULTA");
		return r;
	}	
	
	
}
