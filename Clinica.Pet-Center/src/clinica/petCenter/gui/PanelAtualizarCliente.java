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
import clinica.petCenter.negocio.classesBasicas.Cliente;
import clinica.petCenter.negocio.classesBasicas.OperadorSistema;
import clinica.petCenter.negocio.exceptions.IDIException;
import clinica.petCenter.negocio.exceptions.ONExistenteException;

public class PanelAtualizarCliente extends JPanel {

	private JFrame frame;
	
	private JTextField tfDataNascimento;
	private JTextField tfIdCliente;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfEmail;
	
	private OperadorSistema op;
	private IFachadaCadastro fachada;

	/**
	 * Create the panel.
	 */
	public PanelAtualizarCliente(JFrame frame, OperadorSistema op) {
		
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
		
		JLabel lblTitulo = new JLabel("Atualizar Cliente");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(42, 25, 274, 44);
		add(lblTitulo);
		
		JLabel lblIdCliente = new JLabel("ID Cliente");
		lblIdCliente.setBounds(42, 103, 75, 14);
		add(lblIdCliente);
		
		tfIdCliente = new JTextField();
		tfIdCliente.setColumns(10);
		tfIdCliente.setBounds(127, 100, 138, 20);
		add(tfIdCliente);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(275, 99, 89, 23);
		add(btnBuscar);
		btnBuscar.addActionListener(new EvntBtnBuscar());
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(93, 168, 46, 14);
		add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(203, 165, 320, 20);
		add(tfNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(93, 199, 46, 14);
		add(lblCpf);
		
		tfCpf = new JTextField();
		tfCpf.setColumns(10);
		tfCpf.setBounds(203, 196, 320, 20);
		add(tfCpf);
		
		JLabel lblDataNascimento = new JLabel("Data de Nascimento");
		lblDataNascimento.setBounds(93, 230, 100, 14);
		add(lblDataNascimento);
		
		tfDataNascimento = new JTextField();
		tfDataNascimento.setBounds(203, 227, 320, 20);
		add(tfDataNascimento);
		tfDataNascimento.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(93, 260, 46, 14);
		add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(203, 257, 320, 20);
		add(tfEmail);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(488, 366, 89, 23);
		add(btnAtualizar);
		btnAtualizar.addActionListener(new EvntBtnAtualizar());
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(389, 366, 89, 23);
		add(btnVoltar);
		btnVoltar.addActionListener(new EvntBtnVoltar());
		
	}
	
	private void setFrame(JFrame frame){
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
				
				Cliente c = fachada.buscarCliente(tfIdCliente.getText());
				
				tfNome.setText(c.getNome());
				tfCpf.setText(c.getCPF());
				tfDataNascimento.setText(c.getDataNascimento());
				tfEmail.setText(c.getEmail());
				
			} catch(IDIException iie) {
				JOptionPane.showMessageDialog(null, "ID incorreto ou fora do padrão.", "Erro", JOptionPane.ERROR_MESSAGE);
				tfIdCliente.setText("");
			} catch(ONExistenteException onee) {
				JOptionPane.showMessageDialog(null, "Cliente não encontrado no sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
				tfIdCliente.setText("");
			}
		}
	}
	
	private class EvntBtnAtualizar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			try {
				
				if(!tfIdCliente.getText().isEmpty() && !tfNome.getText().isEmpty() &&  !tfCpf.getText().isEmpty() &&
						!tfDataNascimento.getText().isEmpty() && !tfEmail.getText().isEmpty()) {
					
					Cliente c = new Cliente(tfIdCliente.getText(), tfNome.getText(), tfCpf.getText(), 
							tfDataNascimento.getText(), tfEmail.getText());
					
					fachada.alterarCliente(c, tfIdCliente.getText());
					
					JOptionPane.showMessageDialog(null, "Cliente " + c.getId() + " atualizado com sucesso!", 
							"Sucesso", JOptionPane.PLAIN_MESSAGE);
					
					tfIdCliente.setText("");
					tfNome.setText("");
					tfCpf.setText("");
					tfDataNascimento.setText("");
					tfEmail.setText("");
					
				} else
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Atenção", JOptionPane.WARNING_MESSAGE);
				
			} catch(IDIException iie) {
				JOptionPane.showMessageDialog(null, "ID incorreto ou fora do padrão.", "Erro", JOptionPane.ERROR_MESSAGE);
				tfIdCliente.setText("");
			} catch(ONExistenteException onee) {
				JOptionPane.showMessageDialog(null, "Cliente não encontrado no sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
				tfIdCliente.setText("");
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
