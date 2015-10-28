package clinica.pet_center.utilidades;

import clinica.pet_center.negocio.basicas.Animal;
import clinica.pet_center.negocio.basicas.Cliente;
import clinica.pet_center.negocio.cadastros.CadastroAnimal;
import clinica.pet_center.negocio.cadastros.CadastroCliente;
import clinica.pet_center.negocio.exceptions.IDIException;
import clinica.pet_center.negocio.exceptions.OExistenteException;
import clinica.pet_center.negocio.exceptions.ONExistenteException;

public class PetTestAuxiliar {
	public static void main(String[] args) {
		
		Cliente c = new Cliente("Carlos", "asddaasd", "asdsdf", "asfdfgdfgS");
		Animal a = new Animal("carlos", "cachorro", "vira lata", "asdasd", c);
		Animal b = new Animal("AM1", "PUGA", "cachorro", "vira lata", "asdasd", c);
		
		CadastroCliente cC = new CadastroCliente();
		CadastroAnimal cA = new CadastroAnimal();
		
		try {
			cA.cadastraAnimal(a);
			System.out.println(cA.buscaAnimalId(a.getId()).toString());
			//System.out.println(cA.buscaAnimalId(b.getId()).toString());
			
			cA.cadastraAnimal(b);
			cA.alteraAnimal(a.getId(), b);
			System.out.println(cA.buscaAnimalId(a.getId()).toString());
			
		} catch(OExistenteException oee) {
			System.out.println(oee.getMessage());
		} catch(ONExistenteException one) {
			System.out.println(one.getMessage());
		} catch(IDIException iie) {
			System.out.println(iie.getMessage());
		}
	}
}
