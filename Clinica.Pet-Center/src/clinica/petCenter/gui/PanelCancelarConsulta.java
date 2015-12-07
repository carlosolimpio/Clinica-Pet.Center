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
import clinica.petCenter.negocio.classesBasicas.Consulta;
import clinica.petCenter.negocio.classesBasicas.OperadorSistema;
import clinica.petCenter.negocio.exceptions.IDIException;
import clinica.petCenter.negocio.exceptions.ONExistenteException;

public class PanelCancelarConsulta extends JPanel {

	private JFrame frame;
	private OperadorSistema op;
	private IFachadaCadastro fachada;
	private JTextField tfIdConsulta;
	
	public PanelCancelarConsulta(JFrame frame, OperadorSistema op) {
		setFrame(frame);
		setPreferredSize(new Dimension(600,400));
		setLayout(null);
		setOperadorSistema(op);
		
		fachada = FachadaCadastro.getInstance();
		
		JLabel lblTitulo = new JLabel("Cancelar Consulta");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(26, 21, 225, 39);
		add(lblTitulo);
		
		JLabel lblIdConsulta = new JLabel("ID Consulta");
		lblIdConsulta.setBounds(149, 180, 68, 14);
		add(lblIdConsulta);
		
		tfIdConsulta = new JTextField();
		tfIdConsulta.setColumns(10);
		tfIdConsulta.setBounds(227, 177, 121, 20);
		add(tfIdConsulta);
		
		JButton btnCancelarConsulta = new JButton("Cancelar consulta");
		btnCancelarConsulta.setBounds(370, 176, 117, 23);
		add(btnCancelarConsulta);
		btnCancelarConsulta.addActionListener(new EvntBtnCancelarConsulta());
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(501, 366, 89, 23);
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
	
	private class EvntBtnCancelarConsulta implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {

				Consulta co = fachada.buscarConsulta(tfIdConsulta.getText());
				int i = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar a consulta: " + co.getIdConsulta() + " ?", 
						"Remover", JOptionPane.YES_NO_OPTION);

				if(i == JOptionPane.YES_OPTION) {
					fachada.removerConsulta(tfIdConsulta.getText());
					JOptionPane.showMessageDialog(null, "Consulta cancelada com sucesso!", "Sucesso", JOptionPane.PLAIN_MESSAGE);
					tfIdConsulta.setText("");
				}

			} catch(IDIException iie) {
				JOptionPane.showMessageDialog(null, "ID incorreto ou fora do padrão.", "Erro", JOptionPane.ERROR_MESSAGE);
				tfIdConsulta.setText("");
			} catch(ONExistenteException onee) {
				JOptionPane.showMessageDialog(null, "Consulta não encontrado no sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
				tfIdConsulta.setText("");
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
