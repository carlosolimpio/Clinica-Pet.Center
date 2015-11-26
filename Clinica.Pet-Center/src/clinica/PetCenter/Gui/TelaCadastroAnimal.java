package clinica.PetCenter.Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCadastroAnimal extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfEspecie;
	private JTextField tfRaca;
	private JTextField tfDataNascimento;
	private JTextField tfIdDono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroAnimal frame = new TelaCadastroAnimal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroAnimal() {
		setTitle("Cadastro Animal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(30, 30, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblEspecie = new JLabel("Especie");
		lblEspecie.setBounds(30, 70, 46, 14);
		contentPane.add(lblEspecie);
		
		JLabel lblRaca = new JLabel("Ra\u00E7a");
		lblRaca.setBounds(30, 110, 46, 14);
		contentPane.add(lblRaca);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(30, 150, 105, 14);
		contentPane.add(lblDataDeNascimento);
		
		JLabel lblIdDono = new JLabel("ID Dono");
		lblIdDono.setBounds(30, 190, 46, 14);
		contentPane.add(lblIdDono);
		
		tfNome = new JTextField();
		tfNome.setBounds(160, 27, 310, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfEspecie = new JTextField();
		tfEspecie.setColumns(10);
		tfEspecie.setBounds(160, 67, 310, 20);
		contentPane.add(tfEspecie);
		
		tfRaca = new JTextField();
		tfRaca.setColumns(10);
		tfRaca.setBounds(160, 107, 310, 20);
		contentPane.add(tfRaca);
		
		tfDataNascimento = new JTextField();
		tfDataNascimento.setColumns(10);
		tfDataNascimento.setBounds(160, 147, 310, 20);
		contentPane.add(tfDataNascimento);
		
		tfIdDono = new JTextField();
		tfIdDono.setColumns(10);
		tfIdDono.setBounds(160, 187, 310, 20);
		contentPane.add(tfIdDono);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(485, 327, 90, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(385, 327, 90, 23);
		contentPane.add(btnVoltar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(285, 327, 90, 23);
		contentPane.add(btnLimpar);
	}
}
