package clinica.pet_center.negocio.cadastros;

import java.util.ArrayList;

import clinica.pet_center.dados.IRepositorioClientes;
import clinica.pet_center.dados.RepositorioClientes;
import clinica.pet_center.negocio.basicas.Animal;
import clinica.pet_center.negocio.basicas.Cliente;
import clinica.pet_center.negocio.exceptions.IDIException;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;
import clinica.pet_center.utilidades.Constantes;
import clinica.pet_center.utilidades.Util;

public class CadastroCliente {

	private IRepositorioClientes repositorioCliente;
	
	
	public CadastroCliente() {
		repositorioCliente = RepositorioClientes.getInstancia();
	}
	
	public void cadastraCliente(Cliente cliente) throws OExistenteException, IDIException {
		if(Util.isID(cliente.getId()))
			repositorioCliente.insere(cliente);
		else
			throw new IDIException(cliente.getId());
	}
	
	public Cliente buscaCliente(String id) throws ONExistenteException, IDIException {
		if(Util.isID(id))
			return repositorioCliente.busca(id);
		else
			throw new IDIException(id);
	}
	
	public ArrayList<Cliente> listaClientes() throws ONExistenteException {
		ArrayList<Cliente> listaCliente = repositorioCliente.lista();
		if(listaCliente == null)
		{
			throw new ONExistenteException(Constantes.USUARIO);
		}
		return listaCliente;
		
		
	}
	
	public ArrayList<Animal> listaAnimaisCliente(String id) throws ONExistenteException, IDIException {
		return buscaCliente(id).getAnimais();
	}
	
	public void removeCliente(String id) throws ONExistenteException, IDIException {
		if(Util.isID(id))
			repositorioCliente.remove(id);
		else 
			throw new IDIException(id);
	}
	
	public void alteraCliente(Cliente novo, String id) throws OExistenteException, ONExistenteException, IDIException {
		if(novo != null && Util.isID(id))
			repositorioCliente.atualiza(novo, id);
		else
			throw new IDIException(id);
	}
	
//	@Override
//	public String toString(){
//		return String.format("EXISTEM %d CLIENTES NO SISTEMA", repositorioCliente.lista().size());
//	}
}
