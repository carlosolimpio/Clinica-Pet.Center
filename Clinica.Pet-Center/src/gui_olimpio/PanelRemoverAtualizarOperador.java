package gui_olimpio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelRemoverAtualizarOperador extends JPanel {
	
	private JFrame frame;
	
	private JTextField tfDataNascimento;
	private JTextField tfIdOperador;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfEmail;
	private JTextField tfSenha;
	private JTextField tfConfirmeSenha;

	/**
	 * Create the panel.
	 */
	public PanelRemoverAtualizarOperador(JFrame frame) {
		
		setFrame(frame);
		
		setLayout(null);
		
		JLabel lblIdOperador = new JLabel("ID Operador");
		lblIdOperador.setBounds(50, 50, 75, 14);
		add(lblIdOperador);
		
		tfIdOperador = new JTextField();
		tfIdOperador.setColumns(10);
		tfIdOperador.setBounds(163, 47, 320, 20);
		add(tfIdOperador);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(50, 90, 46, 14);
		add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(163, 87, 320, 20);
		add(tfNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(50, 130, 46, 14);
		add(lblCpf);
		
		tfCpf = new JTextField();
		tfCpf.setColumns(10);
		tfCpf.setBounds(163, 127, 320, 20);
		add(tfCpf);
		
		JLabel lblDataNascimento = new JLabel("Data de Nascimento");
		lblDataNascimento.setBounds(50, 170, 100, 14);
		add(lblDataNascimento);
		
		tfDataNascimento = new JTextField();
		tfDataNascimento.setBounds(163, 167, 320, 20);
		add(tfDataNascimento);
		tfDataNascimento.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(50, 210, 46, 14);
		add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(163, 207, 320, 20);
		add(tfEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(50, 250, 46, 14);
		add(lblSenha);
		
		tfSenha = new JTextField();
		tfSenha.setColumns(10);
		tfSenha.setBounds(163, 247, 320, 20);
		add(tfSenha);
		
		JLabel lblConfirmeASenha = new JLabel("Confirme a senha");
		lblConfirmeASenha.setBounds(50, 290, 100, 14);
		add(lblConfirmeASenha);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(501, 366, 89, 23);
		add(btnRemover);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(402, 366, 89, 23);
		add(btnAtualizar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(303, 366, 89, 23);
		add(btnLimpar);
		
		JButton btnVoltarPanelAdm = new JButton("Voltar");
		btnVoltarPanelAdm.setBounds(204, 366, 89, 23);
		add(btnVoltarPanelAdm);
		EvntBtnVoltarPanelAdm evntVoltarPanelAdm = new EvntBtnVoltarPanelAdm();
		btnVoltarPanelAdm.addActionListener(evntVoltarPanelAdm);
		
		tfConfirmeSenha = new JTextField();
		tfConfirmeSenha.setColumns(10);
		tfConfirmeSenha.setBounds(163, 287, 320, 20);
		add(tfConfirmeSenha);		
		
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
