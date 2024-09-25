package com.locadora.carjapa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.locadora.carjapa.models.Empregador;

@Repository
public interface EmpregadorRepository extends JpaRepository<Empregador, Long>{

}