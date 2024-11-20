package com.someli.someli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.someli.someli.dto.CnpjResponseDTO;
import com.someli.someli.service.CnpjService;

@RestController
@RequestMapping("/someli/consultaCNPJ")
public class CnpjController {

	@Autowired
	private CnpjService cnpjService;

	@GetMapping("/{cnpj}")
	public CnpjResponseDTO getCnpjDetails(@PathVariable String cnpj) {
		return cnpjService.getCnpjDetails(cnpj);
	}
}
