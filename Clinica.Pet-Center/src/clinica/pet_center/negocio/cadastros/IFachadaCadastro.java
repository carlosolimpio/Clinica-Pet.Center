package clinica.pet_center.negocio.cadastros;

import java.util.List;

import clinica.pet_center.negocio.basicas.Animal;
import clinica.pet_center.negocio.basicas.Cliente;
import clinica.pet_center.negocio.basicas.Consulta;
import clinica.pet_center.negocio.basicas.Funcionario;
import clinica.pet_center.negocio.basicas.OperadorSistema;
import clinica.pet_center.negocio.basicas.Veterinario;
import clinica.pet_center.negocio.exceptions.IDIException;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;
import clinica.pet_center.negocio.exceptions.SenhaInvalidaException;

public interface IFachadaCadastro {
	
	Funcionario verificaLogin(String login, String senha) throws ONExistenteException, IDIException, 
	SenhaInvalidaException;
	
	//Animal
	void cadastrarAnimal(Animal animal) throws OExistenteException, IDIException, 
		IllegalArgumentException;
	Animal buscarAnimalId(String id) throws ONExistenteException, IDIException;
	List<Animal> listarAnimais();
	void removerAnimal(String id) throws ONExistenteException, IDIException;
	void alterarAnimal(String id, Animal novo) throws ONExistenteException, IDIException, 
		OExistenteException;
	
	//Cliente
	void cadastrarCliente(Cliente cliente) throws OExistenteException, IDIException, 
		IllegalArgumentException;
	Cliente buscarCliente(String id) throws ONExistenteException, IDIException;
	List<Cliente> listarClientes();
	List<Animal> listarAnimaisDoCliente(String id) throws ONExistenteException, IDIException;
	void removerCliente(String id) throws ONExistenteException, IDIException;
	void alterarCliente(Cliente novo, String id) throws OExistenteException, ONExistenteException, 
		IDIException;
	
	//Consulta
	void cadastrarConsulta(Consulta c) throws OExistenteException, IDIException;
	Consulta buscarConsulta(String idConsulta) throws ONExistenteException, IDIException;
	List<Consulta> listarConsultas();
	void removerConsulta(String idConsulta) throws ONExistenteException, IDIException;
	void alterarConsulta(Consulta novaConsulta, String idConsulta) throws OExistenteException, 
		ONExistenteException, IDIException; 
	
	//Funcionario
	void cadastrarFuncionario(Funcionario func) throws OExistenteException, IDIException;
	Funcionario buscarFuncionario(String id) throws ONExistenteException, IDIException;
	List<Funcionario> listarFuncionarios();
	List<Veterinario> listarVeterinarios();
	List<OperadorSistema> listarOperadoresSistema();
	void alterarFuncionario(Funcionario novo, String id) throws OExistenteException, ONExistenteException, 
		IDIException;
	void removerFuncionario(String id) throws ONExistenteException, IDIException;
}
