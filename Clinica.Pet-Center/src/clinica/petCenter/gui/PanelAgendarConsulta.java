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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clinica.petCenter.negocio.cadastros.FachadaCadastro;
import clinica.petCenter.negocio.cadastros.IFachadaCadastro;
import clinica.petCenter.negocio.classesBasicas.Animal;
import clinica.petCenter.negocio.classesBasicas.Cliente;
import clinica.petCenter.negocio.classesBasicas.Consulta;
import clinica.petCenter.negocio.classesBasicas.OperadorSistema;
import clinica.petCenter.negocio.classesBasicas.Veterinario;
import clinica.petCenter.negocio.exceptions.IDIException;
import clinica.petCenter.negocio.exceptions.OExistenteException;
import clinica.petCenter.negocio.exceptions.ONExistenteException;

public class PanelAgendarConsulta extends JPanel {

	private JFrame frame;
	private OperadorSistema op;
	private Veterinario vet;
	private IFachadaCadastro fachada;
	
	private JTextField tfIdAnimal;
	private JTextField tfData;
	private JTextField tfIdVeterinario;
	private JTextArea txtAreaMotivoVisita;
	
	public PanelAgendarConsulta(JFrame frame, OperadorSistema op) {
		setFrame(frame);
		setPreferredSize(new Dimension(600,400));
		setLayout(null);
		setOperadorSistema(op);

		fachada = FachadaCadastro.getInstance();
		
		JLabel lblTitulo = new JLabel("Agendamento de Consulta");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(21, 29, 275, 42);
		add(lblTitulo);
		
		JLabel lblIdVeterinario = new JLabel("ID Veterinario");
		lblIdVeterinario.setBounds(66, 105, 72, 14);
		add(lblIdVeterinario);
		
		tfIdVeterinario = new JTextField();
		tfIdVeterinario.setBounds(148, 102, 128, 20);
		add(tfIdVeterinario);
		tfIdVeterinario.setColumns(10);
		
		JLabel lblIdAnimal = new JLabel("ID Animal");
		lblIdAnimal.setBounds(66, 136, 46, 14);
		add(lblIdAnimal);
		
		tfIdAnimal = new JTextField();
		tfIdAnimal.setBounds(148, 133, 128, 20);
		add(tfIdAnimal);
		tfIdAnimal.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(66, 167, 46, 14);
		add(lblData);
		
		tfData = new JTextField();
		tfData.setBounds(148, 164, 128, 20);
		add(tfData);
		tfData.setColumns(10);
		
		JLabel lblMotivoVisita = new JLabel("Motivo da Visita");
		lblMotivoVisita.setBounds(58, 198, 80, 14);
		add(lblMotivoVisita);
		
		txtAreaMotivoVisita = new JTextArea();
		txtAreaMotivoVisita.setBounds(148, 195, 288, 96);
		add(txtAreaMotivoVisita);
		
		JScrollPane scrlPane = new JScrollPane(txtAreaMotivoVisita);
		scrlPane.setBounds(148, 195, 288, 96);
		add(scrlPane);
		
		JButton btnAgendar = new JButton("Agendar");
		btnAgendar.setBounds(501, 366, 89, 23);
		add(btnAgendar);
		btnAgendar.addActionListener(new EvntBtnAgendar());
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(402, 366, 89, 23);
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
	
	private void limpar() {
		tfData.setText("");
		tfIdAnimal.setText("");
		tfIdVeterinario.setText("");
		txtAreaMotivoVisita.setText("");
	}
	
	private class EvntBtnAgendar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			try {
				String veterinario = tfIdVeterinario.getText();
				String animal = tfIdAnimal.getText();
				String data = tfData.getText();
				Veterinario v = (Veterinario) fachada.buscarFuncionario(veterinario);
				Animal a = fachada.buscarAnimalId(animal);
				Cliente c = fachada.buscarCliente(a.getIdDono());
				
				if(!tfData.getText().isEmpty() && !txtAreaMotivoVisita.getText().isEmpty()) {
					
					Consulta co = new Consulta(v, c, a, data);
					co.setMotivoVisita(txtAreaMotivoVisita.getText());
					fachada.cadastrarConsulta(co);
					JOptionPane.showMessageDialog(null, "Consulta agendada com sucesso!");
					limpar();
				} else
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Atenção", JOptionPane.WARNING_MESSAGE);
				
			} catch(ONExistenteException onee) {
				JOptionPane.showMessageDialog(null, onee.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				limpar();
			} catch(IDIException iie) {
				JOptionPane.showMessageDialog(null, iie.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				limpar();
			} catch(OExistenteException oee) {
				JOptionPane.showMessageDialog(null, oee.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				limpar();
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
}
