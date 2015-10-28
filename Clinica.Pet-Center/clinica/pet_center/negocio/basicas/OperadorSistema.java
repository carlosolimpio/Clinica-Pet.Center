
package clinica.pet_center.negocio.basicas;

import clinica.pet_center.utilidades.Contadores;
import clinica.pet_center.utilidades.Util;

public class OperadorSistema extends Funcionario {
	
	public OperadorSistema(String nome, String CPF, String dataNascimento,
			String email, String dataAdmissao, double salarioBase, String senha) {
		super(nome, CPF, dataNascimento, email, dataAdmissao, salarioBase);
		setSenha(senha);
		geraId();
	}

	public double calculaSalario(int horasTrabalhadas) {
		if(horasTrabalhadas <= Util.HORAS)
			this.salario = Util.SALARIO_BASE_OP;
		else
			this.salario = Util.SALARIO_BASE_OP + (horasTrabalhadas - Util.HORAS)/(Util.HORAS * Util.SALARIO_BASE_OP);
		
		return this.salario;
	}
	
	protected void setSenha(String senha) {
		if(!senha.isEmpty() && (senha.length() > 8))
			super.senha = senha;
	}
	
	public void geraId(){
		super.id = String.format("OP" + Contadores.getQtdPessoas());
	}
	
	
	@Override
	public String toString() {
		return String.format(super.toString() + " | " + super.getDataAdmissao()).toUpperCase();
	}
}

