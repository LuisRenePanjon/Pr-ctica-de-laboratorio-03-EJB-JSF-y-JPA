package ec.edu.ups.entidad;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Producto
 *
 */
@Entity

public class Producto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int codigo;
	private String nombre;
	private String categoria;
	private double precio;
	
	public Producto() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
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
		Producto other = (Producto) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
	
	
   
}