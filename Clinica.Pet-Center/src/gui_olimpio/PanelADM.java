package gui_olimpio;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class PanelADM extends JPanel {

	private JFrame frame;
	
	public PanelADM (JFrame frame) {
		setLayout(null);
		setPreferredSize(new Dimension(600,400));
		
		setFrame(frame);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 260, 21);
		add(menuBar);
		
		JMenu mnOperadorDeSistema = new JMenu("Operador de sistema");
		mnOperadorDeSistema.setBounds(50,0,140,21);
		menuBar.add(mnOperadorDeSistema);
		
		JMenuItem mntmCadastrarOperador = new JMenuItem("Cadastrar");   //=============================OK
		mnOperadorDeSistema.add(mntmCadastrarOperador);
		EvntMntmCadastrarOperador evntCadastrarOperador = new EvntMntmCadastrarOperador();
		mntmCadastrarOperador.addActionListener(evntCadastrarOperador);
		
		JMenuItem mntmListarOperador = new JMenuItem("Listar");         //=============================OK
		mnOperadorDeSistema.add(mntmListarOperador);
		EvntMntmListarOperador evntListarOperador = new EvntMntmListarOperador();
		mntmListarOperador.addActionListener(evntListarOperador);
		
		JMenuItem mntmRemoverAtualizarOperador = new JMenuItem("Remover/Atualizar");       //=============================OK
		mnOperadorDeSistema.add(mntmRemoverAtualizarOperador);
		EvntMntmRemoverOperador evntRemoverOperador = new EvntMntmRemoverOperador();
		mntmRemoverAtualizarOperador.addActionListener(evntRemoverOperador);
		
		JMenu mnVeterinario = new JMenu("Veterin\u00E1rio");
		mnVeterinario.setBounds(170,0,70,21);
		menuBar.add(mnVeterinario);
		
		JMenuItem mntmCadastrarVeterinario = new JMenuItem("Cadastrar");
		mnVeterinario.add(mntmCadastrarVeterinario);
		
		JMenuItem mntmListarVeterinario = new JMenuItem("Listar");
		mnVeterinario.add(mntmListarVeterinario);
		
		JMenuItem mntmRemoverAtualizarVeterinario = new JMenuItem("Remover/Atualizar");
		mnVeterinario.add(mntmRemoverAtualizarVeterinario);
		
	}	
	
	private void setFrame(JFrame frame){
		this.frame = frame;
	}
	
	private class EvntMntmCadastrarOperador implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelCadastrarOperador(frame));
			frame.getContentPane().setVisible(true);	
			
		}
	}
	
	private class EvntMntmListarOperador implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelListarOperador(frame));
			frame.getContentPane().setVisible(true);	
			
		}
	}
	
	private class EvntMntmRemoverOperador implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelRemoverAtualizarOperador(frame));
			frame.getContentPane().setVisible(true);	
			
		}
	}
}
