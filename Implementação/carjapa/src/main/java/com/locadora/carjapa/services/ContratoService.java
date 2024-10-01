package com.locadora.carjapa.services;

import com.locadora.carjapa.models.Contrato;
import com.locadora.carjapa.repositories.ContratoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ContratoService {
    @Autowired
    private ContratoRepository contratoRepository;

    public Contrato findById(Long id) {
        Optional<Contrato> contrato = this.contratoRepository.findById(id);
        return contrato.orElseThrow(() -> new RuntimeException(
                "Usuário não encontrado! Id: " + id + ", Tipo: " + Contrato.class.getName()));
    }

    @Transactional
    public Contrato create(Contrato obj) {
        obj.setId(null);
        setContratoDatas(obj);
        obj = this.contratoRepository.save(obj);
        return obj;
    }

    private void setContratoDatas(Contrato contrato) {
        if (contrato.getPedido() != null) {
            contrato.getPedido().setDataInicio(LocalDate.now());
            contrato.setDataFim(contrato.getPedido().getDataInicio()
                    .plusMonths(contrato.getPedido().getPeriodoContrato()));
        } else {
            throw new IllegalArgumentException("Pedido de Aluguel não pode ser nulo ao criar um contrato.");
        }
    }

    @Transactional
    public Contrato update(Contrato obj) {
        Contrato newObj = findById(obj.getId());
        return this.contratoRepository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            this.contratoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}
