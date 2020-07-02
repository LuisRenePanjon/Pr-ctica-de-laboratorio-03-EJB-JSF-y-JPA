package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ubicacion
 *
 */
@NamedQuery(name = "getByCiudad", query = "SELECT u FROM Ubicacion u WHERE u.ciudad =:ciudad")

@Entity

public class Ubicacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	private String pais;
	private String provincia;
	private String ciudad;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ubicacion")
	private Set<Bodega> bodegas = new HashSet<Bodega>();

	@Transient
	private boolean editable;
	
	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public Ubicacion() {
		super();
	}

	public Ubicacion(String pais, String provincia, String ciudad) {
		super();
		this.pais = pais;
		this.provincia = provincia;
		this.ciudad = ciudad;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Set<Bodega> getBodegas() {
		return bodegas;
	}

	public void setBodegas(Set<Bodega> bodegas) {
		this.bodegas = bodegas;
	}

	public void agregarBodega(Bodega bodega) {
		this.bodegas.add(bodega);
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
		Ubicacion other = (Ubicacion) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ubicacion [codigo=" + codigo + ", pais=" + pais + ", provincia=" + provincia + ", ciudad=" + ciudad
				+ "]";
	}

}
