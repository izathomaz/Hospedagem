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

import com.hospedagem.entity.Aposento;
import com.hospedagem.service.AposentoService;

@RestController
@RequestMapping("/aposentos")
public class AposentoController {

	private final AposentoService aposentoService;

	public AposentoController(AposentoService aposentoService) {
		this.aposentoService = aposentoService;
	}

	@GetMapping
	public ResponseEntity<List<Aposento>> listar() {
		return ResponseEntity.ok(aposentoService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aposento> buscar(@PathVariable Long id) {

		return aposentoService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Aposento> salvar(@RequestBody Aposento aposento) {

		return ResponseEntity.status(HttpStatus.CREATED).body(aposentoService.salvar(aposento));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Aposento> atualizar(@PathVariable Long id, @RequestBody Aposento aposento) {

		return aposentoService.atualizar(id, aposento).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {

		if (aposentoService.deletar(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
