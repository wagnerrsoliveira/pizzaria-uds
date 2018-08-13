package br.com.pizzariauds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pizzariauds.dominio.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

}
