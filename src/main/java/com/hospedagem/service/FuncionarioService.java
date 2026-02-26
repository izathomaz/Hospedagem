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

	public Optional<Funcionario> buscarPorId(Long id) {
		return funcionarioRepository.findById(id);
	}

	public Funcionario salvar(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public Optional<Funcionario> atualizar(Long id, Funcionario funcionario) {

		return funcionarioRepository.findById(id).map(existente -> {
			funcionario.setId(id);
			return funcionarioRepository.save(funcionario);
		});
	}

	public boolean deletar(Long id) {

		return funcionarioRepository.findById(id).map(existente -> {
			funcionarioRepository.deleteById(id);
			return true;
		}).orElse(false);
	}
}