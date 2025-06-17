package com.someli.someli.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.someli.someli.dto.DespesaDTO;
import com.someli.someli.dto.DespesaFinanceiraDTO;
import com.someli.someli.model.Despesa;
import com.someli.someli.model.PagamentoDespesa;
import com.someli.someli.repository.DespesaRepository;
import com.someli.someli.repository.PagamentoDespesaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DespesaService {

	@Autowired
	private DespesaRepository despesaRepository;

	@Autowired
	private PagamentoDespesaRepository pagamentoDespesaRepository;

	public Despesa salvar(DespesaDTO dto) {
		Despesa despesa = new Despesa();
		despesa.setId(dto.getId());
		despesa.setDescricao(dto.getDescricao());
		despesa.setValorMensal(dto.getValorMensal());
		despesa.setTipoDespesa(dto.getTipo());
		despesa.setParcelas(dto.getParcelas());
		despesa.setDataInicio(dto.getDataInicio());
		despesa.setDiaPagamento(dto.getDiaPagamento());
		despesa.setAtivo(dto.getAtiva() != null ? dto.getAtiva() : true);
		return despesaRepository.save(despesa);
	}

	public List<DespesaDTO> listarTodos() {
		return despesaRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
	}

	public DespesaDTO buscarPorId(Long id) {
		return despesaRepository.findById(id).map(this::toDto)
				.orElseThrow(() -> new RuntimeException("Despesa não encontrada"));
	}

	public Despesa editar(Long id, DespesaDTO dto) {
		Despesa existente = despesaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Despesa não encontrada"));

		// Atualiza os campos
		existente.setDescricao(dto.getDescricao());
		existente.setValorMensal(dto.getValorMensal());
		existente.setTipoDespesa(dto.getTipo());
		existente.setParcelas(dto.getParcelas());
		existente.setDataInicio(dto.getDataInicio());
		existente.setDiaPagamento(dto.getDiaPagamento());
		existente.setAtivo(dto.getAtiva());

		return despesaRepository.save(existente);
	}

	public void inativar(Long id) {
		Despesa despesa = despesaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Despesa não encontrada"));
		despesa.setAtivo(false);
		despesaRepository.save(despesa);
	}

	private DespesaDTO toDto(Despesa d) {
		DespesaDTO dto = new DespesaDTO();
		dto.setId(d.getId());
		dto.setDescricao(d.getDescricao());
		dto.setValorMensal(d.getValorMensal());
		dto.setTipo(d.getTipoDespesa());
		dto.setParcelas(d.getParcelas());
		dto.setDiaPagamento(d.getDiaPagamento());
		dto.setDataInicio(d.getDataInicio());
		dto.setAtiva(d.getAtivo());
		return dto;
	}

	public List<DespesaFinanceiraDTO> buscarDespesasPorMesEAno(String mes, int ano) {
		int numeroMes = obterNumeroDoMes(mes);

		return despesaRepository.findAll().stream().filter(d -> {
			if (!Boolean.TRUE.equals(d.getAtivo()) && d.getTipoDespesa() != 3) {
				return false; // Apenas tipo 3 (Pessoal) pode ter histórico mesmo inativo
			}

			LocalDate dataInicio = d.getDataInicio();
			if (dataInicio == null)
				return false;

			int mesInicio = dataInicio.getMonthValue();
			int anoInicio = dataInicio.getYear();
			LocalDate dataReferencia = LocalDate.of(ano, numeroMes, 1);

			switch (d.getTipoDespesa()) {
			case 1: // Recorrente
				return !dataReferencia.isBefore(dataInicio.withDayOfMonth(1));

			case 2: // Pontual
				if (d.getParcelas() == null || d.getParcelas() <= 0)
					return false;
				LocalDate dataFim = dataInicio.plusMonths(d.getParcelas() - 1);
				return !dataReferencia.isBefore(dataInicio.withDayOfMonth(1))
						&& !dataReferencia.isAfter(dataFim.withDayOfMonth(1));

			case 3: // Pessoal
				if (Boolean.TRUE.equals(d.getAtivo())) {
					return !dataReferencia.isBefore(dataInicio.withDayOfMonth(1));
				} else {
					// se estiver inativo, só aparece se o mês atual for antes ou igual ao da
					// inativação
					return !dataReferencia.isAfter(dataInicio.withDayOfMonth(1));
				}

			default:
				return false;
			}
		}).map(d -> {
			boolean pago = pagamentoDespesaRepository.findByDespesaIdAndMesAndAno(d.getId(), mes, ano)
					.map(PagamentoDespesa::getPago).orElse(false);

			return new DespesaFinanceiraDTO(d.getId(), d.getDescricao(), d.getValorMensal(), d.getDataInicio(),d.getDiaPagamento(), pago);
		}).collect(Collectors.toList());
	}

	private int obterNumeroDoMes(String mes) {
		return switch (mes.toUpperCase()) {
		case "JAN" -> 1;
		case "FEV" -> 2;
		case "MAR" -> 3;
		case "ABR" -> 4;
		case "MAI" -> 5;
		case "JUN" -> 6;
		case "JUL" -> 7;
		case "AGO" -> 8;
		case "SET" -> 9;
		case "OUT" -> 10;
		case "NOV" -> 11;
		case "DEZ" -> 12;
		default -> throw new IllegalArgumentException("Mês inválido: " + mes);
		};
	}

	@Transactional
	public void atualizarStatusDespesaMensal(Long despesaId, String mes, int ano, Boolean pago) {
		Despesa despesa = despesaRepository.findById(despesaId)
				.orElseThrow(() -> new EntityNotFoundException("Despesa não encontrada"));

		PagamentoDespesa pagamento = pagamentoDespesaRepository.findByDespesaIdAndMesAndAno(despesaId, mes, ano)
				.orElseGet(() -> {
					PagamentoDespesa novo = new PagamentoDespesa();
					novo.setDespesa(despesa);
					novo.setMes(mes);
					novo.setAno(ano);
					novo.setValor(despesa.getValorMensal().doubleValue()); // ✅ conversão aqui
					return novo;
				});

		pagamento.setPago(pago);
		pagamentoDespesaRepository.save(pagamento);
	}

}