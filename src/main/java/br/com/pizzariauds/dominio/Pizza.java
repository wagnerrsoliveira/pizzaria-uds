package br.com.pizzariauds.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.pizzariauds.dominio.enums.Tamanho;

@Entity
public class Pizza implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String tamanho;
	private Double valor;
	private Integer tempoDePreparo;

	@ManyToOne
	@JoinColumn(name="sabor_id")
	@JsonManagedReference
	private Sabor sabor;

	public Pizza() {
	}

	public Pizza(Integer id, Tamanho tamanho, Double valor, Integer tempoDePreparo, Sabor sabor) {
		this.id = id;
		this.tamanho = tamanho.getId();
		this.valor = valor;
		this.tempoDePreparo = tempoDePreparo;
		this.sabor = sabor;
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

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
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
