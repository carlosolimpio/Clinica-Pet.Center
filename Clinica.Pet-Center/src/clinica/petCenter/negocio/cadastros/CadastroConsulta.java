package clinica.petCenter.negocio.cadastros;

import java.util.ArrayList;
import java.util.List;

import clinica.petCenter.negocio.classesBasicas.Consulta;
import clinica.petCenter.negocio.exceptions.IDIException;
import clinica.petCenter.negocio.exceptions.OExistenteException;
import clinica.petCenter.negocio.exceptions.ONExistenteException;
import clinica.petCenter.utilidades.Util;
import clinica.petCenter.dados.IRepositorio;
import clinica.petCenter.dados.RepositorioConsultas;

public class CadastroConsulta {

	private IRepositorio<Consulta> repositorioConsulta;
	
	public CadastroConsulta() {
		repositorioConsulta = RepositorioConsultas.getInstancia();
	}
	
	public void cadastrarConsulta(Consulta c) throws OExistenteException, IDIException {
		if(Util.isID(c.getIdConsulta())) {
			existeObjeto(c);
			repositorioConsulta.inserir(c);
		}
		else
			throw new IDIException(c.getIdConsulta());
	}
	
	public Consulta buscarConsulta(String idConsulta) throws ONExistenteException, IDIException {
		if(Util.isID(idConsulta))
			return repositorioConsulta.buscar(idConsulta);
		else 
			throw new IDIException(idConsulta);
	}
	
	public List<Consulta> listarConsultas() {
		return repositorioConsulta.listar();
	}
	
	public List<Consulta> listarConsultasDoVeterinario(String idVet) throws IDIException {
		if(Util.isID(idVet)) {
			List<Consulta> r = new ArrayList<Consulta>();
			for(Consulta c : FachadaCadastro.getInstance().listarConsultas()) {
				if(idVet.equals(c.getVeterinario().getId()))
					r.add(c);
			}
			return r;
		} else
			throw new IDIException(idVet);
	}
	
	public void removerConsulta(String idConsulta) throws ONExistenteException, IDIException {
		if(Util.isID(idConsulta))
			repositorioConsulta.remover(idConsulta);
		else 
			throw new IDIException(idConsulta);
	}
	
	public void alterarConsulta(Consulta novaConsulta, String idConsulta) throws OExistenteException, 
		ONExistenteException, IDIException {
		if(Util.isID(idConsulta)) {
			existeObjeto(novaConsulta);
			repositorioConsulta.atualizar(novaConsulta, idConsulta);
		}
		else
			throw new IDIException(idConsulta);
	}
	
	private void existeObjeto(Object obj) throws OExistenteException, IllegalArgumentException {
		if(obj != null) {
			for(Consulta c : listarConsultas()) {
				if(c.equals(obj))
					throw new OExistenteException(obj);
			}
		}
		else
			throw new IllegalArgumentException("Objeto nulo");
	}
}