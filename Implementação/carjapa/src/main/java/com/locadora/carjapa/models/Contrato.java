package com.locadora.carjapa.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = Contrato.TABLE_NAME)
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrato {
    public static final String TABLE_NAME = "contrato";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private PedidoAluguel pedido;

    @Column(name = "valor")
    @NotNull
    private double valor;

    @Column(name = "dataFim")
    private LocalDate dataFim;
}
