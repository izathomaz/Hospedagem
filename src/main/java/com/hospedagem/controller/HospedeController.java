package com.hospedagem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospedagem.entity.Hospede;
import com.hospedagem.service.HospedeService;

@RestController
@RequestMapping("/hospedes")
public class HospedeController {

	private final HospedeService hospedeService;

	public HospedeController(HospedeService hospedeService) {
		this.hospedeService = hospedeService;
	}

	@GetMapping
	public ResponseEntity<List<Hospede>> listar() {
		return ResponseEntity.ok(hospedeService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Hospede> buscar(@PathVariable Long id) {

		return hospedeService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Hospede> salvar(@RequestBody Hospede hospede) {

		return ResponseEntity.status(HttpStatus.CREATED).body(hospedeService.salvar(hospede));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Hospede> atualizar(@PathVariable Long id, @RequestBody Hospede hospede) {

		return hospedeService.atualizar(id, hospede).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {

		if (hospedeService.deletar(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}