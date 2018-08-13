package br.com.pizzariauds.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pizzariauds.dominio.Sabor;
import br.com.pizzariauds.services.SaborService;

@RestController
@RequestMapping(value = "/sabores")
public class SaborResource {

	@Autowired
	private SaborService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Sabor> find(@PathVariable Integer id) {

		Sabor obj = service.buscar(id);
		return ResponseEntity.ok(obj);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Sabor>> findAll() {

		List<Sabor> sabores = service.buscarTodos();
		return ResponseEntity.ok(sabores);
	}

}
