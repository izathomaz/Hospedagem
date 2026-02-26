package com.hospedagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hospedagem.entity.Aposento;
import com.hospedagem.repository.AposentoRepository;

@Service
public class AposentoService {

	private final AposentoRepository aposentoRepository;

	public AposentoService(AposentoRepository aposentoRepository) {
		this.aposentoRepository = aposentoRepository;
	}

	public List<Aposento> buscarTodos() {
		return aposentoRepository.findAll();
	}

	public Optional<Aposento> buscarPorId(Long id) {
		return aposentoRepository.findById(id);
	}

	public Aposento salvar(Aposento aposento) {
		return aposentoRepository.save(aposento);
	}

	public Optional<Aposento> atualizar(Long id, Aposento aposento) {

		return aposentoRepository.findById(id).map(existente -> {
			aposento.setId(id);
			return aposentoRepository.save(aposento);
		});
	}

	public boolean deletar(Long id) {

		return aposentoRepository.findById(id).map(existente -> {
			aposentoRepository.deleteById(id);
			return true;
		}).orElse(false);
	}
}