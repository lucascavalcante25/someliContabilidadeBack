package com.someli.someli.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.someli.someli.dto.ClienteFinanceiroDTO;
import com.someli.someli.repository.ClienteRepository;

@Service
public class FinanceiroService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteFinanceiroDTO> listarClientesAtivos() {
        return clienteRepository.findByAtivoTrue()
                .stream()
                .map(cliente -> {
                    ClienteFinanceiroDTO dto = new ClienteFinanceiroDTO();
                    dto.setClienteId(cliente.getId());
                    dto.setNome(cliente.getRazaoSocial());
                    dto.setPagamento(cliente.getOrdemPagamento());
                    dto.setVencimento(cliente.getDiaVencimento());
                    dto.setHonorario(cliente.getValorHonorario());
                    dto.setPago(false); // Assume false inicialmente, será ajustado no histórico
                    return dto;
                }).collect(Collectors.toList());
    }
}
