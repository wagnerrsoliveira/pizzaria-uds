package br.com.pizzariauds;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.pizzariauds.dominio.Adicional;
import br.com.pizzariauds.dominio.Pedido;
import br.com.pizzariauds.dominio.Pizza;
import br.com.pizzariauds.dominio.Sabor;
import br.com.pizzariauds.dominio.enums.Tamanho;
import br.com.pizzariauds.repositories.AdicionalRepository;
import br.com.pizzariauds.repositories.PedidoRepository;
import br.com.pizzariauds.repositories.PizzaRepository;
import br.com.pizzariauds.repositories.SaborRepository;

@SpringBootApplication
public class PizzariaUdsApplication implements CommandLineRunner {

	@Autowired
	SaborRepository saborRepository;
	@Autowired
	PizzaRepository pizzaRepository;
	@Autowired
	AdicionalRepository adicionalRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(PizzariaUdsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if (saborRepository.findAll().size() <= 0) {
			Sabor calabresa = new Sabor(null, "Calabresa", 0);
			Sabor marguerita = new Sabor(null, "Marguerita", 0);
			Sabor portuguesa = new Sabor(null, "Portuguesa", 5);
			saborRepository.saveAll(Arrays.asList(calabresa, marguerita, portuguesa));
		}
		if (pizzaRepository.findAll().size() <= 0) {
			Pizza pizzaP = new Pizza(null, Tamanho.PEQUENA, 20.00, 15);
			Pizza pizzaM = new Pizza(null, Tamanho.MEDIA, 30.00, 20);
			Pizza pizzaG = new Pizza(null, Tamanho.GRANDE, 40.00, 25);
			pizzaRepository.saveAll(Arrays.asList(pizzaP, pizzaM, pizzaG));
		}
		if (adicionalRepository.findAll().size() <= 0) {
			Adicional adBacon = new Adicional(null, "Extra bacon", 0, 3.0);
			Adicional adSemCebola = new Adicional(null, "Sem cebola", 0, 0.0);
			Adicional adBordaRecheada = new Adicional(null, "Borda recheada", 5, 5.00);
			adicionalRepository.saveAll(Arrays.asList(adBacon, adSemCebola, adBordaRecheada));
		}
		/*
		Optional<Sabor> sabor = saborRepository.findById(1);
		
		Optional<Pizza> pizza = pizzaRepository.findById(1);
		Pedido p = new Pedido(1, 10, 20.2,pizza.orElse(null),sabor.orElse(null));
		
		
		pedidoRepository.saveAll(Arrays.asList(p));*/

	}
}
