package clinica.pet_center.negocio.cadastros;

import java.util.ArrayList;

import clinica.pet_center.dados.IRepositorioFuncionarios;
import clinica.pet_center.dados.RepositorioFuncionarios;
import clinica.pet_center.negocio.basicas.Funcionario;
import clinica.pet_center.negocio.basicas.OperadorSistema;
import clinica.pet_center.negocio.basicas.Veterinario;
import clinica.pet_center.negocio.exceptions.IDIException;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;
import clinica.pet_center.utilidades.Constantes;
import clinica.pet_center.utilidades.Util;

public class CadastroFuncionario {

	private IRepositorioFuncionarios repositorioFuncionario;
	
	public CadastroFuncionario() {
		repositorioFuncionario = RepositorioFuncionarios.getInstancia();
	}
	
	public void cadastraFuncionario(Funcionario func) throws OExistenteException, IDIException {
		if(Util.isID(func.getId()))
			repositorioFuncionario.insere(func);
		else 
			throw new IDIException(func.getId());
	}
	
	public Funcionario buscaFuncionario(String id) throws ONExistenteException, IDIException {
		if(Util.isID(id))
			return repositorioFuncionario.busca(id);
		else
			throw new IDIException(id);
	}
	
	public ArrayList<Funcionario> listaFuncionarios() throws ONExistenteException 
	{
		ArrayList<Funcionario> listaFunc = repositorioFuncionario.lista();
		if(listaFunc == null)
		{
			throw new ONExistenteException(Constantes.FUNCIONARIO);
		}
		return listaFunc;
	}
	
	@SuppressWarnings("unused")
	public ArrayList<Veterinario> listaVeterinarios() throws ONExistenteException
	{
		ArrayList<Veterinario> r = new ArrayList<Veterinario>();
		for(Funcionario f : repositorioFuncionario.lista()) {
			if(f instanceof Veterinario)
				r.add(((Veterinario) f));
		}
		if (r == null){
			throw new ONExistenteException(Constantes.VETERINARIO);
		}
		return r;
	}
	
	@SuppressWarnings("unused")
	public ArrayList<OperadorSistema> listaOperadoresSistema() throws ONExistenteException 
	{
		ArrayList<OperadorSistema> r = new ArrayList<OperadorSistema>();
		for(Funcionario f : repositorioFuncionario.lista()) {
			if(f instanceof OperadorSistema)
				r.add(((OperadorSistema) f));
		}
		if (r == null){
			throw new ONExistenteException(Constantes.OPSISTEMA);
		}
		return r;
	}
	
	public void alteraFuncionario(Funcionario novo, String id) throws OExistenteException, ONExistenteException, IDIException {
		if(novo != null && Util.isID(id))
			repositorioFuncionario.atualiza(novo, id);
		else
			throw new IDIException(id);
	}
	
	public void removeFuncionario(String id) throws ONExistenteException, IDIException {
		if(Util.isID(id))
			repositorioFuncionario.remove(id);
		else
			throw new IDIException(id);
	}
	
//	@Override
//	public String toString(){
//		return String.format("EXISTEM %d FUNCIONÁRIOS NO SISTEMA",  repositorioFuncionario.lista().size());
//	}
}
