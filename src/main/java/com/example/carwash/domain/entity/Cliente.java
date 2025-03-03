package com.example.carwash.domain.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID idCliente;

    @Column(name = "nome", length = 256, nullable = false)
    private String nome;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "endereco", length = 256)
    private String endereco;

    @Column(name = "email", length = 256, nullable = false)
    private String email;

    @Column(name = "senha", length = 256, nullable = false)
    private String senha;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Veiculo> veiculos;
}
