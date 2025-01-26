package com.example.carwash.domain.entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "servicos")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idServico;

    @Column(name = "tipo_servico", length = 120, nullable = false)
    private String tipoServico;

    @Column(name = "preco", length = 50, nullable = false)
    private double preco;

    @CreationTimestamp
    @Column(name = "data_servico", nullable = false)
    private Date dataServico;

    @CreationTimestamp
    @Column(name = "data_entrega", nullable = false)
    private Date dataEntrega;

    @Column(name = "observacao", length = 256)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;
}
