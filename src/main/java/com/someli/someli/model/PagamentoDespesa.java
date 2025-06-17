package com.someli.someli.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//Entidade equivalente a PagamentoCliente para despesas
@Entity
@Table(name = "PAGAMENTO_DESPESA", schema = "PUBLIC")
public class PagamentoDespesa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_pagamento_despesa")
	@SequenceGenerator(sequenceName = "public.sq_pagamento_despesa", name = "sq_pagamento_despesa", allocationSize = 1)
	@Column(name = "ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DESPESA_ID")
	private Despesa despesa;

	@Column(name = "MES")
	private String mes; // Exemplo: "JAN", "FEV", "MAR"...

	@Column(name = "ANO")
	private Integer ano;

	@Column(name = "PAGO")
	private Boolean pago;

	@Column(name = "VALOR")
	private Double valor;

	@Column(name = "TIPO_PAGAMENTO")
	private String tipoPagamento;

	// Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Despesa getDespesa() {
		return despesa;
	}

	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
}
