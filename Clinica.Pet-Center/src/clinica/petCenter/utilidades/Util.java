package clinica.petCenter.utilidades;

public class Util {
	
	private static final String LOGIN = "ADMIN";
	private static final String SENHA = "1234";
	
	public static boolean isADM(String login, String senha) {
		boolean r = false;
		
		if(login.equals(LOGIN) && senha.equals(SENHA))
			r = true;
		
		return r;
	}
	
	public static boolean isID(String id) {
		boolean r = false;
		
		if(id != null && !id.isEmpty())
			r = id.startsWith("OP") || id.startsWith("VT") || id.startsWith("ANM") || id.startsWith("CL") || id.startsWith("CONSULTA");
		
		return r;
	}	
	
	public static String whatId(String id) {
		String r = "Erro";
		if(id.startsWith("OP")){
			r = "OP";
		}else if(id.startsWith("VT")){
			r = "VT";
		}else if(id.startsWith("ANM")){
			r = "ANM";
		}else if(id.startsWith("CL")){
			r = "CL";
		}else if(id.startsWith("CONSULTA")){
			r = "CONSULTA";
		}
		return r;
	}
}
