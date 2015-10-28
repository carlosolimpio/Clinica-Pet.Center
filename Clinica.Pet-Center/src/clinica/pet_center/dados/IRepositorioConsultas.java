package clinica.pet_center.dados;

import java.util.ArrayList;

import clinica.pet_center.negocio.basicas.Consulta;
import clinica.pet_center.negocio.exceptions.IDIException;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;

public interface IRepositorioConsultas {
	void insere(Consulta c) throws OExistenteException;
	Consulta busca(String idConsulta) throws ONExistenteException, IDIException;
	ArrayList<Consulta> lista();
	void remove(String idConsulta) throws ONExistenteException;
}
