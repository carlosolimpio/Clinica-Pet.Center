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
import clinica.petCenter.negocio.exceptions.IDIException;
import clinica.petCenter.negocio.exceptions.ONExistenteException;
import clinica.petCenter.utilidades.Util;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PanelOperadorSistema extends JPanel {

	private JFrame frame;
	private JTextField tfBuscar;
	private JTextArea txtrBusca;
	private JComboBox comboBox;
	
	private IFachadaCadastro fachada;
	private OperadorSistema op;
	
	/**
	 * Create the panel.
	 */
	public PanelOperadorSistema(JFrame frame, OperadorSistema op) {
		
		setFrame(frame);
		setPreferredSize(new Dimension(600,400));
		setLayout(null);
		setOperadorSistema(op);
		
		fachada = FachadaCadastro.getInstance();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 600, 21);
		add(menuBar);
		
		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		JMenuItem mntmCadastrarCliente = new JMenuItem("Cadastrar");
		mnCliente.add(mntmCadastrarCliente);
		mntmCadastrarCliente.addActionListener(new EvntMntmCadastrarCliente());
		
		JMenuItem mntmAtualizarCliente = new JMenuItem("Atualizar");
		mnCliente.add(mntmAtualizarCliente);
		mntmAtualizarCliente.addActionListener(new EvntMntmAtualizarCliente());
		
		JMenuItem mntmRemoverCliente = new JMenuItem("Remover");
		mnCliente.add(mntmRemoverCliente);
		mntmRemoverCliente.addActionListener(new EvntMntmRemoverCliente());
		
		JMenu mnAnimal = new JMenu("Animal");
		menuBar.add(mnAnimal);
		
		JMenuItem mntmCadastrarAnimal = new JMenuItem("Cadastrar");
		mnAnimal.add(mntmCadastrarAnimal);
		mntmCadastrarAnimal.addActionListener(new EvntMntmCadastrarAnimal());
		
		JMenuItem mntmAtualizarAnimal = new JMenuItem("Atualizar");
		mnAnimal.add(mntmAtualizarAnimal);
		mntmAtualizarAnimal.addActionListener(new EvntMntmAtualizarAnimal());
		
		JMenuItem mntmRemoverAnimal = new JMenuItem("Remover");
		mnAnimal.add(mntmRemoverAnimal);
		mntmRemoverAnimal.addActionListener(new EvntMntmRemoverAnimal());
		
		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);
		
		JMenuItem mntmAgendarConsulta = new JMenuItem("Agendar Consulta");
		mnConsultas.add(mntmAgendarConsulta);
		mntmAgendarConsulta.addActionListener(new EvtnMntmAgendarConsulta());
		
		JMenuItem mntmCancelarConsulta = new JMenuItem("Cancelar Consulta");
		mnConsultas.add(mntmCancelarConsulta);
		mntmCancelarConsulta.addActionListener(new EvtnMntmCancelarConsulta());
		
		JLabel lblIdOpSist = new JLabel("Operador ID " + getOperadorSistema().getId());
		lblIdOpSist.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdOpSist.setBounds(42, 46, 199, 23);
		add(lblIdOpSist);
		
		JLabel lblBuscarId = new JLabel("Buscar ID");
		lblBuscarId.setBounds(42, 109, 71, 14);
		add(lblBuscarId);
		
		tfBuscar = new JTextField();
		tfBuscar.setBounds(101, 106, 134, 20);
		add(tfBuscar);
		tfBuscar.setColumns(10);
		
		ButtonGroup agrupaBtns = new ButtonGroup();
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(245, 105, 89, 23);
		add(btnBuscar);
		btnBuscar.addActionListener(new EvntBtnBuscar());
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(391, 105, 146, 23);
		add(btnListar);
		btnListar.addActionListener(new EvntBtnListar());
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(501, 366, 89, 23);
		add(btnSair);
		btnSair.addActionListener(new EvntBtnSair());
		
		txtrBusca = new JTextArea();
		txtrBusca.setBounds(42, 139, 427, 207);
		add(txtrBusca);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Animais", "Clientes", "Consultas", "Todos"}));
		comboBox.setBounds(391, 71, 146, 20);
		add(comboBox);
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
	
	
	private class EvntBtnBuscar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String id = tfBuscar.getText();
			String temp;
			txtrBusca.setText("");
			String idBusca = Util.whatId(id);
			
			try {
				
				if(idBusca.equals("ANM")) {
					
					Animal a = fachada.buscarAnimalId(id);
					temp = "ID: " + a.getId() + "\n" + "ESPÉCIE: " + a.getEspecie() + "\n" + 
							"RAÇA: " + a.getRaca() + "\n" + "ID DONO: " + a.getIdDono();
					txtrBusca.append(temp.toUpperCase());
					tfBuscar.setText("");
					
				} else if(idBusca.equals("CL")) {
					
					Cliente c = fachada.buscarCliente(id);
					temp = "ID: " + c.getId() + "\n" + "NOME: " + c.getNome() + "\n" + 
							"CPF: " + c.getCPF() + "\n" + "EMAIL: " + c.getEmail();
					txtrBusca.append(temp.toUpperCase());
					tfBuscar.setText("");
					
				} else if(idBusca.equals("CONSULTA")) {
					
					Consulta co = fachada.buscarConsulta(id);
					temp = "ID: " + co.getIdConsulta() + "\n" + "DATA: " + co.getData() + "\n" + 
							"ID ANIMAL: " + co.getAnimal().getId() + "\n" + "ID VETERINÁRIO: " + co.getVeterinario().getId();
					txtrBusca.append(temp.toUpperCase());
					tfBuscar.setText("");
					
				} else {
					JOptionPane.showMessageDialog(null, "Selecione o tipo de busca!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				
			} catch(IDIException idie) {
				JOptionPane.showMessageDialog(null, "ID incorreto ou fora do padrão.", "Erro", JOptionPane.ERROR_MESSAGE);
				tfBuscar.setText("");
			} catch(ONExistenteException onee) {
				JOptionPane.showMessageDialog(null, "Objeto não encontrado no sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
				tfBuscar.setText("");
			}
		}
	}
	
	private class EvntBtnListar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String s = (String)comboBox.getSelectedItem();
			
			if(s.equals("Animais")) {
				
				frame.getContentPane().setVisible(false);
				frame.setContentPane(new PanelListarTodos(frame, "Animais", getOperadorSistema()));
				frame.getContentPane().setVisible(true);
				
			} else if(s.equals("Clientes")) {
				
				frame.getContentPane().setVisible(false);
				frame.setContentPane(new PanelListarTodos(frame, "Clientes", getOperadorSistema()));
				frame.getContentPane().setVisible(true);
				
			} else if(s.equals("Consultas")) {
				
				frame.getContentPane().setVisible(false);
				frame.setContentPane(new PanelListarTodos(frame, "Consultas", getOperadorSistema()));
				frame.getContentPane().setVisible(true);
				
			} else if(s.equals("Todos")){

				frame.getContentPane().setVisible(false);
				frame.setContentPane(new PanelListarTodos(frame, "Todos", getOperadorSistema()));
				frame.getContentPane().setVisible(true);
			}
				
		}
	}
	
	private class EvntMntmCadastrarCliente implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelCadastrarCliente(frame, getOperadorSistema()));
			frame.getContentPane().setVisible(true);	
			
		}
	}
	
	private class EvntMntmAtualizarCliente implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelAtualizarCliente(frame, getOperadorSistema()));
			frame.getContentPane().setVisible(true);
			
		}
	}
	
	private class EvntMntmRemoverCliente implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelRemoverCliente(frame, getOperadorSistema()));
			frame.getContentPane().setVisible(true);	
			
		}
	}
	
	private class EvntMntmCadastrarAnimal implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelCadastrarAnimal(frame, getOperadorSistema()));
			frame.getContentPane().setVisible(true);
		}
	}
	
	private class EvntMntmAtualizarAnimal implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelAtualizarAnimal(frame, getOperadorSistema()));
			frame.getContentPane().setVisible(true);
		}
	}
	
	private class EvntMntmRemoverAnimal implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelRemoverAnimal(frame, getOperadorSistema()));
			frame.getContentPane().setVisible(true);
		}
	}
	
	private class EvtnMntmAgendarConsulta implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelAgendarConsulta(frame, getOperadorSistema()));
			frame.getContentPane().setVisible(true);
		}
	}
	
	private class EvtnMntmCancelarConsulta implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelCancelarConsulta(frame, getOperadorSistema()));
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
