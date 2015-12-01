package clinica.PetCenter.Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaOperadorSistema extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaOperadorSistema frame = new TelaOperadorSistema();
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
	public TelaOperadorSistema() {
		setTitle("Operador de Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar mbAnimal = new JMenuBar();
		mbAnimal.setBounds(0, 0, 50, 21);
		contentPane.add(mbAnimal);
		
		JMenu mnAnimal = new JMenu("Animal");
		mbAnimal.add(mnAnimal);
		
		JMenuItem mntmCadastrarAnimal = new JMenuItem("Cadastrar");
		mntmCadastrarAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroAnimal telaCadastroAnimal = new TelaCadastroAnimal();
				telaCadastroAnimal.setVisible(true);
				dispose();
			}
		});
		mnAnimal.add(mntmCadastrarAnimal);
		
		JMenuItem mntmListarAnimal = new JMenuItem("Listar");
		mntmListarAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarAnimais telaListarAnimais = new TelaListarAnimais();
				telaListarAnimais.setVisible(true);
				dispose();
			}
		});
		mnAnimal.add(mntmListarAnimal);
		
		JMenuItem mntmAtualizarRemoverAnimal = new JMenuItem("Atualizar/Remover");
		mntmAtualizarRemoverAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarAnimal telaAtualizarAnimal = new TelaAtualizarAnimal();
				telaAtualizarAnimal.setVisible(true);
				dispose();
			}
		});
		mnAnimal.add(mntmAtualizarRemoverAnimal);
		
		JMenuBar mbCliente = new JMenuBar();
		mbCliente.setBounds(50, 0, 48, 21);
		contentPane.add(mbCliente);
		
		JMenu mnCliente = new JMenu("Cliente");
		mbCliente.add(mnCliente);
		
		JMenuItem mtnmCadastrarCliente = new JMenuItem("Cadastrar");
		mnCliente.add(mtnmCadastrarCliente);
		
		JMenuItem mntmListarCliente = new JMenuItem("Listar");
		mnCliente.add(mntmListarCliente);
		
		JMenuItem mntmAtualizarRemoverCliente = new JMenuItem("Atualizar/Remover");
		mnCliente.add(mntmAtualizarRemoverCliente);
		
		JMenuBar mbVoltar = new JMenuBar();
		mbVoltar.setBounds(98, 0, 40, 21);
		contentPane.add(mbVoltar);
		
		JMenu mnVoltar = new JMenu("Voltar");
		mbVoltar.add(mnVoltar);
		
		JMenuItem mntmVoltar = new JMenuItem("Voltar");
		mnVoltar.add(mntmVoltar);
	}
	
	

}
