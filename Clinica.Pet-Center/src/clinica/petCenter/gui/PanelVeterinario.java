package clinica.petCenter.gui;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class PanelVeterinario extends JPanel {
	
	private JFrame frame;

	public PanelVeterinario(JFrame frame) {
		
		setFrame(frame);
		setPreferredSize(new Dimension(600,400));
		setLayout(null);
		
		JMenuBar mbConsultas = new JMenuBar();
		mbConsultas.setBounds(50, 0, 97, 21);
		add(mbConsultas);
		
		JMenu mnMconsultas = new JMenu("Consultas");
		mbConsultas.add(mnMconsultas);
		
		JMenuItem mntmRealizarConsulta = new JMenuItem("Realizar Consulta");
		mnMconsultas.add(mntmRealizarConsulta);
		
		JMenuItem mntmImprimirReceita = new JMenuItem("Imprimir Receita");
		mnMconsultas.add(mntmImprimirReceita);
		
		JMenuBar mbAnimais = new JMenuBar();
		mbAnimais.setBounds(0, 0, 97, 21);
		add(mbAnimais);
		
		JMenu mnAnimais = new JMenu("Animais");
		mbAnimais.add(mnAnimais);
		
		JMenuItem mntmListaAnimais = new JMenuItem("Lista Animais");
		mnAnimais.add(mntmListaAnimais);
		
		JMenuItem mntmListaTodosAnimais = new JMenuItem("Lista Todos Animais");
		mnAnimais.add(mntmListaTodosAnimais);
	}

	private void setFrame(JFrame frame) {
		this.frame = frame; 
		
	}
	
}
