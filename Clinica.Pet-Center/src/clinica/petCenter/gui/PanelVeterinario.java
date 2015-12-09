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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clinica.petCenter.negocio.cadastros.FachadaCadastro;
import clinica.petCenter.negocio.cadastros.IFachadaCadastro;
import clinica.petCenter.negocio.classesBasicas.Consulta;
import clinica.petCenter.negocio.classesBasicas.Veterinario;
import clinica.petCenter.negocio.exceptions.IDIException;
import clinica.petCenter.negocio.exceptions.ONExistenteException;
import clinica.petCenter.utilidades.Util;

public class PanelVeterinario extends JPanel {

	private JFrame frame;
	private JLabel lblNomeVet;
	private JLabel lblIdVet;
	private JTextArea txtrBusca;
	
	private IFachadaCadastro fachada;
	private Veterinario vet;
	private JTextField tfBuscar;
	private Consulta consulta;
	

	public PanelVeterinario(JFrame frame, Veterinario vet) {
		
		setFrame(frame);
		setPreferredSize(new Dimension(600,400));
		setLayout(null);
		setVeterinario(vet);
		
		fachada = FachadaCadastro.getInstance();
		
		lblNomeVet = new JLabel("Bem Vindo, veterinario " + vet.getNome());
		lblNomeVet.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNomeVet.setBounds(32, 30, 307, 39);
		add(lblNomeVet);
		
		lblIdVet = new JLabel("ID " + vet.getId());
		lblIdVet.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIdVet.setBounds(32, 56, 307, 39);
		add(lblIdVet);
		
		JLabel label = new JLabel("Buscar ID");
		label.setBounds(32, 109, 71, 14);
		add(label);
		
		tfBuscar = new JTextField();
		tfBuscar.setColumns(10);
		tfBuscar.setBounds(91, 106, 134, 20);
		add(tfBuscar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(235, 105, 89, 23);
		add(btnBuscar);
		btnBuscar.addActionListener(new EvntBtnBuscar());
		
		JButton btnListarTodos = new JButton("Listar todos");
		btnListarTodos.setBounds(381, 105, 146, 23);
		add(btnListarTodos);
		btnListarTodos.addActionListener(new EvntBtnListarTodos());
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(491, 366, 89, 23);
		add(btnSair);
		btnSair.addActionListener(new EvntBtnSair());
		
		txtrBusca = new JTextArea();
		txtrBusca.setBounds(32, 149, 457, 197);
		add(txtrBusca);
		
		JButton btnPreencher = new JButton("Preencher");
		btnPreencher.setBounds(392, 366, 89, 23);
		add(btnPreencher);
		

	}

	private void setVeterinario(Veterinario vet) {
		this.vet = vet;
		
	}
	
	public Veterinario getVeterinario(){
		return vet;
	}

	private void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	private class EvntBtnSair implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			new TelaLogin().getFrame().setVisible(true);
		}
	}
	
	private class EvntBtnBuscar implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String temp;
			txtrBusca.setText("");
			String idBusca = Util.whatId(tfBuscar.getText());
			
			try {
				
				if(idBusca.equals(tfBuscar.getText())) {
					
					Consulta c =  fachada.buscarConsulta(tfBuscar.getText());
					temp = "ID: "+c.getIdConsulta()+"\nID Animal: "+c.getAnimal().getId()+"\nMotivo Visita:\n"
							+c.getMotivoVisita();
					txtrBusca.append(temp.toUpperCase());
					tfBuscar.setText("");
					
				}
				
			} catch(IDIException idie) {
				JOptionPane.showMessageDialog(null, "ID incorreto ou fora do padrão.", "Erro", JOptionPane.ERROR_MESSAGE);
				tfBuscar.setText("");
			} catch(ONExistenteException onee) {
				JOptionPane.showMessageDialog(null, "Funcionario não encontrado no sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
				tfBuscar.setText("");
			} catch (Exception e1){
				e1.printStackTrace();
			}
		}
	}
	
	private class EvntBtnListarTodos implements ActionListener {
		public void actionPerformed(ActionEvent e) {

				frame.getContentPane().setVisible(false);
				frame.setContentPane(new PanelListarVeterinario(frame));
				frame.getContentPane().setVisible(true);
				
		}
	}
}
