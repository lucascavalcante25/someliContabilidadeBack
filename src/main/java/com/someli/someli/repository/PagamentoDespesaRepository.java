package com.someli.someli.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.someli.someli.model.PagamentoDespesa;

@Repository
public interface PagamentoDespesaRepository extends JpaRepository<PagamentoDespesa, Long> {

	Optional<PagamentoDespesa> findByDespesaIdAndMesAndAno(Long despesaId, String mes, Integer ano);
}
