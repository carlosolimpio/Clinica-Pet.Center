package gui;

import java.awt.Container;
import java.awt.Window;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import clinica.pet_center.negocio.basicas.Cliente;
import clinica.pet_center.negocio.cadastros.FachadaCadastro;
import clinica.pet_center.utilidades.Util;


public class AdministracaoTelas {
	private static TelaInicio telaInicio;
	private static AreaRestrita areaRestrita;

	public AdministracaoTelas() {
		this.telaInicio = new TelaInicio();
		this.areaRestrita = new AreaRestrita();
	}

	public static TelaInicio getTelaInicio() {

		return telaInicio;
	}

	

	public static AreaRestrita getAreaRestrita() {

		return areaRestrita;
	}

	public static void administracaoDeTelas(Window fecha, Window abre) {
		if (fecha == null) {
			abre.setVisible(true);

		} else {
			fecha.setVisible(false);
			abre.setVisible(true);

		}
	}
	
	public static void trocarTelas(Container f, JPanel p){
		f.removeAll();
		f.add(p);
		f.revalidate();
		f.repaint();
	}
	
	private static void inicioAdm(){
		try {
			Util.isADM("ADMIN", "1234");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro de Negocio!");
		}
	}

	public static void main(String[] args) {
		try {
			new AdministracaoTelas();
			inicioAdm();
			administracaoDeTelas(null, telaInicio);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
