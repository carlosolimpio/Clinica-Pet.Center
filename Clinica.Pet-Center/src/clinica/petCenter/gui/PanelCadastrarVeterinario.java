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
import clinica.petCenter.negocio.classesBasicas.Veterinario;
import clinica.petCenter.negocio.exceptions.OExistenteException;
import clinica.petCenter.utilidades.Contadores;

import javax.swing.JPasswordField;

public class PanelCadastrarVeterinario extends JPanel {
	
	private JFrame frame;
	
	private JTextField tfDataNascimento;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfEmail;
	private JTextField tfCrmv;

	private IFachadaCadastro fachada;
	private JPasswordField pfSenha;
	private JPasswordField pfCSenha;
	private JTextField tfDataAdmissao;
	/**
	 * Create the panel.
	 */
	public PanelCadastrarVeterinario(JFrame frame) {
		
		setFrame(frame);
		setPreferredSize(new Dimension(600, 400));
		setLayout(null);
		
		fachada = FachadaCadastro.getInstance();
		
		JLabel lblSubTitulo = new JLabel("Cadastro de Veterinario");
		lblSubTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSubTitulo.setBounds(29, 0, 269, 36);
		add(lblSubTitulo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(50, 50, 46, 14);
		add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(50, 90, 46, 14);
		add(lblCpf);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(50, 130, 100, 14);
		add(lblDataDeNascimento);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(50, 170, 46, 14);
		add(lblEmail);
		
		JLabel lblCrmv = new JLabel("CRMV");
		lblCrmv.setBounds(50, 210, 46, 14);
		add(lblCrmv);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(50, 250, 46, 14);
		add(lblSenha);
		
		tfDataNascimento = new JTextField();
		tfDataNascimento.setBounds(160, 127, 318, 20);
		add(tfDataNascimento);
		tfDataNascimento.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(160, 47, 318, 20);
		add(tfNome);
		
		tfCpf = new JTextField();
		tfCpf.setColumns(10);
		tfCpf.setBounds(160, 87, 318, 20);
		add(tfCpf);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(160, 167, 318, 20);
		add(tfEmail);
		
		tfCrmv = new JTextField();
		tfCrmv.setColumns(10);
		tfCrmv.setBounds(160, 207, 318, 20);
		add(tfCrmv);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setBounds(50, 290, 100, 14);
		add(lblConfirmarSenha);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(501, 366, 89, 23);
		add(btnCadastrar);
		btnCadastrar.addActionListener(new EvntBtnCadastrar());
		
		JButton btnVoltarPanelAdm = new JButton("Voltar");
		btnVoltarPanelAdm.setBounds(402, 366, 89, 23);
		add(btnVoltarPanelAdm);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(160, 247, 318, 20);
		add(pfSenha);
		
		pfCSenha = new JPasswordField();
		pfCSenha.setBounds(160, 287, 318, 20);
		add(pfCSenha);
		
		JLabel lblDataAdmissao = new JLabel("Data Admissao");
		lblDataAdmissao.setBounds(50, 330, 100, 14);
		add(lblDataAdmissao);
		
		tfDataAdmissao = new JTextField();
		tfDataAdmissao.setColumns(10);
		tfDataAdmissao.setBounds(160, 327, 318, 20);
		add(tfDataAdmissao);
		EvntBtnVoltarPanelAdm evntVoltarPanelAdm = new EvntBtnVoltarPanelAdm();
		btnVoltarPanelAdm.addActionListener(evntVoltarPanelAdm);

	}
	
	private void setFrame(JFrame frame){
		this.frame = frame;
	}
	
	private class EvntBtnCadastrar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String senha = new String(pfSenha.getPassword());
			String nome = tfNome.getText();
			String cpf = tfCpf.getText();
			String dataNascimento = tfDataNascimento.getText();
			String email = tfEmail.getText();
			String crmv = tfCrmv.getText();
			String dataAdmissao = tfDataAdmissao.getText();
			
			Veterinario vet = new Veterinario(nome, cpf, dataNascimento, email, dataAdmissao, crmv, senha);
			
			try {
				fachada.cadastrarFuncionario(vet);
				JOptionPane.showMessageDialog(null, vet.getId(), "Cadastro", JOptionPane.PLAIN_MESSAGE);
			} catch(OExistenteException oee) {
				JOptionPane.showMessageDialog(null, "Funcionario já cadastrado no sistema.", "Erro", JOptionPane.CANCEL_OPTION);
				Contadores.decrementaPessoas();
			}
		}
	}
	
	private class EvntBtnVoltarPanelAdm implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelADM(frame));
			frame.getContentPane().setVisible(true);	
			
		}
	}
}
