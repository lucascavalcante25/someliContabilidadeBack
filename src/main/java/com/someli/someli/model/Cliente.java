package com.someli.someli.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE", schema = "PUBLIC")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_cliente")
	@SequenceGenerator(sequenceName = "public.sq_cliente", name = "sq_cliente", allocationSize = 0)
	@Column(name = "ID")
	private Long id;

	@Column(name = "CNPJ")
	private String cnpj;

	@Column(name = "RAZAO_SOCIAL")
	private String razaoSocial;

	@Column(name = "NOME_PROPRIETARIO")
	private String nomeProprietario;

	@Column(name = "TELEFONE")
	private String telefone;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "VALOR_HONORARIO")
	private Double valorHonorario;

	@Column(name = "DIA_VENCIMENTO")
	private Long diaVencimento;

	@Column(name = "ORDEM_PAGAMENTO")
	private Long ordemPagamento;
	
	@Column(name = "ATIVO")
	private Boolean ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getValorHonorario() {
		return valorHonorario;
	}

	public void setValorHonorario(Double valorHonorario) {
		this.valorHonorario = valorHonorario;
	}

	public Long getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(Long diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	public Long getOrdemPagamento() {
		return ordemPagamento;
	}

	public void setOrdemPagamento(Long ordemPagamento) {
		this.ordemPagamento = ordemPagamento;
	}

	
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ativo, cnpj, diaVencimento, email, id, nomeProprietario, ordemPagamento, razaoSocial,
				telefone, valorHonorario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(ativo, other.ativo) && Objects.equals(cnpj, other.cnpj)
				&& Objects.equals(diaVencimento, other.diaVencimento) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(nomeProprietario, other.nomeProprietario)
				&& Objects.equals(ordemPagamento, other.ordemPagamento)
				&& Objects.equals(razaoSocial, other.razaoSocial) && Objects.equals(telefone, other.telefone)
				&& Objects.equals(valorHonorario, other.valorHonorario);
	}

}