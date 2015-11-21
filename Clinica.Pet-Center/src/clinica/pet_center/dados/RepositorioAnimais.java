package clinica.pet_center.dados;

import java.util.ArrayList;

import clinica.pet_center.negocio.basicas.Animal;
import clinica.pet_center.negocio.exceptions.ONExistenteException;

public class RepositorioAnimais implements IRepositorioAnimais {

	private static RepositorioAnimais repositorioAnimais;
	private ArrayList<Animal> animais;
	
	private RepositorioAnimais() {
		animais = new ArrayList<Animal>();
	}
	
	public static RepositorioAnimais getInstancia() {
		if(repositorioAnimais == null)
			repositorioAnimais = new RepositorioAnimais();
		return repositorioAnimais;
	}
	
	@Override
	public void inserir(Animal animal) {
		animais.add(animal);
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
	public ArrayList<Animal> listar() throws IllegalArgumentException {
		if(!animais.isEmpty())
			return animais;
		else
			throw new IllegalArgumentException("Repositório vazio.");
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
		if(!r) 
			throw new ONExistenteException(id);
	}
	
	@Override
	public void atualizar(Animal novo, String id) throws ONExistenteException {
		remover(id);
		inserir(novo);
	}
}
