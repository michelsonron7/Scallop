package entities;

import java.util.ArrayList;

public class Venda {

	private Long codigoVenda;
	
	private Double valorTotal;
	
	private String dataVenda;
	
	public Venda() {
		
	}

	public Venda(Long codigoVenda, Double valorTotal, String dataVenda) {
		this.codigoVenda = codigoVenda;
		this.valorTotal = valorTotal;
		this.dataVenda = dataVenda;
	}

	public Long getCodigoVenda() {
		return codigoVenda;
	}

	public void setCodigoVenda(Long codigoVenda) {
		this.codigoVenda = codigoVenda;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public void realizar() {
		
	}
	
	public void ccanancelarVenda() {
		
	}
	
	public void cancelarItem() {
		
	}
	
	public void buscar() {
		
	}
	
	public void adicionarItem() {
		
	}
	
	public ArrayList<Venda> listar(){
		return null;
	}
}
