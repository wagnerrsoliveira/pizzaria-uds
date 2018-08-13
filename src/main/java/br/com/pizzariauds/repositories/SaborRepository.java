package br.com.pizzariauds.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.pizzariauds.dominio.Sabor;

@Repository
public interface SaborRepository extends JpaRepository<Sabor, Integer> {

	@Query("select s from Sabor s where upper(s.descricao) like %?1%")
	List<Sabor> find(String descricao);
}
