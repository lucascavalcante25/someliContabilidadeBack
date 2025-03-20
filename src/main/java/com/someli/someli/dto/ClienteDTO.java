package com.someli.someli.dto;

public class ClienteDTO {
	private Long clienteId;
	private String cnpj;
	private String nome; 
	private String nomeProprietario; 
	private String telefone;
	private String email;
	private Double honorario;
	private Long vencimento;
	private Long pagamento;

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Double getHonorario() {
		return honorario;
	}

	public void setHonorario(Double honorario) {
		this.honorario = honorario;
	}

	public Long getVencimento() {
		return vencimento;
	}

	public void setVencimento(Long vencimento) {
		this.vencimento = vencimento;
	}

	public Long getPagamento() {
		return pagamento;
	}

	public void setPagamento(Long pagamento) {
		this.pagamento = pagamento;
	}

}
