package br.com.pizzariauds.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pizzariauds.dominio.Pedido;
import br.com.pizzariauds.dominio.Pizza;
import br.com.pizzariauds.dominio.Sabor;
import br.com.pizzariauds.repositories.PedidoRepository;
import br.com.pizzariauds.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepo;
	@Autowired
	SaborService saborService;
	@Autowired
	PizzaService pizzaService;
	

	public Pedido buscar(Integer id) {
		Optional<Pedido> pedido = pedidoRepo.findById(id);
		return pedido.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

	public List<Pedido> buscarTodos() {
		List<Pedido> pedidos = pedidoRepo.findAll();
		return pedidos;
	}
	
	public Pedido inserir(Pedido pedido) {
		pedido.setId(null);
		if(pedido.getSabor()!=null){
			Sabor sabor = saborService.buscar(pedido.getSabor().getId());
			pedido.setSabor(sabor);
		}
		if(pedido.getPizza()!=null){
			Pizza pizza = pizzaService.buscar(pedido.getPizza().getId());
			pedido.setPizza(pizza);
		}
		return pedidoRepo.save(pedido);
	}
}
