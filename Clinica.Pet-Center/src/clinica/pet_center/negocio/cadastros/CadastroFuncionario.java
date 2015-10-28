package clinica.pet_center.negocio.cadastros;

import java.util.ArrayList;

import clinica.pet_center.dados.RepositorioFuncionarios;
import clinica.pet_center.negocio.basicas.Funcionario;
import clinica.pet_center.negocio.basicas.OperadorSistema;
import clinica.pet_center.negocio.basicas.Veterinario;
import clinica.pet_center.negocio.exceptions.IDIException;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;
import clinica.pet_center.utilidades.Util;

public class CadastroFuncionario {

	private RepositorioFuncionarios repositorioFuncionario;
	
	public CadastroFuncionario() {
		repositorioFuncionario = RepositorioFuncionarios.getInstancia();
	}
	
	public void cadastraFuncionario(Funcionario func) throws OExistenteException, IDIException {
		if(Util.isID(func.getId()))
			repositorioFuncionario.insere(func);
		else 
			throw new IDIException(func.getId());
	}
	
	public Funcionario buscaFuncionario(String id) throws ONExistenteException, IDIException {
		if(Util.isID(id))
			return repositorioFuncionario.busca(id);
		else
			throw new IDIException(id);
	}
	
	public ArrayList<Funcionario> listaFuncionarios() {
		return repositorioFuncionario.lista();
	}
	
	public ArrayList<Veterinario> listaVeterinarios() {
		ArrayList<Veterinario> r = new ArrayList<Veterinario>();
		for(Funcionario f : repositorioFuncionario.lista()) {
			if(f instanceof Veterinario)
				r.add(((Veterinario) f));
		}
		return r;
	}
	
	public ArrayList<OperadorSistema> listaOperadoresSistema() {
		ArrayList<OperadorSistema> r = new ArrayList<OperadorSistema>();
		for(Funcionario f : repositorioFuncionario.lista()) {
			if(f instanceof OperadorSistema)
				r.add(((OperadorSistema) f));
		}
		return r;
	}
	
//	public boolean alteraFuncionario(String id) {
//		boolean r = false;
//		
//		return r;
//	}
	
	public void removeFuncionario(String id) throws ONExistenteException, IDIException {
		if(Util.isID(id))
			repositorioFuncionario.remove(id);
		else
			throw new IDIException(id);
	}
	
	private boolean checkIDFuncionario(String id) {
		boolean r = false;
		if(id != null && !id.isEmpty())
			r = id.startsWith("VT") || id.startsWith("OP");
		return r;
	}
	
	private boolean isFuncionario(Object obj) {
		boolean r = false;
		if(obj != null)
			r = obj instanceof Funcionario;
		return r;
	}
	
//	@Override
//	public String toString(){
//		return String.format("EXISTEM %d FUNCIONÁRIOS NO SISTEMA",  repositorioFuncionario.lista().size());
//	}
}
