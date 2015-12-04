package clinica.petCenter.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clinica.petCenter.negocio.cadastros.FachadaCadastro;
import clinica.petCenter.negocio.cadastros.IFachadaCadastro;
import clinica.petCenter.negocio.classesBasicas.Funcionario;
import clinica.petCenter.negocio.classesBasicas.Veterinario;

public class PanelListarVeterinario extends JPanel {

private JFrame frame;
	
	
	private JTextField tfCpfVet;
	private JTextField tfNomeVet;
	private JTextField tfIdVet;
	private JTextField tfListarVet;
	private JTextField tfCrmv;
	
	private IFachadaCadastro fachada;

	/**
	 * Create the panel.
	 */
	public PanelListarVeterinario(JFrame frame) {
		setPreferredSize(new Dimension(600,400));
		setLayout(null);
		
		setFrame(frame);
		
		fachada = FachadaCadastro.getInstance();
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(20, 23, 46, 14);
		add(lblNome);
		
		tfNomeVet = new JTextField();
		tfNomeVet.setColumns(10);
		tfNomeVet.setBounds(66, 20, 210, 20);
		add(tfNomeVet);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(20, 56, 46, 14);
		add(lblCpf);
		
		tfCpfVet = new JTextField();
		tfCpfVet.setBounds(66, 53, 210, 20);
		add(tfCpfVet);
		tfCpfVet.setColumns(10);
		
		JLabel lblIdVeterinario = new JLabel("Id Veterin\u00E1rio");
		lblIdVeterinario.setBounds(286, 23, 86, 14);
		add(lblIdVeterinario);
		
		tfIdVet = new JTextField();
		tfIdVet.setColumns(10);
		tfIdVet.setBounds(382, 20, 192, 20);
		add(tfIdVet);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new EvntBtnListar());
		btnListar.setBounds(485, 85, 89, 23);
		add(btnListar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfCpfVet.setText("");
				tfCrmv.setText("");
				tfIdVet.setText("");
				tfListarVet.setText("");
				tfNomeVet.setText("");
			}
		});
		btnLimpar.setBounds(382, 85, 89, 23);
		add(btnLimpar);		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(481, 365, 93, 23);
		add(btnCadastrar);
		
		JButton btnVoltarPanelAdm = new JButton("Voltar");			   
		btnVoltarPanelAdm.setBounds(329, 365, 93, 23);
		add(btnVoltarPanelAdm);
		EvntBtnVoltarPanelAdm evntVoltarPanelAdm = new EvntBtnVoltarPanelAdm();
		btnVoltarPanelAdm.addActionListener(evntVoltarPanelAdm);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(166, 365, 93, 23);
		add(btnRemover);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(20, 365, 93, 23);
		add(btnAtualizar);
		
		tfListarVet = new JTextField();
		tfListarVet.setBounds(21, 119, 553, 235);
		add(tfListarVet);
		tfListarVet.setColumns(10);
		
		tfCrmv = new JTextField();
		tfCrmv.setColumns(10);
		tfCrmv.setBounds(382, 53, 192, 20);
		add(tfCrmv);
		
		JLabel lblCrmv = new JLabel("CRMV");
		lblCrmv.setBounds(326, 56, 46, 14);
		add(lblCrmv);
	}
	
	private void setFrame(JFrame frame){
		this.frame = frame;
	}
	
	private class EvntBtnListar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try {
				List<Veterinario> arrayVT = fachada.listarVeterinarios();
				if(arrayVT != null)
					for(Funcionario fx : arrayVT) 
					{
						System.out.println(fx.toString());
					}
			} catch (Exception e2) {
				e2.getMessage();
			}
		}
	}
	
	private class EvntBtnVoltarPanelAdm implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelADM(frame));
			frame.getContentPane().setVisible(true);	
			
		}
	}
}
