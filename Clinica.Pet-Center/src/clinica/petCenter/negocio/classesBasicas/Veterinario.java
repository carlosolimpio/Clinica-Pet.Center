package clinica.petCenter.negocio.classesBasicas;

import java.util.List;

import clinica.petCenter.negocio.exceptions.IDIException;
import clinica.petCenter.utilidades.Contadores;
import clinica.petCenter.utilidades.Util;

public class Veterinario extends Funcionario {
	
	private String crmv;
	private List<Consulta> consultas;
	
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
	
	public void setConsulta(List<Consulta> consultas) {
		for(Consulta r : consultas) {
			this.consultas.add(r);
		}
	}
	
	public List<Consulta> getConsulta() {
		return consultas;
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
