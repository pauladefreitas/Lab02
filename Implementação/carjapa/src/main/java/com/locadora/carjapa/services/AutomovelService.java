package com.locadora.carjapa.services;

import com.locadora.carjapa.models.Automovel;
import com.locadora.carjapa.repositories.AutomovelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutomovelService {

    @Autowired
    private AutomovelRepository automovelRepository;

    public Automovel findById(Long id) {
        Optional<Automovel> automovel = this.automovelRepository.findById(id);
        return automovel.orElseThrow(() -> new RuntimeException(
                "Usuário não encontrado! Id: " + id + ", Tipo: " + Automovel.class.getName()));
    }

    @Transactional
    public Automovel create(Automovel obj) {
        obj.setId(null);
        obj = this.automovelRepository.save(obj);
        return obj;
    }

    @Transactional
    public Automovel update(Automovel obj) {
        Automovel newObj = findById(obj.getId());
        return this.automovelRepository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            this.automovelRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}
