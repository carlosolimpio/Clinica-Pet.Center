package gui_olimpio;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class PanelCadastrarOperador extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelCadastrarOperador() {
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 97, 21);
		add(menuBar);
		
		JMenu mnCliente = new JMenu("Cliente");
		mnCliente.setBounds(0,0,50,21);
		menuBar.add(mnCliente);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mnCliente.add(mntmCadastrar);
		
		JMenuItem mntmRemover = new JMenuItem("Remover");
		mnCliente.add(mntmRemover);

	}
}
