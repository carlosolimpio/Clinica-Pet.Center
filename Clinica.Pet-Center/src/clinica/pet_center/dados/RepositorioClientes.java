package clinica.pet_center.dados;

import java.util.ArrayList;

import clinica.pet_center.negocio.basicas.Cliente;

public class RepositorioClientes {

	private static RepositorioClientes repositorioClientes;
	private ArrayList<Cliente> clientes;
	
	private RepositorioClientes() {
		clientes = new ArrayList<Cliente>();
	}
	
	public static RepositorioClientes getInstancia() {
		if(repositorioClientes == null)
			repositorioClientes = new RepositorioClientes();
		return repositorioClientes;
	}
	
	public boolean insere(Cliente cliente) {
		boolean r = false;
		if(!jaExiste(cliente)) {
			clientes.add(cliente);
			r = true;
		}
		return r;
	}
	
	public Cliente busca(String id) {
		Cliente r = null;
		for(Cliente c : clientes) {
			if(c.getId().equals(id)) {
				r = c;
				break;
			}
		}
		return r;
	}
	
	public ArrayList<Cliente> lista() {
		return clientes;
	}
	
	public boolean remove(String id) {
		boolean r = false;
		for(int i=0; i<clientes.size(); i++) {
			if(clientes.get(i).getId().equals(id)) {
				clientes.remove(i);
				r = true;
				break;
			}
		}
		return r;
	}
	
	//ver aqui depois
//	public boolean atualiza() {
//		
//	}
	
	public boolean jaExiste(Cliente cliente) {
		boolean r = false;
		for(Cliente c : clientes) {
			if(c.equals(cliente)) {
				r = true;
				break;
			}
		}
		return r;
	}
}
