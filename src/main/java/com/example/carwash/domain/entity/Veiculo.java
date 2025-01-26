package com.example.carwash.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID idVeiculo;

    @Column(name = "placa", length = 15, nullable = false)
    private String placa;

    @Column(name = "marca", length = 100, nullable = false)
    private String marca;

    @Column(name = "modelo", length = 100, nullable = false)
    private String modelo;

    @Column(name = "cor", length = 100, nullable = false)
    private String cor;

    @Column(name = "ano", nullable = false)
    private int ano;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Servico> servicos;
}
