
package clinica.pet_center.negocio.basicas;

import clinica.pet_center.negocio.exceptions.IDIException;
import clinica.pet_center.utilidades.Contadores;
import clinica.pet_center.utilidades.Util;

public class OperadorSistema extends Funcionario {
	
	public OperadorSistema(String nome, String CPF, String dataNascimento,
			String email, String dataAdmissao, String senha) {
		
		super(nome, CPF, dataNascimento, email, dataAdmissao);
		setSenha(senha);
		geraId();
	}
	
	public OperadorSistema(String id, String nome, String CPF, String dataNascimento,
			String email, String dataAdmissao, String senha) throws IDIException {
		
		super(nome, CPF, dataNascimento, email, dataAdmissao);
		setSenha(senha);
		setId(id);
	}
	
	protected void setSenha(String senha) {
		if(!senha.isEmpty() && (senha.length() > 8))
			super.senha = senha;
	}
	
	public void geraId() {
		super.id = String.format("OP" + Contadores.getQtdPessoas());
	}
	
	protected void setId(String id) throws IDIException {
		if(Util.isID(id))
			super.id = id;
		else
			throw new IDIException(id);
	}
	
	@Override
	public String toString() {
		return String.format(super.toString() + " | " + super.getDataAdmissao()).toUpperCase();
	}
}

