package com.someli.someli.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.someli.someli.dto.ClienteComPagamentoDTO;
import com.someli.someli.dto.ClienteFinanceiroDTO;
import com.someli.someli.dto.PagamentoClienteSaveDTO;
import com.someli.someli.model.Cliente;
import com.someli.someli.model.PagamentoCliente;
import com.someli.someli.repository.ClienteRepository;
import com.someli.someli.repository.PagamentoClienteRepository;
import com.someli.someli.service.FinanceiroService;

@RestController
@RequestMapping("/api/financeiro")
@CrossOrigin(origins = "https://localhost:4200", allowedHeaders = "*", methods = { RequestMethod.GET,
		RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class FinanceiroController {

	@Autowired
	private FinanceiroService financeiroService;

	@Autowired
	private PagamentoClienteRepository pagamentoClienteRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/clientes")
	public List<ClienteFinanceiroDTO> listarClientesAtivos() {
		return financeiroService.listarClientesAtivos();
	}

	@PostMapping("/pagamentos")
	public ResponseEntity<?> salvarPagamentos(@RequestBody List<PagamentoClienteSaveDTO> pagamentos) {
		for (PagamentoClienteSaveDTO dto : pagamentos) {
			System.out.println("Recebido pagamento: ClienteID=" + dto.getClienteId() + ", Mês=" + dto.getMes()
					+ ", Ano=" + dto.getAno() + ", Pago=" + dto.getPago());

			Cliente cliente = clienteRepository.findById(dto.getClienteId())
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

			List<PagamentoCliente> existentes = pagamentoClienteRepository
					.findByClienteIdAndMesAndAno(dto.getClienteId(), dto.getMes(), dto.getAno());

			PagamentoCliente pagamento = existentes.isEmpty() ? new PagamentoCliente() : existentes.get(0);

			pagamento.setCliente(cliente);
			pagamento.setMes(dto.getMes());
			pagamento.setAno(dto.getAno());
			pagamento.setPago(dto.getPago()); // <-- valor do checkbox
			pagamento.setValor(Double.valueOf(cliente.getValorHonorario()));
			pagamento.setDiaVencimento(cliente.getDiaVencimento());
			pagamento.setTipoPagamento(cliente.getOrdemPagamento().toString());

			pagamentoClienteRepository.save(pagamento);
		}

		return ResponseEntity.ok("Pagamentos salvos com sucesso");
	}

	@GetMapping("/clientes-com-pagamento")
	public List<ClienteComPagamentoDTO> listarClientesComPagamentos(@RequestParam String mes, @RequestParam int ano) {

		List<Cliente> clientes = clienteRepository.findByAtivoTrue();

		return clientes.stream().map(cliente -> {
			ClienteComPagamentoDTO dto = new ClienteComPagamentoDTO(cliente);

			pagamentoClienteRepository.findByClienteIdAndMesAndAno(cliente.getId(), mes, ano).stream().findFirst()
					.ifPresent(p -> dto.setPago(p.getPago()));

			return dto;
		}).collect(Collectors.toList());
	}

}
