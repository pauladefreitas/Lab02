package com.locadora.carjapa.services;

import java.util.Optional;

import com.locadora.carjapa.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locadora.carjapa.models.Empregador;
import com.locadora.carjapa.repositories.EmpregadorRepository;

import jakarta.transaction.Transactional;

@Service
public class EmpregadorService {

    @Autowired
    private EmpregadorRepository empregadorRepository;

    @Autowired
    private UserService userService;

    public Empregador findById(Long id) {
        Optional<Empregador> empregador = this.empregadorRepository.findById(id);
        return empregador.orElseThrow(() -> new RuntimeException(
                "Usuário não encontrado! Id: " + id + ", Tipo: " + Empregador.class.getName()));
    }

    @Transactional
    public Empregador create(Empregador obj) {
        User user = this.userService.findById(obj.getUser().getId());
        obj.setId(null);
        obj.setNome(obj.getNome());
        obj.setUser(user);
        obj = this.empregadorRepository.save(obj);
        return obj;
    }

    @Transactional
    public Empregador update(Empregador obj) {
        Empregador newObj = findById(obj.getId());
        newObj.setNome(obj.getNome());
        return this.empregadorRepository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            this.empregadorRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}
