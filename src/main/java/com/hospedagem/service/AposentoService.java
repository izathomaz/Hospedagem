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

	public Aposento buscarPorId(Long id) {
		Optional<Aposento> aposento = aposentoRepository.findById(id);
		return aposento.orElse(null);
	}

	public Aposento salvar(Aposento aposento) {
		return aposentoRepository.save(aposento);
	}

	public Aposento atualizar(Long id, Aposento aposento) {
		Optional<Aposento> existente = aposentoRepository.findById(id);

		if (existente.isPresent()) {
			aposento.setId(id);
			return aposentoRepository.save(aposento);
		}
		return null;
	}

	public boolean deletar(Long id) {
		Optional<Aposento> existente = aposentoRepository.findById(id);

		if (existente.isPresent()) {
			aposentoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}