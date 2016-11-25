package com.algaworks.brewer.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorDeSenhaBCrypt {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoder  = new BCryptPasswordEncoder();
		String senha = encoder.encode("admin");
		System.out.println(senha);
	}
}
