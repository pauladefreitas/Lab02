package com.locadora.carjapa.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = User.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    public static final String TABLE_NAME = "user";

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 100, nullable = false, unique = true)
    private String username;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @Column(name = "rg", length = 20, nullable = false)
    @NotBlank
    private String rg;

    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    @NotBlank
    private String cpf;

    @Column(name = "nome", length = 100, nullable = false)
    @NotBlank
    private String nome;

    @Column(name = "endereco", length = 255, nullable = false)
    @NotBlank
    private String endereco;

    @Column(name = "profissao", length = 100)
    private String profissao;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Empregador> empregadores;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rendimento> rendimentos;

    public void addEmpregador(Empregador empregador) {
        if (this.empregadores == null) {
            this.empregadores = new ArrayList<>();
        }
        empregador.setUser(this);
        this.empregadores.add(empregador);
    }

    public void addRendimento(Rendimento rendimento) {
        if (this.rendimentos == null) {
            this.rendimentos = new ArrayList<>();
        }
        if (this.rendimentos.size() < 3) {
            rendimento.setUser(this);
            this.rendimentos.add(rendimento);
        } else {
            throw new IllegalStateException("O usuário já possui o máximo de 3 rendimentos.");
        }
    }
}
