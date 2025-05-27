package com.someli.someli.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "DESPESA", schema = "PUBLIC")
public class Despesa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_despesa")
	@SequenceGenerator(name = "sq_despesa", sequenceName = "public.sq_despesa", allocationSize = 0)
	@Column(name = "ID")
	private Long id;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "VALOR_MENSAL")
	private BigDecimal valorMensal;

	@Column(name = "TIPO_DESPESA")
	private Integer tipoDespesa;

	@Column(name = "PARCELAS")
	private Integer parcelas;

	@Column(name = "DATA_INICIO")
	private LocalDate dataInicio;

	@Column(name = "DIA_PAGAMENTO")
	private Integer diaPagamento;

	@Column(name = "ATIVO")
	private Boolean ativo;

	@Column(name = "PAGA")
	private Boolean paga;

	public Boolean getPaga() {
		return paga;
	}

	public void setPaga(Boolean paga) {
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

	public Integer getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(Integer tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getDiaPagamento() {
		return diaPagamento;
	}

	public void setDiaPagamento(Integer diaPagamento) {
		this.diaPagamento = diaPagamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ativo, dataInicio, descricao, diaPagamento, id, paga, parcelas, tipoDespesa, valorMensal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Despesa other = (Despesa) obj;
		return Objects.equals(ativo, other.ativo) && Objects.equals(dataInicio, other.dataInicio)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(diaPagamento, other.diaPagamento)
				&& Objects.equals(id, other.id) && Objects.equals(paga, other.paga)
				&& Objects.equals(parcelas, other.parcelas) && Objects.equals(tipoDespesa, other.tipoDespesa)
				&& Objects.equals(valorMensal, other.valorMensal);
	}

}
