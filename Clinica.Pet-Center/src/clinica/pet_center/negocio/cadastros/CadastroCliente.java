package clinica.pet_center.negocio.cadastros;

import java.util.ArrayList;

import clinica.pet_center.dados.RepositorioClientes;
import clinica.pet_center.negocio.basicas.Animal;
import clinica.pet_center.negocio.basicas.Cliente;

public class CadastroCliente {

	private RepositorioClientes repositorioCliente;
	
	public CadastroCliente() {
		repositorioCliente = RepositorioClientes.getInstancia();
	}
	
	public boolean cadastraCliente(Cliente cliente) {
		boolean r = false;
		if(cliente != null && repositorioCliente.insere(cliente))
			r = true;	
		return r;
	}
	
	public Cliente buscaCliente(String id) {
		Cliente r = null;
		if(checkIdCliente(id))
			r = repositorioCliente.busca(id);
		return r;
	}
	
	public ArrayList<Cliente> listaClientes() {
		return repositorioCliente.lista();
	}
	
	public ArrayList<Animal> listaAnimaisCliente(String id) {
		return buscaCliente(id).getAnimais();
	}
	
	public boolean removeCliente(String id) {
		boolean r = false;
		if(checkIdCliente(id))
			r = repositorioCliente.remove(id);
		return r;
	}
	
//	public boolean alteraCliente() {
//		
//	}
	
	public boolean checkIdCliente(String id) {
		boolean r = false;
		if(id != null && !id.equals("") && id.startsWith("CL"))
			r = true;
		return r;
	}
	
//	@Override
//	public String toString(){
//		return String.format("EXISTEM %d CLIENTES NO SISTEMA", repositorioCliente.lista().size());
//	}
}
