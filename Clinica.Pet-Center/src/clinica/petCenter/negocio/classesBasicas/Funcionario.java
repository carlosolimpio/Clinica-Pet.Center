package clinica.pet_center.negocio.basicas;

public abstract class Funcionario extends Pessoa {
	
	private String dataAdmissao;
	protected String senha;
	
	public Funcionario(String nome, String CPF, String dataNascimento, String email, String dataAdmissao) {
		super(nome, CPF, dataNascimento, email);
		setDataAdmissao(dataAdmissao);
	}

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	
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
