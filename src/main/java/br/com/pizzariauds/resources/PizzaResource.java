package br.com.pizzariauds.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pizzariauds.dominio.Pizza;
import br.com.pizzariauds.dominio.Sabor;
import br.com.pizzariauds.dominio.enums.Tamanho;
import br.com.pizzariauds.services.PizzaService;
import br.com.pizzariauds.services.SaborService;

@RestController
@RequestMapping(value="/pizzas")
public class PizzaResource {

	@Autowired
	private PizzaService service;

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Pizza> find(@PathVariable Integer id) {
		
		Pizza obj = service.buscar(id);
		return ResponseEntity.ok(obj);
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> find(@RequestParam(value="tamanho") String tamanho,@RequestParam(value="sabor", defaultValue="") String saborDescrica) {
		List<Pizza> obj = service.buscar(Tamanho.toEnum(tamanho.toUpperCase()),saborDescrica);
		return ResponseEntity.ok(obj);
	}
}
