package clinica.pet_center.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import clinica.pet_center.negocio.basicas.Animal;
import clinica.pet_center.negocio.exceptions.ONExistenteException;

@SuppressWarnings("serial")
public class RepositorioAnimais implements IRepositorioAnimais, Serializable {

	private static RepositorioAnimais repositorioAnimais;
	private ArrayList<Animal> animais;
	
	private RepositorioAnimais() {
		animais = new ArrayList<Animal>();
	}
	
	public static RepositorioAnimais getInstancia() {
		if(repositorioAnimais == null)
			repositorioAnimais = //carregaDoArquivo();
		return repositorioAnimais;
	}
	
	@Override
	public void inserir(Animal animal) {
		animais.add(animal);
		salvarArquivo();
	}
	
	@Override
	public Animal buscar(String id) throws ONExistenteException {
		Animal r = null;
		for(Animal a: animais){
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
	public ArrayList<Animal> listar() {
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
	public void atualizar(Animal novo, String id) throws ONExistenteException {
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
	
	private static RepositorioAnimais carregaDoArquivo() {
		
	}
}
