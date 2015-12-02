package clinica.pet_center.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import clinica.pet_center.negocio.basicas.Consulta;
import clinica.pet_center.negocio.exceptions.ONExistenteException;

public class RepositorioConsultas implements IRepositorio<Consulta>, Serializable {

	private static RepositorioConsultas repositorioConsultas;
	private ArrayList<Consulta> consultas;
	private static final String NOME_ARQUIVO = "repositorioConsultas.dat";
	
	private RepositorioConsultas() {
		consultas = new ArrayList<Consulta>();
	}
	
	public static RepositorioConsultas getInstancia() {
		if(repositorioConsultas == null)
			repositorioConsultas = carregaDoArquivo();
		return repositorioConsultas;
	}
	
	@Override
	public void inserir(Consulta consulta) {
		consultas.add(consulta);
		salvarArquivo();
	}
	
	@Override
	public Consulta buscar(String idConsulta) throws ONExistenteException {
		Consulta r = null;
		for(Consulta c : consultas) {
			if(c.getIdConsulta().equals(idConsulta)) {
				r = c;
				break;
			}
		}
		if(r != null) 
			return r;
		else 
			throw new ONExistenteException(idConsulta);
	}
	
	@Override
	public ArrayList<Consulta> listar() {
		return consultas;
	}
	
	@Override
	public void remover(String idConsulta) throws ONExistenteException {
		boolean r = false;
		for(int i=0; i<consultas.size(); i++) {
			if(consultas.get(i).getIdConsulta().equals(idConsulta)) {
				consultas.remove(i);
				r = true;
				break;
			}
		}
		if (r)
			salvarArquivo();
		else
			throw new ONExistenteException(idConsulta);
	}
	
	@Override
	public void atualizar(Consulta novaConsulta, String idConsulta) throws ONExistenteException {
		remover(idConsulta);
		inserir(novaConsulta);
	}
	
	public void salvarArquivo() {
		File arquivo = new File(NOME_ARQUIVO);
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			fos = new FileOutputStream(arquivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(repositorioConsultas);

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

	private static RepositorioConsultas carregaDoArquivo() {
		File arquivo = new File(NOME_ARQUIVO);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		RepositorioConsultas temp = null;

		try {
			if (arquivo.exists()) {
				fis = new FileInputStream(arquivo);
				ois = new ObjectInputStream(fis);
				temp = (RepositorioConsultas) ois.readObject();
			} else { 
				temp = new RepositorioConsultas();
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
