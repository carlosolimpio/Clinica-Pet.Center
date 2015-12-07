package clinica.petCenter.gui;

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

import clinica.petCenter.negocio.cadastros.FachadaCadastro;
import clinica.petCenter.negocio.cadastros.IFachadaCadastro;
import clinica.petCenter.negocio.classesBasicas.Funcionario;
import clinica.petCenter.negocio.classesBasicas.OperadorSistema;
import clinica.petCenter.negocio.classesBasicas.Veterinario;
import clinica.petCenter.negocio.exceptions.IDIException;
import clinica.petCenter.negocio.exceptions.ONExistenteException;
import clinica.petCenter.negocio.exceptions.SenhaInvalidaException;
import clinica.petCenter.utilidades.Util;
import java.awt.Font;
import java.awt.Color;

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
		
		JLabel lblTitulo = new JLabel("Cl\u00EDnica PetCenter");
		lblTitulo.setForeground(new Color(0, 128, 0));
		lblTitulo.setFont(new Font("Lucida Sans", Font.BOLD, 20));
		lblTitulo.setBounds(215, 44, 222, 56);
		frame.getContentPane().add(lblTitulo);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(188, 144, 46, 14);
		frame.getContentPane().add(lblId);
		
		tfId = new JTextField();
		tfId.setBounds(244, 141, 137, 20);
		frame.getContentPane().add(tfId);
		tfId.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(188, 180, 46, 14);
		frame.getContentPane().add(lblSenha);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(244, 177, 137, 20);
		frame.getContentPane().add(pfSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(265, 218, 89, 23);
		frame.getContentPane().add(btnEntrar);
		
		JLabel lblSistemaDesenvolvidoPara = new JLabel("Sistema desenvolvido para a disciplina de POO, UFRPE");
		lblSistemaDesenvolvidoPara.setFont(new Font("Lucida Sans", Font.ITALIC, 13));
		lblSistemaDesenvolvidoPara.setBounds(136, 363, 384, 14);
		frame.getContentPane().add(lblSistemaDesenvolvidoPara);
		EvntBtnEntrar evntEntrar = new EvntBtnEntrar();
		btnEntrar.addActionListener(evntEntrar);
		
	}
	
	public void limpar() {
		tfId.setText("");
		pfSenha.setText("");
	}
	
	public JFrame getFrame() {
		return frame;
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
						frame.setContentPane(new PanelOperadorSistema(frame, (OperadorSistema) r));
						frame.getContentPane().setVisible(true);
						
					} else if(r instanceof Veterinario) {
						frame.getContentPane().setVisible(false);
						frame.setContentPane(new PanelVeterinario(frame, (Veterinario) r));
						frame.getContentPane().setVisible(true);
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
