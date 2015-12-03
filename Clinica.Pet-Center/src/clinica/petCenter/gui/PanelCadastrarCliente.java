package clinica.petCenter.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCadastrarCliente extends JPanel {
	
	private JFrame frame;
	
	private JTextField tfDataNascimento;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfEmail;

	/**
	 * Create the panel.
	 */
	public PanelCadastrarCliente(JFrame frame) {
		
		setFrame(frame);
		
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(50, 50, 46, 14);
		add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(160, 47, 320, 20);
		add(tfNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(50, 90, 46, 14);
		add(lblCpf);
		
		tfCpf = new JTextField();
		tfCpf.setColumns(10);
		tfCpf.setBounds(160, 87, 320, 20);
		add(tfCpf);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(50, 130, 100, 14);
		add(lblDataDeNascimento);
		
		tfDataNascimento = new JTextField();
		tfDataNascimento.setBounds(160, 127, 320, 20);
		add(tfDataNascimento);
		tfDataNascimento.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(50, 170, 46, 14);
		add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(160, 167, 320, 20);
		add(tfEmail);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(495, 366, 95, 23);
		add(btnCadastrar);
		
		JButton btnVoltarPanelOperadorSistema = new JButton("Voltar");
		btnVoltarPanelOperadorSistema.setBounds(385, 366, 95, 23);
		add(btnVoltarPanelOperadorSistema);
		EvntBtnVoltarPanelOperadorSistema evntVoltarPanelOperadorSistema = new EvntBtnVoltarPanelOperadorSistema();
		btnVoltarPanelOperadorSistema.addActionListener(evntVoltarPanelOperadorSistema);
		
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

	

