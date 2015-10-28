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
	public void cadastraAnimal(Animal animal) throws OExistenteException, IDIException {
		cadAnimal.cadastraAnimal(animal);
	}

	public Animal buscaAnimalId(String id) throws ONExistenteException, IDIException {
		return cadAnimal.buscaAnimalId(id);
	}

	public ArrayList<Animal> listaAnimais() {
		return cadAnimal.listaAnimais();
	}

	public void removeAnimal(String id) throws ONExistenteException, IDIException {
		cadAnimal.removeAnimal(id);
	}

	public void alteraAnimal(String id, Animal novo) throws OExistenteException, ONExistenteException, IDIException {
		cadAnimal.alteraAnimal(id, novo);
	}

	//cliente
	public void cadastraCliente(Cliente cliente) throws OExistenteException, IDIException {
		cadCliente.cadastraCliente(cliente);
	}

	public Cliente buscaCliente(String id) throws ONExistenteException, IDIException {
		return cadCliente.buscaCliente(id);
	}

	public ArrayList<Cliente> listaClientes() {
		return cadCliente.listaClientes();
	}

	public ArrayList<Animal> listaAnimaisCliente(String id) throws ONExistenteException, IDIException {
		return cadCliente.listaAnimaisCliente(id);
	}

	public void removeCliente(String id) throws ONExistenteException, IDIException {
		cadCliente.removeCliente(id);
	}

	//consulta
	public void cadastraConsulta(Consulta c) throws OExistenteException, IDIException {
		cadConsulta.cadastraConsulta(c);
	}

	public Consulta buscaConsulta(String idConsulta) throws ONExistenteException, IDIException {
		return cadConsulta.buscaConsulta(idConsulta);
	}

	public ArrayList<Consulta> listaConsultas() {
		return cadConsulta.listaConsultas();
	}

	public void removeConsulta(String idConsulta) throws ONExistenteException, IDIException {
		cadConsulta.removeConsulta(idConsulta);
	}

	//funcionario
	public void cadastraFuncionario(Funcionario func) throws OExistenteException, IDIException {
		cadFuncionario.cadastraFuncionario(func);
	}

	public Funcionario buscaFuncionario(String id) throws ONExistenteException, IDIException {
		return cadFuncionario.buscaFuncionario(id);
	}

	public ArrayList<Funcionario> listaFuncionarios() {
		return cadFuncionario.listaFuncionarios();
	}

	public ArrayList<Veterinario> listaVeterinarios() {
		return cadFuncionario.listaVeterinarios();
	}

	public ArrayList<OperadorSistema> listaOperadoresSistema() {
		return cadFuncionario.listaOperadoresSistema();
	}

	public void removeFuncionario(String id) throws ONExistenteException, IDIException {
		cadFuncionario.removeFuncionario(id);
	}
}
