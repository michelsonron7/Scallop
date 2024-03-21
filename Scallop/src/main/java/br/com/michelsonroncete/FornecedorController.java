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
public class FornecedorController {

private static final ArrayList<Fornecedor> LISTA_FORNECEDORES = new ArrayList<>();
	
	static {
		LISTA_FORNECEDORES.add(new Fornecedor("D'Millus", "57.945.373/0001-52", "Av Rio Branco, 1000", "dmillus@email.com", "dmillus.com", "ACAMINHO", "5 uteis"));
		LISTA_FORNECEDORES.add(new Fornecedor("Vitoria Moda Intima", "12.112.591/0001-78", "Av Presidente Vargas, 1000", "vitoriamoda@email.com", "vitoriamoda.com", "SEPARAÇÃO", "10 uteis"));
		LISTA_FORNECEDORES.add(new Fornecedor("Favorita Moda Intima", "04.935.557/0001-75", ": Rua Ângelo Romano, 186", "favorita@email.com", "favorita.com.br", "PEDIDO RECEBIDO", "15 uteis"));
		LISTA_FORNECEDORES.add(new Fornecedor("Dondoca", "17.190.075/0001-85", " Rua Itu, 1.120", "dondoca@email.com", "dondoca.com.br", "ENTREGUE", "15 uteis"));
		LISTA_FORNECEDORES.add(new Fornecedor("Dona Sacoleira", "48.803.704/0001-29", "Rua Pedro Colino, nº 271", "donasacoleira@email.com", "donasacoleira.com.br", "ENTREGUE", "15 uteis"));
		
	}
	
	@GetMapping("/contatos/fornecedores")
	public String index() {
		return "indexContatosFornecedores";
	}
	
	@GetMapping("/contatos/contatos/fornecedores")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("listarContatosFornecedores");
		
		modelAndView.addObject("contatos", LISTA_FORNECEDORES);
		
		return modelAndView;
	}
	
	@GetMapping("/contatos/novoFornecedores")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("formularioContatosFornecedores");
		
		modelAndView.addObject("contato", new Fornecedor());
		
		return modelAndView;
	}
	
	@PostMapping("/contatos/fornecedores")
	public String cadastrar(Fornecedor fornecedor) {
		String cnpj = UUID.randomUUID().toString();
		
		fornecedor.setCnpj(cnpj);
		
		LISTA_FORNECEDORES.add(fornecedor);
		
		return "redirect:/contatos";
	}
	
	@GetMapping("/contatos/{cnpj}/editar")
	public ModelAndView editar(@PathVariable String cnpj) {
		ModelAndView modelAndView = new ModelAndView("formularioContatosFornecedores");
		
		Fornecedor fornecedor = procurarContatoFornecedor(cnpj);
				
		modelAndView.addObject("contato", fornecedor);
				
		return modelAndView;
	}
	
	@PutMapping("/contatos/{cnpj}")
	public String atualizar(Fornecedor fornecedor) {
		Integer indice = procurarIndiceContatoFornecedor(fornecedor.getCnpj());
		
		Fornecedor contatoFornecedorVelho = LISTA_FORNECEDORES.get(indice);
		
		LISTA_FORNECEDORES.remove(contatoFornecedorVelho);
		
		LISTA_FORNECEDORES.add(indice, fornecedor);
		
		return "redirect:/contatos";
	}
	
	@DeleteMapping("/contatos/{cnpj}")
	public String remover(@PathVariable String cnpj) {
		Fornecedor fornecedor = procurarContatoFornecedor(cnpj);
		
		LISTA_FORNECEDORES.remove(fornecedor);
		
		return "redirect:/contatos";
		
	}

//	------------------AUXILIARES---------------------
	
	private Fornecedor procurarContatoFornecedor(String cnpj) {
		Integer indice = procurarIndiceContatoFornecedor(cnpj);
			
			if (indice != null) {
				Fornecedor fornecedor = LISTA_FORNECEDORES.get(indice);
				return fornecedor;
			}
			
			return null;
		}
		
	private Integer procurarIndiceContatoFornecedor(String cnpj) {
		for (int i = 0; i < LISTA_FORNECEDORES.size(); i++) {
			Fornecedor fornecedor = LISTA_FORNECEDORES.get(i);
			
			if (fornecedor.getCnpj().equals(cnpj)) {
				
				return i;
			}
		}
		
		return null;
	}
}
