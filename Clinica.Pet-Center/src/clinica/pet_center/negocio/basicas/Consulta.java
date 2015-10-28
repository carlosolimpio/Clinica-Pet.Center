package clinica.pet_center.negocio.basicas;

public class Consulta {
	
	private Veterinario veterinario;
	private Cliente cliente;
	private Animal animal;
	private String motivoVisita;
	private String diagnostico;
	private String receita;
	private String data;
	private String idConsulta;
	private static int contador = 0;
	
	/**
	 * 
	 * @param veterinario - medico responsavel pela consulta
	 * @param cliente - dono do bicho
	 * @param animal - animal do cliente
	 * @param motivoVisita - cliente ir� informar. Basicamente descri��o dita pelo dono do animal
	 * @param diagnostico - conclus�o do m�dico veterinario depois de exames
	 * @param receita - receita m�dica com medicamentos, indica��es, etc.
	 * @param data - vai servir para data da consulta em si.
	 */
	
	public Consulta(Veterinario veterinario, Cliente cliente, Animal animal, String data) {
		setVeterinario(veterinario);
		setCliente(cliente);
		setAnimal(animal);
		setData(data);
		geraIdConsulta();
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario != null ? veterinario : null;
	}
	
	public Veterinario getVeterinario() {
		return veterinario;
	}

	public Animal getAnimal() {
		return animal;
	}
	
	public void setAnimal(Animal animal) {
		this.animal = animal != null && isDono(animal, this.getCliente()) ? animal : null;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente != null ? cliente : null;
	}

	public String getMotivoVisita() {
		return String.format("Informa��es dadas pelo dono do animal:\n" + this.motivoVisita).toUpperCase();
	}

	public void setMotivoVisita(String motivoVisita) {
		this.motivoVisita = motivoVisita;
	}

	public String getDiagnostico() {
		return String.format("Diagn�stico:\n" + this.diagnostico).toUpperCase();
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public void setReceita(String receita) {
		this.receita = receita;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data != null ? data : this.data;
	}
	
	private void geraIdConsulta() {
		this.idConsulta = String.format("CONSULTA|" + contador);
	}
	
	public String getIdConsulta() {
		return this.idConsulta;
	}
	
	//verifica se o animal ja foi cadastrado no Cliente
	private boolean isDono(Animal animal, Cliente dono) {
		boolean r = false;
		
		for(Animal a : dono.getAnimais()) {
			if(a.equals(animal)) {
				r = true; 			//animal existe
				break;
			}
		}
		return r;
	}
	
	public String imprimeBasico() {
		return String.format(getIdConsulta() + " | " + getVeterinario().getId() + " | " +  getCliente().getId() +
				" | " + getAnimal().getId()).toUpperCase();
	}
	
	public String getReceita() {
		return String.format("Receita:\n" + this.receita + "\n" + imprimeBasico()).toUpperCase();
	}
	
}
