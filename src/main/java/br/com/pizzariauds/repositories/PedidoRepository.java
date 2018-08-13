package br.com.pizzariauds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pizzariauds.dominio.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
