package gui_olimpio;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import clinica.pet_center.negocio.basicas.OperadorSistema;
import clinica.pet_center.negocio.cadastros.FachadaCadastro;
import clinica.pet_center.negocio.cadastros.IFachadaCadastro;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.utilidades.Contadores;

public class PanelCadastrarOperador extends JPanel {
	
	private JFrame frame;
	
	private JTextField tfDataNascimento;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfEmail;
	private JPasswordField pfConfirmaSenha;
	private JPasswordField pfSenha;
	
	private IFachadaCadastro fachada;
	

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
		lblSubTitulo.setBounds(34, 23, 269, 36);
		add(lblSubTitulo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(85, 92, 46, 14);
		add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(195, 89, 320, 20);
		add(tfNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(85, 132, 46, 14);
		add(lblCpf);
		
		tfCpf = new JTextField();
		tfCpf.setColumns(10);
		tfCpf.setBounds(195, 129, 320, 20);
		add(tfCpf);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(85, 172, 100, 14);
		add(lblDataDeNascimento);
		
		tfDataNascimento = new JTextField();
		tfDataNascimento.setBounds(195, 169, 320, 20);
		add(tfDataNascimento);
		tfDataNascimento.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(85, 212, 46, 14);
		add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(195, 209, 320, 20);
		add(tfEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(85, 252, 46, 14);
		add(lblSenha);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(195, 249, 320, 20);
		add(pfSenha);
		
		JLabel lblConfirmeASenha = new JLabel("Confirme a Senha");
		lblConfirmeASenha.setBounds(85, 292, 100, 14);
		add(lblConfirmeASenha);
		
		pfConfirmaSenha = new JPasswordField();
		pfConfirmaSenha.setBounds(195, 289, 320, 20);
		add(pfConfirmaSenha);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(495, 366, 95, 23);
		add(btnCadastrar);
		btnCadastrar.addActionListener(new EvntBtnCadastrar());
		
		JButton btnVoltarPanelAdm = new JButton("Voltar");
		btnVoltarPanelAdm.setBounds(390, 366, 95, 23);
		add(btnVoltarPanelAdm);
		btnVoltarPanelAdm.addActionListener(new EvntBtnVoltarPanelAdm());

	}
	
	private void setFrame(JFrame frame){
		this.frame = frame;
	}
	
	private class EvntBtnCadastrar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String senha = new String(pfSenha.getPassword());
			String cSenha = new String(pfConfirmaSenha.getPassword());
			
			OperadorSistema op = new OperadorSistema(tfNome.getText(), tfCpf.getText(), tfDataNascimento.getText(), 
					tfEmail.getText(), "02/12/2015", senha);
			
			try {
				
				fachada.cadastrarFuncionario(op);
				JOptionPane.showMessageDialog(null, op.getId(), "Cadastro", JOptionPane.PLAIN_MESSAGE);
				
				
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
