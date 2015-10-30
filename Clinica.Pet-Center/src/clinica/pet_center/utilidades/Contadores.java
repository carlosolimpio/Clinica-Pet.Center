package clinica.pet_center.utilidades;

import java.text.DecimalFormat;

public class Contadores {
	
	private static int contadorAnimais = 0;
	private static int contadorPessoas = 0;
	private static int contadorConsultas = 0;
	
	public static void contConsultas() {
		contadorConsultas++;
	}
	
	public static void contAnimais() {
		contadorAnimais++;
	}
	
	public static void contPessoas() {
		contadorPessoas++;
	}
	
	public static String getQtdConsultas() {
		return String.format(getFormato(contadorConsultas));
	}
	
	public static String getQtdAnimais() {
		return String.format(getFormato(contadorAnimais));
	}
	
	public static String getQtdPessoas() {
		return String.format(getFormato(contadorPessoas));
	}
	
	private static String getFormato(int valor) {
		DecimalFormat formato = new DecimalFormat("00000"); //ex: 00315
		return formato.format(valor);
	}
}
