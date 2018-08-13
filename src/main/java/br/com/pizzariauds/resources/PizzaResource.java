package br.com.pizzariauds.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pizzariauds.dominio.Pizza;
import br.com.pizzariauds.services.PizzaService;

@RestController
@RequestMapping(value = "/pizzas")
public class PizzaResource {

	@Autowired
	private PizzaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pizza> find(@PathVariable Integer id) {

		Pizza obj = service.buscar(id);
		return ResponseEntity.ok(obj);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Pizza>> findAll() {

		List<Pizza> pizzas = service.buscarTodos();
		return ResponseEntity.ok(pizzas);
	}
}
