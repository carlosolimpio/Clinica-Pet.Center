package clinica.pet_center.negocio.cadastros;

import java.util.ArrayList;

import clinica.pet_center.dados.RepositorioConsultas;
import clinica.pet_center.negocio.basicas.Consulta;
import clinica.pet_center.negocio.exceptions.IDIException;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;
import clinica.pet_center.utilidades.Util;

public class CadastroConsulta {

	private RepositorioConsultas repositorioConsulta;
	
	public CadastroConsulta() {
		repositorioConsulta = RepositorioConsultas.getInstancia();
	}
	
	public void cadastraConsulta(Consulta c) throws OExistenteException, IDIException {
		if(Util.isID(c.getIdConsulta()))
			repositorioConsulta.insere(c);
		else
			throw new IDIException(c.getIdConsulta());
	}
	
	public Consulta buscaConsulta(String idConsulta) throws ONExistenteException, IDIException {
		if(Util.isID(idConsulta))
			return repositorioConsulta.busca(idConsulta);
		else 
			throw new IDIException(idConsulta);
	}
	
	public ArrayList<Consulta> listaConsultas() {
		return repositorioConsulta.lista();
	}
	
	public void removeConsulta(String idConsulta) throws ONExistenteException, IDIException {
		if(Util.isID(idConsulta))
			repositorioConsulta.remove(idConsulta);
		else 
			throw new IDIException(idConsulta);
	}
	
//	//será uma consulta se todos parametros de consulta forem != null
//	private boolean isConsulta(Consulta c) {
//		boolean r = false;
//		if(c != null)
//			r = c.getCliente() != null && c.getAnimal() != null && c.getVeterinario() != null 
//				&& c.getDiagnostico() != null && c.getMotivoVisita() != null && c.getReceita() != null
//				&& c.getData() != null && c.getIdConsulta() != null;
//		return r;
//	}
	
//	@Override
//	public String toString(){
//		return String.format("EXISTEM %d CONSULTAS NO SISTEMA",  repositorioConsulta.lista().size());
//	}
}