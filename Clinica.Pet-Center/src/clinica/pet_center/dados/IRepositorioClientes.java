package clinica.pet_center.dados;

import java.util.ArrayList;

import clinica.pet_center.negocio.basicas.Cliente;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;

public interface IRepositorioClientes {
	
	void insere(Cliente cliente) throws OExistenteException;
	Cliente busca(String id) throws ONExistenteException;
	ArrayList<Cliente> lista();
	void remove(String id) throws ONExistenteException;
	void atualiza(Cliente novo, String id) throws OExistenteException, ONExistenteException;
}
