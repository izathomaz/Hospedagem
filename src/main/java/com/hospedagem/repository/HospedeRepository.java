package com.hospedagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospedagem.entity.Hospede;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Long> {

}