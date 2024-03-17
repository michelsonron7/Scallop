package br.com.michelsonroncete;

public class Produto {

	private String id;
	
	private String nomeProduto;
	
	private Double valorCompra;
	
	private Double valorVenda;
	
	private String descricao;
	
	private Integer quantidade;
	
	public Produto() {
		
	}

	public Produto(String id, String nomeProduto, Double valorCompra, Double valorVenda, String descricao,
			Integer quantidade) {
		super();
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.valorCompra = valorCompra;
		this.valorVenda = valorVenda;
		this.descricao = descricao;
		this.quantidade = quantidade;
	}
	
	public boolean isNovo() {
		return id == null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
