package clinica.pet_center.negocio.basicas;



public abstract class Funcionario extends Pessoa {
	
	private String dataAdmissao;
	protected String senha;
	protected double salario;
	
	/**
	 * @author Carlos olimpio
	 * 
	 * @param dataAdmissao - data de contrato
	 * @param salarioBase - salario minimo base para calculo posterior
	 */
	
	public Funcionario(String nome, String CPF, String dataNascimento, String email, String dataAdmissao, double salarioBase) {
		super(nome, CPF, dataNascimento, email);
		setDataAdmissao(dataAdmissao);
		this.salario = salarioBase;
	}
	
	public double getSalarioBase() {
		return salario;
	}

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public abstract double calculaSalario(int horasTrabalhadas);
	
	protected abstract void setSenha(String senha);
	
	public String getSenha() {
		return this.senha;
	}
	
	public boolean equals(Object obj) {
		boolean r = false;
		if(obj != null && obj instanceof Funcionario && this.getCPF() != null && this.getId() != null)
			r = this.getCPF().equals(((Funcionario) obj).getCPF()) || this.getId().equals(((Funcionario) obj).getId());
		return r;
	}
	
}
