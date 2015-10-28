package clinica.pet_center.negocio.basicas;

import java.util.ArrayList;

import clinica.pet_center.utilidades.Contadores;

public class Cliente extends Pessoa {
	
	private ArrayList<Animal> animais;
	
	public Cliente(String nome, String CPF, String dataNascimento, String email) {
		super(nome, CPF, dataNascimento, email);
		geraId();
	}
	
	public void setAnimais(ArrayList<Animal> animais) {
		this.animais = new ArrayList<Animal>();
		for(Animal a : animais)
			this.animais.add(a);
	}
	
	public ArrayList<Animal> getAnimais() {
		return animais;
	}
	
	public void addAnimal(Animal animal) {
		this.animais.add(animal);
	}
	
	public int getQtdAnimais() {
		return animais.size();
	}
	
	public void geraId() {
		//formato: CL + contadorPessoas (exemplo: CL002) ver aqui depois
		super.id = String.format("CL" + Contadores.getQtdPessoas());
	}
	
	public boolean equals(Object obj) {
		/**
		 * Compara CPF e ID
		 */
		boolean r = false;
		if(obj != null && obj instanceof Cliente && this.getCPF() != null && this.getId() != null)
			r = ((Cliente) obj).getCPF().equals(this.getCPF()) && ((Cliente) obj).getId().equals(this.getId());
		return r;
	}
	
	@Override
	public String toString() {
		/**
		 * Classe pessoa: NOME|CPF|ID|DATANASCIMENTO|EMAIL
		 * Classe Cliente: QTDANIMAIS
		 */
		return super.toString();
	}
}
