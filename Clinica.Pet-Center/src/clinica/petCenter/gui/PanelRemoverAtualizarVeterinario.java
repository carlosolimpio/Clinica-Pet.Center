package clinica.petCenter.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import clinica.petCenter.negocio.cadastros.FachadaCadastro;
import clinica.petCenter.negocio.cadastros.IFachadaCadastro;
import clinica.petCenter.negocio.classesBasicas.Funcionario;
import clinica.petCenter.negocio.classesBasicas.Veterinario;
import clinica.petCenter.negocio.exceptions.IDIException;
import clinica.petCenter.negocio.exceptions.OExistenteException;
import clinica.petCenter.negocio.exceptions.ONExistenteException;

public class PanelRemoverAtualizarVeterinario extends JPanel {

private JFrame frame;
	
	private JTextField tfDataNascimento;
	private JTextField tfIdVeterinario;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfEmail;
	private JTextField tfCrmv;
	
	private IFachadaCadastro fachada;
	private Veterinario vet;
	private Funcionario funcionario;
	private JPasswordField pfSenha;
	private JPasswordField pfCSenha;
	private JTextField tfDataAdmissao;

	/**
	 * Create the panel.
	 */
	public PanelRemoverAtualizarVeterinario(JFrame frame) {
		
		setFrame(frame);
		setPreferredSize(new Dimension(600,400));
		setLayout(null);
		
		fachada = FachadaCadastro.getInstance();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 600, 21);
		add(menuBar);
		
		JMenu mnOperadorDeSistema = new JMenu("Operador de sistema");
		mnOperadorDeSistema.setBounds(50,0,140,21);
		menuBar.add(mnOperadorDeSistema);
		
		JMenuItem mntmCadastrarOperador = new JMenuItem("Cadastrar");   
		mnOperadorDeSistema.add(mntmCadastrarOperador);
		mntmCadastrarOperador.addActionListener(new EvntMntmCadastrarOperador());
		
		JMenuItem mntmRemoverAtualizarOperador = new JMenuItem("Remover / Atualizar");
		mnOperadorDeSistema.add(mntmRemoverAtualizarOperador);
		mntmRemoverAtualizarOperador.addActionListener(new EvntMntmRemoverAtualizarOperador());
		
		
		JMenu mnVeterinario = new JMenu("Veterin\u00E1rio");
		mnVeterinario.setBounds(170,0,70,21);
		menuBar.add(mnVeterinario);
		
		JMenuItem mntmCadastrarVeterinario = new JMenuItem("Cadastrar");
		mnVeterinario.add(mntmCadastrarVeterinario);
		mntmCadastrarVeterinario.addActionListener(new EvntMntmCadastrarVeterinario());
		
		JMenuItem mntmRemoverAtualizarVeterinario = new JMenuItem("Remover / Atualizar");
		mnVeterinario.add(mntmRemoverAtualizarVeterinario);
		mntmRemoverAtualizarVeterinario.addActionListener(new EvntMntmRemoverAtualizarVeterinario());
		
		JLabel lblIdVeterinario = new JLabel("ID Veterin\u00E1rio");
		lblIdVeterinario.setBounds(50, 40, 75, 14);
		add(lblIdVeterinario);
		
		tfIdVeterinario = new JTextField();
		tfIdVeterinario.setColumns(10);
		tfIdVeterinario.setBounds(163, 37, 320, 20);
		add(tfIdVeterinario);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(50, 77, 46, 14);
		add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(163, 74, 320, 20);
		add(tfNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(50, 114, 46, 14);
		add(lblCpf);
		
		tfCpf = new JTextField();
		tfCpf.setColumns(10);
		tfCpf.setBounds(163, 111, 320, 20);
		add(tfCpf);
		
		JLabel lblCrmv = new JLabel("CRMV");
		lblCrmv.setBounds(50, 151, 46, 14);
		add(lblCrmv);
		
		tfCrmv = new JTextField();
		tfCrmv.setColumns(10);
		tfCrmv.setBounds(163, 148, 320, 20);
		add(tfCrmv);
		
		JLabel lblDataNascimento = new JLabel("Data de Nascimento");
		lblDataNascimento.setBounds(50, 188, 100, 14);
		add(lblDataNascimento);
		
		tfDataNascimento = new JTextField();
		tfDataNascimento.setBounds(163, 185, 320, 20);
		add(tfDataNascimento);
		tfDataNascimento.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(50, 262, 46, 14);
		add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(163, 259, 320, 20);
		add(tfEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(50, 299, 46, 14);
		add(lblSenha);
		
		JLabel lblConfirmeASenha = new JLabel("Confirme a senha");
		lblConfirmeASenha.setBounds(50, 336, 100, 14);
		add(lblConfirmeASenha);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(501, 366, 89, 23);
		add(btnRemover);
		btnRemover.addActionListener(new EvntBtnRemover());
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(402, 366, 89, 23);
		add(btnAtualizar);
		btnAtualizar.addActionListener(new EvntBtnAtualizar());
		
		JButton btnPreencher = new JButton("Preencher");
		btnPreencher.setBounds(493, 36, 89, 23);
		add(btnPreencher);
		btnPreencher.addActionListener(new EvntBtnPreencher());
		
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
		pfSenha.setBounds(163, 296, 320, 20);
		add(pfSenha);
		
		pfCSenha = new JPasswordField();
		pfCSenha.setBounds(163, 333, 320, 20);
		add(pfCSenha);
		
		JLabel lblDataAdmissao = new JLabel("Data Admissao");
		lblDataAdmissao.setBounds(50, 225, 100, 14);
		add(lblDataAdmissao);
		
		tfDataAdmissao = new JTextField();
		tfDataAdmissao.setBounds(163, 222, 320, 20);
		add(tfDataAdmissao);
		tfDataAdmissao.setColumns(10);
		EvntBtnVoltarPanelAdm evntVoltarPanelAdm = new EvntBtnVoltarPanelAdm();
		btnVoltarPanelAdm.addActionListener(evntVoltarPanelAdm);
		
	}
	
	private void setFrame(JFrame frame){
		this.frame = frame;
	}
	
	public void limpar() {
		tfCpf.setText("");
		tfDataNascimento.setText("");
		tfEmail.setText("");
		tfNome.setText("");
		tfIdVeterinario.setText("");
		tfCrmv.setText("");
		pfSenha.setText("");
		pfCSenha.setText("");
		tfDataAdmissao.setText("");
		}
	
	private class EvntBtnVoltarPanelAdm implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelADM(frame));
			frame.getContentPane().setVisible(true);	
			
		}
	}
	
	private class EvntBtnPreencher implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			String id = tfIdVeterinario.getText();
			
			try {
				funcionario = fachada.buscarFuncionario(id);
				if(funcionario instanceof Veterinario){
					tfNome.setText(funcionario.getNome());
					tfCpf.setText(funcionario.getCPF());
					tfDataNascimento.setText(funcionario.getDataNascimento());
					tfEmail.setText(funcionario.getEmail());
					pfSenha.setText(funcionario.getSenha());
					tfCrmv.setText(((Veterinario) funcionario).getCrmv());
					tfDataAdmissao.setText(funcionario.getDataAdmissao());
					tfIdVeterinario.setEnabled(false);
				}else {
					JOptionPane.showMessageDialog(null, "Id incorreto!"
							, "ERRO", JOptionPane.PLAIN_MESSAGE);	
					limpar();
					
				}
			} catch (ONExistenteException e1) {
				e1.printStackTrace();				
			} catch (IDIException e1) {
				e1.printStackTrace();
			}						
		}
	}
	
	private class EvntBtnRemover implements ActionListener {
		public void actionPerformed(ActionEvent e){
			String id = tfIdVeterinario.getText();	
			
			try {
				int reply = JOptionPane.showConfirmDialog(null, "Realmente deseja remover este Veterinario?"
						, "Atenção", JOptionPane.YES_NO_OPTION);
				  if (reply == JOptionPane.YES_OPTION)
				  {
					  fachada.removerFuncionario(id);
						JOptionPane.showMessageDialog(null, "Veterinario removido com sucesso!"
							, "Removido", JOptionPane.PLAIN_MESSAGE);	
						limpar();
						tfIdVeterinario.setEnabled(true);
				  }
					
				
			} catch (ONExistenteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IDIException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private class EvntBtnAtualizar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			String senha = new String(pfSenha.getPassword());
			String cSenha = new String(pfCSenha.getPassword());
			
			Date dataHoje = new Date();
			SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
			String data = formataData.format(dataHoje);			
			
			if(senha.equals(cSenha)){
					try {
						vet = null;
						vet = new Veterinario(tfIdVeterinario.getText(), tfNome.getText(), tfCpf.getText(), tfDataNascimento.getText(),
								tfEmail.getText(), tfDataAdmissao.getText(), tfCrmv.getText(), senha);
					} catch (IDIException e1) {
						System.out.println("Erro IDIException");
					}
					
					try {
						fachada.alterarFuncionario(vet, vet.getId());
						JOptionPane.showMessageDialog(null, "Veterinario atualizado com sucesso!");
						limpar();
						tfIdVeterinario.setEnabled(true);
					} catch (OExistenteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ONExistenteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IDIException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}				
			}else{
				JOptionPane.showMessageDialog(null, "Senhas diferentes!"
						, "Senha", JOptionPane.PLAIN_MESSAGE);		
			}
			
		}
	}
	
	private class EvntMntmCadastrarOperador implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelCadastrarOperador(frame));
			frame.getContentPane().setVisible(true);
			
		}
	}
	
	private class EvntMntmRemoverAtualizarOperador implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelRemoverAtualizarOperador(frame));
			frame.getContentPane().setVisible(true);	
		}
	}
	
	private class EvntMntmCadastrarVeterinario implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelCadastrarVeterinario(frame));
			frame.getContentPane().setVisible(true);	
			
		}
	}
	
	private class EvntMntmRemoverAtualizarVeterinario implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelRemoverAtualizarVeterinario(frame));
			frame.getContentPane().setVisible(true);	
			
		}
	}
}

