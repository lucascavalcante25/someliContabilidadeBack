package com.someli.someli.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "PAGAMENTO_CLIENTE", schema = "PUBLIC")
public class PagamentoCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_pagamento_cliente")
	@SequenceGenerator(sequenceName = "public.sq_pagamento_cliente", name = "sq_pagamento_cliente", allocationSize = 1)
	@Column(name = "ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENTE_ID")
	private Cliente cliente;

	@Column(name = "MES")
	private String mes; // Exemplo: "JAN", "FEV", "MAR"...

	@Column(name = "PAGO")
	private Boolean pago;

	@Column(name = "DIA_VENCIMENTO")
	private Long diaVencimento;

	@Column(name = "VALOR")
	private Double valor;

	@Column(name = "TIPO_PAGAMENTO")
	private String tipoPagamento; // Ex: "P", "K", "S"

	@Column(name = "ANO")
	private Integer ano;

	// Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}

	public Long getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(Long diaVencimento) {
		this.diaVencimento = diaVencimento;
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

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ano, cliente, diaVencimento, id, mes, pago, tipoPagamento, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PagamentoCliente other = (PagamentoCliente) obj;
		return Objects.equals(ano, other.ano) && Objects.equals(cliente, other.cliente)
				&& Objects.equals(diaVencimento, other.diaVencimento) && Objects.equals(id, other.id)
				&& Objects.equals(mes, other.mes) && Objects.equals(pago, other.pago)
				&& Objects.equals(tipoPagamento, other.tipoPagamento) && Objects.equals(valor, other.valor);
	}

}
