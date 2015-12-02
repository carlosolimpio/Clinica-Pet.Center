package clinica.pet_center.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import clinica.pet_center.negocio.basicas.Cliente;
import clinica.pet_center.negocio.exceptions.ONExistenteException;

public class RepositorioClientes implements IRepositorio<Cliente>, Serializable {

	private static RepositorioClientes repositorioClientes;
	private ArrayList<Cliente> clientes;
	private static final String NOME_ARQUIVO = "repositorioClientes.dat";
	
	private RepositorioClientes() {
		clientes = new ArrayList<Cliente>();
	}
	
	public static RepositorioClientes getInstancia() {
		if(repositorioClientes == null)
			repositorioClientes = carregaDoArquivo();
		return repositorioClientes;
	}
	
	@Override
	public void inserir(Cliente cliente) {
		clientes.add(cliente);
		salvarArquivo();
	}
	
	@Override
	public Cliente buscar(String id) throws ONExistenteException {
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
	public ArrayList<Cliente> listar() {
		return clientes;
	}
	
	@Override
	public void remover(String id) throws ONExistenteException {
		boolean r = false;
		for(int i=0; i<clientes.size(); i++) {
			if(clientes.get(i).getId().equals(id)) {
				clientes.remove(i);
				r = true;
				break;
			}
		}
		if (r)
			salvarArquivo();
		else
			throw new ONExistenteException(id);
	}
	
	@Override
	public void atualizar(Cliente novo, String id) throws ONExistenteException {
		remover(id);
		inserir(novo);
	}
	
	private void salvarArquivo() {
		File arquivo = new File(NOME_ARQUIVO);
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			fos = new FileOutputStream(arquivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(repositorioClientes);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(oos != null) {
				try {
					oos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static RepositorioClientes carregaDoArquivo() {
		File arquivo = new File(NOME_ARQUIVO);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		RepositorioClientes temp = null;

		try {
			if (arquivo.exists()) {
				fis = new FileInputStream(arquivo);
				ois = new ObjectInputStream(fis);
				temp = (RepositorioClientes) ois.readObject();
			} else { 
				temp = new RepositorioClientes();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return temp;
	}
}
