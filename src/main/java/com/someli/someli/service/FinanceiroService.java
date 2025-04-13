package com.someli.someli.service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.someli.someli.dto.ClienteFinanceiroDTO;
import com.someli.someli.model.Cliente;
import com.someli.someli.model.PagamentoCliente;
import com.someli.someli.repository.ClienteRepository;
import com.someli.someli.repository.PagamentoClienteRepository;

@Service
public class FinanceiroService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PagamentoClienteRepository pagamentoClienteRepository;

	public List<ClienteFinanceiroDTO> buscarClientesAtivos() {
		return clienteRepository.findByAtivoTrue().stream().map(cliente -> {
			ClienteFinanceiroDTO dto = new ClienteFinanceiroDTO();
			dto.setClienteId(cliente.getId());
			dto.setNome(cliente.getRazaoSocial());
			dto.setPagamento(cliente.getOrdemPagamento());
			dto.setVencimento(cliente.getDiaVencimento());
			dto.setHonorario(cliente.getValorHonorario());
			dto.setPago(false);
			return dto;
		}).collect(Collectors.toList());
	}

	public List<ClienteFinanceiroDTO> buscarClientesFinanceiros(String mes, Integer ano) {
		List<PagamentoCliente> pagamentos = pagamentoClienteRepository.findByMesAndAno(mes, ano);
		Map<Long, PagamentoCliente> mapaPagamentos = pagamentos.stream()
				.collect(Collectors.toMap(p -> p.getCliente().getId(), Function.identity()));

		return clienteRepository.findByAtivoTrue().stream().map(cliente -> {
			PagamentoCliente pagamento = mapaPagamentos.get(cliente.getId());

			ClienteFinanceiroDTO dto = new ClienteFinanceiroDTO();
			dto.setClienteId(cliente.getId());
			dto.setNome(cliente.getRazaoSocial());
			dto.setPagamento(cliente.getOrdemPagamento());
			dto.setVencimento(cliente.getDiaVencimento());
			dto.setHonorario(cliente.getValorHonorario());

			if (pagamento != null) {
				dto.setId(pagamento.getId());
				dto.setPago(Boolean.TRUE.equals(pagamento.getPago()));
			} else {
				dto.setId(null);
				dto.setPago(false);
			}

			return dto;
		}).collect(Collectors.toList());
	}

	@Transactional
	public void atualizarPagamentoCliente(Long clienteId, Boolean pago, String mes, Integer ano) {
		PagamentoCliente pagamento = pagamentoClienteRepository.findByClienteIdAndMesAndAno(clienteId, mes, ano)
				.orElse(null);

		if (pagamento == null) {
			Cliente cliente = clienteRepository.findById(clienteId)
					.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

			pagamento = new PagamentoCliente();
			pagamento.setCliente(cliente);
			pagamento.setMes(mes);
			pagamento.setAno(ano);
			pagamento.setPago(pago);
			pagamento.setDiaVencimento(cliente.getDiaVencimento());
			pagamento.setValor(cliente.getValorHonorario());
			pagamento.setTipoPagamento("P");

			pagamentoClienteRepository.save(pagamento);
		} else {
			pagamento.setPago(pago);
			pagamentoClienteRepository.save(pagamento);
		}
	}
}
