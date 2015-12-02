package clinica.pet_center.negocio.cadastros;

import java.util.List;

import clinica.pet_center.dados.IRepositorio;
import clinica.pet_center.dados.RepositorioConsultas;
import clinica.pet_center.negocio.basicas.Consulta;
import clinica.pet_center.negocio.exceptions.IDIException;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;
import clinica.pet_center.utilidades.Util;

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