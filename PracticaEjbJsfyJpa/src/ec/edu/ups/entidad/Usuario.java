package ec.edu.ups.entidad;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity

public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	
	private String nombre;
	
	private String apellido;
	
	private String cedula;
	
	private String correo;
	
	private String contrasena;
	
	@ManyToOne
	@JoinColumn
	private Rol rol;
	
	
	private FacturaCabecera fCabecera;
	
	public Usuario() {
		super();
	}


	public Usuario(String nombre, String apellido, String cedula, String correo, String contrasena) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.correo = correo;
		this.contrasena = contrasena;
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
		Usuario other = (Usuario) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", correo=" + correo + ", contrasena=" + contrasena + "]";
	}
	
	
   
}
