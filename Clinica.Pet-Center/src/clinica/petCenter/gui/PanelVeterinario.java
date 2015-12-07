package clinica.petCenter.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import clinica.petCenter.negocio.cadastros.IFachadaCadastro;
import clinica.petCenter.negocio.classesBasicas.OperadorSistema;
import clinica.petCenter.negocio.classesBasicas.Veterinario;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelVeterinario extends JPanel {

	private JFrame frame;
	private JLabel lblNomeVet;
	private JLabel lblIdVet;
	
	private IFachadaCadastro fachada;
	private Veterinario vet;

	public PanelVeterinario(JFrame frame, Veterinario vet) {
		
		setFrame(frame);
		setPreferredSize(new Dimension(600,400));
		setLayout(null);
		
		JMenuBar mbConsultas = new JMenuBar();
		mbConsultas.setBounds(50, 0, 97, 21);
		add(mbConsultas);
		
		JMenu mnMconsultas = new JMenu("Consultas");
		mbConsultas.add(mnMconsultas);
		
		JMenuItem mntmImprimirReceita = new JMenuItem("Imprimir Receita");
		mnMconsultas.add(mntmImprimirReceita);
		
		JMenuItem mntmPreencherConsulta = new JMenuItem("Preencher Consulta");
		mntmPreencherConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().setVisible(false);
				//frame.setContentPane(new PanelAgendarConsulta(frame, vet));
				frame.getContentPane().setVisible(true);
			}
		});
		mnMconsultas.add(mntmPreencherConsulta);
		
		JMenuBar mbAnimais = new JMenuBar();
		mbAnimais.setBounds(0, 0, 97, 21);
		add(mbAnimais);
		
		JMenu mnAnimais = new JMenu("Animais");
		mbAnimais.add(mnAnimais);
		
		JMenuItem mntmListaAnimais = new JMenuItem("Lista Animais");
		mnAnimais.add(mntmListaAnimais);
		
		JMenuItem mntmListaTodosAnimais = new JMenuItem("Lista Todos Animais");
		mnAnimais.add(mntmListaTodosAnimais);
		
		lblNomeVet = new JLabel("Bem Vindo, veterinario " + vet.getNome());
		lblNomeVet.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNomeVet.setBounds(32, 30, 307, 39);
		add(lblNomeVet);
		
		lblIdVet = new JLabel("ID " + vet.getId());
		lblIdVet.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIdVet.setBounds(32, 80, 307, 39);
		add(lblIdVet);
		

	}

	private void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
