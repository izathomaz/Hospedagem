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

	public Optional<Hospede> buscarPorId(Long id) {
		return hospedeRepository.findById(id);
	}

	public Hospede salvar(Hospede hospede) {
		return hospedeRepository.save(hospede);
	}

	public Optional<Hospede> atualizar(Long id, Hospede hospede) {

		return hospedeRepository.findById(id).map(existente -> {
			hospede.setId(id);
			return hospedeRepository.save(hospede);
		});
	}

	public boolean deletar(Long id) {

		return hospedeRepository.findById(id).map(existente -> {
			hospedeRepository.deleteById(id);
			return true;
		}).orElse(false);
	}
}