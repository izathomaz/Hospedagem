package com.hospedagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hospedagem.entity.Hospede;
import com.hospedagem.repository.HospedeRepository;

@Service
public class HospedeService {

	private final HospedeRepository hospedeRepository;

	public HospedeService(HospedeRepository hospedeRepository) {
		this.hospedeRepository = hospedeRepository;
	}

	public List<Hospede> buscarTodos() {
		return hospedeRepository.findAll();
	}

	public Hospede buscarPorId(Long id) {
		Optional<Hospede> hospede = hospedeRepository.findById(id);
		return hospede.orElse(null);
	}

	public Hospede salvar(Hospede hospede) {
		return hospedeRepository.save(hospede);
	}

	public Hospede atualizar(Long id, Hospede hospede) {
		Optional<Hospede> existente = hospedeRepository.findById(id);

		if (existente.isPresent()) {
			hospede.setId(id);
			return hospedeRepository.save(hospede);
		}
		return null;
	}

	public boolean deletar(Long id) {
		Optional<Hospede> existente = hospedeRepository.findById(id);

		if (existente.isPresent()) {
			hospedeRepository.deleteById(id);
			return true;
		}
		return false;
	}
}