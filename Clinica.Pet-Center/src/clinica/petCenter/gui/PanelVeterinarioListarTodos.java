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
import clinica.petCenter.negocio.classesBasicas.OperadorSistema;
import clinica.petCenter.negocio.classesBasicas.Veterinario;

public class PanelVeterinarioListarTodos extends JPanel {

	private JFrame frame;
	private JTextArea textArea;
	
	private IFachadaCadastro fachada;
	private String tipo;
	private OperadorSistema op;
	
	public PanelVeterinarioListarTodos(JFrame frame, String tipo) {
		
		setFrame(frame);
		setPreferredSize(new Dimension(600,400));
		setLayout(null);
		setFrame(frame);
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
	
	private void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	private void mostraListaDeObjetos(String tipo) {
		
		String temp;
		
		try {
			if(tipo.equals("Operadores de Sistema")) {
				for(OperadorSistema op : fachada.listarOperadoresSistema()) {
					
					temp = "ID: " + op.getId() + "\n" + "NOME: " + op.getNome() + "\n" + 
							"CPF: " + op.getCPF() + "\n" + "EMAIL: " + op.getEmail() + "\n" + "DATA ADMISSÃO: " + op.getDataAdmissao()
							 + "\n\n";
					textArea.append(temp.toUpperCase());;
				}
				
			} else if(tipo.equals("Veterinários")) {
				for(Veterinario v : fachada.listarVeterinarios()) {
					temp = "ID: " + v.getId() + "\n" + "NOME: " + v.getNome() + "\n" + "CRMV: " + v.getCrmv() + "\n"
							+ "CPF: " + v.getCPF() + "\n" + "EMAIL: " + v.getEmail() + "\n" + "DATA ADMISSÃO: "
							+ v.getDataAdmissao() + "\n\n";
					textArea.append(temp.toUpperCase());
				}
				
			} else if(tipo.equals("Todos")){
				for(Veterinario v : fachada.listarVeterinarios()) {
					temp = "ID: " + v.getId() + "\n" + "NOME: " + v.getNome() + "\n" + "CRMV: " + v.getCrmv() + "\n"
							+ "CPF: " + v.getCPF() + "\n" + "EMAIL: " + v.getEmail() + "\n" + "DATA ADMISSÃO: "
							+ v.getDataAdmissao() + "\n\n";
					textArea.append(temp.toUpperCase());
				}
				for(OperadorSistema op : fachada.listarOperadoresSistema()) {					
					temp = "ID: " + op.getId() + "\n" + "NOME: " + op.getNome() + "\n" + 
							"CPF: " + op.getCPF() + "\n" + "EMAIL: " + op.getEmail() + "\n" + "DATA ADMISSÃO: " + op.getDataAdmissao()
							 + "\n\n";
					textArea.append(temp.toUpperCase());;
				}
			}else 
				throw new IllegalArgumentException("Erro na Lista");
			
		} catch(IllegalArgumentException iae) {
			JOptionPane.showMessageDialog(null, iae.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private class EvntBtnVoltar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			textArea.setText("");
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelADM(frame));
			frame.setVisible(true);
		}
	}
	
}
