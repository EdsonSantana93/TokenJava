package br.com.edson.token.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.edson.token.model.Usuario;
import br.com.edson.token.security.Autenticator;
import br.com.edson.token.security.Token;


@RestController
@CrossOrigin("*")
public class UsuarioController {
	@PostMapping("/login")
	public ResponseEntity<Token> autentica(@RequestBody Usuario usuario){
		if (usuario.getEmail().equals("edson@edson.com") && usuario.getSenha().equals("12345")) {
			// simulação da recuperação no banco de dados
			usuario.setId(1);
			usuario.setNome("Edson");
			
			// Construção do Token
			
			String tk = Autenticator.generateToken(usuario);
			System.out.println("TOKEN Gerado: " + tk);
			Token token = new Token();
			token.setAtrToken(tk);
			return ResponseEntity.ok(token);
		}else {
			return ResponseEntity.status(403).build();
		}
	}
}
