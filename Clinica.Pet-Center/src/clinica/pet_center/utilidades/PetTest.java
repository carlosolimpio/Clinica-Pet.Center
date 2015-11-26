package clinica.pet_center.utilidades;

import java.util.ArrayList;
import java.util.Scanner;

import clinica.pet_center.negocio.basicas.Animal;
import clinica.pet_center.negocio.basicas.Cliente;
import clinica.pet_center.negocio.basicas.Consulta;
import clinica.pet_center.negocio.basicas.Funcionario;
import clinica.pet_center.negocio.basicas.OperadorSistema;
import clinica.pet_center.negocio.basicas.Veterinario;
import clinica.pet_center.negocio.cadastros.CadastroAnimal;
import clinica.pet_center.negocio.cadastros.CadastroCliente;
import clinica.pet_center.negocio.cadastros.CadastroConsulta;
import clinica.pet_center.negocio.cadastros.CadastroFuncionario;

public class PetTest 
{

	public static void main(String[] args) 
	{

		Scanner input = new Scanner(System.in);
		int op = -1;
		String aux1, aux2;

		CadastroFuncionario cadFunc = new CadastroFuncionario();


		do 
		{
			System.out.println("*****CLINICA PET CENTER*****");
			System.out.println("1 - Login com ADM");
			System.out.println("2 - Login com Funcionario");
			System.out.println("0 - Sair");
			System.out.print("OPÇÃO: ");
			op = input.nextInt();

			switch(op) 
			{
			case 1:
				System.out.print("ID: ");
				aux1 = input.next();
				System.out.print("Senha: ");
				aux2 = input.next();

				if(Util.isADM(aux1, aux2)) 
				{
					telaADM();
					break;
				}
				else 
				{
					System.out.println("ID OU SENHA INCORRETOS!");
					break;
				}

			case 2:
				System.out.print("ID: ");
				aux1 = input.next();
				System.out.print("Senha: ");
				aux2 = input.next();

				ArrayList<Funcionario> arrF = cadFunc.listaFuncionarios();

				if(arrF != null) 
					for(Funcionario func : arrF) 
					{
						if(func.getId().equals(aux1) || func.getSenha().equals(aux2))
							telaFuncionario(func);
						else
							System.out.println("ID ou SENHA INCORRETOS!");
					}
				else
					System.out.println("Não há funcionarios no sistema");
				break;

			case 0:
				System.out.println("Saindo do PetCenter!");
				break;
			}
		} while(op != 0);
		input.close();
	}

	private static void telaFuncionario(Funcionario func) 
	{
		int op = -1;
		int op2 = -1;
		String aux1, aux2, aux3, aux4, aux5, aux6, aux7;
		String id;

		Scanner input = new Scanner(System.in);
		Consulta consulta;
		Cliente cliente;
		Animal animal;

		CadastroCliente cadCL = new CadastroCliente();
		CadastroAnimal cadAN = new CadastroAnimal();
		CadastroConsulta cadCON = new CadastroConsulta();

		do 
		{
			System.out.printf("\n*****BEM VINDO %s*****", func.getNome().toUpperCase());

			if(func instanceof Veterinario) 
			{
				System.out.println("\n1 - REALIZAR CONSULTA");
				System.out.println("2 - IMPRIMIR RECEITA");
				System.out.println("3 - LISTA ANIMAIS DE DONO ESPECIFICO");
				System.out.println("4 - LISTA TODOS ANIMAIS");
				System.out.println("0 - VOLTAR");
				op = input.nextInt();

				switch(op) 
				{
				case 1:
					do 
					{
						System.out.println("1 - CADASTRAR ANIMAL"); //Operador de sistema
						System.out.println("2 - PREENCHER CONSULTA");
						System.out.println("3 - BUSCA ANIMAL (ID)");//operador de sistema
						System.out.println("0 - SAIR");
						op2 = input.nextInt();

						switch(op2) 
						{
						case 1:
							//cadastra animal
							System.out.print("\nNome: ");
							input.next();
							aux1 = input.nextLine();
							System.out.print("\nEspecie: ");
							aux2 = input.nextLine();
							System.out.print("\nRaça: ");
							aux3 = input.nextLine();
							System.out.print("\nData de Nascimento: ");
							aux4 = input.nextLine();
							System.out.print("\nID Dono: ");
							aux6 = input.nextLine();

							cliente = cadCL.buscaCliente(aux6);

							if(cliente != null) 
							{
								animal = new Animal(aux1, aux2, aux3, aux4, cliente);  //cria um animal
								cliente.addAnimal(animal);							   //add animal no array de animais de um cliente
								if(cadAN.cadastraAnimal(animal))
									System.out.println("Animal Cadastrado!");
							}
							else
								System.out.println("Cliente não encontrado");
							break;

						case 2:
							//preenche consulta
							System.out.print("\nMotivo da visita: ");
							input.next();
							aux1 = input.nextLine();
							System.out.print("\nDiagnostico: ");
							aux2 = input.nextLine();
							System.out.print("\nReceita: ");
							aux3 = input.nextLine();
							System.out.print("\nData: ");
							aux4 = input.nextLine();

							System.out.print("ID do animal consultado: ");
							aux5 = input.next();
							System.out.print("ID do cliente: ");
							aux6 = input.next();

							animal = cadAN.buscaAnimalId(aux5);
							cliente = cadCL.buscaCliente(aux6);

							if(animal != null && cliente != null) 
							{
								consulta = new Consulta((Veterinario) func, cliente, animal, aux4);
								if(cadCON.cadastraConsulta(consulta))
									System.out.println("Consulta realizada com sucesso!");
								else
									System.out.println("Erro na consulta");
							}
							else
								System.out.println("Erro");	
							break;

						case 3:
							//busca animal especifico, pelo id
							System.out.print("Informe o id do animal: ");
							id = input.next();

							animal = cadAN.buscaAnimalId(id);

							if(animal != null)
								System.out.println(animal.toString());
							else
								System.out.println("Animal nao encontrado!");
							break;

						case 0:
							System.out.println("Voltando ao menu");
							break;
						}
					} while(op2 != 0);
					break;

				case 2:
					//imprime receita
					System.out.println("Informe o ID da consulta: ");
					aux1 = input.next();

					consulta = cadCON.buscaConsulta(aux1);

					if(consulta != null)
						System.out.println(consulta.getReceita());
					else
						System.out.println("Consulta não encontrada!");
					break;

				case 3:
					//lista animais de um unico dono
					System.out.print("Informe o id do cliente: ");
					id = input.next();

					cliente = cadCL.buscaCliente(id);

					if(cliente != null) 
					{
						ArrayList<Animal> arrAN = cadCL.listaAnimaisCliente(cliente.getId());
						System.out.printf("\nAnimais do cliente %s:\n", cliente.getNome());
						for(Animal ax : arrAN)
							System.out.println(ax.toString());
					}
					else
						System.out.println("Cliente nao encontrado!");
					break;

				case 4:
					//lista todos animais do sistema
					ArrayList<Animal> arrAN = cadAN.listaAnimais();
					if(arrAN != null) 
					{
						for(Animal ax : arrAN)
							System.out.println(ax.toString());
					}
					else	
						System.out.println("Não há animais no sistema");		
					break;

				case 0:
					System.out.println("Saindo");
					break;
				default:
				}
			}
			else if(func instanceof OperadorSistema) 
			{
				System.out.println("\n1 - CADASTRAR CLIENTE");				//OK
				System.out.println("2 - LISTA ANIMAIS DE DONO ESPECIFICO");	//OK
				System.out.println("3 - LISTA TODOS ANIMAIS");				//OK
				System.out.println("4 - BUSCA ANIMAL (ID)");				//OK
				System.out.println("5 - REMOVE ANIMAL");					//OK
				System.out.println("6 - LISTA TODOS CLIENTES");				//OK
				System.out.println("7 - BUSCA CLIENTE (ID)");				//OK
				System.out.println("8 - REMOVE CLIENTE");					//OK
				System.out.println("9 - CADASTRAR ANIMAL");					//OK
				System.out.println("0 - VOLTAR");
				op = input.nextInt();

				switch(op) 
				{
				case 1:
					//cadastra Cliente
					System.out.print("\nNome: ");
					input.next();
					aux1 = input.nextLine();
					System.out.print("\nCPF: ");
					aux2 = input.nextLine();
					System.out.print("\nData de Nascimento: ");
					aux3 = input.nextLine();
					System.out.print("\nEmail: ");
					aux4 = input.nextLine();

					cliente = new Cliente(aux1, aux2, aux3, aux4);

					if(cadCL.cadastraCliente(cliente))
						System.out.printf("Cliente %s cadastrado com sucesso!\n", cliente.getNome());
					else
						System.out.println("Erro no cadastro de cliente");
					break;

				case 2:
					//lista animais de um dono especifico
					System.out.print("Informe o id do cliente: ");
					id = input.next();

					cliente = cadCL.buscaCliente(id);

					if(cliente != null) {
						ArrayList<Animal> arrAN = cadCL.listaAnimaisCliente(cliente.getId());
						System.out.printf("\nAnimais do cliente %s:\n", cliente.getNome());
						for(Animal ax : arrAN)
							System.out.println(ax.toString());
					}
					else
						System.out.println("Cliente nao encontrado!");
					break;

				case 3:
					//lista todos animais
					ArrayList<Animal> arrAN = cadAN.listaAnimais();
					if(arrAN != null) {
						for(Animal ax : arrAN)
							System.out.println(ax.toString());
					}
					else	
						System.out.println("Não há animais no sistema");
					break;

				case 4:
					//busca animal especifico, pelo id
					System.out.print("Informe o id do animal: ");
					id = input.next();

					animal = cadAN.buscaAnimalId(id);

					if(animal != null)
						System.out.println(animal.toString());
					else
						System.out.println("Animal nao encontrado!");
					break;

				case 5:
					//remove animal
					System.out.print("Informe o id do animal: ");
					id = input.next();

					animal = cadAN.buscaAnimalId(id);

					if(animal != null) 
					{
						if(cadAN.removeAnimal(animal.getId()))
							System.out.println("Animal removido!");
					}
					else
						System.out.println("Animal nao encontrado!");
					break;

				case 6:
					//listar todos clientes
					ArrayList<Cliente> arrCL = cadCL.listaClientes();
					if(arrCL != null) 
					{
						for(Cliente cx : arrCL)
							System.out.println(cx.toString());
					}
					else	
						System.out.println("Não há clientes no sistema");
					break;

				case 7:
					//busca cliente especifico, pelo id
					System.out.print("Informe o id do cliente: ");
					id = input.next();

					cliente = cadCL.buscaCliente(id);

					if(cliente != null)
						System.out.println(cliente.toString());
					else
						System.out.println("Cliente nao encontrado!");
					break;

				case 8:
					//remove CLiente
					System.out.print("Informe o id do cliente: ");
					id = input.next();

					cliente = cadCL.buscaCliente(id);

					if(cliente != null) 
					{
						if(cadCL.removeCliente(cliente.getId()))
							System.out.println("Cliente removido!");
					}
					else
						System.out.println("Cliente nao encontrado!");
					break;

				case 0:
					System.out.println("Saindo");
					break;
				default:

				}
			}
		} while(op != 0);
	}

	private static void telaADM() 
	{
		int op = -1;
		int op2 = -1;

		String aux1, aux2, aux3, aux4, aux5, aux6, aux7;
		String id;

		Scanner input = new Scanner(System.in);

		Funcionario func;
		CadastroFuncionario cadF;


		do 
		{

			System.out.println("*****BEM VINDO ADM*****");
			System.out.println("1 - CADASTRAR FUNCIONARIO");
			System.out.println("2 - REMOVER FUNCIONARIO");
			System.out.println("3 - BUSCAR FUNCIONARIO (ID)");
			System.out.println("4 - LISTAR FUNCIONARIOS");
			System.out.println("5 - LISTAR CLIENTES");
			System.out.println("6 - LISTAR ANIMAIS");
			System.out.println("7 - LISTAR CONSULTAS");
			System.out.println("0 - SAIR");
			System.out.print("OPÇÃO: ");
			op = input.nextInt();

			cadF = new CadastroFuncionario();

			switch(op) 
			{
			case 1:
				System.out.println("CADASTRAR FUNCIONARIO");
				System.out.println("\n1 - Operador de Sistema");
				System.out.println("2 - Veterinario");
				System.out.print("OPÇÃO: ");
				op2 = input.nextInt();

				if(op2 == 1) 
				{

					System.out.print("\nNome: ");
					input.next();
					aux1 = input.nextLine();
					System.out.print("\nCPF: ");
					aux2 = input.nextLine();
					System.out.print("\nData de Nascimento: ");
					aux3 = input.nextLine();
					System.out.print("\nEmail: ");
					aux4 = input.nextLine();
					System.out.print("\nData de Admissão: ");
					aux5 = input.nextLine();
					System.out.print("\nSenha: ");
					aux6 = input.nextLine();

					func = new OperadorSistema(aux1, aux2, aux3, aux4, aux5, Util.SALARIO_BASE_OP, aux6);

					if(cadF.cadastraFuncionario(func))
						System.out.println("Operador de Sistema " + func.getNome() + " cadastrado com sucesso!");
					else
						System.out.println("Erro no cadastro!");

				}
				else if(op2 == 2) 
				{
					System.out.print("\nNome: ");
					input.next();
					aux1 = input.nextLine();
					System.out.print("\nCPF: ");
					aux2 = input.nextLine();
					System.out.print("\nData de Nascimento: ");
					aux3 = input.nextLine();
					System.out.print("\nEmail: ");
					aux4 = input.nextLine();
					System.out.print("\nData de Admissão: ");
					aux5 = input.nextLine();
					System.out.print("\nCRMV: ");
					aux6 = input.nextLine();
					System.out.print("\nSenha: ");
					aux7 = input.nextLine();

					func = new Veterinario(aux1, aux2, aux3, aux4, aux5, Util.SALARIO_BASE_VETERINARIO, aux6, aux7);

					if(cadF.cadastraFuncionario(func))
						System.out.println("Veterinario " + func.getNome() + " cadastrado com sucesso!");
					else
						System.out.println("Erro no cadastro!");
				}

				break;

			case 2:
				System.out.println("REMOVER FUNCIONARIO");
				System.out.print("Informe o id: ");
				id = input.next();

				if(cadF.removeFuncionario(id))
					System.out.println("Funcionario removido com sucesso!");
				else
					System.out.println("Erro na remoção!");

				break;

			case 3:
				System.out.println("BUSCAR FUNCIONARIO");
				System.out.print("Informe o id: ");
				id = input.next();

				func = cadF.buscaFuncionario(id);

				if(func != null)
					System.out.println(func.toString());
				else
					System.out.println("Erro na busca!");
				break;

			case 4:
				System.out.println("FUNCIONARIOS");
				System.out.println("1 - Operadores de Sistema");
				System.out.println("2 - Veterinarios");
				System.out.println("3 - Todos");
				op2 = input.nextInt();

				switch(op2) 
				{
				case 1:
					System.out.println("Operadores de Sistema");
					ArrayList<OperadorSistema> arOP = cadF.listaOperadoresSistema();
					if(arOP != null)
						for(Funcionario fx : arOP) 
						{
							System.out.println(fx.toString());;
						}
					else
						System.out.println("Erro ao listar!");
					break;

				case 2: 
					System.out.println("Veterinarios");
					ArrayList<Veterinario> arVT = cadF.listaVeterinarios();
					if(arVT != null)
						for(Funcionario fx : arVT) 
						{
							System.out.println(fx.toString());;
						}
					else
						System.out.println("Erro ao listar!");
					break;

				case 3:
					System.out.println("Funcionarios");
					ArrayList<Funcionario> arF = cadF.listaFuncionarios();
					if(arF != null)
						for(Funcionario fx : arF) 
						{
							System.out.println(fx.toString());;
						}
					else
						System.out.println("Erro ao listar!");
					break;
				}
				break;
				
			case 5:
				System.out.println("CLIENTES");
				CadastroCliente cadC = new CadastroCliente();
				ArrayList<Cliente> arC = cadC.listaClientes();
				if(arC != null)
					for(Cliente cx : arC) {
						System.out.println(cx.toString());;
					}
				else
					System.out.println("Erro ao listar!");
				break;

			case 6:
				System.out.println("ANIMAIS");
				CadastroAnimal cadA = new CadastroAnimal();
				ArrayList<Animal> arA = cadA.listaAnimais();
				if(arA != null)
					for(Animal ax : arA) 
					{
						System.out.println(ax.toString());;
					}
				else
					System.out.println("Erro ao listar!");
				break;

			case 7:
				System.out.println("CONSULTAS");
				CadastroConsulta cadCO = new CadastroConsulta();
				ArrayList<Consulta> arCO = cadCO.listaConsultas();
				if(arCO != null)
					for(Consulta cox : arCO) 
					{
						System.out.println(cox.toString());;
					}
				else
					System.out.println("Erro ao listar!");
				break;

			case 0:
				System.out.println("Voltando ao menu inicial");
				break;
			default:

			}
		} while(op != 0);
		input.close();
	}
}