package br.com.pizzariauds;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.pizzariauds.dominio.Adicional;
import br.com.pizzariauds.dominio.Pizza;
import br.com.pizzariauds.dominio.Sabor;
import br.com.pizzariauds.dominio.enums.Tamanho;
import br.com.pizzariauds.repositories.AdicionalRepository;
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

	public static void main(String[] args) {
		SpringApplication.run(PizzariaUdsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Sabor calabresa = new Sabor(null, "Calabresa", 0);
		Sabor marguerita = new Sabor(null, "Marguerita", 0);
		Sabor portuguesa = new Sabor(null, "Portuguesa", 5);

		Pizza pizzaPCalabresa = new Pizza(null, Tamanho.PEQUENA, 20.00, 15, calabresa);
		Pizza pizzaMCalabresa = new Pizza(null, Tamanho.MEDIA, 30.00, 20, calabresa);
		Pizza pizzaGCalabresa = new Pizza(null, Tamanho.GRANDE, 40.00, 25, calabresa);

		Pizza pizzaPMarguerita = new Pizza(null, Tamanho.PEQUENA, 20.00, 15, marguerita);
		Pizza pizzaMMarguerita = new Pizza(null, Tamanho.MEDIA, 30.00, 20, marguerita);
		Pizza pizzaGMarguerita = new Pizza(null, Tamanho.GRANDE, 40.00, 25, marguerita);

		Pizza pizzaPPortuguesa = new Pizza(null, Tamanho.PEQUENA, 20.00, 15, portuguesa);
		Pizza pizzaMPortuguesa = new Pizza(null, Tamanho.MEDIA, 30.00, 20, portuguesa);
		Pizza pizzaGPortuguesa = new Pizza(null, Tamanho.GRANDE, 40.00, 25, portuguesa);

		calabresa.getPizzas().addAll(Arrays.asList(pizzaPCalabresa, pizzaMCalabresa, pizzaGCalabresa));
		marguerita.getPizzas().addAll(Arrays.asList(pizzaPMarguerita, pizzaMMarguerita, pizzaGMarguerita));
		portuguesa.getPizzas().addAll(Arrays.asList(pizzaPPortuguesa, pizzaMPortuguesa, pizzaGPortuguesa));

		Adicional adBacon = new Adicional(null, "Extra bacon", 0, 3.0);
		Adicional adSemCebola = new Adicional(null, "Sem cebola", 0, 0.0);
		Adicional adBordaRecheada = new Adicional(null, "Borda recheada", 5, 5.00);
		
		saborRepository.saveAll(Arrays.asList(calabresa, marguerita, portuguesa));
		pizzaRepository.saveAll(Arrays.asList(
				pizzaPCalabresa, pizzaMCalabresa, pizzaGCalabresa, pizzaPMarguerita, pizzaMMarguerita, pizzaGMarguerita,
				pizzaPPortuguesa, pizzaMPortuguesa, pizzaGPortuguesa
		));
		
		adicionalRepository.saveAll(Arrays.asList(adBacon,adSemCebola,adBordaRecheada));
	}
}
