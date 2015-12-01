package gui_olimpio;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelADM extends JPanel {

	public PanelADM () {
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 260, 21);
		add(menuBar);
		
		JMenu mnOperadorDeSistema = new JMenu("Operador de sistema");
		mnOperadorDeSistema.setBounds(50,0,140,21);
		menuBar.add(mnOperadorDeSistema);
		
		JMenuItem mntmCadastrarOperador = new JMenuItem("Cadastrar");
		mntmCadastrarOperador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnOperadorDeSistema.add(mntmCadastrarOperador);
		
		JMenuItem mntmListarOperador = new JMenuItem("Listar");
		mnOperadorDeSistema.add(mntmListarOperador);
		
		JMenuItem mntmRemoverOperador = new JMenuItem("Remover");
		mnOperadorDeSistema.add(mntmRemoverOperador);
		
		JMenu mnVeterinario = new JMenu("Veterin\u00E1rio");
		mnVeterinario.setBounds(170,0,70,21);
		menuBar.add(mnVeterinario);
		
		JMenuItem mntmCadastrarVeterinario = new JMenuItem("Cadastrar");
		mnVeterinario.add(mntmCadastrarVeterinario);
		
		JMenuItem mntmListarVeterinario = new JMenuItem("Listar");
		mnVeterinario.add(mntmListarVeterinario);
		
		JMenuItem mntmRemoverVeterinario = new JMenuItem("Remover");
		mnVeterinario.add(mntmRemoverVeterinario);		
		
	}	
		
}
