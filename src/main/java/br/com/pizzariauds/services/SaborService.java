package br.com.pizzariauds.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pizzariauds.dominio.Sabor;
import br.com.pizzariauds.repositories.SaborRepository;
import br.com.pizzariauds.services.exceptions.ObjectNotFoundException;

@Service
public class SaborService {

	@Autowired
	SaborRepository saborRepo;

	public Sabor buscar(Integer id) {
		Optional<Sabor> sabor = saborRepo.findById(id);
		return sabor.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Sabor.class.getName()));
	}

	public List<Sabor> buscarTodos() {
		List<Sabor> sabores = saborRepo.findAll();
		return sabores;
	}
}
