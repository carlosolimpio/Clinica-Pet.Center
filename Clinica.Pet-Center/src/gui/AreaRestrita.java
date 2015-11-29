package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clinica.pet_center.negocio.basicas.Administrador;
import clinica.pet_center.negocio.basicas.Cliente;
import clinica.pet_center.negocio.basicas.OperadorSistema;
import clinica.pet_center.negocio.basicas.Pessoa;
import clinica.pet_center.negocio.basicas.Veterinario;

public class AreaRestrita extends JFrame {

	private PainelAdministrador painelAdministrador;
	private PainelCliente painelCliente;
	private PainelOperadorSistema painelOperadorSistema;
	private PainelVeterinario painelVeterinario;
	public static Container painel;

	public AreaRestrita() {
		this.painelAdministrador = new PainelAdministrador();
		painel = this.getContentPane();
		this.setBounds(0, 0, 710, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void carregarTela(Pessoa p){
		if(p instanceof Cliente){
			Cliente c = (Cliente)p;
			painel.add(painelCliente);
		}
		else if(p instanceof OperadorSistema){
			OperadorSistema op = (OperadorSistema)p;
			painel.add(painelOperadorSistema);
		}
		else if(p instanceof Veterinario){
			Veterinario vet = (Veterinario)p;
			painel.add(painelVeterinario);
		}
		else if(p instanceof Administrador){
			Administrador adm = (Administrador)p;
			painel.add(painelAdministrador);
		}
		
	}

}
