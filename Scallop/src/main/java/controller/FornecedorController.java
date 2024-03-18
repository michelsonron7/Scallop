package controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;

import entities.Fornecedor;

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
}
