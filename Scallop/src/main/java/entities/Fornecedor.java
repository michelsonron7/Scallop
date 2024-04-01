package entities;

public class Fornecedor {

	private String id;
	
	private String nomeFantasia;
	
	private String endereco;

	private String email;
	
	private String site;
	
	private String situacao;
	
	private String tempoEntrega;
	
	public Fornecedor() {
		
	}

	public Fornecedor(String id, String nomeFantasia
		   , String endereco, String email, String site
		   , String situacao, String tempoEntrega) {
		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.endereco = endereco;
		this.email = email;
		this.site = site;
		this.situacao = situacao;
		this.tempoEntrega = tempoEntrega;
	}
	
	public boolean isNovo() {
		return id == null;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getTempoEntrega() {
		return tempoEntrega;
	}

	public void setTempoEntrega(String tempoEntrega) {
		this.tempoEntrega = tempoEntrega;
	}
	
}	
	
