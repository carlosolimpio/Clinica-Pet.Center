package clinica.pet_center.dados;

import java.util.ArrayList;

import clinica.pet_center.negocio.basicas.Animal;
import clinica.pet_center.negocio.basicas.AnimalAux;
import clinica.pet_center.negocio.exceptions.ONExistenteException;

public interface IRepositorioAnimais {
	
	void inserir(AnimalAux animal);
	AnimalAux buscar(String id) throws ONExistenteException;
	ArrayList<AnimalAux> listar();
	void remover(String id) throws ONExistenteException;
	void atualizar(AnimalAux novo, String idVelho) throws ONExistenteException;
}
