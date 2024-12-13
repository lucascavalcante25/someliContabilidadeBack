package com.someli.someli.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.someli.someli.dto.SintegraDTO;

@Service
public class SintegraService {

	private static final String API_URL = "https://api.infosimples.com/api/v2/consultas/sintegra/unificada";
	private static final String API_TOKEN = "Kst6NquxRVjb5A_c9nRyOkU3IasEIjKs1RBN2fkJ";

	public SintegraDTO consultarSintegra(String uf, String cnpj, String ie, String ieProdutor, String cpf)
			throws Exception {
		if (uf == null || uf.isEmpty()) {
			throw new IllegalArgumentException("UF é obrigatória para a consulta SINTEGRA.");
		}

		// Monta o payload para a requisição POST
		Map<String, String> payload = new HashMap<>();
		payload.put("token", API_TOKEN);
		payload.put("uf", uf);
		if (cnpj != null)
			payload.put("cnpj", cnpj);
		if (ie != null)
			payload.put("ie", ie);
		if (ieProdutor != null)
			payload.put("ie_produtor", ieProdutor);
		if (cpf != null)
			payload.put("cpf", cpf);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(payload, headers);

		try {
			RestTemplate restTemplate = new RestTemplate();

			ResponseEntity<String> response = restTemplate.postForEntity(API_URL, requestEntity, String.class);

			if (response.getStatusCode().is2xxSuccessful()) {
				ObjectMapper objectMapper = new ObjectMapper();
				return objectMapper.readValue(response.getBody(), SintegraDTO.class);
			} else {
				throw new RuntimeException("Erro ao consultar SINTEGRA: Código " + response.getStatusCode());
			}
		} catch (HttpClientErrorException e) {
			System.err.println("Erro na API Infosimples: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
			throw new RuntimeException("Erro na API Infosimples: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Erro inesperado: " + e.getMessage());
			throw e;
		}
	}
}
