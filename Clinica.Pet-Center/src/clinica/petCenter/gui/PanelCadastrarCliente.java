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
import javax.swing.JTextField;

import clinica.petCenter.negocio.cadastros.FachadaCadastro;
import clinica.petCenter.negocio.cadastros.IFachadaCadastro;
import clinica.petCenter.negocio.classesBasicas.Cliente;
import clinica.petCenter.negocio.classesBasicas.OperadorSistema;
import clinica.petCenter.negocio.exceptions.IDIException;
import clinica.petCenter.negocio.exceptions.OExistenteException;
import clinica.petCenter.utilidades.Contadores;

public class PanelCadastrarCliente extends JPanel {
	
	private JFrame frame;
	
	private JTextField tfDataNascimento;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfEmail;
	
	private OperadorSistema op;
	private IFachadaCadastro fachada;

	/**
	 * Create the panel.
	 */
	public PanelCadastrarCliente(JFrame frame, OperadorSistema op) {
		
		setFrame(frame);
		setPreferredSize(new Dimension(600,400));
		setLayout(null);
		setOp(op);
		
		fachada = FachadaCadastro.getInstance();
		
		JLabel lblTitulo = new JLabel("Cadastro de Cliente");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(40, 25, 239, 40);
		add(lblTitulo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(85, 113, 46, 14);
		add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(195, 110, 320, 20);
		add(tfNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(85, 144, 46, 14);
		add(lblCpf);
		
		tfCpf = new JTextField();
		tfCpf.setColumns(10);
		tfCpf.setBounds(195, 141, 320, 20);
		add(tfCpf);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(85, 175, 100, 14);
		add(lblDataDeNascimento);
		
		tfDataNascimento = new JTextField();
		tfDataNascimento.setBounds(195, 172, 320, 20);
		add(tfDataNascimento);
		tfDataNascimento.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(85, 206, 46, 14);
		add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(195, 203, 320, 20);
		add(tfEmail);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(495, 366, 95, 23);
		add(btnCadastrar);
		btnCadastrar.addActionListener(new EvntBtnCadastrar());
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(385, 366, 95, 23);
		add(btnVoltar);
		btnVoltar.addActionListener(new EvntBtnVoltar());
	}
	
	private void setFrame(JFrame frame){
		this.frame = frame;
	}
	
	public OperadorSistema getOp() {
		return op;
	}

	public void setOp(OperadorSistema op) {
		this.op = op;
	}

	private class EvntBtnCadastrar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			try {
				if(!tfNome.getText().isEmpty() &&  !tfCpf.getText().isEmpty() &&
						!tfDataNascimento.getText().isEmpty() && !tfEmail.getText().isEmpty()) {
					
					Cliente c = new Cliente(tfNome.getText(), tfCpf.getText(), tfDataNascimento.getText(), tfEmail.getText());
					
					fachada.cadastrarCliente(c);
					
					JOptionPane.showMessageDialog(null, "Cliente " + c.getId() + " cadastrado com sucesso!", 
							"Sucesso", JOptionPane.PLAIN_MESSAGE);
					
					frame.getContentPane().setVisible(false);
					frame.setContentPane(new PanelOperadorSistema(frame, getOp()));
					frame.getContentPane().setVisible(true);	
				} else
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Atenção", JOptionPane.WARNING_MESSAGE);
				
			} catch(OExistenteException ooe) {
				JOptionPane.showMessageDialog(null, "Cliente já cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
				tfNome.setText("");
				tfCpf.setText("");
				tfDataNascimento.setText("");
				tfEmail.setText("");
				Contadores.decrementaPessoas();
				
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	private class EvntBtnVoltar implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelOperadorSistema(frame, getOp()));
			frame.getContentPane().setVisible(true);	
			
		}
	}
}