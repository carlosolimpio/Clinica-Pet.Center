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

public interface IFachadaCadastro {
	
	//Animal
	void cadastraAnimal(Animal animal) throws OExistenteException, IDIException;
	Animal buscaAnimalId(String id) throws ONExistenteException, IDIException;
	ArrayList<Animal> listaAnimais() throws ONExistenteException;
	void removeAnimal(String id) throws ONExistenteException, IDIException;
	void alteraAnimal(String id, Animal novo) throws OExistenteException, ONExistenteException, IDIException;
	
	//Cliente
	void cadastraCliente(Cliente cliente) throws OExistenteException, IDIException;
	Cliente buscaCliente(String id) throws ONExistenteException, IDIException;
	ArrayList<Cliente> listaClientes() throws ONExistenteException;
	ArrayList<Animal> listaAnimaisCliente(String id) throws ONExistenteException, IDIException;
	void removeCliente(String id) throws ONExistenteException, IDIException;
	void alteraCliente(Cliente novo, String id) throws OExistenteException, ONExistenteException, IDIException;
	
	//Consulta
	void cadastraConsulta(Consulta c) throws OExistenteException, IDIException;
	Consulta buscaConsulta(String idConsulta) throws ONExistenteException, IDIException;
	ArrayList<Consulta> listaConsultas() throws ONExistenteException;
	void removeConsulta(String idConsulta) throws ONExistenteException, IDIException;
	void alteraConsulta(Consulta novaConsulta, String idConsulta) throws OExistenteException, ONExistenteException, IDIException; 
	
	//Funcionario
	void cadastraFuncionario(Funcionario func) throws OExistenteException, IDIException;
	Funcionario buscaFuncionario(String id) throws ONExistenteException, IDIException;
	ArrayList<Funcionario> listaFuncionarios() throws ONExistenteException;
	ArrayList<Veterinario> listaVeterinarios() throws ONExistenteException;
	ArrayList<OperadorSistema> listaOperadoresSistema() throws ONExistenteException;
	void removeFuncionario(String id) throws ONExistenteException, IDIException;
	void alteraFuncionario(Funcionario novo, String id) throws OExistenteException, ONExistenteException, IDIException;
}
