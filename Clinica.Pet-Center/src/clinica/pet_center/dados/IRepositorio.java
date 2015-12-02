package clinica.pet_center.dados;

import java.util.List;

import clinica.pet_center.negocio.exceptions.ONExistenteException;

public interface IRepositorio<T> {

	void inserir(T tipo);
	T buscar(String id) throws ONExistenteException;
	List<T> listar();
	void remover(String id) throws ONExistenteException;
	void atualizar(T tipo, String idVelho) throws ONExistenteException;
	
}
