package com.locadora.carjapa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locadora.carjapa.models.Rendimento;
import com.locadora.carjapa.repositories.RendimentoRepository;

import jakarta.transaction.Transactional;

@Service
public class RendimentoService {

    @Autowired
    private RendimentoRepository rendimentoRepository;

    public Rendimento findById(Long id) {
        Optional<Rendimento> Rendimento = this.rendimentoRepository.findById(id);
        return Rendimento.orElseThrow(() -> new RuntimeException(
                "Usuário não encontrado! Id: " + id + ", Tipo: " + Rendimento.class.getName()));
    }

    @Transactional
    public Rendimento create(Rendimento obj) {
        obj.setId(null);
        obj.setDescricao(obj.getDescricao());
        obj.setValor(obj.getValor());
        obj.setUser(obj.getUser());
        obj = this.rendimentoRepository.save(obj);
        return obj;
    }

    @Transactional
    public Rendimento update(Rendimento obj) {
        Rendimento newObj = findById(obj.getId());
        newObj.setDescricao(obj.getDescricao());
        newObj.setValor(newObj.getValor());
        return this.rendimentoRepository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            this.rendimentoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}
