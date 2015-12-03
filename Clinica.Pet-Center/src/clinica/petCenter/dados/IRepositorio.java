package clinica.petCenter.dados;

import java.util.List;

import clinica.petCenter.negocio.exceptions.ONExistenteException;

public interface IRepositorio<T> {

	void inserir(T tipo);
	T buscar(String id) throws ONExistenteException;
	List<T> listar();
	void remover(String id) throws ONExistenteException;
	void atualizar(T tipo, String idVelho) throws ONExistenteException;
	
}
