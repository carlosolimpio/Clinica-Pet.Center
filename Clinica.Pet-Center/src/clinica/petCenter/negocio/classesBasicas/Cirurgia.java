package clinica.pet_center.negocio.basicas;

public class Cirurgia {
	private String codigoCirurgia;
	private String nomeCirurgia;
	private String data;
	private Veterinario crmv;
	private Animal idAnimal;
	private Cliente idDono;
	
	public Cirurgia(String codigoCirurgia, String nomeCirurgia, String data,
			Veterinario crmv, Animal idAnimal, Cliente idDono) {
		setCodigoCirurgia(codigoCirurgia);
		setNomeCirurgia(nomeCirurgia);
		setData(data);
		setCrmv(crmv);
		setIdAnimal(idAnimal);
		setIdDono(idDono);
	}

	public String getCodigoCirurgia() {
		return codigoCirurgia;
	}

	public void setCodigoCirurgia(String codigoCirurgia) {
		this.codigoCirurgia = codigoCirurgia;
	}

	public String getNomeCirurgia() {
		return nomeCirurgia;
	}

	public void setNomeCirurgia(String nomeCirurgia) {
		this.nomeCirurgia = nomeCirurgia;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Veterinario getCrmv() {
		return crmv;
	}

	public void setCrmv(Veterinario crmv) {
		this.crmv = crmv;
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
		return String.format("Codigo da cirurgia: %s\nNome da cirurgia: %s\n"
				+ "Data: %s\nCRMV do medico: %s\nId do Animal: %s\n"
				+ "Id do dono: %s\n\n",
				getCodigoCirurgia(), getNomeCirurgia(), getData(), 
				getCrmv(), getIdAnimal(), getIdDono());
	}
	
	
}
