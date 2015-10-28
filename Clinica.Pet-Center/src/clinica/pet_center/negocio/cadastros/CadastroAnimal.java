package clinica.pet_center.negocio.cadastros;

import java.util.ArrayList;

import clinica.pet_center.dados.RepositorioAnimais;
import clinica.pet_center.negocio.basicas.Animal;
import clinica.pet_center.negocio.exceptions.IDIException;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;
import clinica.pet_center.utilidades.Util;

public class CadastroAnimal {
	
	private RepositorioAnimais repositorioAnimal;
	
	public CadastroAnimal() {
		repositorioAnimal = RepositorioAnimais.getInstancia();
	}
	
	public void cadastraAnimal(Animal animal) throws OExistenteException, IDIException {
		if(Util.isID(animal.getId()))
			repositorioAnimal.insere(animal);
		else
			throw new IDIException(animal.getId());
	}
	
	public Animal buscaAnimalId(String id) throws ONExistenteException, IDIException {
		if(Util.isID(id))
			return repositorioAnimal.busca(id);
		else
			throw new IDIException(id);
	}
	
	public ArrayList<Animal> listaAnimais() {
		return repositorioAnimal.lista();
	}
	
	public void removeAnimal(String id) throws ONExistenteException, IDIException {
		if(Util.isID(id))
			repositorioAnimal.remove(id);
		else {
			IDIException iie = new IDIException(id);
			throw iie;
		}
	}
	
	public void alteraAnimal(String id, Animal novo) throws OExistenteException, ONExistenteException, IDIException {
		if(novo != null && Util.isID(id)) {
			repositorioAnimal.atualiza(novo, id);
		}
		else {
			IDIException iie = new IDIException(id);
			throw iie;
		}
	}
	
//	@Override
//	public String toString(){
//		return String.format("EXISTEM %d ANIMAIS NO SISTEMA", repositorioAnimal.lista().size());
//	}
}
