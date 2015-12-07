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
import javax.swing.JTextField;

import clinica.petCenter.negocio.cadastros.FachadaCadastro;
import clinica.petCenter.negocio.cadastros.IFachadaCadastro;
import clinica.petCenter.negocio.classesBasicas.Animal;
import clinica.petCenter.negocio.classesBasicas.OperadorSistema;
import clinica.petCenter.negocio.exceptions.IDIException;
import clinica.petCenter.negocio.exceptions.ONExistenteException;

public class PanelRemoverAnimal extends JPanel {

	private JFrame frame;
	private OperadorSistema op;
	private IFachadaCadastro fachada;
	private JTextField tfAnimal;
	
	public PanelRemoverAnimal(JFrame frame, OperadorSistema op) {

		setFrame(frame);
		setPreferredSize(new Dimension(600,400));
		setLayout(null);
		setOp(op);
		
		fachada = FachadaCadastro.getInstance();
		
		JLabel lblTitulo = new JLabel("Remover Animal");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(33, 23, 225, 39);
		add(lblTitulo);
		
		JLabel lblAnimal = new JLabel("ID Animal");
		lblAnimal.setBounds(153, 144, 68, 14);
		add(lblAnimal);
		
		tfAnimal = new JTextField();
		tfAnimal.setColumns(10);
		tfAnimal.setBounds(231, 141, 121, 20);
		add(tfAnimal);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(374, 140, 89, 23);
		add(btnRemover);
		btnRemover.addActionListener(new EvntBtnRemover());
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(501, 366, 89, 23);
		add(btnVoltar);
		btnVoltar.addActionListener(new EvntBtnVoltar());
	}
	
	private void setFrame(JFrame frame){
		this.frame = frame;
	}
	
	public OperadorSistema getOp() {
		return op;
	}

	public void setOp(OperadorSistema op) {
		this.op = op;
	}
	
	private class EvntBtnRemover implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {

				Animal a = fachada.buscarAnimalId(tfAnimal.getText());
				int i = JOptionPane.showConfirmDialog(null, "Deseja realmente remover o animal " + a.getId() + " ?", 
						"Remover", JOptionPane.YES_NO_OPTION);

				if(i == JOptionPane.YES_OPTION) {
					fachada.removerAnimal(tfAnimal.getText());
					JOptionPane.showMessageDialog(null, "Animal removido com sucesso!", "Sucesso", JOptionPane.PLAIN_MESSAGE);
					tfAnimal.setText("");
				}

			} catch(IDIException iie) {
				JOptionPane.showMessageDialog(null, "ID incorreto ou fora do padrão.", "Erro", JOptionPane.ERROR_MESSAGE);
				tfAnimal.setText("");
			} catch(ONExistenteException onee) {
				JOptionPane.showMessageDialog(null, "Animal não encontrado no sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
				tfAnimal.setText("");
			}
		}
	}
	
	private class EvntBtnVoltar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().setVisible(false);
			frame.setContentPane(new PanelOperadorSistema(frame, getOp()));
			frame.getContentPane().setVisible(true);
		}
	}
}
