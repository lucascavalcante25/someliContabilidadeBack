package com.someli.someli.service;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioServiceTest {

	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Test
	public void deveCriptografarSenhaCorretamente() {
		String senhaOriginal = "123456";

		String senhaCriptografada = passwordEncoder.encode(senhaOriginal);

		System.out.println("Senha criptografada: " + senhaCriptografada);

		assertNotEquals(senhaOriginal, senhaCriptografada); // não pode ser igual
		assertTrue(passwordEncoder.matches(senhaOriginal, senhaCriptografada)); // deve validar corretamente
	}
}
