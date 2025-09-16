package com.example.meu_primeiro_springbootapplication.Services;

import com.example.meu_primeiro_springbootapplication.Model.Usuario;
import com.example.meu_primeiro_springbootapplication.Repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Usuario registraUsuario(String username, String password){
        String senhaCriptografada = passwordEncoder.encode(password);
        return usuarioRepository.save(new Usuario(username, senhaCriptografada));
    }

    public Optional<Usuario> buscarPorUsername(String usernarme){
        return usuarioRepository.findByUsername(usernarme);
    }
}
