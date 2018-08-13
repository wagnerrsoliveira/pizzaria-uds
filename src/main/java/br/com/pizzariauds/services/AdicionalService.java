package br.com.pizzariauds.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pizzariauds.dominio.Adicional;
import br.com.pizzariauds.repositories.AdicionalRepository;
import br.com.pizzariauds.services.exceptions.ObjectNotFoundException;

@Service
public class AdicionalService {
	@Autowired
	AdicionalRepository AdicionalRepo;

	public Adicional buscar(Integer id) {
		Optional<Adicional> obj = AdicionalRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Adicional.class.getName()));
	}

	public List<Adicional> buscarTodos() {
		List<Adicional> adicionais = AdicionalRepo.findAll();
		return adicionais;
	}
}
