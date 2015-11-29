package clinica.pet_center.negocio.basicas;

import clinica.pet_center.negocio.exceptions.IDIException;
import clinica.pet_center.utilidades.Contadores;
import clinica.pet_center.utilidades.Util;

public class Administrador extends Pessoa {
	public Administrador(String nome, String CPF, String dataNascimento, String email){
		super(nome,CPF,dataNascimento,email);
	}

	@Override
	public void geraId() {
		super.id = String.format("ADM" + Contadores.getQtdPessoas());
		
	}

	@Override
	protected void setId(String id) throws IDIException {
		if(Util.isID(id))
			super.id = id;
		else
			throw new IDIException(id);
		
	}

	@Override
	public boolean equals(Object obj) {
		boolean r = false;
		if(obj != null && obj instanceof Administrador && this.getCPF() != null && this.getId() != null)
			r = ((Administrador) obj).getCPF().equals(this.getCPF()) && ((Administrador) obj).getId().equals(this.getId());
		return r;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	
	
	
}
