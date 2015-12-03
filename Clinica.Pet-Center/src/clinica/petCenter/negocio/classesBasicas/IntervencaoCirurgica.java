package clinica.petCenter.negocio.classesBasicas;

public class IntervencaoCirurgica {
	private EquipeMedica codEquipeMedica;
	private Cirurgia codCirurgia;
	private Animal idAnimal;
	private Cliente idDono;
	
	public IntervencaoCirurgica(EquipeMedica codEquipeMedica,
			Cirurgia codCirurgia, Animal idAnimal, Cliente idDono) {
		this.codEquipeMedica = codEquipeMedica;
		this.codCirurgia = codCirurgia;
		this.idAnimal = idAnimal;
		this.idDono = idDono;
	}
	
	public EquipeMedica getCodEquipeMedica() {
		return codEquipeMedica;
	}
	
	public void setCodEquipeMedica(EquipeMedica codEquipeMedica) {
		this.codEquipeMedica = codEquipeMedica;
	}
	
	public Cirurgia getCodCirurgia() {
		return codCirurgia;
	}

	public void setCodCirurgia(Cirurgia codCirurgia) {
		this.codCirurgia = codCirurgia;
	}

	public Animal getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Animal idAnimal) {
		this.idAnimal = idAnimal;
	}

	public Cliente getIdDono() {
		return idDono;
	}
	public void setIdDono(Cliente idDono) {
		this.idDono = idDono;
	}

	@Override
	public String toString() {
		return String.format("Codigo da equipe medica: %s\nCodigo da cirurgia: %s\n"
				+ "Id do animal: %s\nId do Dono: %s\n\n", 
				getCodEquipeMedica(), getCodCirurgia(), getIdAnimal(), getIdDono());
	}
	
	
	
}
