package com.someli.someli.util;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	private final String SECRET = "MinhaChaveSecretaMuitoForteMesmoParaJwtCom256Bits!";

	private final long EXPIRATION = 8 * 60 * 60 * 1000; // 8 horas em milissegundos

	private Key getChave() {
		return Keys.hmacShaKeyFor(SECRET.getBytes());
	}

	public String gerarToken(String cpf) {
		return Jwts.builder().setSubject(cpf).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
				.signWith(getChave(), SignatureAlgorithm.HS256).compact();
	}

	public String getCpfDoToken(String token) {
		return Jwts.parserBuilder().setSigningKey(getChave()).build().parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validarToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(getChave()).build().parseClaimsJws(token);
			return true;
		} catch (JwtException e) {
			return false;
		}
	}
}
