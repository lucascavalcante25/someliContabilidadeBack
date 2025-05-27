package com.someli.someli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.someli.someli.dto.DespesaDTO;
import com.someli.someli.model.Despesa;
import com.someli.someli.service.DespesaService;

@RestController
@RequestMapping("/api/despesas")
public class DespesaController {

	@Autowired
	private DespesaService despesaService;

	@PostMapping
	public ResponseEntity<Despesa> salvar(@RequestBody DespesaDTO dto) {
		return ResponseEntity.ok(despesaService.salvar(dto));
	}

	@GetMapping
	public ResponseEntity<List<DespesaDTO>> listarTodos() {
		return ResponseEntity.ok(despesaService.listarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<DespesaDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(despesaService.buscarPorId(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Despesa> editar(@PathVariable Long id, @RequestBody DespesaDTO dto) {
	    return ResponseEntity.ok(despesaService.editar(id, dto));
	}


	@PatchMapping("/{id}/inativar")
	public ResponseEntity<Void> inativar(@PathVariable Long id) {
		despesaService.inativar(id);
		return ResponseEntity.noContent().build();
	}
}