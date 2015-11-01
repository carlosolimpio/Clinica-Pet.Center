package clinica.pet_center.dados;

import java.util.ArrayList;

import clinica.pet_center.negocio.basicas.Funcionario;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;

public interface IRepositorioFuncionarios {
	
	void insere(Funcionario func) throws OExistenteException;
	Funcionario busca(String id) throws ONExistenteException;
	ArrayList<Funcionario> lista();
	void remove(String id) throws ONExistenteException;
	void atualiza(Funcionario funcionario, String id) throws OExistenteException, ONExistenteException;
}
