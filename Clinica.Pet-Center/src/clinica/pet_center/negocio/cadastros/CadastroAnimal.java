package clinica.pet_center.negocio.cadastros;

import java.util.ArrayList;

import clinica.pet_center.dados.IRepositorioAnimais;
import clinica.pet_center.dados.RepositorioAnimais;
import clinica.pet_center.negocio.basicas.Animal;
import clinica.pet_center.negocio.exceptions.IDIException;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;
import clinica.pet_center.utilidades.Util;

public class CadastroAnimal {
	
	private IRepositorioAnimais repositorioAnimal;
	
	public CadastroAnimal() {
		repositorioAnimal = RepositorioAnimais.getInstancia();
	}
	
	public void cadastrarAnimal(Animal animal) throws OExistenteException, IDIException, IllegalArgumentException {
		if(Util.isID(animal.getId())) {
			existeObjeto(animal);
			repositorioAnimal.inserir(animal);
		}
		else
			throw new IDIException(animal.getId());
	}
	
	public Animal buscarAnimalId(String id) throws ONExistenteException, IDIException {
		if(Util.isID(id))
			return repositorioAnimal.buscar(id);
		else
			throw new IDIException(id);
	}
	
	public ArrayList<Animal> listarAnimais() throws IllegalArgumentException {
		return repositorioAnimal.listar();
	}
	
	public void removerAnimal(String id) throws ONExistenteException, IDIException {
		if(Util.isID(id))
			repositorioAnimal.remover(id);
		else 
			throw new IDIException(id);
	}
	
	public void alterarAnimal(String id, Animal novo) throws ONExistenteException, IDIException {
		if(Util.isID(id))
			repositorioAnimal.atualizar(novo, id);
		else
			throw new IDIException(id);
	}
	
	private void existeObjeto(Object obj) throws OExistenteException, IllegalArgumentException {
		if(obj != null) {
			for(Animal a : listarAnimais()) {
				if(a.equals(obj))
					throw new OExistenteException(obj);
			}
		}
		else
			throw new IllegalArgumentException("Objeto nulo");
	}
}