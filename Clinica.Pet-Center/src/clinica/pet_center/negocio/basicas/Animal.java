package clinica.pet_center.negocio.basicas;

import clinica.pet_center.utilidades.Contadores;

public class Animal {
	
	private String nome;
	private String especie;
	private String raca;
	private String dataNascimento;
	private Cliente dono;
	private String id;
	
	/**
	 * 
	 * @param nome - n ome do bicho
	 * @param especie - tipo do animal(gato, cachorro...)
	 * @param raca - raça
	 * @param idade - ano de nascimento
	 * @param dono - dono do bicho
	 * @param id - id do animal
	 */
	
	public Animal(String nome, String especie, String raca, String dataNascimento, Cliente dono) {
		setNome(nome);
		setEspecie(especie);
		setRaca(raca);
		setDataNascimento(dataNascimento);
		setDono(dono);
		Contadores.contAnimais();
		geraId();
	}
	
	public Animal(String id, String nome, String especie, String raca, String dataNascimento, Cliente dono) {
		setNome(nome);
		setEspecie(especie);
		setRaca(raca);
		setDataNascimento(dataNascimento);
		setId(id);
		setDono(dono);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Cliente getDono() {
		return dono;
	}

	public void setDono(Cliente dono) {
		this.dono = dono;
	}
	
	public String getId() {
		return id;
	}

	private void setId(String id) {
		this.id = id;
	}
	
	public void geraId() {
		/**
		 * id animal: ANM + contadorAnimais (ANM005)
		 */
		this.id = String.format("ANM" + Contadores.getQtdAnimais());
	}

	public boolean equals(Object obj) {
		/**
		 * Compara id do animal e id dos donos
		 */
		boolean r = false;
		if(obj instanceof Animal)
			r = ((Animal) obj).getId().equals(this.getId()) && 
				((Animal) obj).getDono().getId().equals(this.getDono().getId());
		return r;
	}
	
	@Override
	public String toString() {
		/**
		 * ID | NOME | RAÇA | ID_DONO
		 */
		return String.format(getId() + " | " + getNome() + " | " + getRaca() + " | " + getDono().getId()).toUpperCase();
	}
}
