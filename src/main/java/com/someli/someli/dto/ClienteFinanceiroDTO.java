package com.someli.someli.dto;

public class ClienteFinanceiroDTO {
    private Long id; // <-- ID do PagamentoCliente
    private Long clienteId;
    private String nome;
    private Long pagamento;
    private Long vencimento;
    private Double honorario;
    private Boolean pago;
    // getters e setters

	public Long getClienteId() {
		return clienteId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getPagamento() {
		return pagamento;
	}

	public void setPagamento(Long pagamento) {
		this.pagamento = pagamento;
	}

	public Long getVencimento() {
		return vencimento;
	}

	public void setVencimento(Long vencimento) {
		this.vencimento = vencimento;
	}

	public Double getHonorario() {
		return honorario;
	}

	public void setHonorario(Double honorario) {
		this.honorario = honorario;
	}

	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}

}
