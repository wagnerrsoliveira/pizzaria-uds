package br.com.pizzariauds.dominio;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ItemAdicionalPedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemAdicionalPedidoPk  id =new ItemAdicionalPedidoPk();

	public ItemAdicionalPedido() {
	}

	public ItemAdicionalPedido(Pedido pedido,Adicional adicional) {
		this.id.setPedido(pedido);
		this.id.setAdicional(adicional);
	}

	public ItemAdicionalPedidoPk getId() {
		return id;
	}

	public void setId(ItemAdicionalPedidoPk id) {
		this.id = id;
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
		ItemAdicionalPedido other = (ItemAdicionalPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
