package clinica.PetCenter.Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clinica.pet_center.negocio.basicas.Funcionario;
import clinica.pet_center.negocio.basicas.OperadorSistema;
import clinica.pet_center.negocio.cadastros.CadastroFuncionario;
import clinica.pet_center.negocio.exceptions.IDIException;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroOperadorSistema extends JFrame {

	private CadastroFuncionario FachadaCadastro;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfCPF;
	private JTextField tfDataNascimento;
	private JTextField tfEmail;
	private JTextField tfDataAdmissao;
	private JTextField tfSalarioBase;
	private JTextField tfSenha;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CadastroOperadorSistema frame = new CadastroOperadorSistema();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public CadastroOperadorSistema() {
		setTitle("Cadastro Operador Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(21, 21, 115, 14);
		contentPane.add(lblNome);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(21, 46, 115, 14);
		contentPane.add(lblCPF);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(21, 76, 115, 14);
		contentPane.add(lblDataDeNascimento);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(21, 108, 115, 14);
		contentPane.add(lblEmail);
		
		JLabel lblDataDeAdmisso = new JLabel("Data de Admiss\u00E3o:");
		lblDataDeAdmisso.setBounds(21, 139, 115, 14);
		contentPane.add(lblDataDeAdmisso);
		
		JLabel lblSalarioBase = new JLabel("Salario Base:");
		lblSalarioBase.setBounds(21, 171, 115, 14);
		contentPane.add(lblSalarioBase);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(21, 201, 115, 14);
		contentPane.add(lblSenha);
		
		tfNome = new JTextField();
		tfNome.setBounds(135, 18, 230, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfCPF = new JTextField();
		tfCPF.setColumns(10);
		tfCPF.setBounds(135, 46, 230, 20);
		contentPane.add(tfCPF);
		
		tfDataNascimento = new JTextField();
		tfDataNascimento.setColumns(10);
		tfDataNascimento.setBounds(135, 73, 230, 20);
		contentPane.add(tfDataNascimento);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(135, 105, 230, 20);
		contentPane.add(tfEmail);
		
		tfDataAdmissao = new JTextField();
		tfDataAdmissao.setColumns(10);
		tfDataAdmissao.setBounds(135, 136, 230, 20);
		contentPane.add(tfDataAdmissao);
		
		tfSalarioBase = new JTextField();
		tfSalarioBase.setColumns(10);
		tfSalarioBase.setBounds(135, 165, 230, 20);
		contentPane.add(tfSalarioBase);
		
		tfSenha = new JTextField();
		tfSenha.setColumns(10);
		tfSenha.setBounds(135, 196, 230, 20);
		contentPane.add(tfSenha);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarOP();
			}
		});
		btnCadastrar.setBounds(319, 227, 89, 23);
		contentPane.add(btnCadastrar);
		this.FachadaCadastro = new CadastroFuncionario();
	}
	public void cadastrarOP(){
		try {
			String nome = tfNome.getText();
			String cpf = tfCPF.getText();
			String dataNascimento = tfDataNascimento.getText();
			String email = tfEmail.getText();
			String dataAdmissao = tfDataAdmissao.getText();
			double salarioBase = Double.parseDouble(tfSalarioBase.getText());
			String senha = tfSenha.getText();
			Funcionario func;
			func = new OperadorSistema(nome,cpf, dataNascimento, email, dataAdmissao, salarioBase, senha);
			FachadaCadastro.cadastraFuncionario(func);
			JOptionPane.showMessageDialog(this, "Operador de sistema cadastrado com sucesso!");
			TelaAdm tadm = new TelaAdm();
			tadm.setLocationRelativeTo(null);
			tadm.setVisible(true);
			
		} catch (IDIException idi) {
			JOptionPane.showMessageDialog(this, idi.getMessage());
		}
		catch(OExistenteException oe){
			JOptionPane.showMessageDialog(this, oe.getMessage());
		}
		catch(NumberFormatException nf){
			JOptionPane.showMessageDialog(this, nf.getMessage());
		}
		
	}

}








