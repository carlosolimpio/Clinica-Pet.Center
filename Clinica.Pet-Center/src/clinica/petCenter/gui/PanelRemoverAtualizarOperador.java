package clinica.petCenter.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import clinica.petCenter.negocio.cadastros.FachadaCadastro;
import clinica.petCenter.negocio.cadastros.IFachadaCadastro;
import clinica.petCenter.negocio.classesBasicas.Funcionario;
import clinica.petCenter.negocio.classesBasicas.OperadorSistema;
import clinica.petCenter.negocio.exceptions.IDIException;
import clinica.petCenter.negocio.exceptions.OExistenteException;
import clinica.petCenter.negocio.exceptions.ONExistenteException;

public class PanelRemoverAtualizarOperador extends JPanel {
	
	private JFrame frame;
	
	private JTextField tfDataNascimento;
	private JTextField tfIdOperador;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfEmail;
	private JPasswordField pfSenha;
	private JPasswordField pfConfirmeSenha;
	private Funcionario funcionario;
	
	private IFachadaCadastro fachada;
	private OperadorSistema operador;

	/**
	 * Create the panel.
	 */
	public PanelRemoverAtualizarOperador(JFrame frame) {
		
		setFrame(frame);
		setPreferredSize(new Dimension(600,400));
		setLayout(null);
		
		fachada = FachadaCadastro.getInstance();
		
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
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(163, 247, 320, 20);
		add(pfSenha);
		
		JLabel lblConfirmeASenha = new JLabel("Confirme a senha");
		lblConfirmeASenha.setBounds(50, 290, 100, 14);
		add(lblConfirmeASenha);
		
		pfConfirmeSenha = new JPasswordField();
		pfConfirmeSenha.setBounds(163, 287, 320, 20);
		add(pfConfirmeSenha);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(501, 366, 89, 23);
		add(btnRemover);
		btnRemover.addActionListener(new EvntBtnRemover());
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(402, 366, 89, 23);
		add(btnAtualizar);
		btnAtualizar.addActionListener(new EvntBtnAtualizar());
		
		JButton btnVoltarPanelAdm = new JButton("Voltar");
		btnVoltarPanelAdm.setBounds(204, 366, 89, 23);
		add(btnVoltarPanelAdm);
		btnVoltarPanelAdm.addActionListener(new EvntBtnVoltarPanelAdm());
		
		JButton btnPreencher = new JButton("Preencher");
		btnPreencher.setBounds(493, 46, 89, 23);
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
		
	}
	
	private void setFrame(JFrame frame){
		this.frame = frame;
	}
	
	public void limpar() {
		tfCpf.setText("");
		tfDataNascimento.setText("");
		tfEmail.setText("");
		tfNome.setText("");
		pfSenha.setText("");
		tfIdOperador.setText("");
		pfConfirmeSenha.setText("");
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
				
			String id = tfIdOperador.getText();	
			
			try {
				funcionario = fachada.buscarFuncionario(id);
				if(funcionario instanceof OperadorSistema){
					tfNome.setText(funcionario.getNome());
					tfCpf.setText(funcionario.getCPF());
					tfDataNascimento.setText(funcionario.getDataNascimento());
					tfEmail.setText(funcionario.getEmail());
					pfSenha.setText(funcionario.getSenha());
					tfIdOperador.setEnabled(false);
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
			String id = tfIdOperador.getText();	
			
			try {
				int reply = JOptionPane.showConfirmDialog(null, "Realmente deseja remover este Operador?"
						, "Atenção", JOptionPane.YES_NO_OPTION);
				  if (reply == JOptionPane.YES_OPTION)
				  {
					  fachada.removerFuncionario(id);
						JOptionPane.showMessageDialog(null, "Operador removido com sucesso!"
							, "Removido", JOptionPane.PLAIN_MESSAGE);	
						limpar();
						tfIdOperador.setEnabled(true);
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
			String cSenha = new String(pfConfirmeSenha.getPassword());
			
			Date dataHoje = new Date();
			SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
			String data = formataData.format(dataHoje);			
			
			if(senha.equals(cSenha)){
					try {
						operador = null;
						operador = new OperadorSistema(tfIdOperador.getText(), tfNome.getText(), tfCpf.getText(), 
								tfDataNascimento.getText(),tfEmail.getText(), data, senha);
					} catch (IDIException e1) {
						System.out.println("Erro IDIException");
					}
					
					try {
						fachada.alterarFuncionario(operador, operador.getId());
						JOptionPane.showMessageDialog(null, "Operador atualizado com sucesso!");
						limpar();
						tfIdOperador.setEnabled(true);
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
}
