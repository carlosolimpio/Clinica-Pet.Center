package clinica.petCenter.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clinica.petCenter.negocio.cadastros.FachadaCadastro;
import clinica.petCenter.negocio.cadastros.IFachadaCadastro;
import clinica.petCenter.negocio.classesBasicas.Animal;
import clinica.petCenter.negocio.classesBasicas.OperadorSistema;
import clinica.petCenter.negocio.exceptions.IDIException;
import clinica.petCenter.negocio.exceptions.ONExistenteException;

public class PanelAtualizarAnimal extends JPanel {

	private JFrame frame;
	private OperadorSistema op;
	private IFachadaCadastro fachada;
	
	private JTextField tfIdAnimal;
	private JTextField tfNome;
	private JTextField tfEspecie;
	private JTextField tfRaca;
	private JTextField tfDataNascimento;
	private JTextField tfTipoSanguineo;
	private JTextField tfIdCliente;
	
	public PanelAtualizarAnimal(JFrame frame, OperadorSistema op) {
		
		setFrame(frame);
		setPreferredSize(new Dimension(600,400));
		setLayout(null);
		setOp(op);
		
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
		
		JLabel lblTitulo = new JLabel("Atualizar Animal");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(45, 25, 274, 44);
		add(lblTitulo);
		
		JLabel lblIdAnimal = new JLabel("ID Animal");
		lblIdAnimal.setBounds(45, 102, 67, 14);
		add(lblIdAnimal);
		
		tfIdAnimal = new JTextField();
		tfIdAnimal.setBounds(127, 100, 138, 20);
		add(tfIdAnimal);
		tfIdAnimal.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(275, 98, 89, 23);
		add(btnBuscar);
		btnBuscar.addActionListener(new EvntBtnBuscar());
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(93, 159, 46, 14);
		add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(201, 156, 320, 20);
		add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblEspcie = new JLabel("Espécie");
		lblEspcie.setBounds(93, 221, 46, 14);
		add(lblEspcie);
		
		tfEspecie = new JTextField();
		tfEspecie.setBounds(201, 187, 320, 20);
		add(tfEspecie);
		tfEspecie.setColumns(10);
		
		JLabel lblRaca = new JLabel("Raça");
		lblRaca.setBounds(93, 190, 46, 14);
		add(lblRaca);
		
		tfRaca = new JTextField();
		tfRaca.setBounds(201, 218, 320, 20);
		add(tfRaca);
		tfRaca.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento");
		lblDataDeNascimento.setBounds(93, 252, 101, 14);
		add(lblDataDeNascimento);
		
		tfDataNascimento = new JTextField();
		tfDataNascimento.setBounds(201, 249, 138, 20);
		add(tfDataNascimento);
		tfDataNascimento.setColumns(10);
		
		JLabel lblTipoSanguneo = new JLabel("Tipo sanguíneo");
		lblTipoSanguneo.setBounds(93, 283, 80, 14);
		add(lblTipoSanguneo);
		
		tfTipoSanguineo = new JTextField();
		tfTipoSanguineo.setBounds(201, 280, 138, 20);
		add(tfTipoSanguineo);
		tfTipoSanguineo.setColumns(10);
		
		JLabel lblIdCliente = new JLabel("ID Cliente");
		lblIdCliente.setBounds(93, 314, 80, 14);
		add(lblIdCliente);
		
		tfIdCliente = new JTextField();
		tfIdCliente.setBounds(201, 311, 138, 20);
		add(tfIdCliente);
		tfIdCliente.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(402, 366, 89, 23);
		add(btnVoltar);
		btnVoltar.addActionListener(new EvntBtnVoltar());
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(501, 366, 89, 23);
		add(btnAtualizar);
		btnAtualizar.addActionListener(new EvntBtnAtualizar());
	}

	private void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public OperadorSistema getOperadorSistema() {
		return op;
	}

	public void setOp(OperadorSistema op) {
		this.op = op;
	}
	
	private class EvntBtnBuscar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			try {
				
				Animal a = fachada.buscarAnimalId(tfIdAnimal.getText());
				
				tfNome.setText(a.getNome());
				tfEspecie.setText(a.getEspecie());
				tfRaca.setText(a.getRaca());
				tfDataNascimento.setText(a.getDataNascimento());
				tfTipoSanguineo.setText(a.getTipoSanguineo());
				tfIdCliente.setText(a.getIdDono());
				
			} catch(IDIException iie) {
				JOptionPane.showMessageDialog(null, "ID incorreto ou fora do padrão.", "Erro", JOptionPane.ERROR_MESSAGE);
				tfIdAnimal.setText("");
			} catch(ONExistenteException onee) {
				JOptionPane.showMessageDialog(null, "Cliente não encontrado no sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
				tfIdAnimal.setText("");
			}
		}
	}
	
	private class EvntBtnAtualizar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			try {
				
				if(!tfNome.getText().isEmpty() && !tfDataNascimento.getText().isEmpty() && 
						!tfEspecie.getText().isEmpty() && !tfRaca.getText().isEmpty() && 
						!tfTipoSanguineo.getText().isEmpty() && !tfIdCliente.getText().isEmpty()) {
					
					Animal a = new Animal(tfIdAnimal.getText(), tfNome.getText(), tfEspecie.getText(), 
							tfRaca.getText(), tfDataNascimento.getText(), tfIdCliente.getText(), tfTipoSanguineo.getText());
					
					fachada.alterarAnimal(tfIdAnimal.getText(), a);
					JOptionPane.showMessageDialog(null, "Animal " + a.getId() + " atualizado com sucesso!", 
							"Sucesso", JOptionPane.PLAIN_MESSAGE);
					
					tfNome.setText("");
					tfDataNascimento.setText("");
					tfEspecie.setText("");
					tfIdCliente.setText("");
					tfRaca.setText("");
					tfTipoSanguineo.setText("");
					tfIdAnimal.setText("");
				} else
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Atenção", JOptionPane.WARNING_MESSAGE);
				
			} catch(IDIException iie) {
				JOptionPane.showMessageDialog(null, "ID incorreto ou fora do padrão.", "Erro", JOptionPane.ERROR_MESSAGE);
				tfIdAnimal.setText("");
			} catch(ONExistenteException onee) {
				JOptionPane.showMessageDialog(null, "Animal não encontrado no sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
				tfIdAnimal.setText("");
			}
		}
	}
	
	private class EvntBtnVoltar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelOperadorSistema(frame, getOperadorSistema()));
			frame.getContentPane().setVisible(true);	
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
}
