package clinica.pet_center.dados;

import java.util.ArrayList;

import clinica.pet_center.negocio.basicas.Consulta;
import clinica.pet_center.negocio.exceptions.IDIException;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;

public class RepositorioConsultas {

	private static RepositorioConsultas repositorioConsultas;
	private ArrayList<Consulta> consultas;
	
	private RepositorioConsultas() {
		consultas = new ArrayList<Consulta>();
	}
	
	public static RepositorioConsultas getInstancia() {
		if(repositorioConsultas == null)
			repositorioConsultas = new RepositorioConsultas();
		return repositorioConsultas;
	}
	
	public void insere(Consulta c) throws OExistenteException {
		jaExiste(c);
		consultas.add(c);
	}
	
	public Consulta busca(String idConsulta) throws ONExistenteException, IDIException {
		Consulta r = null;
		for(Consulta c : consultas) {
			if(c.getIdConsulta().equals(idConsulta)) {
				r = c;
				break;
			}
		}
		if(r != null) 
			return r;
		else {
			ONExistenteException one = new ONExistenteException(idConsulta);
			throw one;
		}
	}
	
	public ArrayList<Consulta> lista() {
		return consultas;
	}
	
	public void remove(String idConsulta) throws ONExistenteException {
		boolean r = false;
		for(int i=0; i<consultas.size(); i++) {
			if(consultas.get(i).getIdConsulta().equals(idConsulta)) {
				consultas.remove(i);
				r = true;
				break;
			}
		}
		if(!r) {
			ONExistenteException one = new ONExistenteException(idConsulta);
			throw one;
		}
	}
	
	private void jaExiste(Consulta c) throws OExistenteException {
		for(Consulta r : consultas) {
			if(r.equals(c)) {
				OExistenteException oee = new OExistenteException(c);
				throw oee;
			}
		}
	}
}
