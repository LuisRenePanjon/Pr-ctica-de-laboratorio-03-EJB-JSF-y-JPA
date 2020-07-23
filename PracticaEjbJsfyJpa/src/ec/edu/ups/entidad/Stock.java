package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	private int cantidad;
	@OneToOne
	private Producto producto;
	
	@ManyToOne
	@JoinColumn
	private Bodega bodega;
	
	@Transient
	private boolean editable;
	
	//Cambios Realizados

	public Stock() {
		super();
	}
	
	

	public Stock( int cantidad, Producto producto, Bodega bodega) {
		this.cantidad = cantidad;
		this.producto = producto;
		this.bodega = bodega;
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
	
	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	public Producto getProducto() {
		return producto;
	}



	public void setProducto(Producto producto) {
		this.producto = producto;
	}



	public Bodega getBodega() {
		return bodega;
	}



	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
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
