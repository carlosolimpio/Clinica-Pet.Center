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
import clinica.petCenter.negocio.classesBasicas.Animal;
import clinica.petCenter.negocio.classesBasicas.Cliente;
import clinica.petCenter.negocio.classesBasicas.OperadorSistema;
import clinica.petCenter.negocio.exceptions.IDIException;
import clinica.petCenter.negocio.exceptions.OExistenteException;
import clinica.petCenter.negocio.exceptions.ONExistenteException;
import clinica.petCenter.utilidades.Contadores;

public class PanelCadastrarAnimal extends JPanel {

	private JFrame frame;
	private OperadorSistema op;
	private IFachadaCadastro fachada;
	private JTextField tfNome;
	private JTextField tfEspecie;
	private JTextField tfRaca;
	private JTextField tfDataNascimento;
	private JTextField tfTipoSanguineo;
	private JTextField tfIdCliente;
	
	public PanelCadastrarAnimal(JFrame frame, OperadorSistema op) {
		setFrame(frame);
		setPreferredSize(new Dimension(600,400));
		setLayout(null);
		setOp(op);
		
		fachada = FachadaCadastro.getInstance();
		
		JLabel lblTitulo = new JLabel("Cadastro de Animal");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(40, 25, 239, 40);
		add(lblTitulo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(89, 125, 46, 14);
		add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(197, 122, 320, 20);
		add(tfNome);
		
		JLabel lblEspecie = new JLabel("Esp\u00E9cie");
		lblEspecie.setBounds(89, 156, 46, 14);
		add(lblEspecie);
		
		tfEspecie = new JTextField();
		tfEspecie.setColumns(10);
		tfEspecie.setBounds(197, 153, 320, 20);
		add(tfEspecie);
		
		JLabel lblRaca = new JLabel("Ra\u00E7a");
		lblRaca.setBounds(89, 187, 46, 14);
		add(lblRaca);
		
		tfRaca = new JTextField();
		tfRaca.setColumns(10);
		tfRaca.setBounds(197, 184, 320, 20);
		add(tfRaca);
		
		JLabel lblDataNascimento = new JLabel("Data de nascimento");
		lblDataNascimento.setBounds(89, 218, 101, 14);
		add(lblDataNascimento);
		
		tfDataNascimento = new JTextField();
		tfDataNascimento.setColumns(10);
		tfDataNascimento.setBounds(197, 215, 138, 20);
		add(tfDataNascimento);
		
		JLabel lblTipoSanguineo = new JLabel("Tipo sangu\u00EDneo");
		lblTipoSanguineo.setBounds(89, 249, 80, 14);
		add(lblTipoSanguineo);
		
		tfTipoSanguineo = new JTextField();
		tfTipoSanguineo.setColumns(10);
		tfTipoSanguineo.setBounds(197, 246, 138, 20);
		add(tfTipoSanguineo);
		
		JLabel lblIdCliente = new JLabel("ID Cliente");
		lblIdCliente.setBounds(89, 280, 80, 14);
		add(lblIdCliente);
		
		tfIdCliente = new JTextField();
		tfIdCliente.setColumns(10);
		tfIdCliente.setBounds(197, 277, 138, 20);
		add(tfIdCliente);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(402, 366, 89, 23);
		add(btnVoltar);
		btnVoltar.addActionListener(new EvntBtnvoltar());
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(501, 366, 89, 23);
		add(btnCadastrar);
		btnCadastrar.addActionListener(new EvntBtnCadastrar());
	}
	
	private void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public OperadorSistema getOp() {
		return op;
	}

	public void setOp(OperadorSistema op) {
		this.op = op;
	}
	
	private class EvntBtnCadastrar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			try {
				
				if(!tfNome.getText().isEmpty() && !tfDataNascimento.getText().isEmpty() && 
						!tfEspecie.getText().isEmpty() && !tfRaca.getText().isEmpty() && 
						!tfTipoSanguineo.getText().isEmpty()) {
					
					Cliente c = fachada.buscarCliente(tfIdCliente.getText());
					
					Animal a = new Animal(tfNome.getText(), tfEspecie.getText(), tfRaca.getText(), 
							tfDataNascimento.getText(), c.getId(), tfTipoSanguineo.getText());
					
					fachada.cadastrarAnimal(a);
					
					JOptionPane.showMessageDialog(null, "Animal " + a.getId() + " cadastrado com sucesso!", 
							"Sucesso", JOptionPane.PLAIN_MESSAGE);
					
					frame.getContentPane().setVisible(false);
					frame.setContentPane(new PanelOperadorSistema(frame, getOp()));
					frame.getContentPane().setVisible(true);
					
				} else
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Atenção", JOptionPane.WARNING_MESSAGE);
				
			} catch(IDIException iie) {
				JOptionPane.showMessageDialog(null, "ID Cliente incorreto ou fora do padrão.", "Erro", JOptionPane.ERROR_MESSAGE);
			} catch(ONExistenteException onee) {
				JOptionPane.showMessageDialog(null, "Cliente não encontrado no sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
				tfIdCliente.setText("");
			} catch(OExistenteException oee) {
				JOptionPane.showMessageDialog(null, "Animal já cadastrado no sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
				tfNome.setText("");
				tfEspecie.setText("");
				tfRaca.setText("");
				tfDataNascimento.setText("");
				tfIdCliente.setText(""); 
				tfTipoSanguineo.setText("");
				Contadores.decrementaAnimais();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private class EvntBtnvoltar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelOperadorSistema(frame, getOp()));
			frame.getContentPane().setVisible(true);
		}
	}
}
