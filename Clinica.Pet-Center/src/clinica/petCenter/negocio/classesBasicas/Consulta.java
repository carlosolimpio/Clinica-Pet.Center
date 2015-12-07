package clinica.petCenter.negocio.classesBasicas;

import java.io.Serializable;

import clinica.petCenter.negocio.exceptions.IDIException;
import clinica.petCenter.utilidades.Contadores;
import clinica.petCenter.utilidades.Util;

public class Consulta implements Serializable{
	
	private Veterinario veterinario;
	private Cliente cliente;
	private Animal animal;
	private String motivoVisita;
	private String diagnostico;
	private String receita;
	private String data;
	private String idConsulta;
	
	/**
	 * 
	 * @param veterinario - medico responsavel pela consulta
	 * @param cliente - dono do bicho
	 * @param animal - animal do cliente
	 * @param motivoVisita - cliente irá informar. Basicamente descrição dita pelo dono do animal
	 * @param diagnostico - conclusão do médico veterinario depois de exames
	 * @param receita - receita médica com medicamentos, indicações, etc.
	 * @param data - vai servir para data da consulta em si.
	 */
	
	public Consulta(Veterinario veterinario, Cliente cliente, Animal animal, String data) {
		setVeterinario(veterinario);
		setCliente(cliente);
		setAnimal(animal);
		setData(data);
		geraIdConsulta();
	}
	
	public Consulta(String idConsulta, Veterinario veterinario, Cliente cliente, Animal animal, String data) throws IDIException {
		setIdConsulta(idConsulta);
		setVeterinario(veterinario);
		setCliente(cliente);
		setAnimal(animal);
		setData(data);
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
//		this.animal = (animal != null) && isDono(animal, this.getCliente()) ? animal : null;
		this.animal = animal;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente != null ? cliente : null;
	}

	public String getMotivoVisita() {
		return String.format("Informações dadas pelo dono do animal:\n" + this.motivoVisita).toUpperCase();
	}

	public void setMotivoVisita(String motivoVisita) {
		this.motivoVisita = motivoVisita;
	}

	public String getDiagnostico() {
		return String.format("Diagnóstico:\n" + this.diagnostico).toUpperCase();
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
	
	private void setIdConsulta(String idConsulta) throws IDIException {
		if(Util.isID(idConsulta))
			this.idConsulta = idConsulta;
		else
			throw new IDIException(idConsulta);
	}
	
	private void geraIdConsulta() {
		this.idConsulta = String.format("CONSULTA|" + Contadores.getQtdConsultas());
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
