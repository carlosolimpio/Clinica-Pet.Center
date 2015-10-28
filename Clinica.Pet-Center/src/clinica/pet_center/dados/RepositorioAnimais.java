package clinica.pet_center.dados;

import java.util.ArrayList;

import clinica.pet_center.negocio.basicas.Animal;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;

public class RepositorioAnimais {

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
	
	public void insere(Animal animal) throws OExistenteException {
		jaExiste(animal);
		animais.add(animal);
	}
	
	public Animal busca(String id) throws ONExistenteException {
		Animal r = null;
		for(Animal a: animais){
			if(a.getId().equals(id)) {
				r = a;
				break;
			}
		}
		if(r != null)
			return r;
		else {
			ONExistenteException one = new ONExistenteException(id);
			throw one;
		}
	}
	
	public ArrayList<Animal> lista() { //fazer exce��o
		return animais;
	}
	
	public void remove(String id) throws ONExistenteException {
		boolean r = false;
		for(int i=0; i<animais.size(); i++){
			if(animais.get(i).getId().equals(id)){
				animais.remove(i);
				r = true;
				break;
			}
		}
		if(!r) {
			ONExistenteException one = new ONExistenteException(id);
			throw one;
		}	
	}
	
	public void atualiza(Animal novo, String idVelho) throws OExistenteException, ONExistenteException {
		jaExiste(novo);
		remove(idVelho);
		insere(novo);
	}
	
	private void jaExiste(Animal animal) throws OExistenteException {
		for(Animal a : animais) {
			if(a.equals(animal)) {
				OExistenteException oee = new OExistenteException(animal);
				throw oee;
			}
		}
	}
	
	//crud
	//create, read, update, delete
}
