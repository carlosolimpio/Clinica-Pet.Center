package clinica.petCenter.utilidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Contadores {
	
	private static int contadorAnimais;
	private static int contadorPessoas;
	private static int contadorConsultas;	
	
	public static String getQtdConsultas() {
		carregaDoArquivoConsultas();
		contadorConsultas++;
		salvarArquivoConsultas();
		return String.format(getFormato(contadorConsultas));
	} 
	
	public static String getQtdAnimais() {
		carregaDoArquivoAnimais();
		contadorAnimais++;
		salvarArquivoAnimais();
		return String.format(getFormato(contadorAnimais));
	}
	
	public static String getQtdPessoas() {
		carregaDoArquivoPessoas();
		contadorPessoas++;
		salvarArquivoPessoas();
		return String.format(getFormato(contadorPessoas));
	}
	
	private static String getFormato(int valor) {
		DecimalFormat formato = new DecimalFormat("00000"); //ex: 00315
		return formato.format(valor);
	}
	
	public static void decrementaPessoas() {
		carregaDoArquivoPessoas();
		contadorPessoas--;
		salvarArquivoPessoas();
	}
	
	public static void decrementaAnimais() {
		carregaDoArquivoAnimais();
		contadorAnimais--;
		salvarArquivoAnimais();
	}
	
	public static void decrementaConsultas() {
		carregaDoArquivoConsultas();
		contadorConsultas--;
		salvarArquivoConsultas();
	}
	
	private static void salvarArquivoPessoas() {
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

	private static void carregaDoArquivoPessoas() {
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
	
	private static void salvarArquivoAnimais() {
		File arquivo = new File("contadorAnimais.dat");
		FileWriter fw = null;
		
		try {
			
			fw = new FileWriter(arquivo);
			fw.append(String.format("%d", contadorAnimais));
			
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

	private static void carregaDoArquivoAnimais() {
		File arquivo = new File("contadorAnimais.dat");
		Scanner s = null;
		
		try {
			
			if(arquivo.exists()) {
				s = new Scanner(arquivo);
				contadorAnimais = Integer.parseInt(s.nextLine());
			} else {
				contadorAnimais = 0;
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
	
	private static void salvarArquivoConsultas() {
		File arquivo = new File("contadorConsultas.dat");
		FileWriter fw = null;
		
		try {
			
			fw = new FileWriter(arquivo);
			fw.append(String.format("%d", contadorConsultas));
			
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

	private static void carregaDoArquivoConsultas() {
		File arquivo = new File("contadorConsultas.dat");
		Scanner s = null;
		
		try {
			
			if(arquivo.exists()) {
				s = new Scanner(arquivo);
				contadorConsultas = Integer.parseInt(s.nextLine());
			} else {
				contadorConsultas = 0;
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