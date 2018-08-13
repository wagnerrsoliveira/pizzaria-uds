package br.com.pizzariauds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pizzariauds.dominio.Adicional;

@Repository
public interface AdicionalRepository extends JpaRepository<Adicional, Integer> {

}
