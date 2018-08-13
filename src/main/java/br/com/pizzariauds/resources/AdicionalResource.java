package br.com.pizzariauds.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pizzariauds.dominio.Adicional;
import br.com.pizzariauds.services.AdicionalService;

@RestController
@RequestMapping(value = "/adicionais")
public class AdicionalResource {

	@Autowired
	private AdicionalService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Adicional> find(@PathVariable Integer id) {

		Adicional obj = service.buscar(id);
		return ResponseEntity.ok(obj);
	}
}