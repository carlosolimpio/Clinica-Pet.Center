package clinica.pet_center.negocio.cadastros;

import java.util.ArrayList;

import clinica.pet_center.dados.RepositorioFuncionarios;
import clinica.pet_center.negocio.basicas.Funcionario;
import clinica.pet_center.negocio.basicas.OperadorSistema;
import clinica.pet_center.negocio.basicas.Veterinario;

public class CadastroFuncionario {

	private RepositorioFuncionarios repositorioFuncionario;
	
	public CadastroFuncionario() {
		repositorioFuncionario = RepositorioFuncionarios.getInstancia();
	}
	
	public boolean cadastraFuncionario(Funcionario func) {
		boolean r = false;
		if(isFuncionario(func))
			r = repositorioFuncionario.insere(func);
		return r;
	}
	
	public Funcionario buscaFuncionario(String id) {
		Funcionario r = null;
		if(checkIDFuncionario(id))
		r = repositorioFuncionario.busca(id);
		return r;
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
	
	public boolean removeFuncionario(String id) {
		boolean r = false;
		if(checkIDFuncionario(id))
		r = repositorioFuncionario.remove(id);
		return r;
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
