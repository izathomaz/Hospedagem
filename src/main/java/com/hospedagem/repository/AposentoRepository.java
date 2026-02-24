package com.hospedagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospedagem.entity.Aposento;

@Repository
public interface AposentoRepository extends JpaRepository<Aposento, Long> {

}