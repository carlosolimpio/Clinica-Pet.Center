package clinica.pet_center.negocio.basicas;

import clinica.pet_center.negocio.exceptions.IDIException;
import clinica.pet_center.utilidades.Contadores;
import clinica.pet_center.utilidades.Util;

public class Veterinario extends Funcionario {
	
	private String crmv;
	
	public Veterinario(String nome, String CPF, String dataNascimento, String email, 
			String dataAdmissao, String crmv, String senha) {
		
		super(nome, CPF, dataNascimento, email, dataAdmissao);
		setSenha(senha);
		setCrmv(crmv);
		geraId();
	}
	
	public Veterinario(String id, String nome, String CPF, String dataNascimento, String email, 
			String dataAdmissao, String crmv, String senha) throws IDIException {
		
		super(nome, CPF, dataNascimento, email, dataAdmissao);
		setSenha(senha);
		setCrmv(crmv);
		setId(id);
	}

	private void setCrmv(String crmv) {
		this.crmv = crmv;
	}
	
	public String getCrmv() {
		return crmv;
	}
	
	protected void setSenha(String senha) {
		if(!senha.isEmpty() && (senha.length() > 8))
			super.senha = senha;
	}
	
	protected void setId(String id) throws IDIException {
		if(Util.isID(id))
			super.id = id;
		else
			throw new IDIException(id);
	}
	
	public void geraId() {
		super.id = String.format("VT" + Contadores.getQtdPessoas());
	}
	
	@Override
	public String toString() {
		return String.format(super.toString() + " | " + super.getDataAdmissao()).toUpperCase();
	}
}