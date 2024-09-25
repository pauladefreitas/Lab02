package com.locadora.carjapa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.locadora.carjapa.models.Rendimento;

@Repository
public interface RendimentoRepository extends JpaRepository<Rendimento, Long>{

}