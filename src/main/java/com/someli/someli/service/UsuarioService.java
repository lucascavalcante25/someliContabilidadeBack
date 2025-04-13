package com.someli.someli.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.someli.someli.dto.UsuarioDTO;
import com.someli.someli.model.Usuario;
import com.someli.someli.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public List<UsuarioDTO> listarTodos() {
        List<Usuario> entidades = usuarioRepository.findAll();

        return entidades.stream().map(usuario -> {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setId(usuario.getId());
            dto.setNome(usuario.getNome());
            dto.setCpf(usuario.getCpf());
            dto.setEmail(usuario.getEmail());
            dto.setPerfil(usuario.getPerfil()); // retorna apenas o número (1)
            return dto;
        }).collect(Collectors.toList());
    }


    public Usuario salvar(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setCpf(dto.getCpf());
        usuario.setEmail(dto.getEmail());
        usuario.setPerfil(dto.getPerfil());
        usuario.setSenha(passwordEncoder.encode(dto.getSenha())); // Criptografa a senha

        return usuarioRepository.save(usuario);
    }
}
