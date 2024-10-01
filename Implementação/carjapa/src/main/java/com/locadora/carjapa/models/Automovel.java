package com.locadora.carjapa.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = Automovel.TABLE_NAME)
@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Automovel {
    public static final String TABLE_NAME = "automovel";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "matricula", length = 100, nullable = false)
    @NotBlank
    private String matricula;

    @Column(name = "ano", length = 100, nullable = false)
    private int ano;

    @Column(name = "marca", length = 100, nullable = false)
    @NotBlank
    private String marca;

    @Column(name = "modelo", length = 100, nullable = false)
    @NotBlank
    private String modelo;

    @Column(name = "placa", length = 100, nullable = false)
    @NotBlank
    private String placa;

    @Column(name = "valorMensal", nullable = false)
    private double valorMensal;

}
