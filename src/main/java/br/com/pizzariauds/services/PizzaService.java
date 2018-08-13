package br.com.pizzariauds.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pizzariauds.dominio.Pizza;
import br.com.pizzariauds.dominio.Sabor;
import br.com.pizzariauds.dominio.enums.Tamanho;
import br.com.pizzariauds.repositories.PizzaRepository;
import br.com.pizzariauds.services.exceptions.ObjectNotFoundException;

@Service
public class PizzaService {

	@Autowired
	PizzaRepository pizzaRepo;
	@Autowired
	SaborService saborServ;

	public Pizza buscar(Integer id) {
		Optional<Pizza> obj = pizzaRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pizza.class.getName()));
	}


	public List<Pizza> buscar(Tamanho tamanho, String saborDescricao) {
		List<Sabor> sabores = saborServ.buscar(saborDescricao);
		List<Pizza> pizzas = pizzaRepo.findDistinctByTamanhoContainingAndSaborIn(tamanho.getId(), sabores);
		return pizzas;
	}
}
