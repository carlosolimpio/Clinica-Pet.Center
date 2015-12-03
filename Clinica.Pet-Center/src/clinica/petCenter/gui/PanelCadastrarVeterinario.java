package clinica.petCenter.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCadastrarVeterinario extends JPanel {
	
	private JFrame frame;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	public PanelCadastrarVeterinario(JFrame frame) {
		
		setFrame(frame);
		
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(50, 50, 46, 14);
		add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(50, 90, 46, 14);
		add(lblCpf);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(50, 130, 100, 14);
		add(lblDataDeNascimento);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(50, 170, 46, 14);
		add(lblEmail);
		
		JLabel lblCrmv = new JLabel("CRMV");
		lblCrmv.setBounds(50, 210, 46, 14);
		add(lblCrmv);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(50, 250, 46, 14);
		add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(160, 127, 318, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(160, 47, 318, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(160, 87, 318, 20);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(160, 167, 318, 20);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(160, 207, 318, 20);
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(160, 247, 318, 20);
		add(textField_5);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setBounds(50, 293, 100, 14);
		add(lblConfirmarSenha);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(160, 290, 318, 20);
		add(textField_6);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(501, 366, 89, 23);
		add(btnCadastrar);
		
		JButton btnVoltarPanelAdm = new JButton("Voltar");
		btnVoltarPanelAdm.setBounds(402, 366, 89, 23);
		add(btnVoltarPanelAdm);
		EvntBtnVoltarPanelAdm evntVoltarPanelAdm = new EvntBtnVoltarPanelAdm();
		btnVoltarPanelAdm.addActionListener(evntVoltarPanelAdm);

	}
	
	private void setFrame(JFrame frame){
		this.frame = frame;
	}
	
	private class EvntBtnVoltarPanelAdm implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelADM(frame));
			frame.getContentPane().setVisible(true);	
			
		}
	}

}
