package gui_olimpio;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JSlider;

public class PanelOperadorSistema extends JPanel {

	private JFrame frame;
	private JTextField tfBuscar;
	/**
	 * Create the panel.
	 */
	public PanelOperadorSistema(JFrame frame) {
		
		setFrame(frame);
		setPreferredSize(new Dimension(600,400));
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
		
		JLabel lblBuscarId = new JLabel("Buscar ID");
		lblBuscarId.setBounds(51, 78, 71, 14);
		add(lblBuscarId);
		
		tfBuscar = new JTextField();
		tfBuscar.setBounds(110, 75, 134, 20);
		add(tfBuscar);
		tfBuscar.setColumns(10);
		
		JRadioButton rdbtnCliente = new JRadioButton("Cliente");
		rdbtnCliente.setBounds(110, 106, 82, 14);
		add(rdbtnCliente);
		
		JRadioButton rdbtnAnimal = new JRadioButton("Animal");
		rdbtnAnimal.setBounds(51, 102, 57, 23);
		add(rdbtnAnimal);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(254, 74, 89, 23);
		add(btnBuscar);
		
		JButton btnListar = new JButton("Listar todos");
		btnListar.setBounds(400, 74, 146, 23);
		add(btnListar);

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
