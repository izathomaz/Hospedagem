package com.hospedagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hospedagem.entity.Funcionario;
import com.hospedagem.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	private final FuncionarioRepository funcionarioRepository;

	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public List<Funcionario> buscarTodos() {
		return funcionarioRepository.findAll();
	}

	public Funcionario buscarPorId(Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		return funcionario.orElse(null);
	}

	public Funcionario salvar(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public Funcionario atualizar(Long id, Funcionario funcionario) {
		Optional<Funcionario> existente = funcionarioRepository.findById(id);

		if (existente.isPresent()) {
			funcionario.setId(id);
			return funcionarioRepository.save(funcionario);
		}
		return null;
	}

	public boolean deletar(Long id) {
		Optional<Funcionario> existente = funcionarioRepository.findById(id);

		if (existente.isPresent()) {
			funcionarioRepository.deleteById(id);
			return true;
		}
		return false;
	}
}