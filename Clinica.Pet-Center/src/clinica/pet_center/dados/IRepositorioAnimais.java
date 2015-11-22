package clinica.pet_center.dados;

import java.util.ArrayList;

import clinica.pet_center.negocio.basicas.Animal;
import clinica.pet_center.negocio.exceptions.ONExistenteException;

public interface IRepositorioAnimais {
	
	void inserir(Animal animal);
	Animal buscar(String id) throws ONExistenteException;
	ArrayList<Animal> listar();
	void remover(String id) throws ONExistenteException;
	void atualizar(Animal novo, String idVelho) throws ONExistenteException;
}
