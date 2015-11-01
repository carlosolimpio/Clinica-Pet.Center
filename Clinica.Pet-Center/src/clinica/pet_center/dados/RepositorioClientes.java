package clinica.pet_center.dados;

import java.util.ArrayList;

import clinica.pet_center.negocio.basicas.Cliente;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;

public class RepositorioClientes implements IRepositorioClientes{

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
	
	@Override
	public void insere(Cliente cliente) throws OExistenteException {
		jaExiste(cliente);
		clientes.add(cliente);
	}
	
	@Override
	public Cliente busca(String id) throws ONExistenteException {
		Cliente r = null;
		for(Cliente c : clientes) {
			if(c.getId().equals(id)) {
				r = c;
				break;
			}
		}
		if(r != null)
			return r;
		else
			throw new ONExistenteException(id);
	}
	
	@Override
	public ArrayList<Cliente> lista() {
		return clientes;
	}
	
	@Override
	public void remove(String id) throws ONExistenteException {
		boolean r = false;
		for(int i=0; i<clientes.size(); i++) {
			if(clientes.get(i).getId().equals(id)) {
				clientes.remove(i);
				r = true;
				break;
			}
		}
		if(!r)
			throw new ONExistenteException(id);
	}
	
	public void atualiza(Cliente novo, String id) throws OExistenteException, ONExistenteException {
		jaExiste(novo);
		remove(id);
		insere(novo);
	}
	
	public void jaExiste(Cliente cliente) throws OExistenteException {
		for(Cliente c : clientes) {
			if(c.equals(cliente))
				throw new OExistenteException(cliente);
		}
	}
}
