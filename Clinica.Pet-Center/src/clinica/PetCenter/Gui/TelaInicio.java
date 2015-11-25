package clinica.PetCenter.Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import clinica.pet_center.negocio.basicas.Funcionario;
import clinica.pet_center.negocio.cadastros.CadastroFuncionario;
import clinica.pet_center.negocio.exceptions.ONExistenteException;
import clinica.pet_center.utilidades.Util;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.naming.NameNotFoundException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;

public class TelaInicio extends JFrame {
	
	private CadastroFuncionario FachadaCadastro;
	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfSenha;

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
		setTitle("*****Clinica Pet Center*****");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(38, 64, 57, 14);
		contentPane.add(lblId);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(38, 95, 57, 14);
		contentPane.add(lblSenha);
		
		tfId = new JTextField();
		tfId.setBounds(111, 61, 97, 20);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfSenha = new JPasswordField();
		tfSenha.setBounds(111, 92, 97, 20);
		contentPane.add(tfSenha);
		tfSenha.setColumns(10);
		
		JButton btnLoginAdm = new JButton("Login");
		btnLoginAdm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login();
				
			}
		});
		btnLoginAdm.setBounds(255, 60, 140, 23);
		contentPane.add(btnLoginAdm);
		
	/*	JButton btnLoginFuncionario = new JButton("Login Funcionario");
		btnLoginFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFuncionario();
			}
		});
		btnLoginFuncionario.setBounds(255, 95, 140, 23);
		contentPane.add(btnLoginFuncionario);
	*/
		
		this.FachadaCadastro = new CadastroFuncionario();
	}
	
	private void login(){
		try{
			String id = tfId.getText();
			String senha = tfSenha.getText();
			if(Util.isADM(id, senha)) 
			{
				JOptionPane.showMessageDialog(this, "Logado com sucesso!");
				dispose();
				TelaAdm tadm = new TelaAdm();
				tadm.setLocationRelativeTo(null);
				tadm.setVisible(true);
			}else if(!Util.isADM(id, senha)){
				JOptionPane.showMessageDialog(this, "Login ou senha incorretos!");
			}else{
				ArrayList<Funcionario> arrlf = this.FachadaCadastro.listaFuncionarios();
				for(Funcionario func : arrlf) 
				{
					if(func.getId().equals(id) && func.getSenha().equals(senha))
						JOptionPane.showMessageDialog(this, "Logado com sucesso no sistema!");
				}
			}
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(this, "Erro ao logar");
		}
		
		
	}
	
	private void LoginADM(){
		try {
			String id = tfId.getText();
			String senha = tfSenha.getText();
			if(Util.isADM(id, senha)) 
			{
				JOptionPane.showMessageDialog(this, "Logado com sucesso!");
				dispose();
				TelaAdm tadm = new TelaAdm();
				tadm.setLocationRelativeTo(null);
				tadm.setVisible(true);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erro ao logar");
		}
	}
	

	private void LoginFuncionario(){
		try {
			String id = tfId.getText();
			String senha = tfSenha.getText();
			ArrayList<Funcionario> arrlf = this.FachadaCadastro.listaFuncionarios();
			for(Funcionario func : arrlf) 
			{
				if(func.getId().equals(id) && func.getSenha().equals(senha))
					JOptionPane.showMessageDialog(this, "Logado com sucesso no sistema!");
			}
		} 
		catch (ONExistenteException one) {
			JOptionPane.showMessageDialog(this, one.getMessage());
		}
		catch (NullPointerException np){
			JOptionPane.showMessageDialog(this, "Não pode deixar espaço em branco");
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(this, "erro");
		}
	}
}
