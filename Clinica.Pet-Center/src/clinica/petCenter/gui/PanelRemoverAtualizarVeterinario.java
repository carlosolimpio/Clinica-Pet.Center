package clinica.petCenter.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelRemoverAtualizarVeterinario extends JPanel {

private JFrame frame;
	
	private JTextField tfDataNascimento;
	private JTextField tfIdOperador;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfEmail;
	private JTextField tfSenha;
	private JTextField tfConfirmeSenha;
	private JTextField tfCrmv;

	/**
	 * Create the panel.
	 */
	public PanelRemoverAtualizarVeterinario(JFrame frame) {
		
		setFrame(frame);
		
		setLayout(null);
		
		JLabel lblIdVeterinario = new JLabel("ID Veterin\u00E1rio");
		lblIdVeterinario.setBounds(50, 40, 75, 14);
		add(lblIdVeterinario);
		
		tfIdOperador = new JTextField();
		tfIdOperador.setColumns(10);
		tfIdOperador.setBounds(163, 37, 320, 20);
		add(tfIdOperador);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(50, 80, 46, 14);
		add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(163, 77, 320, 20);
		add(tfNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(50, 120, 46, 14);
		add(lblCpf);
		
		tfCpf = new JTextField();
		tfCpf.setColumns(10);
		tfCpf.setBounds(163, 117, 320, 20);
		add(tfCpf);
		
		JLabel lblCrmv = new JLabel("CRMV");
		lblCrmv.setBounds(50, 160, 46, 14);
		add(lblCrmv);
		
		tfCrmv = new JTextField();
		tfCrmv.setColumns(10);
		tfCrmv.setBounds(163, 157, 320, 20);
		add(tfCrmv);
		
		JLabel lblDataNascimento = new JLabel("Data de Nascimento");
		lblDataNascimento.setBounds(50, 200, 100, 14);
		add(lblDataNascimento);
		
		tfDataNascimento = new JTextField();
		tfDataNascimento.setBounds(163, 197, 320, 20);
		add(tfDataNascimento);
		tfDataNascimento.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(50, 240, 46, 14);
		add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(163, 237, 320, 20);
		add(tfEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(50, 280, 46, 14);
		add(lblSenha);
		
		tfSenha = new JTextField();
		tfSenha.setColumns(10);
		tfSenha.setBounds(163, 277, 320, 20);
		add(tfSenha);
		
		JLabel lblConfirmeASenha = new JLabel("Confirme a senha");
		lblConfirmeASenha.setBounds(50, 320, 100, 14);
		add(lblConfirmeASenha);
		
		tfConfirmeSenha = new JTextField();
		tfConfirmeSenha.setColumns(10);
		tfConfirmeSenha.setBounds(163, 317, 320, 20);
		add(tfConfirmeSenha);		
		
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

