package clinica.petCenter.negocio.exceptions;

public class ONExistenteException extends Exception {
	
	public ONExistenteException(String id) {
		super("Objeto n�o existente no sistema!\nID: " + id);
	}
}
