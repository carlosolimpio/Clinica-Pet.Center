package clinica.pet_center.negocio.cadastros;

import java.util.List;

import clinica.pet_center.dados.IRepositorio;
import clinica.pet_center.dados.RepositorioClientes;
import clinica.pet_center.negocio.basicas.Animal;
import clinica.pet_center.negocio.basicas.Cliente;
import clinica.pet_center.negocio.exceptions.IDIException;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;
import clinica.pet_center.utilidades.Util;

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
	
	public void alterarCliente(Cliente novo, String id) throws OExistenteException, ONExistenteException, 
		IDIException {
		if(Util.isID(id)) {
			existeObjeto(novo);
			repositorioCliente.atualizar(novo, id);
		}
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
