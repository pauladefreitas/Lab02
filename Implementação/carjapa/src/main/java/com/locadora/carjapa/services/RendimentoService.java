package com.locadora.carjapa.services;

import java.util.Optional;

import com.locadora.carjapa.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locadora.carjapa.models.Rendimento;
import com.locadora.carjapa.repositories.RendimentoRepository;

import jakarta.transaction.Transactional;

@Service
public class RendimentoService {

    @Autowired
    private RendimentoRepository rendimentoRepository;

    @Autowired
    private UserService userService;

    public Rendimento findById(Long id) {
        Optional<Rendimento> Rendimento = this.rendimentoRepository.findById(id);
        return Rendimento.orElseThrow(() -> new RuntimeException(
                "Usuário não encontrado! Id: " + id + ", Tipo: " + Rendimento.class.getName()));
    }

    @Transactional
    public Rendimento create(Rendimento obj) {
        if (obj.getUser() != null && obj.getUser().getId() != null) {
            User user = this.userService.findById(obj.getUser().getId());
            obj.setUser(user);
        } else {
            throw new RuntimeException("User não encontrado.");
        }

        obj.setId(null);
        obj.setDescricao(obj.getDescricao());
        obj.setValor(obj.getValor());
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
