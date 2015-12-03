package clinica.petCenter.negocio.exceptions;

public class IDIException extends Exception {
	
	public IDIException(String id) {
		super("ID " + id + " fora de padrão.");
	}
}
