package clinica.pet_center.utilidades;

public class Contadores {
	
	private static int contadorAnimais = 0;
	private static int contadorPessoas = 0;
	
	public static void contAnimais() {
		contadorAnimais++;
	}
	
	public static void contPessoas() {
		contadorPessoas++;
	}
	
	public static int getQtdAnimais() {
		return contadorAnimais;
	}
	
	public static int getQtdPessoas() {
		return contadorPessoas;
	}
}
