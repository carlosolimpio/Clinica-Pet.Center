package clinica.PetCenter.Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clinica.pet_center.negocio.cadastros.CadastroFuncionario;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAdm extends JFrame {

	private CadastroFuncionario FachadaCadastro;
	private CadastroOperadorSistema op;
	private JPanel contentPane;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaAdm frame = new TelaAdm();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public TelaAdm() {
		setTitle("Tela Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar mbFuncionario = new JMenuBar();
		mbFuncionario.setBounds(0, 0, 114, 21);
		contentPane.add(mbFuncionario);
		
		JMenu mnFuncionario = new JMenu("Funcionario");
		mbFuncionario.add(mnFuncionario);
		
		JMenuItem mntmRemover = new JMenuItem("Remover");
		mntmRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerFuncionario();
			}
		});
		
		JMenu mnCadastrar = new JMenu("Cadastrar");
		mnFuncionario.add(mnCadastrar);
		
		JMenuItem mntmOperadorSistema = new JMenuItem("Operador Sistema");
		mntmOperadorSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarOperadorSistema();
			}
		});
		mnCadastrar.add(mntmOperadorSistema);
		
		JMenuItem mntmVeterinario = new JMenuItem("Veterinario");
		mntmVeterinario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarVeterinario();
			}
		});
		mnCadastrar.add(mntmVeterinario);
		mnFuncionario.add(mntmRemover);
		
		JMenuItem mntmBuscar = new JMenuItem("Buscar");
		mntmBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarFuncionario();
			}
		});
		mnFuncionario.add(mntmBuscar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarFuncionario();
			}
		});
		mnFuncionario.add(mntmListar);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(112, 0, 97, 21);
		contentPane.add(menuBar);
		
		JMenu mnListar = new JMenu("Listar");
		menuBar.add(mnListar);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mnListar.add(mntmCliente);
		
		JMenuItem mntmAnimais = new JMenuItem("Animais");
		mnListar.add(mntmAnimais);
		
		JMenuItem mntmConsulta = new JMenuItem("Consulta");
		mnListar.add(mntmConsulta);
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarFuncionario();
			}
		});
		
		JMenuBar mbVoltar = new JMenuBar();
		mbVoltar.setBounds(209, 0, 97, 21);
		contentPane.add(mbVoltar);
		
		JMenu mnVoltar = new JMenu("Voltar");
		mbVoltar.add(mnVoltar);
		
		JMenuItem mntmvoltarLogin = new JMenuItem("Tela de Login");
		mnVoltar.add(mntmvoltarLogin);
		
		//JMenu mnVoltar = new JMenu("Voltar");
		//menuBar.add(mnVoltar);		
		
		//JMenuItem mntmVoltar = new JMenuItem("Tela de Login");
		//mnVoltar.add(mntmVoltar);
		
		this.FachadaCadastro = new CadastroFuncionario();
	}
	
	private void cadastrarOperadorSistema(){
		try {
			CadastroOperadorSistema op = new CadastroOperadorSistema();
			op.setLocationRelativeTo(null);
			op.setVisible(true);
		} 
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erro!");
		}
	}
	
	private void cadastrarVeterinario(){
		
	}
	
	private void removerFuncionario(){
		
	}
	
	private void buscarFuncionario(){
		
	}
	
	private void listarFuncionario(){
		
	}
}
