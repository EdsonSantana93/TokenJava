package br.com.edson.token.security;

import javax.xml.bind.DatatypeConverter;

import br.com.edson.token.model.Usuario;

public class Autenticator {
	
	private static final String PREFIXO="*GeNeRaTiOn|";
	
	public static String generateToken(Usuario usuario) {
		String str = PREFIXO + usuario.toString();
		String token = DatatypeConverter.printHexBinary(str.getBytes());
		return token;
	}
	
	public static boolean isValid(String token) {
		byte[] vetor = DatatypeConverter.parseHexBinary(token);
		String novoToken = new String(vetor);
		System.out.println("Debug = "+novoToken);
		if (novoToken.startsWith(PREFIXO)) {
			return true;
		}else {
			return false;
		}
	}
}
