package com.someli.someli.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DespesaFinanceiraDTO {
    private Long id;
    private String descricao;
    private BigDecimal valorMensal;
    private LocalDate dataInicio;
    private Boolean paga;
    
    

    // ✅ Construtor necessário para o map
    public DespesaFinanceiraDTO(Long id, String descricao, BigDecimal valorMensal, LocalDate dataInicio, Boolean paga) {
        this.id = id;
        this.descricao = descricao;
        this.valorMensal = valorMensal;
        this.dataInicio = dataInicio;
        this.paga = paga;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(BigDecimal valorMensal) {
		this.valorMensal = valorMensal;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Boolean getPaga() {
		return paga;
	}

	public void setPaga(Boolean paga) {
		this.paga = paga;
	}

    
    
}
