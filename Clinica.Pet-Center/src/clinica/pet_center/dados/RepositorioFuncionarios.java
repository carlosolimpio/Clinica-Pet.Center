package clinica.pet_center.dados;

import java.util.ArrayList;

import clinica.pet_center.negocio.basicas.Funcionario;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;

public class RepositorioFuncionarios {

	private static RepositorioFuncionarios repositorioFuncionarios;
	private ArrayList<Funcionario> funcionarios;
	
	private RepositorioFuncionarios() {
		funcionarios = new ArrayList<Funcionario>();
	}
	
	public static RepositorioFuncionarios getInstancia() {
		if(repositorioFuncionarios == null)
			repositorioFuncionarios = new RepositorioFuncionarios();
		return repositorioFuncionarios;
	}
	
	public void insere(Funcionario func) throws OExistenteException {
		jaExiste(func);
		funcionarios.add(func);
	}
	
	public Funcionario busca(String id) throws ONExistenteException {
		Funcionario r = null;
		for(Funcionario f : funcionarios) {
			if(f.getId().equals(id)) {
				r = f;
				break;
			}
		}
		if(r != null)
			return r;
		else
			throw new ONExistenteException(id);
	}
	
	public ArrayList<Funcionario> lista() {
		return funcionarios;
	}
	
	public void remove(String id) throws ONExistenteException {
		boolean r = false;
		for(int i=0; i<funcionarios.size(); i++) {
			if(funcionarios.get(i).getId().equals(id)) {
				funcionarios.remove(i);
				r = true;
				break;
			}
		}
		if(!r) 
			throw new ONExistenteException(id);
	}
	
//	public boolean atualiza() {
//		
//	}
	
	private void jaExiste(Funcionario func) throws OExistenteException {
		for(Funcionario f : funcionarios) {
			if(f.equals(func))
				throw new OExistenteException(func);
		}
	}
}
