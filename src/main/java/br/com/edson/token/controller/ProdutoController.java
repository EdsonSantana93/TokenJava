package br.com.edson.token.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.edson.token.model.Produto;
import br.com.edson.token.security.Autenticator;

@RestController  // anota que o codigo é um controller
@CrossOrigin("*") // anotação para liberar qualquer porta utilizar os dados
public class ProdutoController {
	
	@GetMapping("produto/todos") // cria a rota 
	public ResponseEntity<ArrayList<Produto>> getAllProduto(@RequestParam String token){ //Manda uma requisição get para o banco de dados
		if (Autenticator.isValid(token)) { // verifica se o token é valido 
		/*Esse trecho simula uma consulta ao banco de dados*/
			ArrayList<Produto> lista = new ArrayList<Produto>(); // Caso seja, será criado uma varredura no banco
			for (int i = 0; i < 20; i++) {
				Produto p = new Produto();
				p.setCodigo((i+1)*100);
				p.setTitulo("Titulo: " +(i+1));
				p.setDetalhes("Produto: "+(i+1));
				p.setPreco(105f + i);
				
				lista.add(p);
			}
			return ResponseEntity.ok(lista);
		}else { 
			return ResponseEntity.status(403).build();
		}
	}
}
