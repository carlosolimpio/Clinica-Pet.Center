package clinica.petCenter.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clinica.petCenter.negocio.cadastros.FachadaCadastro;
import clinica.petCenter.negocio.cadastros.IFachadaCadastro;
import clinica.petCenter.negocio.classesBasicas.Consulta;
import clinica.petCenter.negocio.classesBasicas.OperadorSistema;
import clinica.petCenter.negocio.exceptions.IDIException;
import clinica.petCenter.negocio.exceptions.ONExistenteException;

public class PanelCancelarConsulta extends JPanel {

	private JFrame frame;
	private OperadorSistema op;
	private IFachadaCadastro fachada;
	private JTextField tfIdConsulta;
	
	public PanelCancelarConsulta(JFrame frame, OperadorSistema op) {
		setFrame(frame);
		setPreferredSize(new Dimension(600,400));
		setLayout(null);
		setOperadorSistema(op);
		
		fachada = FachadaCadastro.getInstance();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 600, 21);
		add(menuBar);
		
		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		JMenuItem mntmCadastrarCliente = new JMenuItem("Cadastrar");
		mnCliente.add(mntmCadastrarCliente);
		mntmCadastrarCliente.addActionListener(new EvntMntmCadastrarCliente());
		
		JMenuItem mntmAtualizarCliente = new JMenuItem("Atualizar");
		mnCliente.add(mntmAtualizarCliente);
		mntmAtualizarCliente.addActionListener(new EvntMntmAtualizarCliente());
		
		JMenuItem mntmRemoverCliente = new JMenuItem("Remover");
		mnCliente.add(mntmRemoverCliente);
		mntmRemoverCliente.addActionListener(new EvntMntmRemoverCliente());
		
		JMenu mnAnimal = new JMenu("Animal");
		menuBar.add(mnAnimal);
		
		JMenuItem mntmCadastrarAnimal = new JMenuItem("Cadastrar");
		mnAnimal.add(mntmCadastrarAnimal);
		mntmCadastrarAnimal.addActionListener(new EvntMntmCadastrarAnimal());
		
		JMenuItem mntmAtualizarAnimal = new JMenuItem("Atualizar");
		mnAnimal.add(mntmAtualizarAnimal);
		mntmAtualizarAnimal.addActionListener(new EvntMntmAtualizarAnimal());
		
		JMenuItem mntmRemoverAnimal = new JMenuItem("Remover");
		mnAnimal.add(mntmRemoverAnimal);
		mntmRemoverAnimal.addActionListener(new EvntMntmRemoverAnimal());
		
		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);
		
		JMenuItem mntmAgendarConsulta = new JMenuItem("Agendar Consulta");
		mnConsultas.add(mntmAgendarConsulta);
		mntmAgendarConsulta.addActionListener(new EvtnMntmAgendarConsulta());
		
		JMenuItem mntmCancelarConsulta = new JMenuItem("Cancelar Consulta");
		mnConsultas.add(mntmCancelarConsulta);
		mntmCancelarConsulta.addActionListener(new EvtnMntmCancelarConsulta());
		
		JLabel lblTitulo = new JLabel("Cancelar Consulta");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(26, 21, 225, 39);
		add(lblTitulo);
		
		JLabel lblIdConsulta = new JLabel("ID Consulta");
		lblIdConsulta.setBounds(149, 180, 68, 14);
		add(lblIdConsulta);
		
		tfIdConsulta = new JTextField();
		tfIdConsulta.setColumns(10);
		tfIdConsulta.setBounds(227, 177, 121, 20);
		add(tfIdConsulta);
		
		JButton btnCancelarConsulta = new JButton("Cancelar consulta");
		btnCancelarConsulta.setBounds(370, 176, 117, 23);
		add(btnCancelarConsulta);
		btnCancelarConsulta.addActionListener(new EvntBtnCancelarConsulta());
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(501, 366, 89, 23);
		add(btnVoltar);
		btnVoltar.addActionListener(new EvntBtnVoltar());	
	}
	
	private void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	private void setOperadorSistema(OperadorSistema op) {
		this.op = op;
	}
	
	public OperadorSistema getOperadorSistema() {
		return op;
	}
	
	private class EvntBtnCancelarConsulta implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {

				Consulta co = fachada.buscarConsulta(tfIdConsulta.getText());
				int i = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar a consulta: " + co.getIdConsulta() + " ?", 
						"Remover", JOptionPane.YES_NO_OPTION);

				if(i == JOptionPane.YES_OPTION) {
					fachada.removerConsulta(tfIdConsulta.getText());
					JOptionPane.showMessageDialog(null, "Consulta cancelada com sucesso!", "Sucesso", JOptionPane.PLAIN_MESSAGE);
					tfIdConsulta.setText("");
				}

			} catch(IDIException iie) {
				JOptionPane.showMessageDialog(null, "ID incorreto ou fora do padr�o.", "Erro", JOptionPane.ERROR_MESSAGE);
				tfIdConsulta.setText("");
			} catch(ONExistenteException onee) {
				JOptionPane.showMessageDialog(null, "Consulta n�o encontrado no sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
				tfIdConsulta.setText("");
			}
		}
	}
	
	private class EvntBtnVoltar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelOperadorSistema(frame, getOperadorSistema()));
			frame.getContentPane().setVisible(true);
		}
	}
	
	private class EvntMntmCadastrarCliente implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelCadastrarCliente(frame, getOperadorSistema()));
			frame.getContentPane().setVisible(true);	
			
		}
	}
	
	private class EvntMntmAtualizarCliente implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelAtualizarCliente(frame, getOperadorSistema()));
			frame.getContentPane().setVisible(true);
			
		}
	}
	
	private class EvntMntmRemoverCliente implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelRemoverCliente(frame, getOperadorSistema()));
			frame.getContentPane().setVisible(true);	
			
		}
	}
	
	private class EvntMntmCadastrarAnimal implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelCadastrarAnimal(frame, getOperadorSistema()));
			frame.getContentPane().setVisible(true);
		}
	}
	
	private class EvntMntmAtualizarAnimal implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelAtualizarAnimal(frame, getOperadorSistema()));
			frame.getContentPane().setVisible(true);
		}
	}
	
	private class EvntMntmRemoverAnimal implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelRemoverAnimal(frame, getOperadorSistema()));
			frame.getContentPane().setVisible(true);
		}
	}
	
	private class EvtnMntmAgendarConsulta implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelAgendarConsulta(frame, getOperadorSistema()));
			frame.getContentPane().setVisible(true);
		}
	}
	
	private class EvtnMntmCancelarConsulta implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelCancelarConsulta(frame, getOperadorSistema()));
			frame.getContentPane().setVisible(true);
		}
	}

}
