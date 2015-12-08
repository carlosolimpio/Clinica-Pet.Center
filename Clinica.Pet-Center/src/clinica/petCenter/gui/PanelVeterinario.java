package clinica.petCenter.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import clinica.petCenter.negocio.cadastros.IFachadaCadastro;
import clinica.petCenter.negocio.classesBasicas.OperadorSistema;
import clinica.petCenter.negocio.classesBasicas.Veterinario;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class PanelVeterinario extends JPanel {

	private JFrame frame;
	private JLabel lblNomeVet;
	private JLabel lblIdVet;
	private JTextArea textArea;
	
	private IFachadaCadastro fachada;
	private Veterinario vet;
	private JTextField tfBuscaId;

	public PanelVeterinario(JFrame frame, Veterinario vet) {
		
		setFrame(frame);
		setPreferredSize(new Dimension(600,400));
		setLayout(null);
		
		lblNomeVet = new JLabel("Bem Vindo, veterinario " + vet.getNome());
		lblNomeVet.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNomeVet.setBounds(32, 30, 307, 39);
		add(lblNomeVet);
		
		lblIdVet = new JLabel("ID " + vet.getId());
		lblIdVet.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIdVet.setBounds(32, 56, 307, 39);
		add(lblIdVet);
		
		JLabel label = new JLabel("Buscar ID");
		label.setBounds(32, 109, 71, 14);
		add(label);
		
		tfBuscaId = new JTextField();
		tfBuscaId.setColumns(10);
		tfBuscaId.setBounds(91, 106, 134, 20);
		add(tfBuscaId);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(235, 105, 89, 23);
		add(btnBuscar);
		
		JButton btnListarTodos = new JButton("Listar todas");
		btnListarTodos.setBounds(381, 105, 146, 23);
		add(btnListarTodos);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(491, 366, 89, 23);
		add(btnSair);
		btnSair.addActionListener(new EvntBtnSair());
		
		textArea = new JTextArea();
		textArea.setBounds(32, 149, 457, 197);
		add(textArea);
		

	}

	private void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	private class EvntBtnSair implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			new TelaLogin().getFrame().setVisible(true);
		}
	}
}
