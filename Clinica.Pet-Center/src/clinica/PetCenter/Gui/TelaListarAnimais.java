package clinica.PetCenter.Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListarAnimais extends JFrame {

	private JPanel contentPane;
	private JTextField tfNomeAnimal;
	private JTextField tfEspecieAnimal;
	private JTextField tfRaca;
	private JTextField tfIdDono;
	private JTextField tfIdAnimal;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarAnimais frame = new TelaListarAnimais();
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
	public TelaListarAnimais() {
		setTitle("Animais");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 10, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblEspecie = new JLabel("Especie");
		lblEspecie.setBounds(10, 35, 46, 14);
		contentPane.add(lblEspecie);
		
		JLabel lblRaca = new JLabel("Ra\u00E7a");
		lblRaca.setBounds(10, 60, 46, 14);
		contentPane.add(lblRaca);
		
		tfNomeAnimal = new JTextField();
		tfNomeAnimal.setBounds(66, 7, 210, 20);
		contentPane.add(tfNomeAnimal);
		tfNomeAnimal.setColumns(10);
		
		tfEspecieAnimal = new JTextField();
		tfEspecieAnimal.setColumns(10);
		tfEspecieAnimal.setBounds(66, 32, 210, 20);
		contentPane.add(tfEspecieAnimal);
		
		tfRaca = new JTextField();
		tfRaca.setColumns(10);
		tfRaca.setBounds(66, 57, 210, 20);
		contentPane.add(tfRaca);
		
		tfIdDono = new JTextField();
		tfIdDono.setColumns(10);
		tfIdDono.setBounds(356, 7, 218, 20);
		contentPane.add(tfIdDono);
		
		JLabel lblIdDono = new JLabel("Id Dono");
		lblIdDono.setBounds(300, 10, 46, 14);
		contentPane.add(lblIdDono);
		
		JLabel lblIdAnimal = new JLabel("Id Animal");
		lblIdAnimal.setBounds(300, 35, 46, 14);
		contentPane.add(lblIdAnimal);
		
		tfIdAnimal = new JTextField();
		tfIdAnimal.setColumns(10);
		tfIdAnimal.setBounds(356, 32, 218, 20);
		contentPane.add(tfIdAnimal);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(485, 56, 89, 23);
		contentPane.add(btnListar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(356, 56, 89, 23);
		contentPane.add(btnLimpar);
		
		textField = new JTextField();
		textField.setBounds(10, 91, 564, 225);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(484, 327, 90, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnVoltar.setBounds(321, 327, 90, 23);
		contentPane.add(btnVoltar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(163, 327, 90, 23);
		contentPane.add(btnRemover);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(10, 327, 90, 23);
		contentPane.add(btnAtualizar);
	}
}
