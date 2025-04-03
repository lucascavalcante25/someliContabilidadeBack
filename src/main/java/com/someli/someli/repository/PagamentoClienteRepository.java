package com.someli.someli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.someli.someli.model.PagamentoCliente;

@Repository
public interface PagamentoClienteRepository extends JpaRepository<PagamentoCliente, Long> {
	List<PagamentoCliente> findByMesAndAno(String mes, Integer ano);

	List<PagamentoCliente> findByClienteIdAndMesAndAno(Long clienteId, String mes, Integer ano);
}