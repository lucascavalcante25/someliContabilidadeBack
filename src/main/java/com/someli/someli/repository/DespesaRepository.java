package com.someli.someli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.someli.someli.model.Despesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {
	List<Despesa> findByAtivoTrue();

	@Query("SELECT d FROM Despesa d WHERE to_char(d.dataInicio, 'MM') = :mes AND extract(year from d.dataInicio) = :ano")
	List<Despesa> findByMesAndAno(@Param("mes") String mes, @Param("ano") int ano);

}
