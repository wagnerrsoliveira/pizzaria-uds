package br.com.pizzariauds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pizzariauds.dominio.Sabor;

@Repository
public interface SaborRepository extends JpaRepository<Sabor, Integer> {

}
