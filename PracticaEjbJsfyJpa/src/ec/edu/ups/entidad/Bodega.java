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
//Error
public class Bodega implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	private String nombre;
	@ManyToOne
	@JoinColumn
	private Ubicacion ubicacion;
	@ManyToOne
	@JoinColumn
	private Distribuidora distribuidora;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bodega")
	private Set<Stock> listaStock = new HashSet<Stock>();
	
	@Transient
	private boolean editable;

	public Bodega() {
		super();
	}


	
	

	public Bodega(int codigo, String nombre, Ubicacion ubicacion, Distribuidora distribuidora) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.distribuidora = distribuidora;
	}





	public Bodega(String nombre, Ubicacion ubicacion, Distribuidora distribuidora, boolean editable) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.distribuidora = distribuidora;
		this.editable = editable;
	}

	public Bodega(String nombre) {
		super();
		this.nombre = nombre;
	}
	

	public Bodega(String nombre, Ubicacion ubicacion, Distribuidora distribuidora) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.distribuidora = distribuidora;
	}

	public Bodega(String nombre, Ubicacion ubicacion) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
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

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Distribuidora getDistribuidora() {
		return distribuidora;
	}

	public void setDistribuidora(Distribuidora distribuidora) {
		this.distribuidora = distribuidora;
	}

	
	public Set<Stock> getListaStock() {
		return listaStock;
	}

	public void setListaStock(Set<Stock> listaStock) {
		this.listaStock = listaStock;
	}

	public void agregarStock(Stock stock) {
		this.listaStock.add(stock);
	}

	
	

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
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

	@Override
	public String toString() {
		return "Bodega [codigo=" + codigo + ", nombre=" + nombre + "]";
	}

}
