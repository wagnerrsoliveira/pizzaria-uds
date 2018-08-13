package br.com.pizzariauds.dominio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer tempoPreparo;
	private Double valorTotal;

	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="pizza_id")
	@NonNull
	private Pizza pizza;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="sabor_id")
	@NonNull
	private Sabor sabor;
	
	@OneToMany(mappedBy="id.pedido")
	private Set<ItemAdicionalPedido> itensAdicionais = new HashSet<>();

	public Pedido() {
	}

	public Pedido(Integer id, Integer tempoPreparo, Double valorTotal, Pizza pizza, Sabor sabor) {
		this.id = id;
		this.tempoPreparo = tempoPreparo;
		this.valorTotal = valorTotal;
		this.setPizza(pizza);
		this.setSabor(sabor);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTempoPreparo() {
		return tempoPreparo;
	}

	public void setTempoPreparo(Integer tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

	public Set<ItemAdicionalPedido> getItensAdicionais() {
		return itensAdicionais;
	}

	public void setItensAdicionais(Set<ItemAdicionalPedido> itensAdicionais) {
		this.itensAdicionais = itensAdicionais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Double somaValorTotal() {
		return 0.0;
	}

}
