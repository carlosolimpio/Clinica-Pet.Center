package clinica.pet_center.negocio.cadastros;

import java.util.ArrayList;
import java.util.List;

import clinica.pet_center.dados.IRepositorio;
import clinica.pet_center.dados.RepositorioFuncionarios;
import clinica.pet_center.negocio.basicas.Funcionario;
import clinica.pet_center.negocio.basicas.OperadorSistema;
import clinica.pet_center.negocio.basicas.Veterinario;
import clinica.pet_center.negocio.exceptions.IDIException;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;
import clinica.pet_center.utilidades.Util;

public class CadastroFuncionario {

	private IRepositorio<Funcionario> repositorioFuncionario;
	
	public CadastroFuncionario() {
		repositorioFuncionario = RepositorioFuncionarios.getInstancia();
	}
	
	public void cadastrarFuncionario(Funcionario func) throws OExistenteException {
		existeObjeto(func);
		repositorioFuncionario.inserir(func);
	}
	
	public Funcionario buscarFuncionario(String id) throws ONExistenteException, IDIException {
		if(Util.isID(id))
			return repositorioFuncionario.buscar(id);
		else
			throw new IDIException(id);
	}
	
	public List<Funcionario> listarFuncionarios() {
		return repositorioFuncionario.listar();
	}
	
	public List<Veterinario> listarVeterinarios() {	
		List<Veterinario> r = new ArrayList<Veterinario>();
		for(Funcionario f : listarFuncionarios()) {
			if(f instanceof Veterinario)
				r.add((Veterinario) f);
		}
		return r;
	}
	
	public List<OperadorSistema> listarOperadoresSistema() {
		List<OperadorSistema> r = new ArrayList<OperadorSistema>();
		for(Funcionario f : listarFuncionarios()) {
			if(f instanceof OperadorSistema)
				r.add((OperadorSistema) f);
		}
		return r;
	}
	
	public void alterarFuncionario(Funcionario novo, String id) throws OExistenteException, ONExistenteException, 
		IDIException {
		if(Util.isID(id)) {
			existeObjeto(novo);
			repositorioFuncionario.atualizar(novo, id);
		}
		else
			throw new IDIException(id);
	}
	
	public void removerFuncionario(String id) throws ONExistenteException, IDIException {
		if(Util.isID(id))
			repositorioFuncionario.remover(id);
		else
			throw new IDIException(id);
	}

	private void existeObjeto(Object obj) throws OExistenteException, IllegalArgumentException {
		if(obj != null) {
			for(Funcionario f : listarFuncionarios()) {
				if(f.equals(obj))
					throw new OExistenteException(obj);
			}
		}
		else
			throw new IllegalArgumentException("Objeto nulo");
	}
}
