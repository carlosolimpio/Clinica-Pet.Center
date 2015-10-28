package clinica.pet_center.dados;

import java.util.ArrayList;

import clinica.pet_center.negocio.basicas.Animal;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;

public interface IRepositorioAnimais {
	void insere(Animal animal) throws OExistenteException;
	Animal busca(String id) throws ONExistenteException;
	ArrayList<Animal> lista();
	void remove(String id) throws ONExistenteException;
	void atualiza(Animal novo, String idVelho) throws OExistenteException, ONExistenteException;
	
}
