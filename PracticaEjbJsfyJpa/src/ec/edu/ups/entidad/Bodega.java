package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bodega
 *
 */
@Entity

public class Bodega implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int codigo;
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bodega")
	private Set<Ubicacion> ubicaciones = new HashSet<Ubicacion>();
	
	

	public Bodega() {
		super();
	}



	public Bodega(String nombre) {
		super();
		this.nombre = nombre;
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



	public Set<Ubicacion> getUbicaciones() {
		return ubicaciones;
	}



	public void setUbicaciones(Set<Ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
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
		Bodega other = (Bodega) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
   
	
}
