package com.someli.someli.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.someli.someli.dto.ClienteDTO;
import com.someli.someli.model.Cliente;
import com.someli.someli.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public ClienteDTO obterDadosClientePorId(Long id) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

		return converterParaDTO(cliente);
	}

	private ClienteDTO converterParaDTO(Cliente cliente) {
		ClienteDTO dto = new ClienteDTO();
		dto.setNome(cliente.getRazaoSocial());
		dto.setCnpj(cliente.getCnpj());
		dto.setEmail(cliente.getEmail());
		dto.setTelefone(cliente.getTelefone());
		dto.setHonorario(cliente.getValorHonorario());
		dto.setPagamento(cliente.getOrdemPagamento());
		dto.setVencimento(cliente.getDiaVencimento());
		return dto;
	}

	public List<ClienteDTO> listarTodos() {
		List<Cliente> listaDeClientes = clienteRepository.findAll();

		List<ClienteDTO> listaDeClientesDTO = new ArrayList<>();

		for (Cliente list : listaDeClientes) {

			ClienteDTO dto = new ClienteDTO();

			dto.setNome(list.getRazaoSocial());
			dto.setCnpj(list.getCnpj());
			dto.setEmail(list.getEmail());
			dto.setTelefone(list.getTelefone());
			dto.setNomeProprietario(list.getNomeProprietario());
			dto.setHonorario(list.getValorHonorario());
			dto.setPagamento(list.getOrdemPagamento());
			dto.setVencimento(list.getDiaVencimento());
			listaDeClientesDTO.add(dto);

		}

		return listaDeClientesDTO;
	}

	public Cliente salvarCliente(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();

		cliente.setCnpj(clienteDTO.getCnpj());
		cliente.setRazaoSocial(clienteDTO.getNome());
		cliente.setNomeProprietario(clienteDTO.getNomeProprietario());
		cliente.setTelefone(clienteDTO.getTelefone());
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setValorHonorario(clienteDTO.getHonorario());
		cliente.setDiaVencimento(clienteDTO.getVencimento());
		cliente.setOrdemPagamento(clienteDTO.getPagamento());

		return clienteRepository.save(cliente);
	}
}