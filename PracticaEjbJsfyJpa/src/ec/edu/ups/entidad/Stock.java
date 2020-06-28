package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Stock
 *
 */
@Entity

public class Stock implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int codigo;
	private int cantidad;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
	private Set<Bodega> listaBodegas = new HashSet<Bodega>();

	public Stock() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Set<Bodega> getListaBodegas() {
		return listaBodegas;
	}

	public void setListaBodegas(Set<Bodega> listaBodegas) {
		this.listaBodegas = listaBodegas;
	}

	public void agregarBodega(Bodega bodega) {
		this.listaBodegas.add(bodega);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		Stock other = (Stock) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

}
