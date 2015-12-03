package clinica.pet_center.negocio.basicas;

import java.io.Serializable;

import clinica.pet_center.utilidades.Contadores;
import clinica.pet_center.utilidades.Util;

public class Animal implements Serializable {
	
	private String nome;
	private String especie;
	private String raca;
	private String dataNascimento;
	private String id;
	private String idDono;
	private String tipoSanguineo;
	
	public Animal(String nome, String especie, String raca, String dataNascimento, String idDono, String tipoSanguineo) {
		setNome(nome);
		setEspecie(especie);
		setRaca(raca);
		setDataNascimento(dataNascimento);
		setIdDono(idDono);
		setTipoSanguineo(tipoSanguineo);
		geraId();
	}
	
	public Animal(String id, String nome, String especie, String raca, String dataNascimento, String idDono, String tipoSanguineo) {
		setNome(nome);
		setEspecie(especie);
		setRaca(raca);
		setDataNascimento(dataNascimento);
		setIdDono(idDono);
		setTipoSanguineo(tipoSanguineo);
		setId(id);
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
	
	public String getIdDono() {
		return idDono;
	}
	
	private void setIdDono(String idDono) {
		this.idDono = Util.isID(idDono) ? idDono : this.idDono;
	}
	
	public String getTipoSanguineo() {
		return tipoSanguineo;
	}
	
	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}
	
	public String getId() {
		return id;
	}

	private void setId(String id) {
		this.id = Util.isID(id) ? id : this.id;
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
				((Animal) obj).getIdDono().equals(this.idDono);
		return r;
	}
	
	@Override
	public String toString() {
		/**
		 * ID | NOME | RA�A | ID_DONO
		 */
		return String.format(getId() + " | " + getNome() + " | " + getRaca() + " | " + getIdDono().toUpperCase());
	}
}