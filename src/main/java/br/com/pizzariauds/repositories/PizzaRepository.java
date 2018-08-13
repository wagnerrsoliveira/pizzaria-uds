package br.com.pizzariauds.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pizzariauds.dominio.Pizza;
import br.com.pizzariauds.dominio.Sabor;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

	
	List<Pizza> findDistinctByTamanhoContainingAndSaborIn(String tamanho, List<Sabor> sabores);
}
