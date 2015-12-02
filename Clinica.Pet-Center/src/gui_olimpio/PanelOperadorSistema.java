package gui_olimpio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class PanelOperadorSistema extends JPanel {

	private JFrame frame;
	/**
	 * Create the panel.
	 */
	public PanelOperadorSistema(JFrame frame) {
		
		setFrame(frame);
		
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 97, 21);
		add(menuBar);
		
		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		JMenuItem mntmCadastrarCliente = new JMenuItem("Cadastrar");
		mnCliente.add(mntmCadastrarCliente);
		EvntMntmCadastrarCliente evntCadastrarCliente = new EvntMntmCadastrarCliente();
		mntmCadastrarCliente.addActionListener(evntCadastrarCliente);
		
		JMenuItem mntmListarCliente = new JMenuItem("Listar");
		mnCliente.add(mntmListarCliente);
		EvntMntmListarCliente evntListarCliente = new EvntMntmListarCliente();
		mntmListarCliente.addActionListener(evntListarCliente);
		
		JMenuItem mntmRemoverAtualizarCliente = new JMenuItem("Remover/Atualizar");
		mnCliente.add(mntmRemoverAtualizarCliente);
		EvntMntmRemoverAtualizarCliente evntRemoverAtualizarCliente = new EvntMntmRemoverAtualizarCliente();
		mntmRemoverAtualizarCliente.addActionListener(evntRemoverAtualizarCliente);
		
		JMenu mnAnimal = new JMenu("Animal");
		menuBar.add(mnAnimal);
		
		JMenuItem mntmCadastrarAnimal = new JMenuItem("Cadastrar");
		mnAnimal.add(mntmCadastrarAnimal);
		
		JMenuItem mntmListarAnimal = new JMenuItem("Listar");
		mnAnimal.add(mntmListarAnimal);
		
		JMenuItem mntmRemoveratualizarAnimal = new JMenuItem("Remover/Atualizar");
		mnAnimal.add(mntmRemoveratualizarAnimal);

	}
	
	private void setFrame(JFrame frame){
		this.frame = frame;
	}
	
	private class EvntMntmCadastrarCliente implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelCadastrarCliente(frame));
			frame.getContentPane().setVisible(true);	
			
		}
	}
	
	private class EvntMntmListarCliente implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelListarCliente(frame));
			frame.getContentPane().setVisible(true);	
			
		}
	}
	
	private class EvntMntmRemoverAtualizarCliente implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
				
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelRemoverAtualizarCliente(frame));
			frame.getContentPane().setVisible(true);	
			
		}
	}
}
