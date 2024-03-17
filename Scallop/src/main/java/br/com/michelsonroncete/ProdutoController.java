package br.com.michelsonroncete;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProdutoController {

	private static final ArrayList<Produto> LISTA_PRODUTOS = new ArrayList<>();
	
	static {
		LISTA_PRODUTOS.add(new Produto("1", "Conjunto Dani ", 27.90, 64.90, "conjunto de renda sem bojo", 10));
		LISTA_PRODUTOS.add(new Produto("2", "produto Bondy Sofia", 41.90, 84.90, "Body de renda ideal para compor os looks mais despojados .", 10));
		LISTA_PRODUTOS.add(new Produto("3", "produto Conjunto Vitória ", 25.00, 84.90, "Conjunto rendaa", 10));
		LISTA_PRODUTOS.add(new Produto("4", "produto Pijama Suede ", 30.00, 89.99, "baby Doll de Suede", 10));
		LISTA_PRODUTOS.add(new Produto("5", "calcinha caleçon ", 9.00, 21.90, "calcinha possui lateral mais larga", 10));
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/produtos")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("listar");
		
		modelAndView.addObject("produtos", LISTA_PRODUTOS);
		
		return modelAndView;
	}

	@GetMapping("/produtos/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("formulario");

		modelAndView.addObject("produto", new Produto());
		
		return modelAndView;
	}
	
	@PostMapping("/produtos")
	public String cadastrar(Produto produto) {
		String id = UUID.randomUUID().toString();
		
		produto.setId(id);
		
		LISTA_PRODUTOS.add(produto);
		
		return "redirect:/produtos";
	}
	
	@GetMapping("/produtos/{id}/editar")
	public ModelAndView editar(@PathVariable String id) {
		ModelAndView modelAndView = new ModelAndView("formulario");
		
		Produto produto = procurarProduto(id);
				
		modelAndView.addObject("produto", produto);
				
		return modelAndView;
	}
	
	@PutMapping("/produtos/{id}")
	public String atualizar(Produto produto) {
		Integer indice = procurarIndiceProduto(produto.getId());
		
		Produto produtoVelho = LISTA_PRODUTOS.get(indice);
		
		LISTA_PRODUTOS.remove(produtoVelho);
		
		LISTA_PRODUTOS.add(indice, produto);
		
		return "redirect:/produtos";
	}
	
	@DeleteMapping("/produtos/{id}")
	public String remover(@PathVariable String id) {
		Produto produto = procurarProduto(id);
		
		LISTA_PRODUTOS.remove(produto);
		
		return "redirect:/produtos";
		
	}
	
//	------------------AUXILIARES---------------------
	
	public Produto procurarProduto(String id) {
		Integer indice = procurarIndiceProduto(id);
			
			if (indice != null) {
				Produto produto = LISTA_PRODUTOS.get(indice);
				return produto;
			}
			
			return null;
		}
		
	public Integer procurarIndiceProduto(String id) {
		for (int i = 0; i < LISTA_PRODUTOS.size(); i++) {
			Produto produto = LISTA_PRODUTOS.get(i);
			
			if (produto.getId().equals(id)) {
				
				return i;
			}
		}
		
		return null;
	}
}
