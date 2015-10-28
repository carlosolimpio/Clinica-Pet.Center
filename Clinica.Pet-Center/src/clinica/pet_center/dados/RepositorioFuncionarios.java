package clinica.pet_center.dados;

import java.util.ArrayList;

import clinica.pet_center.negocio.basicas.Funcionario;

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
	
	public boolean insere(Funcionario func) {
		boolean r = false;
		
		if(!jaExiste(func))
			r = funcionarios.add(func);
		return r;
	}
	
	public Funcionario busca(String id) {
		Funcionario r = null;
		for(Funcionario f : funcionarios) {
			if(f.getId().equals(id)) {
				r = f;
				break;
			}
		}
		return r;
	}
	
	public ArrayList<Funcionario> lista() {
		return funcionarios;
	}
	
	public boolean remove(String id) {
		boolean r = false;
		for(int i=0; i<funcionarios.size(); i++) {
			if(funcionarios.get(i).getId().equals(id)) {
				funcionarios.remove(i);
				r = true;
				break;
			}
		}
		return r;
	}
	
//	public boolean atualiza() {
//		
//	}
	
	private boolean jaExiste(Funcionario func) {
		boolean r = false;
		
		for(Funcionario f : funcionarios) {
			if(f.equals(func)) {
				r = true;
				break;
			}
		}
		return r;
	}
}
