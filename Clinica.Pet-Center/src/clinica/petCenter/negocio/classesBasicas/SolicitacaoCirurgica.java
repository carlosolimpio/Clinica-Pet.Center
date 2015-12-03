package clinica.pet_center.negocio.basicas;

public class SolicitacaoCirurgica {
	private Veterinario crmv;
	private Cirurgia codigoCirurgia;
	private String dataSolicitacao;
	private String descricaoCirurgica;
	
	public SolicitacaoCirurgica(Veterinario crmv, Cirurgia codigoCirurgia,
			String dataSolicitacao, String descricaoCirurgica) {
		setCrmv(crmv);
		setCodigoCirurgia(codigoCirurgia);
		setDataSolicitacao(dataSolicitacao);
		setDescricaoCirurgica(descricaoCirurgica);
	}

	public Veterinario getCrmv() {
		return crmv;
	}

	public void setCrmv(Veterinario crmv) {
		this.crmv = crmv;
	}

	public Cirurgia getCodigoCirurgia() {
		return codigoCirurgia;
	}

	public void setCodigoCirurgia(Cirurgia codigoCirurgia) {
		this.codigoCirurgia = codigoCirurgia;
	}

	public String getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(String dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public String getDescricaoCirurgica() {
		return descricaoCirurgica;
	}

	public void setDescricaoCirurgica(String descricaoCirurgica) {
		this.descricaoCirurgica = descricaoCirurgica;
	}

	@Override
	public String toString() {
		return String.format("CRMV do medico: %s\nCodigo da cirurgia: %s\n"
				+ "Data da solicitação de cirurgia: %s\n"
				+ "Descrição da cirurgia: %s\n\n", 
				getCrmv(), getCodigoCirurgia(), getDataSolicitacao(),
				getDescricaoCirurgica());
	}
	
	
	
	
	
}
