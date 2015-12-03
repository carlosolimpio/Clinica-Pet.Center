package clinica.petCenter.negocio.classesBasicas;

import java.util.ArrayList;

public class EquipeMedica {
	private String IdVeterinarioResponsavel;
	private String especialidadeMedicoResponsavel;
	private ArrayList<String> Medico;
	private String codigoEquipe;
	public EquipeMedica(String idVeterinarioResponsavel,
			String especialidadeMedicoResponsavel, String codigoEquipe) 
	{
		IdVeterinarioResponsavel = idVeterinarioResponsavel;
		this.especialidadeMedicoResponsavel = especialidadeMedicoResponsavel;
		this.codigoEquipe = codigoEquipe;
	}
	public String getIdVeterinarioResponsavel() {
		return IdVeterinarioResponsavel;
	}
	public void setIdVeterinarioResponsavel(String idVeterinarioResponsavel) {
		IdVeterinarioResponsavel = idVeterinarioResponsavel;
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
				getIdVeterinarioResponsavel(), getEspecialidadeMedicoResponsavel(),
				getMedico(), getCodigoEquipe());
	}
	
	
	
}
