package controller;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import entities.Fornecedor;

@Controller
public class FornecedorController {

	private static final ArrayList<Fornecedor> LISTA_FORNECEDORES = new ArrayList<>();
	
	static {
		LISTA_FORNECEDORES.add(new Fornecedor("1", "D'Millus", "Av Rio Branco, 1000", "dmillus@email.com", "dmillus.com", "ACAMINHO", "5 uteis"));
		LISTA_FORNECEDORES.add(new Fornecedor("2", "Vitoria Moda Intima", "Av Presidente Vargas, 1000", "vitoriamoda@email.com", "vitoriamoda.com", "SEPARAÇÃO", "10 uteis"));
		LISTA_FORNECEDORES.add(new Fornecedor("3", "Favorita Moda Intima", ": Rua Ângelo Romano, 186", "favorita@email.com", "favorita.com.br", "PEDIDO RECEBIDO", "15 uteis"));
		LISTA_FORNECEDORES.add(new Fornecedor("4", "Dondoca", " Rua Itu, 1.120", "dondoca@email.com", "dondoca.com.br", "ENTREGUE", "15 uteis"));
		LISTA_FORNECEDORES.add(new Fornecedor("5", "Dona Sacoleira", "Rua Pedro Colino, nº 271", "donasacoleira@email.com", "donasacoleira.com.br", "ENTREGUE", "15 uteis"));
		
	}
	
	@GetMapping("/fornecedores")
	public String index() {
		return "indexContatosFornecedores";
	}
	
	@GetMapping("/fornecedores/contatosFornecedores")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("listarContatosFornecedores");
		
		modelAndView.addObject("fornecedores", LISTA_FORNECEDORES);
		
		return modelAndView;
	}
	
	@GetMapping("/fornecedores/novo")
	public ModelAndView novo() {
		var modelAndView = new ModelAndView("formularioContatosFornecedores");
		
//		modelAndView.addObject("fornecedores", new Fornecedor());
		modelAndView.addObject("fonecedor", new Fornecedor());
		return modelAndView;
	}
	
	@PostMapping("/fornecedores")
	public String cadastrar(Fornecedor fornecedor) {
		String id = UUID.randomUUID().toString();
		
		fornecedor.setId(id);
		
		LISTA_FORNECEDORES.add(fornecedor);
		
		return "redirect:/fornecedores";
	}
	
	@GetMapping("/fornecedores/{id}/editar")
	public ModelAndView editar(@PathVariable String id) {
		ModelAndView modelAndView = new ModelAndView("formularioContatosFornecedores");
		
		Fornecedor fornecedor = procurarContatoFornecedor(id);
				
		modelAndView.addObject("fornecedores/contatosFornecedores", fornecedor);
				
		return modelAndView;
	}
	
	@PutMapping("/fornecedores/{id}")
	public String atualizar(Fornecedor fornecedor) {
		Integer indice = procurarIndiceContatoFornecedor(fornecedor.getId());
		
		Fornecedor contatoFornecedorVelho = LISTA_FORNECEDORES.get(indice);
		
		LISTA_FORNECEDORES.remove(contatoFornecedorVelho);
		
		LISTA_FORNECEDORES.add(indice, fornecedor);
		
		return "redirect:/fornecedores/contatosFornecedores";
	}
	
	@DeleteMapping("/fornecedores/{id}")
	public String remover(@PathVariable String id) {
		Fornecedor fornecedor = procurarContatoFornecedor(id);
		
		LISTA_FORNECEDORES.remove(fornecedor);
		
		return "redirect:/fornecedores/contatosFornecedores";
		
	}

//	------------------AUXILIARES---------------------
	
	private Fornecedor procurarContatoFornecedor(String id) {
		Integer indice = procurarIndiceContatoFornecedor(id);
			
			if (indice != null) {
				Fornecedor fornecedor = LISTA_FORNECEDORES.get(indice);
				return fornecedor;
			}
			
			return null;
		}
		
	private Integer procurarIndiceContatoFornecedor(String id) {
		for (int i = 0; i < LISTA_FORNECEDORES.size(); i++) {
			Fornecedor fornecedor = LISTA_FORNECEDORES.get(i);
			
			if (fornecedor.getId().equals(id)) {
				
				return i;
			}
		}
		
		return null;
	}
}
