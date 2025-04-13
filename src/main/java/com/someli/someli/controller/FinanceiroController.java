package com.someli.someli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.someli.someli.dto.ClienteFinanceiroDTO;
import com.someli.someli.service.FinanceiroService;

@RestController
@RequestMapping("/api/financeiro")
public class FinanceiroController {

    @Autowired
    private FinanceiroService financeiroService;

    @GetMapping("/clientes/ativos")
    public List<ClienteFinanceiroDTO> buscarClientesAtivos() {
        return financeiroService.buscarClientesAtivos();
    }

    @GetMapping("/clientes/financeiro")
    public List<ClienteFinanceiroDTO> buscarClientesFinanceiros(@RequestParam String mes,
                                                                 @RequestParam Integer ano) {
        return financeiroService.buscarClientesFinanceiros(mes, ano);
    }

    @PutMapping("/pagamentos/status")
    public ResponseEntity<Void> atualizarPagamentoCliente(@RequestParam Long clienteId,
                                                          @RequestParam String mes,
                                                          @RequestParam Integer ano,
                                                          @RequestBody Boolean pago) {
        financeiroService.atualizarPagamentoCliente(clienteId, pago, mes, ano);
        return ResponseEntity.ok().build();
    }
}

