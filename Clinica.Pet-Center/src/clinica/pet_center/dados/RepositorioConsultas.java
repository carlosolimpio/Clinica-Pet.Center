package clinica.pet_center.dados;

import java.util.ArrayList;

import clinica.pet_center.negocio.basicas.Consulta;
import clinica.pet_center.negocio.exceptions.IDIException;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;

public class RepositorioConsultas implements IRepositorioConsultas{

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
	
	@Override
	public void insere(Consulta c) throws OExistenteException {
		jaExiste(c);
		consultas.add(c);
	}
	
	@Override
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
		else 
			throw new ONExistenteException(idConsulta);
	}
	
	@Override
	public ArrayList<Consulta> lista() {
		return consultas;
	}
	
	@Override
	public void remove(String idConsulta) throws ONExistenteException {
		boolean r = false;
		for(int i=0; i<consultas.size(); i++) {
			if(consultas.get(i).getIdConsulta().equals(idConsulta)) {
				consultas.remove(i);
				r = true;
				break;
			}
		}
		if(!r) 
			throw new ONExistenteException(idConsulta);
	}
	
	@Override
	public void atualiza(Consulta novaConsulta, String idConsulta) throws OExistenteException, ONExistenteException {
		jaExiste(novaConsulta);
		remove(idConsulta);
		insere(novaConsulta);
	}
	
	private void jaExiste(Consulta c) throws OExistenteException {
		for(Consulta r : consultas) {
			if(r.equals(c))
				throw new OExistenteException(c);
		}
	}
}
