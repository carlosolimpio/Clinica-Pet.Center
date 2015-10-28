package clinica.pet_center.negocio.basicas;

import clinica.pet_center.utilidades.Contadores;

public abstract class Pessoa {
	
	private String nome;
	private String CPF; // 12312312390
	private String dataNascimento;
	private String email;
	protected String id;
	
	/**
	 * @author Carlos Olimpio
	 * 
	 * @param nome - nome
	 * @param CPF - cpf(11122233300) sem pontos e traço(?)
	 * @param dataNascimento - data nascimento
	 * @param email - email
	 * @param id - identificador para cada pessoa
	 * @param contador - usado no id
	 */
	
	public Pessoa(String nome, String CPF, String dataNascimento, String email) {
		
		setNome(nome);
		setDataNascimento(dataNascimento);
		setEmail(email);
		this.CPF = CPF;
		Contadores.contPessoas();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}
	
	//gera id pessoal
	public abstract void geraId();
	
	public abstract boolean equals(Object obj);
	
	@Override
	public String toString() {
		/**
		 *	Classe pessoa: NOME|CPF|ID|DATANASCIMENTO|EMAIL
		 */
		return String.format(getNome() + " | " + getCPF() + " | " + getId() + " | " + getDataNascimento() + " | " + getEmail()).toUpperCase();
	}
}
