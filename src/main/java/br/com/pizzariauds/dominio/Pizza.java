package br.com.pizzariauds.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.pizzariauds.dominio.enums.Tamanho;

@Entity
public class Pizza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tamanho;
	private Double valor;
	private Integer tempoDePreparo;

	@JsonBackReference
	@OneToMany
	@JoinColumn(name = "pedido_id")	
	private List<Pedido> pedidos = new ArrayList<>();

	public Pizza() {
	}

	public Pizza(Integer id, Tamanho tamanho, Double valor, Integer tempoDePreparo) {
		this.id = id;
		this.tamanho = tamanho.getId();
		this.valor = valor;
		this.tempoDePreparo = tempoDePreparo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tamanho getTamanho() {
		return Tamanho.toEnum(tamanho);
	}

	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho.getId();
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}

	public void setTempoDePreparo(Integer tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
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
		Pizza other = (Pizza) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
