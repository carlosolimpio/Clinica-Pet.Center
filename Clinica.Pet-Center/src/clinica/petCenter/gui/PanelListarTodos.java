package clinica.petCenter.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import clinica.petCenter.negocio.cadastros.FachadaCadastro;
import clinica.petCenter.negocio.cadastros.IFachadaCadastro;
import clinica.petCenter.negocio.classesBasicas.Animal;
import clinica.petCenter.negocio.classesBasicas.Cliente;
import clinica.petCenter.negocio.classesBasicas.Consulta;
import clinica.petCenter.negocio.classesBasicas.OperadorSistema;

public class PanelListarTodos extends JPanel {

	private JFrame frame;
	private JTextArea textArea;
	
	private IFachadaCadastro fachada;
	private String tipo;
	private OperadorSistema op;
	
	public PanelListarTodos(JFrame frame, String tipo, OperadorSistema op) {
		
		setFrame(frame);
		setPreferredSize(new Dimension(600,400));
		setLayout(null);
		setOperadorSistema(op);
		setTipo(tipo);
		
		fachada = FachadaCadastro.getInstance();
		
		JLabel lblTitulo = new JLabel(getTipo());
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(23, 11, 295, 28);
		add(lblTitulo);
		
		textArea = new JTextArea();
		textArea.setBounds(41, 50, 516, 306);
		
		JScrollPane scrlPane = new JScrollPane(textArea);
		scrlPane.setBounds(41, 50, 516, 306);
		add(scrlPane);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(501, 367, 89, 23);
		add(btnVoltar);
		btnVoltar.addActionListener(new EvntBtnVoltar());
		
		mostraListaDeObjetos(getTipo());
	}
	
	private void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	private void setOperadorSistema(OperadorSistema op) {
		this.op = op;
	}
	
	public OperadorSistema getOperadorSistema() {
		return op;
	}
	
	private void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	private void mostraListaDeObjetos(String tipo) {
		
		String temp;
		
		try {
			if(tipo.equals("Animais")) {
				for(Animal a : fachada.listarAnimais()) {
					
					temp = "ID: " + a.getId() + "\n" + "ESPÉCIE: " + a.getEspecie() + "\n" + 
							"RAÇA: " + a.getRaca() + "\n" + "ID DONO: " + a.getIdDono() + "\n\n";
					textArea.append(temp.toUpperCase());
				}
				
				
			} else if(tipo.equals("Clientes")) {
				for(Cliente c : fachada.listarClientes()) {
					temp = "ID: " + c.getId() + "\n" + "NOME: " + c.getNome() + "\n" + 
							"CPF: " + c.getCPF() + "\n" + "EMAIL: " + c.getEmail() + "\n\n";
					textArea.append(temp.toUpperCase());
				}
				
			} else if(tipo.equals("Consultas")) {
				for(Consulta co : fachada.listarConsultas()) {
					temp = "ID: " + co.getIdConsulta() + "\n" + "DATA: " + co.getData() + "\n" + 
							"ID ANIMAL: " + co.getAnimal().getId() + "\n" + "ID VETERINÁRIO: " + co.getVeterinario().getId() + "\n\n";
					textArea.append(temp.toUpperCase());
				}
			}else if(tipo.equals("Todos")){
				for(Animal a : fachada.listarAnimais()) {
					
					temp = "ID: " + a.getId() + "\n" + "ESPÉCIE: " + a.getEspecie() + "\n" + 
							"RAÇA: " + a.getRaca() + "\n" + "ID DONO: " + a.getIdDono() + "\n\n";
					textArea.append(temp.toUpperCase());
				}
				for(Cliente c : fachada.listarClientes()) {
					temp = "ID: " + c.getId() + "\n" + "NOME: " + c.getNome() + "\n" + 
							"CPF: " + c.getCPF() + "\n" + "EMAIL: " + c.getEmail() + "\n\n";
					textArea.append(temp.toUpperCase());
				}
				for(Consulta co : fachada.listarConsultas()) {
					temp = "ID: " + co.getIdConsulta() + "\n" + "DATA: " + co.getData() + "\n" + 
							"ID ANIMAL: " + co.getAnimal().getId() + "\n" + "ID VETERINÁRIO: " + co.getVeterinario().getId() + "\n\n";
					textArea.append(temp.toUpperCase());
				}
			}
			
			else 
				throw new IllegalArgumentException("Erro na Lista");
			
		} catch(IllegalArgumentException iae) {
			JOptionPane.showMessageDialog(null, iae.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private class EvntBtnVoltar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			textArea.setText("");
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelOperadorSistema(frame, getOperadorSistema()));
			frame.setVisible(true);
		}
	}
}
