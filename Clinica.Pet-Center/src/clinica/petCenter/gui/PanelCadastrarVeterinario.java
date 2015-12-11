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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import clinica.petCenter.negocio.cadastros.FachadaCadastro;
import clinica.petCenter.negocio.cadastros.IFachadaCadastro;
import clinica.petCenter.negocio.classesBasicas.Veterinario;
import clinica.petCenter.negocio.exceptions.OExistenteException;
import clinica.petCenter.utilidades.Contadores;

public class PanelCadastrarVeterinario extends JPanel {
	
	private JFrame frame;
	
	private JTextField tfDataNascimento;
	private JTextField tfNome;
	private JTextField tfCPF;
	private JTextField tfEmail;
	private JTextField tfCrmv;
	private JPasswordField pfSenha;
	private JPasswordField pfConfirmaSenha;
	
	private IFachadaCadastro fachada;
	private JTextField tfDataAdmissao;

	/**
	 * Create the panel.
	 */
	public PanelCadastrarVeterinario(JFrame frame) {
		
		setFrame(frame);
		setPreferredSize(new Dimension(600, 400));
		setLayout(null);
		
		fachada = FachadaCadastro.getInstance();
		
		JLabel lblTitulo = new JLabel("Cadastro de Veterin\u00E1rio");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(28, 11, 269, 36);
		add(lblTitulo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(82, 88, 46, 14);
		add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(192, 85, 318, 20);
		add(tfNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(82, 119, 46, 14);
		add(lblCpf);
		
		tfCPF = new JTextField();
		tfCPF.setColumns(10);
		tfCPF.setBounds(192, 116, 183, 20);
		add(tfCPF);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(82, 150, 100, 14);
		add(lblDataDeNascimento);
		
		tfDataNascimento = new JTextField();
		tfDataNascimento.setBounds(192, 147, 129, 20);
		add(tfDataNascimento);
		tfDataNascimento.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(82, 181, 46, 14);
		add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(192, 178, 183, 20);
		add(tfEmail);
		
		JLabel lblCrmv = new JLabel("CRMV");
		lblCrmv.setBounds(82, 212, 46, 14);
		add(lblCrmv);
		
		tfCrmv = new JTextField();
		tfCrmv.setColumns(10);
		tfCrmv.setBounds(192, 209, 129, 20);
		add(tfCrmv);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(82, 242, 46, 14);
		add(lblSenha);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(192, 239, 129, 20);
		add(pfSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setBounds(82, 273, 100, 14);
		add(lblConfirmarSenha);
		
		pfConfirmaSenha = new JPasswordField();
		pfConfirmaSenha.setBounds(192, 270, 129, 20);
		add(pfConfirmaSenha);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(501, 366, 89, 23);
		add(btnCadastrar);
		btnCadastrar.addActionListener(new EvntBtnCadastrar());
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(402, 366, 89, 23);
		add(btnVoltar);
		
		JLabel lblDataadmissao = new JLabel("Data Admissao");
		lblDataadmissao.setBounds(82, 303, 100, 14);
		add(lblDataadmissao);
		
		tfDataAdmissao = new JTextField();
		tfDataAdmissao.setBounds(192, 301, 129, 20);
		add(tfDataAdmissao);
		tfDataAdmissao.setColumns(10);
		btnVoltar.addActionListener(new EvntBtnVoltar());
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 600, 21);
		add(menuBar);
		
		JMenu mnOperadorDeSistema = new JMenu("Operador de sistema");
		menuBar.add(mnOperadorDeSistema);
		
		JMenuItem mntmCadastrarOperador = new JMenuItem("Cadastrar");
		mnOperadorDeSistema.add(mntmCadastrarOperador);
		mntmCadastrarOperador.addActionListener(new EvntMntmCadastrarOperador());
		
		JMenuItem mntmRemoverAtualizarOperador = new JMenuItem("Remover / Atualizar");
		mnOperadorDeSistema.add(mntmRemoverAtualizarOperador);
		mntmRemoverAtualizarOperador.addActionListener(new EvntMntmRemoverAtualizarOperador());
		
		JMenu mnVeterinario = new JMenu("Veterin\u00E1rio");
		menuBar.add(mnVeterinario);
		
		JMenuItem mntmCadastrarVeterinario = new JMenuItem("Cadastrar");
		mnVeterinario.add(mntmCadastrarVeterinario);
		mntmCadastrarVeterinario.addActionListener(new EvntMntmCadastrarVeterinario());
		
		JMenuItem mntmRemoverAtualizarVeterinario = new JMenuItem("Remover / Atualizar");
		mnVeterinario.add(mntmRemoverAtualizarVeterinario);
		mntmRemoverAtualizarVeterinario.addActionListener(new EvntMntmRemoverAtualizarVeterinario());

	}
	
	private void setFrame(JFrame frame){
		this.frame = frame;
	}
	
	public void limpar() {
		tfCPF.setText("");
		tfCrmv.setText("");
		tfDataAdmissao.setText("");
		tfDataNascimento.setText("");
		tfEmail.setText("");
		tfNome.setText("");
		pfSenha.setText("");
		pfConfirmaSenha.setText("");
		}
	
	
	private class EvntBtnCadastrar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		
			String senha = new String(pfSenha.getPassword());
			String cSenha = new String(pfConfirmaSenha.getPassword());
			String nome = tfNome.getText();
			String cpf = tfCPF.getText();
			String dataNascimento = tfDataNascimento.getText();
			String email = tfEmail.getText();
			String crmv = tfCrmv.getText();
			String dataAdmissao = tfDataAdmissao.getText();	
			
			if(!nome.isEmpty() && !dataAdmissao.isEmpty() && !cpf.isEmpty() && !dataNascimento.isEmpty() 
					&& !email.isEmpty() && !senha.isEmpty() && !cSenha.isEmpty() && !crmv.isEmpty()) {
			
				if(senha.length() > 8){
					if(senha.equals(cSenha)) {
						Veterinario v = new Veterinario(nome, cpf, dataNascimento, email, dataAdmissao, crmv, senha);
						
						try {
							
							fachada.cadastrarFuncionario(v);
							JOptionPane.showMessageDialog(null, "Veterinario " + v.getId() + " cadastrado com sucesso!", 
									"Sucesso", JOptionPane.PLAIN_MESSAGE);
							limpar();
							
							
						} catch(OExistenteException oee) {
							JOptionPane.showMessageDialog(null, "Veterinario já cadastrado no sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
							Contadores.decrementaPessoas();
							limpar();
						}
						
					} else {
						JOptionPane.showMessageDialog(null, "Senhas diferentes.", "Erro", JOptionPane.ERROR_MESSAGE);
						pfSenha.setText("");
						pfConfirmaSenha.setText("");
					}
				}
				else
					JOptionPane.showMessageDialog(null, "A senha tem que ter tamanho maior que oito caracteres!");

			} else
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);	
		}
	}
	
	private class EvntBtnVoltar implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelADM(frame));
			frame.getContentPane().setVisible(true);	
			
		}
		
	}
	
	private class EvntMntmCadastrarOperador implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelCadastrarOperador(frame));
			frame.getContentPane().setVisible(true);
			
		}
	}
	
	private class EvntMntmRemoverAtualizarOperador implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelRemoverAtualizarOperador(frame));
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
}
