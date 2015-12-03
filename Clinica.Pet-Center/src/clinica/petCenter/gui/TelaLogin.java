package gui_olimpio;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import clinica.pet_center.negocio.basicas.Funcionario;
import clinica.pet_center.negocio.basicas.OperadorSistema;
import clinica.pet_center.negocio.basicas.Veterinario;
import clinica.pet_center.negocio.cadastros.FachadaCadastro;
import clinica.pet_center.negocio.cadastros.IFachadaCadastro;
import clinica.pet_center.negocio.exceptions.IDIException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;
import clinica.pet_center.negocio.exceptions.SenhaInvalidaException;
import clinica.pet_center.utilidades.Util;

public class TelaLogin {

	private JFrame frame;
	private JTextField tfId;
	private JPasswordField pfSenha;
	
	private IFachadaCadastro fachada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try { //aparencia do SO
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.getStackTrace();
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 610, 433);
		frame.setResizable(false);
		frame.setTitle("Clínica PetCenter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		fachada = FachadaCadastro.getInstance();
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(58, 58, 46, 14);
		frame.getContentPane().add(lblId);
		
		tfId = new JTextField();
		tfId.setBounds(155, 55, 137, 20);
		frame.getContentPane().add(tfId);
		tfId.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(58, 94, 46, 14);
		frame.getContentPane().add(lblSenha);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(155, 91, 137, 20);
		frame.getContentPane().add(pfSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(168, 166, 89, 23);
		frame.getContentPane().add(btnEntrar);
		EvntBtnEntrar evntEntrar = new EvntBtnEntrar();
		btnEntrar.addActionListener(evntEntrar);
		
	}
	
	public void limpar() {
		tfId.setText("");
		pfSenha.setText("");
	}
	
	private class EvntBtnEntrar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			try {
				
				String senha;
				String login = tfId.getText();
				senha = new String(pfSenha.getPassword());
				
				if(Util.isADM(login, senha)) {
					frame.getContentPane().setVisible(false);
					frame.setContentPane(new PanelADM(frame));
					frame.getContentPane().setVisible(true);
				} else {
					
					Funcionario r = fachada.verificaLogin(login, senha);
					
					
					if(r instanceof OperadorSistema) {
						
						frame.getContentPane().setVisible(false);
						frame.setContentPane(new PanelOperadorSistema(frame));
						frame.getContentPane().setVisible(true);
						
					} else if(r instanceof Veterinario) {
						
					}
					
					
				}
				
			} catch(ONExistenteException onee) {
				JOptionPane.showMessageDialog(null, "Funcionario não cadastrado.", "Alerta", JOptionPane.ERROR_MESSAGE);
				limpar();
			} catch(IDIException iie) {
				//JOptionPane.showMessageDialog(null, iie.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
				iie.printStackTrace();
				limpar();
			} catch(SenhaInvalidaException sie) {
				JOptionPane.showMessageDialog(null, "Senha inválida!", "Alerta", JOptionPane.ERROR_MESSAGE);
				limpar();
			} catch(IllegalArgumentException iae) {
				JOptionPane.showMessageDialog(null, iae.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
				limpar();
			}
		}
	}
}
