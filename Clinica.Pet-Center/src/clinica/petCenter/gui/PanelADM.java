package clinica.petCenter.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelADM extends JPanel {

	private JFrame frame;
	
	public PanelADM (JFrame frame) {
		setLayout(null);
		setPreferredSize(new Dimension(600,400));
		
		setFrame(frame);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 210, 21);
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
		EvntMntmCadastrarVeterinario evntCadastrarVeterinario = new EvntMntmCadastrarVeterinario();
		mntmCadastrarVeterinario.addActionListener(evntCadastrarVeterinario);
		
		JMenuItem mntmListarVeterinario = new JMenuItem("Listar");
		mnVeterinario.add(mntmListarVeterinario);
		EvntMntmListarVeterinario evntListarVeterinario = new EvntMntmListarVeterinario();
		mntmListarVeterinario.addActionListener(evntListarVeterinario);
		
		JMenuItem mntmRemoverAtualizarVeterinario = new JMenuItem("Remover/Atualizar");
		mnVeterinario.add(mntmRemoverAtualizarVeterinario);
		EvntMntmRemoverAtualizarVeterinario evntRemoverAtualizarVeterinario = new EvntMntmRemoverAtualizarVeterinario();
		mntmRemoverAtualizarVeterinario.addActionListener(evntRemoverAtualizarVeterinario);
		
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
	
	private class EvntMntmCadastrarVeterinario implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelCadastrarVeterinario(frame));
			frame.getContentPane().setVisible(true);	
			
		}
	}
	
	private class EvntMntmListarVeterinario implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelListarVeterinario(frame));
			frame.getContentPane().setVisible(true);	
			
		}
	}
	
	private class EvntMntmRemoverAtualizarVeterinario implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelRemoverAtualizarVeterinario(frame));
			frame.getContentPane().setVisible(true);	
			
		}
	}
}
