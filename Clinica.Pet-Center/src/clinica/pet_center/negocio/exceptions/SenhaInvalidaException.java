package clinica.pet_center.negocio.exceptions;

public class SenhaInvalidaException extends Exception {

	public SenhaInvalidaException(String id) {
		super("ID: " + id + " - Senha inválida!");
	}
}
