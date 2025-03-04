package com.example.carwash.controllers;

import com.example.carwash.domain.entity.Cliente;
import com.example.carwash.domain.repositories.ClienteRepository;
import com.example.carwash.dtos.LoginRequestDTO;
import com.example.carwash.dtos.RegisterRequestDTO;
import com.example.carwash.infra.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final ClienteRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody LoginRequestDTO body) {
        Cliente cliente = this.repository.findByEmail(body.email())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (passwordEncoder.matches(body.password(), cliente.getSenha())) {
            String token = tokenService.generateToken(cliente);
            return ResponseEntity.ok(new LoginRequestDTO(cliente.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register (@RequestBody RegisterRequestDTO body) {
        Optional<Cliente> cliente = this.repository.findByEmail(body.email());

        if (cliente.isEmpty()) {
            Cliente newCliente = new Cliente();
            newCliente.setNome(body.name());
            newCliente.setEmail(body.email());
            newCliente.setSenha(passwordEncoder.encode(body.password()));
            this.repository.save(newCliente);

            String token = tokenService.generateToken(newCliente);
            return ResponseEntity.ok(new LoginRequestDTO(newCliente.getNome(), token));
        }
            return ResponseEntity.badRequest().build();
        }
}
