package com.someli.someli.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.someli.someli.dto.DespesaDTO;
import com.someli.someli.dto.DespesaFinanceiraDTO;
import com.someli.someli.model.Despesa;
import com.someli.someli.repository.DespesaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DespesaService {

	@Autowired
	private DespesaRepository despesaRepository;

	public Despesa salvar(DespesaDTO dto) {
		Despesa despesa = new Despesa();
		despesa.setId(dto.getId());
		despesa.setDescricao(dto.getDescricao());
		despesa.setValorMensal(dto.getValorMensal());
		despesa.setTipoDespesa(dto.getTipo());
		despesa.setParcelas(dto.getParcelas());
		despesa.setDataInicio(dto.getDataInicio());
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
			if (!Boolean.TRUE.equals(d.getAtivo()))
				return false;

			LocalDate dataInicio = d.getDataInicio();
			if (dataInicio == null)
				return false;

			int mesInicio = dataInicio.getMonthValue();
			int anoInicio = dataInicio.getYear();

			switch (d.getTipoDespesa()) {
			case 1:
				return (ano > anoInicio) || (ano == anoInicio && numeroMes >= mesInicio);

			case 2:
				if (d.getParcelas() == null || d.getParcelas() <= 0)
					return false;
				int mesesDesdeInicio = (ano - anoInicio) * 12 + (numeroMes - mesInicio + 1);
				return mesesDesdeInicio >= 1 && mesesDesdeInicio <= d.getParcelas();

			case 3:
				return ano == anoInicio && numeroMes == mesInicio;

			default:
				return false;
			}
		}).map(d -> new DespesaFinanceiraDTO(d.getId(), d.getDescricao(), d.getValorMensal(), d.getDataInicio(),
				d.getPaga())).collect(Collectors.toList());
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
	public void atualizarStatusDespesa(Long id, boolean pago) {
		Despesa despesa = despesaRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Despesa não encontrada"));
		despesa.setPaga(pago);
		despesaRepository.save(despesa);
	}

}