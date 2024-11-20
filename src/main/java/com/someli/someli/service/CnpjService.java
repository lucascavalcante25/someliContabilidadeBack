package com.someli.someli.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.someli.someli.dto.CnpjResponseDTO;

@Service
public class CnpjService {

    @Value("${receitaws.api.url}")
    private String apiUrl;

    public CnpjResponseDTO getCnpjDetails(String cnpj) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + cnpj;

        return restTemplate.getForObject(url, CnpjResponseDTO.class);
    }
}
