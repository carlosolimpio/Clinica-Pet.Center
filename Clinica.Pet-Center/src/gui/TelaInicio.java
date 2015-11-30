package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clinica.pet_center.negocio.basicas.Administrador;
import clinica.pet_center.negocio.basicas.Pessoa;
import clinica.pet_center.negocio.basicas.Veterinario;
import clinica.pet_center.negocio.cadastros.FachadaCadastro;
import clinica.pet_center.utilidades.Util;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicio extends JFrame {

	private JPanel contentPane;
	private JTextField tfLogin;
	private JTextField tfSenha;
	private String login;
	private String senha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicio frame = new TelaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaInicio() {
		setTitle("Pet Center - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLogin.setBounds(25, 49, 82, 20);
		contentPane.add(lblLogin);
		
		tfLogin = new JTextField();
		tfLogin.setBounds(25, 80, 139, 20);
		contentPane.add(tfLogin);
		tfLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSenha.setBounds(25, 114, 82, 20);
		contentPane.add(lblSenha);
		
		tfSenha = new JTextField();
		tfSenha.setBounds(25, 145, 143, 20);
		contentPane.add(tfSenha);
		tfSenha.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfLogin.getText().equals("") || tfSenha.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Entre com login e a senha:");
				}
				else{
					Pessoa p;
					login = tfLogin.getText();
					senha = tfSenha.getText();
					try {
						if(Util.isADM(login, senha)){
							JOptionPane.showMessageDialog(null, "Logado com sucesso!");
							Administrador p1 = new Administrador("Mara", "11043254207", "07/12/2000", "m@gma.ww");
							p = p1;
							AdministracaoTelas.getAreaRestrita().carregarTela(p);
							AdministracaoTelas.administracaoDeTelas(TelaInicio.this, AdministracaoTelas.getAreaRestrita());
						}
						
						
					} 
					catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Erro de tela");
					}
				}
			}
		});
		btnEntrar.setBounds(285, 209, 89, 23);
		contentPane.add(btnEntrar);
		
		JLabel lblPC = new JLabel("PetCenter");
		lblPC.setForeground(new Color(165, 42, 42));
		lblPC.setHorizontalAlignment(SwingConstants.CENTER);
		lblPC.setFont(new Font("Stencil Std", Font.PLAIN, 30));
		lblPC.setBounds(213, 77, 211, 60);
		getContentPane().add(lblPC);
		
		JLabel lblSlogan = new JLabel("Clinica é aqui!");
		lblSlogan.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlogan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSlogan.setBounds(213, 132, 211, 20);
		getContentPane().add(lblSlogan);
	}
}
