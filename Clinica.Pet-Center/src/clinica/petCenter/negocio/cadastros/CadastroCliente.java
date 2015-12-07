package clinica.petCenter.negocio.cadastros;

import java.util.List;

import clinica.petCenter.negocio.classesBasicas.Animal;
import clinica.petCenter.negocio.classesBasicas.Cliente;
import clinica.petCenter.negocio.exceptions.IDIException;
import clinica.petCenter.negocio.exceptions.OExistenteException;
import clinica.petCenter.negocio.exceptions.ONExistenteException;
import clinica.petCenter.utilidades.Util;
import clinica.petCenter.dados.IRepositorio;
import clinica.petCenter.dados.RepositorioClientes;

public class CadastroCliente {

	private IRepositorio<Cliente> repositorioCliente;
	
	public CadastroCliente() {
		repositorioCliente = RepositorioClientes.getInstancia();
	}
	
	public void cadastrarCliente(Cliente cliente) throws OExistenteException, IDIException, 
		IllegalArgumentException {
		if(Util.isID(cliente.getId())) {
			existeObjeto(cliente);
			repositorioCliente.inserir(cliente);
		}
		else
			throw new IDIException(cliente.getId());
	}
	
	public Cliente buscarCliente(String id) throws ONExistenteException, IDIException {
		if(Util.isID(id))
			return repositorioCliente.buscar(id);
		else
			throw new IDIException(id);
	}
	
	public List<Cliente> listarClientes() {
		return repositorioCliente.listar();
	}
	
	public List<Animal> listarAnimaisDoCliente(String id) throws ONExistenteException, IDIException {
		if(Util.isID(id))
			return buscarCliente(id).getAnimais();
		else
			throw new IDIException(id);
	}
	
	public void removerCliente(String id) throws ONExistenteException, IDIException {
		if(Util.isID(id))
			repositorioCliente.remover(id);
		else 
			throw new IDIException(id);
	}
	
	public void alterarCliente(Cliente novo, String id) throws ONExistenteException, 
		IDIException {
		if(Util.isID(id))
			repositorioCliente.atualizar(novo, id);
		else
			throw new IDIException(id);
	}
	
	private void existeObjeto(Object obj) throws OExistenteException, IllegalArgumentException {
		if(obj != null) {
			for(Cliente c : listarClientes()) {
				if(c.equals(obj))
					throw new OExistenteException(obj);
			}
		}
		else
			throw new IllegalArgumentException("Objeto nulo");
	}
}
