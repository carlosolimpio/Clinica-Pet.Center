package clinica.petCenter.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelRemoverAtualizarCliente extends JPanel {

private JFrame frame;
	
	private JTextField tfDataNascimento;
	private JTextField tfIdOperador;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfEmail;

	/**
	 * Create the panel.
	 */
	public PanelRemoverAtualizarCliente(JFrame frame) {
		
		setFrame(frame);
		
		setLayout(null);
		
		JLabel lblIdCliente = new JLabel("ID Cliente");
		lblIdCliente.setBounds(50, 50, 75, 14);
		add(lblIdCliente);
		
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
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(501, 366, 89, 23);
		add(btnRemover);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(402, 366, 89, 23);
		add(btnAtualizar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(303, 366, 89, 23);
		add(btnLimpar);
		
		JButton btnVoltarPanelOperadorSistema = new JButton("Voltar");
		btnVoltarPanelOperadorSistema.setBounds(204, 366, 89, 23);
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
