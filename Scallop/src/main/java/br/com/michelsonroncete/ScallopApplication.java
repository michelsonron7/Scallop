package br.com.michelsonroncete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import conexaoDAO.ProdutoDAO;
import entities.Produto;

@SpringBootApplication
public class ScallopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScallopApplication.class, args);
		
		Produto produto = new Produto();
		produto.setNomeProduto("Conjunto Dani");
		produto.setValorCompra(27.90);
		produto.setValorVenda(64.90);
		produto.setDescricao("Conjunto de renda sem bojo");
		produto.setQuantidade(10);
		
		new ProdutoDAO().cadastrarUsuario(produto);
	}

}
