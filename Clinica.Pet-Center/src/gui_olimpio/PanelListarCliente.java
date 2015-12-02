package gui_olimpio;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelListarCliente extends JPanel {

private JFrame frame;
	
	
	private JTextField tfCpfOperador;
	private JTextField tfNomeOperador;
	private JTextField tfIdOperador;
	private JTextField tfListarOperador;

	/**
	 * Create the panel.
	 */
	public PanelListarCliente(JFrame frame) {
		setPreferredSize(new Dimension(600,400));
		setLayout(null);
		
		setFrame(frame);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(20, 23, 46, 14);
		add(lblNome);
		
		tfNomeOperador = new JTextField();
		tfNomeOperador.setColumns(10);
		tfNomeOperador.setBounds(66, 20, 210, 20);
		add(tfNomeOperador);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(20, 56, 46, 14);
		add(lblCpf);
		
		tfCpfOperador = new JTextField();
		tfCpfOperador.setBounds(66, 53, 210, 20);
		add(tfCpfOperador);
		tfCpfOperador.setColumns(10);
		
		JLabel lblIdCliente = new JLabel("Id Cliente");
		lblIdCliente.setBounds(314, 23, 58, 14);
		add(lblIdCliente);
		
		tfIdOperador = new JTextField();
		tfIdOperador.setColumns(10);
		tfIdOperador.setBounds(382, 20, 192, 20);
		add(tfIdOperador);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(485, 52, 89, 23);
		add(btnListar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(382, 52, 89, 23);
		add(btnLimpar);		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(481, 365, 93, 23);
		add(btnCadastrar);
		
		JButton btnVoltarPanelOperadorSistema = new JButton("Voltar");			   
		btnVoltarPanelOperadorSistema.setBounds(329, 365, 93, 23);
		add(btnVoltarPanelOperadorSistema);
		EvntBtnVoltarPanelOperadorSistema evntVoltarPanelOperadorSistema = new EvntBtnVoltarPanelOperadorSistema();
		btnVoltarPanelOperadorSistema.addActionListener(evntVoltarPanelOperadorSistema);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(166, 365, 93, 23);
		add(btnRemover);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(20, 365, 93, 23);
		add(btnAtualizar);
		
		tfListarOperador = new JTextField();
		tfListarOperador.setBounds(21, 96, 550, 258);
		add(tfListarOperador);
		tfListarOperador.setColumns(10);
	}
	
	private void setFrame(JFrame frame){
		this.frame = frame;
	}
	
	private class EvntBtnVoltarPanelOperadorSistema implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelOperadorSistema(frame));
			frame.getContentPane().setVisible(true);	
			
		}
	}
}