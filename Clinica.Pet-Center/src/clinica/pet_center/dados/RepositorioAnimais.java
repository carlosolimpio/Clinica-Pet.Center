package clinica.pet_center.dados;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import clinica.pet_center.negocio.basicas.Animal;
import clinica.pet_center.negocio.basicas.AnimalAux;
import clinica.pet_center.negocio.exceptions.ONExistenteException;

@SuppressWarnings("serial")
public class RepositorioAnimais implements IRepositorioAnimais, Serializable {

	private static RepositorioAnimais repositorioAnimais;
	private ArrayList<AnimalAux> animais;
	
	private RepositorioAnimais() {
		animais = new ArrayList<AnimalAux>();
	}
	
	public static RepositorioAnimais getInstancia() {
//		if(repositorioAnimais == null)
//			repositorioAnimais = //carregaDoArquivo();
		return repositorioAnimais;
	}
	
	@Override
	public void inserir(AnimalAux animal) {
		animais.add(animal);
		salvarArquivo();
	}
	
	@Override
	public AnimalAux buscar(String id) throws ONExistenteException {
		AnimalAux r = null;
		for(AnimalAux a: animais){
			if(a.getId().equals(id)) {
				r = a;
				break;
			}
		}
		if(r != null)
			return r;
		else 
			throw new ONExistenteException(id);
	}
	
	@Override
	public ArrayList<AnimalAux> listar() {
		return animais;
	}
	
	@Override
	public void remover(String id) throws ONExistenteException {
		boolean r = false;
		for(int i=0; i<animais.size(); i++){
			if(animais.get(i).getId().equals(id)){
				animais.remove(i);
				r = true;
				break;
			}
		}
		if(r)
			salvarArquivo();
		else
			throw new ONExistenteException(id);
	}
	
	@Override
	public void atualizar(AnimalAux novo, String id) throws ONExistenteException {
		remover(id);
		inserir(novo);
	}
	
	private void salvarArquivo() {
		File arquivo = new File("repositorioAnimais.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			
			fos = new FileOutputStream(arquivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(repositorioAnimais);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
//	private static RepositorioAnimais carregaDoArquivo() {
		
//	}
}
