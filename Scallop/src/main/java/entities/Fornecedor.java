package entities;

import java.util.ArrayList;

public class Fornecedor {

	private String nomeFantasia;
	
	private String cnpj;
	
	private String endereco;

	private String email;
	
	private String site;
	
	private String situacao;
	
	private String tempoEntrega;
	
	public Fornecedor() {
		
	}

	public Fornecedor(String nomeFantasia, String cnpj
		   , String endereco, String email, String site
		   , String situacao, String tempoEntrega) {
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.email = email;
		this.site = site;
		this.situacao = situacao;
		this.tempoEntrega = tempoEntrega;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
	
	public void cadastrar() {
		
	}
	
	public void alterar() {
		
	}
	
	public ArrayList<Produto> listar(){
		return null;
	}
	
	public void buscar() {
		
	}
}	
	
