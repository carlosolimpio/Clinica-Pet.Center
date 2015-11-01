package clinica.pet_center.negocio.cadastros;

import java.util.ArrayList;

import clinica.pet_center.negocio.basicas.Animal;
import clinica.pet_center.negocio.basicas.Cliente;
import clinica.pet_center.negocio.basicas.Consulta;
import clinica.pet_center.negocio.basicas.Funcionario;
import clinica.pet_center.negocio.basicas.OperadorSistema;
import clinica.pet_center.negocio.basicas.Veterinario;
import clinica.pet_center.negocio.exceptions.IDIException;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;

public class FachadaCadastro implements IFachadaCadastro {

	private CadastroAnimal cadAnimal;
	private CadastroCliente cadCliente;
	private CadastroConsulta cadConsulta;
	private CadastroFuncionario cadFuncionario;
	
	/**
	 * NÃO ESTÁ FINALIZADA
	 */
	
	public FachadaCadastro() {
		cadAnimal = new CadastroAnimal();
		cadCliente = new CadastroCliente();
		cadConsulta = new CadastroConsulta();
		cadFuncionario = new CadastroFuncionario();
	}

	//animal
	@Override
	public void cadastraAnimal(Animal animal) throws OExistenteException, IDIException {
		cadAnimal.cadastraAnimal(animal);
	}

	@Override
	public Animal buscaAnimalId(String id) throws ONExistenteException, IDIException {
		return cadAnimal.buscaAnimalId(id);
	}

	@Override
	public ArrayList<Animal> listaAnimais() {
		return cadAnimal.listaAnimais();
	}

	@Override
	public void removeAnimal(String id) throws ONExistenteException, IDIException {
		cadAnimal.removeAnimal(id);
	}

	@Override
	public void alteraAnimal(String id, Animal novo) throws OExistenteException, ONExistenteException, IDIException {
		cadAnimal.alteraAnimal(id, novo);
	}

	//cliente
	@Override
	public void cadastraCliente(Cliente cliente) throws OExistenteException, IDIException {
		cadCliente.cadastraCliente(cliente);
	}

	@Override
	public Cliente buscaCliente(String id) throws ONExistenteException, IDIException {
		return cadCliente.buscaCliente(id);
	}

	@Override
	public ArrayList<Cliente> listaClientes() {
		return cadCliente.listaClientes();
	}

	@Override
	public ArrayList<Animal> listaAnimaisCliente(String id) throws ONExistenteException, IDIException {
		return cadCliente.listaAnimaisCliente(id);
	}

	@Override
	public void removeCliente(String id) throws ONExistenteException, IDIException {
		cadCliente.removeCliente(id);
	}
	
	@Override
	public void alteraCliente(Cliente novo, String id) throws OExistenteException, ONExistenteException, IDIException {
		cadCliente.alteraCliente(novo, id);
	}

	//consulta
	@Override
	public void cadastraConsulta(Consulta c) throws OExistenteException, IDIException {
		cadConsulta.cadastraConsulta(c);
	}

	@Override
	public Consulta buscaConsulta(String idConsulta) throws ONExistenteException, IDIException {
		return cadConsulta.buscaConsulta(idConsulta);
	}

	@Override
	public ArrayList<Consulta> listaConsultas() {
		return cadConsulta.listaConsultas();
	}

	@Override
	public void removeConsulta(String idConsulta) throws ONExistenteException, IDIException {
		cadConsulta.removeConsulta(idConsulta);
	}
	
	@Override
	public void alteraConsulta(Consulta novaConsulta, String idConsulta) throws OExistenteException, ONExistenteException, IDIException {
		cadConsulta.alteraConsulta(novaConsulta, idConsulta);
	}

	//funcionario
	@Override
	public void cadastraFuncionario(Funcionario func) throws OExistenteException, IDIException {
		cadFuncionario.cadastraFuncionario(func);
	}

	@Override
	public Funcionario buscaFuncionario(String id) throws ONExistenteException, IDIException {
		return cadFuncionario.buscaFuncionario(id);
	}

	@Override
	public ArrayList<Funcionario> listaFuncionarios() {
		return cadFuncionario.listaFuncionarios();
	}

	@Override
	public ArrayList<Veterinario> listaVeterinarios() {
		return cadFuncionario.listaVeterinarios();
	}

	@Override
	public ArrayList<OperadorSistema> listaOperadoresSistema() {
		return cadFuncionario.listaOperadoresSistema();
	}

	@Override
	public void removeFuncionario(String id) throws ONExistenteException, IDIException {
		cadFuncionario.removeFuncionario(id);
	}
	
	@Override
	public void alteraFuncionario(Funcionario novo, String id) throws OExistenteException, ONExistenteException, IDIException {
		cadFuncionario.alteraFuncionario(novo, id);
	}
}
