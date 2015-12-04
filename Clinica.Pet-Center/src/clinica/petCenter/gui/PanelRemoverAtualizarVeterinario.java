package clinica.petCenter.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clinica.petCenter.negocio.cadastros.FachadaCadastro;
import clinica.petCenter.negocio.cadastros.IFachadaCadastro;
import clinica.petCenter.negocio.classesBasicas.Veterinario;

import javax.swing.JPasswordField;

public class PanelRemoverAtualizarVeterinario extends JPanel {

private JFrame frame;
	
	private JTextField tfDataNascimento;
	private JTextField tfIdVet;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfEmail;
	private JTextField tfDataAdmissao;
	private JTextField tfCrmv;
	private JPasswordField pfSenha;
	
	private IFachadaCadastro fachada;

	public PanelRemoverAtualizarVeterinario(JFrame frame) {
		
		setFrame(frame);
		setPreferredSize(new Dimension(600,400));
		setLayout(null);
		
		fachada = FachadaCadastro.getInstance();
		
		JLabel lblSubTitulo = new JLabel("Remover/Atualizar Veterinario");
		lblSubTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSubTitulo.setBounds(29, 0, 269, 36);
		add(lblSubTitulo);
		
		JLabel lblIdVeterinario = new JLabel("ID Veterin\u00E1rio");
		lblIdVeterinario.setBounds(50, 40, 75, 14);
		add(lblIdVeterinario);
		
		tfIdVet = new JTextField();
		tfIdVet.setColumns(10);
		tfIdVet.setBounds(163, 37, 320, 20);
		add(tfIdVet);
		
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
		
		JLabel lblDataAdmissao = new JLabel("DataAdmissao");
		lblDataAdmissao.setBounds(50, 320, 100, 14);
		add(lblDataAdmissao);
		
		tfDataAdmissao = new JTextField();
		tfDataAdmissao.setColumns(10);
		tfDataAdmissao.setBounds(163, 317, 320, 20);
		add(tfDataAdmissao);		
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = tfIdVet.getText();
					fachada.removerFuncionario(id);
					JOptionPane.showMessageDialog(null, "Veterinario removido com sucesso!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro na remoção!");
					limpar();
					
				}
			}
		});
		btnRemover.setBounds(501, 366, 89, 23);
		add(btnRemover);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = tfIdVet.getText();
					if(tfNome.getText() != "" && tfCpf.getText() != "" && tfDataNascimento.getText() != "" && tfEmail.getText() != "" && tfDataAdmissao.getText() != "" && tfCrmv.getText() != "" && pfSenha.getText() != "")
					{
						fachada.alterarFuncionario(new Veterinario(tfNome.getText(), tfCpf.getText(), tfDataNascimento.getText(), tfEmail.getText(), tfDataAdmissao.getText(), tfCrmv.getText(), pfSenha.getName()), id);
					}
					JOptionPane.showMessageDialog(null, "Veterinario atualizado com sucesso!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro na atualização!");
					limpar();
				}
			}
		});
		btnAtualizar.setBounds(402, 366, 89, 23);
		add(btnAtualizar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(303, 366, 89, 23);
		add(btnLimpar);
		
		JButton btnVoltarPanelAdm = new JButton("Voltar");
		btnVoltarPanelAdm.setBounds(204, 366, 89, 23);
		add(btnVoltarPanelAdm);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(163, 277, 320, 20);
		add(pfSenha);
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
	
	public void limpar() {
		tfCpf.setText("");
		tfCrmv.setText("");
		tfDataAdmissao.setText("");
		tfDataNascimento.setText("");
		tfEmail.setText("");
		tfIdVet.setText("");
		tfNome.setText("");
		pfSenha.setText("");
	}
}

