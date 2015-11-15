package clinica.pet_center.negocio.basicas;

public class IntervencaoCirurgica {
	private String codEquipeMedica;
	private String codCirurgia;
	private String idAnimal;
	private String idDono;
	
	public IntervencaoCirurgica(String codEquipeMedica, String codCirurgia,
			String idAnimal, String idDono) {
		this.codEquipeMedica = codEquipeMedica;
		this.codCirurgia = codCirurgia;
		this.idAnimal = idAnimal;
		this.idDono = idDono;
	}

	public String getCodEquipeMedica() {
		return codEquipeMedica;
	}

	public void setCodEquipeMedica(String codEquipeMedica) {
		this.codEquipeMedica = codEquipeMedica;
	}

	public String getCodCirurgia() {
		return codCirurgia;
	}

	public void setCodCirurgia(String codCirurgia) {
		this.codCirurgia = codCirurgia;
	}

	public String getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(String idAnimal) {
		this.idAnimal = idAnimal;
	}

	public String getIdDono() {
		return idDono;
	}

	public void setIdDono(String idDono) {
		this.idDono = idDono;
	}

	@Override
	public String toString() {
		return String.format("Codigo da equipe medica: %s\nCodigo da cirurgia: %s\n"
				+ "Id do animal: %s\nId do Dono: %s\n\n", 
				getCodEquipeMedica(), getCodCirurgia(), getIdAnimal(), getIdDono());
	}
	
	
	
}
