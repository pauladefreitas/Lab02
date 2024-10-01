package com.locadora.carjapa.services;

import com.locadora.carjapa.exception.PeriodoContratoInvalidoException;
import com.locadora.carjapa.models.Contrato;
import com.locadora.carjapa.models.PedidoAluguel;
import com.locadora.carjapa.models.User;
import com.locadora.carjapa.repositories.ContratoRepository;
import com.locadora.carjapa.repositories.PedidoAluguelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PedidoAluguelService {
    @Autowired
    private PedidoAluguelRepository pedidoAluguelRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ContratoRepository contratoRepository;
    @Autowired
    private ContratoService contratoService;

    public PedidoAluguel findById(Long id) {
        Optional<PedidoAluguel> pedidoAluguel = this.pedidoAluguelRepository.findById(id);
        return pedidoAluguel.orElseThrow(() -> new RuntimeException(
                "Usuário não encontrado! Id: " + id + ", Tipo: " + PedidoAluguel.class.getName()));
    }

    @Transactional
    public PedidoAluguel create(PedidoAluguel obj) {
        User user = this.userService.findById(obj.getUser().getId());
        obj.setId(null);
        obj.setUser(user);
        obj.setDataInicio(LocalDate.now());

        validarPeriodoContrato(obj.getPeriodoContrato());

        Contrato contrato = new Contrato();
        contrato.setPedido(obj);
        contrato.setValor(10.00);
        contrato = this.contratoService.create(contrato);

        obj.setContrato(contrato);
        obj = this.pedidoAluguelRepository.save(obj);

        return obj;
    }

    private void validarPeriodoContrato(int periodoContrato) {
        if (periodoContrato != 12 && periodoContrato != 24 && periodoContrato != 36 && periodoContrato != 48) {
            throw new PeriodoContratoInvalidoException("O período do contrato deve ser 12, 24, 36 ou 48 meses.");
        }
    }

    @Transactional
    public PedidoAluguel update(PedidoAluguel obj) {
        PedidoAluguel newObj = findById(obj.getId());
        return this.pedidoAluguelRepository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            this.pedidoAluguelRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}
