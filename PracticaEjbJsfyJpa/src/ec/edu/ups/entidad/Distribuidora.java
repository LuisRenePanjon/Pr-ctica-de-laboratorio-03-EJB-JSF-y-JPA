package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Distribuidora
 *
 */
@NamedQuery(name = "getByDistribuidora", query = "SELECT d FROM Distribuidora d WHERE d.nombre =:nombre")

@Entity
public class Distribuidora implements Serializable {

	// Falta agregar campo FK de bodega

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;

	private String nombre;

	private String direccion;

	private String ruc;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "distribuidora")
	private Set<FacturaCabecera> listaFacturas = new HashSet<FacturaCabecera>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "distribuidora")
	private Set<Bodega> listaBodegas = new HashSet<Bodega>();
	
	@Transient
	private boolean editable;

	public Distribuidora() {
		super();
	}

	public Distribuidora(String nombre, String direccion, String ruc) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.ruc = ruc;
	}
	
	public Distribuidora(String nombre, String direccion, String ruc, boolean editable) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.ruc = ruc;
		this.editable = editable;
	}
	

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public void setListaFacturas(Set<FacturaCabecera> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}

	public Set<Bodega> getListaBodegas() {
		return listaBodegas;
	}

	public Set<FacturaCabecera> getListaFacturas() {
		return listaFacturas;
	}

	public void setListaBodegas(Set<Bodega> listaBodegas) {
		this.listaBodegas = listaBodegas;
	}

	public void agregarFactura(FacturaCabecera facturaCabecera) {
		this.listaFacturas.add(facturaCabecera);
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
		Distribuidora other = (Distribuidora) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Distribuidora [codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + ", ruc=" + ruc
				+ "]";
	}

}
