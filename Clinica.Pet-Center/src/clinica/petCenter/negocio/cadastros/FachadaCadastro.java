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

public class FachadaCadastro implements IFachadaCadastro {
	private static FachadaCadastro instance;
	private CadastroAnimal cadAnimal;
	private CadastroCliente cadCliente;
	private CadastroConsulta cadConsulta;
	private CadastroFuncionario cadFuncionario;
	
	private FachadaCadastro() {
		cadAnimal = new CadastroAnimal();
		cadCliente = new CadastroCliente();
		cadConsulta = new CadastroConsulta();
		cadFuncionario = new CadastroFuncionario();
	}
	
	public static FachadaCadastro getInstance() {
    	if (instance == null) {
			instance = new FachadaCadastro();
		}
    	return instance;
    }
	
	public Funcionario verificaLogin(String login, String senha) throws ONExistenteException, IDIException, 
		SenhaInvalidaException {
		Funcionario r = cadFuncionario.buscarFuncionario(login);
		if(senha.equals(r.getSenha()))
			return r;
		else
			throw new SenhaInvalidaException("Senha inválida login:" + login);
	}

	//animal
	@Override
	public void cadastrarAnimal(Animal animal) throws OExistenteException, IDIException, 
		IllegalArgumentException {
		cadAnimal.cadastrarAnimal(animal);
	}

	@Override
	public Animal buscarAnimalId(String id) throws ONExistenteException, IDIException {
		return cadAnimal.buscarAnimalId(id);
	}

	@Override
	public List<Animal> listarAnimais() {
		return cadAnimal.listarAnimais();
	}

	@Override
	public void removerAnimal(String id) throws ONExistenteException, IDIException {
		cadAnimal.removerAnimal(id);
	}

	@Override
	public void alterarAnimal(String id, Animal novo) throws ONExistenteException, IDIException, 
		OExistenteException {
		cadAnimal.alterarAnimal(id, novo);
	}

	//cliente
	@Override
	public void cadastrarCliente(Cliente cliente) throws OExistenteException, IDIException, 
		IllegalArgumentException {
		cadCliente.cadastrarCliente(cliente);
	}

	@Override
	public Cliente buscarCliente(String id) throws ONExistenteException, IDIException {
		return cadCliente.buscarCliente(id);
	}

	@Override
	public List<Cliente> listarClientes() {
		return cadCliente.listarClientes();
	}

	@Override
	public List<Animal> listarAnimaisDoCliente(String id) throws ONExistenteException, IDIException {
		return cadCliente.listarAnimaisDoCliente(id);
	}

	@Override
	public void removerCliente(String id) throws ONExistenteException, IDIException {
		cadCliente.removerCliente(id);
	}
	
	@Override
	public void alterarCliente(Cliente novo, String id) throws OExistenteException, ONExistenteException, 
		IDIException {
		cadCliente.alterarCliente(novo, id);
	}

	//consulta
	@Override
	public void cadastrarConsulta(Consulta c) throws OExistenteException, IDIException {
		cadConsulta.cadastrarConsulta(c);
	}

	@Override
	public Consulta buscarConsulta(String idConsulta) throws ONExistenteException, IDIException {
		return cadConsulta.buscarConsulta(idConsulta);
	}

	@Override
	public List<Consulta> listarConsultas() {
		return cadConsulta.listarConsultas();
	}

	@Override
	public void removerConsulta(String idConsulta) throws ONExistenteException, IDIException {
		cadConsulta.removerConsulta(idConsulta);
	}
	
	@Override
	public void alterarConsulta(Consulta novaConsulta, String idConsulta) throws OExistenteException, 
		ONExistenteException, IDIException {
		cadConsulta.alterarConsulta(novaConsulta, idConsulta);
	}

	//funcionario
	@Override
	public void cadastrarFuncionario(Funcionario func) throws OExistenteException {
		cadFuncionario.cadastrarFuncionario(func);
	}

	@Override
	public Funcionario buscarFuncionario(String id) throws ONExistenteException, IDIException {
		return cadFuncionario.buscarFuncionario(id);
	}

	@Override
	public List<Funcionario> listarFuncionarios() {
		return cadFuncionario.listarFuncionarios();
	}

	@Override
	public List<Veterinario> listarVeterinarios() {
		return cadFuncionario.listarVeterinarios();
	}

	@Override
	public List<OperadorSistema> listarOperadoresSistema() {
		return cadFuncionario.listarOperadoresSistema();
	}

	@Override
	public void removerFuncionario(String id) throws ONExistenteException, IDIException {
		cadFuncionario.removerFuncionario(id);
	}
	
	@Override
	public void alterarFuncionario(Funcionario novo, String id) throws OExistenteException, ONExistenteException, 
		IDIException {
		cadFuncionario.alterarFuncionario(novo, id);
	}
}
