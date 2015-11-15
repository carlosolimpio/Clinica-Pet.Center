package clinica.pet_center.negocio.basicas;

import java.util.ArrayList;

public class EquipeMedica {
	private String IdMedicoResponsavel;
	private String especialidadeMedicoResponsavel;
	private ArrayList<String> Medico;
	private String codigoEquipe;
	public EquipeMedica(String idMedicoResponsavel,
			String especialidadeMedicoResponsavel, String codigoEquipe) 
	{
		IdMedicoResponsavel = idMedicoResponsavel;
		this.especialidadeMedicoResponsavel = especialidadeMedicoResponsavel;
		this.codigoEquipe = codigoEquipe;
	}
	public String getIdMedicoResponsavel() {
		return IdMedicoResponsavel;
	}
	public void setIdMedicoResponsavel(String idMedicoResponsavel) {
		IdMedicoResponsavel = idMedicoResponsavel;
	}
	public String getEspecialidadeMedicoResponsavel() {
		return especialidadeMedicoResponsavel;
	}
	public void setEspecialidadeMedicoResponsavel(
			String especialidadeMedicoResponsavel) {
		this.especialidadeMedicoResponsavel = especialidadeMedicoResponsavel;
	}
	public ArrayList<String> getMedico() {
		return Medico;
	}
	public void setMedico(ArrayList<String> medico) {
		Medico = medico;
	}
	public String getCodigoEquipe() {
		return codigoEquipe;
	}
	public void setCodigoEquipe(String codigoEquipe) {
		this.codigoEquipe = codigoEquipe;
	}
	@Override
	public String toString() {
		return String.format("Id do medico responsavel: %s\n"
				+ "Especialidade do medico responsavel: %s\n"
				+ "Lista de medicos no grupo: %s\n"
				+ "Codigo da equipo medica: %s\n\n", 
				getIdMedicoResponsavel(), getEspecialidadeMedicoResponsavel(),
				getMedico(), getCodigoEquipe());
	}
	
	
	
}
