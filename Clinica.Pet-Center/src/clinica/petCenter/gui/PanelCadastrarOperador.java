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
import clinica.petCenter.negocio.classesBasicas.OperadorSistema;
import clinica.petCenter.negocio.exceptions.OExistenteException;
import clinica.petCenter.utilidades.Contadores;

public class PanelCadastrarOperador extends JPanel {
	
	private JFrame frame;
	
	private JTextField tfDataNascimento;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfEmail;
	private JPasswordField pfConfirmaSenha;
	private JPasswordField pfSenha;
	
	private IFachadaCadastro fachada;
	private JTextField tfDataAdmissao;
	

	/**
	 * Create the panel.
	 */
	public PanelCadastrarOperador(JFrame frame) {
		
		setFrame(frame);
		setPreferredSize(new Dimension(600, 400));
		setLayout(null);
		
		fachada = FachadaCadastro.getInstance();
		
		JLabel lblSubTitulo = new JLabel("Cadastro de Operador de Sistema");
		lblSubTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSubTitulo.setBounds(34, 40, 269, 36);
		add(lblSubTitulo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(115, 118, 46, 14);
		add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(215, 115, 320, 20);
		add(tfNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(115, 149, 46, 14);
		add(lblCpf);
		
		tfCpf = new JTextField();
		tfCpf.setColumns(10);
		tfCpf.setBounds(215, 146, 320, 20);
		add(tfCpf);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(115, 180, 100, 14);
		add(lblDataDeNascimento);
		
		tfDataNascimento = new JTextField();
		tfDataNascimento.setBounds(215, 177, 139, 20);
		add(tfDataNascimento);
		tfDataNascimento.setColumns(10);
		
		JLabel lblDataDeAdmissao = new JLabel("Data de Admiss\u00E3o");
		lblDataDeAdmissao.setBounds(115, 208, 100, 14);
		add(lblDataDeAdmissao);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(115, 236, 46, 14);
		add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(215, 233, 220, 20);
		add(tfEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(115, 267, 46, 14);
		add(lblSenha);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(215, 264, 139, 20);
		add(pfSenha);
		
		JLabel lblConfirmeASenha = new JLabel("Confirme a Senha");
		lblConfirmeASenha.setBounds(115, 298, 100, 14);
		add(lblConfirmeASenha);
		
		pfConfirmaSenha = new JPasswordField();
		pfConfirmaSenha.setBounds(215, 295, 139, 20);
		add(pfConfirmaSenha);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(495, 366, 95, 23);
		add(btnCadastrar);
		btnCadastrar.addActionListener(new EvntBtnCadastrar());
		
		JButton btnVoltarPanelAdm = new JButton("Voltar");
		btnVoltarPanelAdm.setBounds(390, 366, 95, 23);
		add(btnVoltarPanelAdm);
		
		tfDataAdmissao = new JTextField();
		tfDataAdmissao.setBounds(215, 205, 139, 20);
		add(tfDataAdmissao);
		tfDataAdmissao.setColumns(10);
		btnVoltarPanelAdm.addActionListener(new EvntBtnVoltarPanelAdm());
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(291, 366, 89, 23);
		add(btnLimpar);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 600, 21);
		add(menuBar);
		
		JMenu mnOperadordeSistema = new JMenu("Operador de sistema");
		menuBar.add(mnOperadordeSistema);
		
		JMenuItem mntmCadastrarOperador = new JMenuItem("Cadastrar");
		mnOperadordeSistema.add(mntmCadastrarOperador);
		mntmCadastrarOperador.addActionListener(new EvntMntmCadastrarOperador());
		
		JMenuItem mntmRemoverAtualizarOperador = new JMenuItem("Remover / Atualizar");
		mnOperadordeSistema.add(mntmRemoverAtualizarOperador);
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
		tfCpf.setText("");
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
			
			if(!tfCpf.getText().isEmpty() && !tfDataAdmissao.getText().isEmpty() && !tfDataNascimento.getText().isEmpty() &&
					!tfEmail.getText().isEmpty() && !tfNome.getText().isEmpty() && !senha.isEmpty() && !cSenha.isEmpty()) {
				if(senha.length() > 8){
					if(senha.equals(cSenha)) {
						OperadorSistema op = new OperadorSistema(tfNome.getText(), tfCpf.getText(), tfDataNascimento.getText(), 
								tfEmail.getText(), tfDataAdmissao.getText(), senha);
						
						try {
							
							fachada.cadastrarFuncionario(op);
							JOptionPane.showMessageDialog(null, "Operador " + op.getId() + " cadastrado com sucesso!", 
									"Sucesso", JOptionPane.PLAIN_MESSAGE);
							limpar();
							
							
						} catch(OExistenteException oee) {
							JOptionPane.showMessageDialog(null, "Operador já cadastrado no sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
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
	
	private class EvntBtnVoltarPanelAdm implements ActionListener {
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
