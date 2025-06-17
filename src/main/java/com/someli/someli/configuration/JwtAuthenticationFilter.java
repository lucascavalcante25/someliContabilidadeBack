package com.someli.someli.configuration;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.someli.someli.repository.UsuarioRepository;
import com.someli.someli.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtUtil jwtUtil;
	private final UsuarioRepository usuarioRepository;

	public JwtAuthenticationFilter(JwtUtil jwtUtil, UsuarioRepository usuarioRepository) {
		this.jwtUtil = jwtUtil;
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String authHeader = request.getHeader("Authorization");

		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}

		String token = authHeader.substring(7); // remove "Bearer "

		try {
			String cpf = jwtUtil.getCpfDoToken(token);

			if (cpf != null && jwtUtil.validarToken(token)
					&& SecurityContextHolder.getContext().getAuthentication() == null) {

				var usuario = usuarioRepository.findByCpf(cpf).orElse(null);

				if (usuario != null) {
					UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(usuario, null,
							List.of());

					auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(auth);
				}
			}

		} catch (io.jsonwebtoken.ExpiredJwtException e) {
			System.out.println("Token expirado: " + e.getMessage());
			// Você pode logar aqui ou apenas ignorar — a requisição seguirá sem
			// autenticação
		} catch (Exception e) {
			System.out.println("Erro ao processar token JWT: " + e.getMessage());
		}

		filterChain.doFilter(request, response);
	}

}
