package clinica.pet_center.negocio.exceptions;

public class ONExistenteException extends Exception {
	
	public ONExistenteException(String id) {
		super("Objeto não existente no sistema!\nID: " + id);
	}
}
