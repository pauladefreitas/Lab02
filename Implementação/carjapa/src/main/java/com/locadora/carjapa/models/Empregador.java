package com.locadora.carjapa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = Empregador.TABLE_NAME)
@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Empregador {

    public static final String TABLE_NAME = "empregador";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    @NotBlank
    private String nome;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
