package com.someli.someli.dto;

import com.someli.someli.model.Cliente;

public class ClienteComPagamentoDTO {
    private Long clienteId;
    private String nome;
    private Double honorario;
    private Integer vencimento;
    private Integer pagamento;
    private Boolean pago = false;

    public ClienteComPagamentoDTO(Cliente cliente) {
        this.clienteId = cliente.getId();
        this.nome = cliente.getRazaoSocial();
        this.honorario = cliente.getValorHonorario();
        this.vencimento = cliente.getDiaVencimento().intValue();
        this.pagamento = cliente.getOrdemPagamento().intValue();
    }

    // Getters e setters

    public Long getClienteId() {
        return clienteId;
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

    public Double getHonorario() {
        return honorario;
    }

    public void setHonorario(Double honorario) {
        this.honorario = honorario;
    }

    public Integer getVencimento() {
        return vencimento;
    }

    public void setVencimento(Integer vencimento) {
        this.vencimento = vencimento;
    }

    public Integer getPagamento() {
        return pagamento;
    }

    public void setPagamento(Integer pagamento) {
        this.pagamento = pagamento;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }
}
