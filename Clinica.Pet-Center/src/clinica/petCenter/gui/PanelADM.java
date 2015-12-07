package clinica.petCenter.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clinica.petCenter.negocio.cadastros.FachadaCadastro;
import clinica.petCenter.negocio.cadastros.IFachadaCadastro;
import clinica.petCenter.negocio.classesBasicas.OperadorSistema;
import clinica.petCenter.negocio.classesBasicas.Veterinario;
import clinica.petCenter.negocio.exceptions.IDIException;
import clinica.petCenter.negocio.exceptions.ONExistenteException;
import clinica.petCenter.utilidades.Util;

public class PanelADM extends JPanel {

	private JFrame frame;
	private JTextField tfBuscar;
	private JComboBox comboBox;
	private IFachadaCadastro fachada;
	
	private JTextArea txtrBusca;
	
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
		
		JMenuItem mntmCadastrarOperador = new JMenuItem("Cadastrar");   
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
		
		ButtonGroup agrupaBtns = new ButtonGroup();
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(245, 105, 89, 23);
		add(btnBuscar);
		btnBuscar.addActionListener(new EvntBtnBuscar());
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(391, 105, 146, 23);
		add(btnListar);
		btnListar.addActionListener(new EvntBtnListarTodos());
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(501, 366, 89, 23);
		add(btnSair);
		btnSair.addActionListener(new EvntBtnSair());
		
		txtrBusca = new JTextArea();
		txtrBusca.setBounds(42, 149, 457, 197);
		add(txtrBusca);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Operador de Sistema", "Veterinario"}));
		comboBox.setBounds(391, 74, 146, 20);
		add(comboBox);
		
	}	
	
	private void setFrame(JFrame frame){
		this.frame = frame;
	}
	
	private class EvntBtnBuscar implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String id = tfBuscar.getText();
			String temp;
			txtrBusca.setText("");
			String idBusca = Util.whatId(id);
			
			try {
				
				if(idBusca.equals("OP")) {
					
					OperadorSistema op = (OperadorSistema) fachada.buscarFuncionario(id);
					temp = "ID: " + op.getId() + "\n" + "NOME: " + op.getNome() + "\n" + 
							"CPF: " + op.getCPF() + "\n" + "EMAIL: " + op.getEmail() + "\n" + "DATA ADMISSÃO: " + op.getDataAdmissao();
					txtrBusca.append(temp.toUpperCase());
					tfBuscar.setText("");
					
				} else if(idBusca.equals("VT")) {
					
					Veterinario v = (Veterinario) fachada.buscarFuncionario(id);
					temp = "ID: " + v.getId() + "\n" + "NOME: " + v.getNome() + "\n" + "CRMV: " + v.getCrmv() + "\n"
							+ "CPF: " + v.getCPF() + "\n" + "EMAIL: " + v.getEmail() + "\n" + "DATA ADMISSÃO: " + v.getDataAdmissao();
					txtrBusca.append(temp.toUpperCase());
					tfBuscar.setText("");
					
				}
				
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
			
			String s = (String)comboBox.getSelectedItem();
			
			
			if(s.equals("Operador de Sistema")) {

				frame.getContentPane().setVisible(false);
				frame.setContentPane(new PanelADMListarTodos(frame, "Operadores de Sistema"));
				frame.getContentPane().setVisible(true);

			} else if(s.equals("Veterinario")) {

				frame.getContentPane().setVisible(false);
				frame.setContentPane(new PanelADMListarTodos(frame, "Veterinários"));
				frame.getContentPane().setVisible(true);

			} else if(s.equals("Todos")) {
				frame.getContentPane().setVisible(false);
				frame.setContentPane(new PanelADMListarTodos(frame, "Todos"));
				frame.getContentPane().setVisible(true);
			}
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
