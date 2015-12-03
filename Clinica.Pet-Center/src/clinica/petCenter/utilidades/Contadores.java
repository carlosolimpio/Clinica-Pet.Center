package clinica.pet_center.utilidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Contadores {
	
	private static int contadorAnimais = 0;
	private static int contadorPessoas;
	private static int contadorConsultas = 0;	
	
	public static String getQtdConsultas() {
		contadorConsultas++;
		return String.format(getFormato(contadorConsultas));
	} 
	
	public static String getQtdAnimais() {
		contadorAnimais++;
		return String.format(getFormato(contadorAnimais));
	}
	
	public static String getQtdPessoas() {
		carregaDoArquivo();
		contadorPessoas++;
		salvarArquivo();
		return String.format(getFormato(contadorPessoas));
	}
	
	private static String getFormato(int valor) {
		DecimalFormat formato = new DecimalFormat("00000"); //ex: 00315
		return formato.format(valor);
	}
	
	public static void decrementaPessoas() {
		carregaDoArquivo();
		contadorPessoas--;
		salvarArquivo();
	}
	
	private static void salvarArquivo() {
		File arquivo = new File("contadorPessoas.dat");
		FileWriter fw = null;
		
		try {
			
			fw = new FileWriter(arquivo);
			fw.append(String.format("%d", contadorPessoas));
			
		} catch(IOException ioe) {
			//Silent Exception
		} finally {
			try {
				fw.close();
			} catch(IOException iooe) {
				//Silent Exception
				}
			}
	}

	private static void carregaDoArquivo() {
		File arquivo = new File("contadorPessoas.dat");
		Scanner s = null;
		
		try {
			
			if(arquivo.exists()) {
				s = new Scanner(arquivo);
				contadorPessoas = Integer.parseInt(s.nextLine());
			} else {
				contadorPessoas = 0;
			}
			
		} catch(Exception e) {
			//Silent Exception
		} finally {
			try {
				s.close();
			} catch(Exception ex) {
				//Silent Exception
				}
			}
	}
}