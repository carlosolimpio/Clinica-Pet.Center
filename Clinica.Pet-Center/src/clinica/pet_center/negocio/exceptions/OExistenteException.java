package clinica.pet_center.negocio.exceptions;

public class OExistenteException extends Exception {

private Object obj;
	
	public OExistenteException(Object obj) {
		super("Objeto com mesmo ID existente no sistema! \nDetalhes:\n"
				+ obj.toString());
		
		setObj(obj);
	}
	
	private void setObj(Object obj) {
		if(obj != null)
			this.obj = obj;
	}
	
	public Object getObj() {
		return this.obj;
	}
}
