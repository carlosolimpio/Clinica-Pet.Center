package clinica.pet_center.negocio.cadastros;

import java.util.ArrayList;

import clinica.pet_center.dados.RepositorioClientes;
import clinica.pet_center.negocio.basicas.Animal;
import clinica.pet_center.negocio.basicas.Cliente;
import clinica.pet_center.negocio.exceptions.IDIException;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;
import clinica.pet_center.utilidades.Util;

public class CadastroCliente {

	private RepositorioClientes repositorioCliente;
	
	public CadastroCliente() {
		repositorioCliente = RepositorioClientes.getInstancia();
	}
	
	public void cadastraCliente(Cliente cliente) throws OExistenteException, IDIException {
		if(Util.isID(cliente.getId())) {
			repositorioCliente.insere(cliente);
		} else {
			IDIException iie = new IDIException(cliente.getId());
			throw iie;
		}
	}
	
	public Cliente buscaCliente(String id) throws ONExistenteException, IDIException {
		if(Util.isID(id)) {
			return repositorioCliente.busca(id);
		} else {
			IDIException iie = new IDIException(id);
			throw iie;
		}
	}
	
	public ArrayList<Cliente> listaClientes() {
		return repositorioCliente.lista();
	}
	
	public ArrayList<Animal> listaAnimaisCliente(String id) throws ONExistenteException, IDIException {
		return buscaCliente(id).getAnimais();
	}
	
	public void removeCliente(String id) throws ONExistenteException, IDIException {
		if(Util.isID(id)) {
			repositorioCliente.remove(id);
		} else {
			IDIException iie = new IDIException(id);
			throw iie;
		}
	}
	
//	public boolean alteraCliente() {
//		
//	}
	
//	@Override
//	public String toString(){
//		return String.format("EXISTEM %d CLIENTES NO SISTEMA", repositorioCliente.lista().size());
//	}
}
