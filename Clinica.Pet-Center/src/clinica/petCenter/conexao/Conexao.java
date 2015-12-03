package clinica.petCenter.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	Connection con;
	String servidor = "jdbc:mysql://localhost:3306/clinicapetshop";
	String usuario = "root";
	String senha = "";
	String driver = "com.mysql.jdbc.Driver";
	
	public Connection abrirBDCon(){
		con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(servidor,usuario,senha);
			JOptionPane.showMessageDialog(null, "Conexão aberta");
		}
		catch(ClassNotFoundException cnf){
			JOptionPane.showMessageDialog(null, cnf.getMessage());
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao abrir com o banco!");
		}
		return con;
	}
	public void fecharBDCon(){
		try {
			con.close();
			JOptionPane.showMessageDialog(null, "Conexao finalizada!");
		} catch (SQLException sql) {
			JOptionPane.showMessageDialog(null, "Falha na finalização da conexão!");
		}
	}
}
