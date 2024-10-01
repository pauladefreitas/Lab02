package com.locadora.carjapa.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = PedidoAluguel.TABLE_NAME)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoAluguel {
    public static final String TABLE_NAME = "pedidoAluguel";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status", length = 100, nullable = false)
    @NotBlank
    private String status;

    @Column(name = "periodoContrato", length = 100, nullable = false)
    private int periodoContrato;

    @Column(name = "opcaoCompra", length = 100, nullable = false)
    @NotNull
    private boolean opcaoCompra;

    @Column(name = "dataInicio")
    private LocalDate dataInicio;
    
    @Column(name = "credito", length = 100, nullable = false)
    @NotNull
    private boolean credito;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "automovel_id", nullable = false)
    private Automovel automovel;

    @OneToOne
    @JoinColumn(name = "contrato_id", nullable = false)
    private Contrato contrato;
}
