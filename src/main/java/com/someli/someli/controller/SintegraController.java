package com.someli.someli.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.someli.someli.dto.SintegraDTO;
import com.someli.someli.request.SintegraRequest;
import com.someli.someli.service.SintegraService;

@RestController
@RequestMapping("/someli/api/sintegra")
@CrossOrigin(origins = "https://localhost:4200", allowedHeaders = "*", methods = { RequestMethod.GET,
		RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class SintegraController {

	private final SintegraService sintegraService;

	public SintegraController(SintegraService sintegraService) {
		this.sintegraService = sintegraService;
	}

	@PostMapping("/consulta")
	public ResponseEntity<SintegraDTO> consultarSintegra(@RequestBody SintegraRequest request) {
		try {
			SintegraDTO sintegraDTO = sintegraService.consultarSintegra(request.getUf(), request.getCnpj(),
					request.getIe(), request.getIeProdutor(), request.getCpf());

			// 🔥 Se houver erro, retorna o código e a mensagem de erro
			if (sintegraDTO.getCode() != 200) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sintegraDTO);
			}

			return ResponseEntity.ok(sintegraDTO);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(new SintegraDTO(400, e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new SintegraDTO(500, "Erro interno ao consultar o Sintegra."));
		}
	}

}
