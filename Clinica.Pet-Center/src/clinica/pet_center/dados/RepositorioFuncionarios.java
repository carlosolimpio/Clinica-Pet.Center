package clinica.pet_center.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import clinica.pet_center.negocio.basicas.Funcionario;
import clinica.pet_center.negocio.exceptions.ONExistenteException;

public class RepositorioFuncionarios implements IRepositorio<Funcionario>, Serializable {

	private static RepositorioFuncionarios repositorioFuncionarios;
	private ArrayList<Funcionario> funcionarios;
	private static final String NOME_ARQUIVO = "repositorioFuncionarios.dat";
	
	private RepositorioFuncionarios() {
		funcionarios = new ArrayList<Funcionario>();
	}
	
	public static RepositorioFuncionarios getInstancia() {
		if(repositorioFuncionarios == null)
			repositorioFuncionarios = carregaDoArquivo();
		return repositorioFuncionarios;
	}
	
	@Override
	public void inserir(Funcionario func) {
		funcionarios.add(func);
		salvarArquivo();
	}
	
	@Override
	public Funcionario buscar(String id) throws ONExistenteException {
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
	
	@Override
	public ArrayList<Funcionario> listar() {
		return funcionarios;
	}
	
	@Override
	public void remover(String id) throws ONExistenteException {
		boolean r = false;
		for(int i=0; i<funcionarios.size(); i++) {
			if(funcionarios.get(i).getId().equals(id)) {
				funcionarios.remove(i);
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
	public void atualizar(Funcionario funcionario, String id) throws ONExistenteException {
		remover(id);
		inserir(funcionario);
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
			oos.writeObject(repositorioFuncionarios);

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

	private static RepositorioFuncionarios carregaDoArquivo() {
		File arquivo = new File(NOME_ARQUIVO);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		RepositorioFuncionarios temp = null;

		try {
			if (arquivo.exists()) {
				fis = new FileInputStream(arquivo);
				ois = new ObjectInputStream(fis);
				temp = (RepositorioFuncionarios) ois.readObject();
			} else { 
				temp = new RepositorioFuncionarios();
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
