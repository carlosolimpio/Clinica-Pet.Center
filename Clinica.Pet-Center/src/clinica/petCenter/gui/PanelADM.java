package clinica.petCenter.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clinica.petCenter.negocio.cadastros.FachadaCadastro;
import clinica.petCenter.negocio.cadastros.IFachadaCadastro;
import clinica.petCenter.negocio.classesBasicas.Animal;
import clinica.petCenter.negocio.classesBasicas.Cliente;
import clinica.petCenter.negocio.classesBasicas.Consulta;
import clinica.petCenter.negocio.classesBasicas.OperadorSistema;
import clinica.petCenter.negocio.classesBasicas.Veterinario;
import clinica.petCenter.negocio.exceptions.IDIException;
import clinica.petCenter.negocio.exceptions.ONExistenteException;

public class PanelADM extends JPanel {

	private JFrame frame;
	private JTextField tfBuscar;
	
	private IFachadaCadastro fachada;
	
	private JTextArea txtrBusca;
	private JRadioButton rdBtnVeterinario;
	private JRadioButton rdBtnOperador;
	
	public PanelADM (JFrame frame) {
		
		setLayout(null);
		setPreferredSize(new Dimension(600,400));
		setFrame(frame);
		
		fachada = FachadaCadastro.getInstance();
		
		JLabel lblTitulo = new JLabel("ADMINISTRADOR");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(32, 43, 192, 37);
		add(lblTitulo);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 600, 21);
		add(menuBar);
		
		JMenu mnOperadorDeSistema = new JMenu("Operador de sistema");
		mnOperadorDeSistema.setBounds(50,0,140,21);
		menuBar.add(mnOperadorDeSistema);
		
		JMenuItem mntmCadastrarOperador = new JMenuItem("Cadastrar");   //=============================OK
		mnOperadorDeSistema.add(mntmCadastrarOperador);
		
		JMenuItem mntmAtualizarOperador = new JMenuItem("Atualizar");
		mnOperadorDeSistema.add(mntmAtualizarOperador);
		
		JMenuItem mntmRemoverOperador = new JMenuItem("Remover");
		mnOperadorDeSistema.add(mntmRemoverOperador);
		mntmCadastrarOperador.addActionListener(new EvntMntmCadastrarOperador());
		
		JMenu mnVeterinario = new JMenu("Veterin\u00E1rio");
		mnVeterinario.setBounds(170,0,70,21);
		menuBar.add(mnVeterinario);
		
		JMenuItem mntmCadastrarVeterinario = new JMenuItem("Cadastrar");
		mnVeterinario.add(mntmCadastrarVeterinario);
		
		JMenuItem mntmAtualizarVeterinario = new JMenuItem("Atualizar");
		mnVeterinario.add(mntmAtualizarVeterinario);
		
		JMenuItem mntmRemoverVeterinario = new JMenuItem("Remover");
		mnVeterinario.add(mntmRemoverVeterinario);
		EvntMntmCadastrarVeterinario evntCadastrarVeterinario = new EvntMntmCadastrarVeterinario();
		mntmCadastrarVeterinario.addActionListener(evntCadastrarVeterinario);
		
		JLabel label = new JLabel("Buscar ID");
		label.setBounds(42, 109, 71, 14);
		add(label);
		
		tfBuscar = new JTextField();
		tfBuscar.setColumns(10);
		tfBuscar.setBounds(101, 106, 134, 20);
		add(tfBuscar);
		
		rdBtnOperador = new JRadioButton("Operador de Sistema");
		rdBtnOperador.setBounds(42, 133, 127, 23);
		add(rdBtnOperador);
		
		rdBtnVeterinario = new JRadioButton("Veterin\u00E1rio");
		rdBtnVeterinario.setBounds(171, 133, 89, 23);
		add(rdBtnVeterinario);
		
		ButtonGroup agrupaBtns = new ButtonGroup();
		agrupaBtns.add(rdBtnOperador);
		agrupaBtns.add(rdBtnVeterinario);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(245, 105, 89, 23);
		add(btnBuscar);
		btnBuscar.addActionListener(new EvntBtnBuscar());
		
		JButton btnListarTodos = new JButton("Listar todos");
		btnListarTodos.setBounds(391, 105, 146, 23);
		add(btnListarTodos);
		btnListarTodos.addActionListener(new EvntBtnListarTodos());
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(501, 366, 89, 23);
		add(btnSair);
		btnSair.addActionListener(new EvntBtnSair());
		
		txtrBusca = new JTextArea();
		txtrBusca.setBounds(42, 193, 427, 153);
		add(txtrBusca);
		
	}	
	
	private void setFrame(JFrame frame){
		this.frame = frame;
	}
	
	private class EvntBtnBuscar implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String id = tfBuscar.getText();
			String temp;
			txtrBusca.setText("");
			
			try {
				
				if(rdBtnOperador.isSelected()) {
					
					OperadorSistema op = (OperadorSistema) fachada.buscarFuncionario(id);
					temp = "ID: " + op.getId() + "\n" + "NOME: " + op.getNome() + "\n" + 
							"CPF: " + op.getCPF() + "\n" + "EMAIL: " + op.getEmail() + "\n" + "DATA ADMISSÃO: " + op.getDataAdmissao();
					txtrBusca.append(temp.toUpperCase());
					tfBuscar.setText("");
					
				} else if(rdBtnVeterinario.isSelected()) {
					
					Veterinario v = (Veterinario) fachada.buscarFuncionario(id);
					temp = "ID: " + v.getId() + "\n" + "NOME: " + v.getNome() + "\n" + "CRMV: " + v.getCrmv() + "\n"
							+ "CPF: " + v.getCPF() + "\n" + "EMAIL: " + v.getEmail() + "\n" + "DATA ADMISSÃO: " + v.getDataAdmissao();
					txtrBusca.append(temp.toUpperCase());
					tfBuscar.setText("");
					
				} else 
					JOptionPane.showMessageDialog(null, "Selecione o tipo de busca!", "Erro", JOptionPane.ERROR_MESSAGE);
				
			} catch(IDIException idie) {
				JOptionPane.showMessageDialog(null, "ID incorreto ou fora do padrão.", "Erro", JOptionPane.ERROR_MESSAGE);
				tfBuscar.setText("");
			} catch(ONExistenteException onee) {
				JOptionPane.showMessageDialog(null, "Funcionario não encontrado no sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
				tfBuscar.setText("");
			}
		}
	}
	
	private class EvntBtnListarTodos implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(rdBtnOperador.isSelected()) {

				frame.getContentPane().setVisible(false);
				frame.setContentPane(new PanelADMListarTodos(frame, "Operadores de Sistema"));
				frame.getContentPane().setVisible(true);

			} else if(rdBtnVeterinario.isSelected()) {

				frame.getContentPane().setVisible(false);
				frame.setContentPane(new PanelADMListarTodos(frame, "Veterinários"));
				frame.getContentPane().setVisible(true);

			} else
				JOptionPane.showMessageDialog(null, "Selecione o tipo de listagem!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private class EvntMntmCadastrarOperador implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelCadastrarOperador(frame));
			frame.getContentPane().setVisible(true);
			
		}
	}
	
	private class EvntMntmCadastrarVeterinario implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelCadastrarVeterinario(frame));
			frame.getContentPane().setVisible(true);	
			
		}
	}
	
	private class EvntMntmRemoverAtualizarVeterinario implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelRemoverAtualizarVeterinario(frame));
			frame.getContentPane().setVisible(true);	
			
		}
	}
	
	private class EvntBtnSair implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			new TelaLogin().getFrame().setVisible(true);
		}
	}
}
