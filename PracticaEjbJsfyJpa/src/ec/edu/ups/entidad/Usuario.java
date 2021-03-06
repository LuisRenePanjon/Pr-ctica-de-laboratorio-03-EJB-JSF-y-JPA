package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@NamedQuery(name = "getByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo AND u.contrasena = :pass")
@NamedQuery(name = "listarPorCargo", query = "SELECT u FROM Usuario u WHERE u.rol.codigo = :cargo")
@NamedQuery(name = "getByCedulaoCorreo", query ="SELECT u FROM  Usuario u WHERE  u.cedula = :cedula OR u.correo = :correo")



@Entity
public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	
	private String nombre;
	
	private String apellido;
	
	@Column(unique=true)
	private String cedula;
	
	private String correo;
	@Column(unique=true)
	private String contrasena;
	
	private String estado;
	
	private String cuenta;
	
	@ManyToOne
	@JoinColumn
	private Rol rol;
	
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private Set<FacturaCabecera> listaFacturas = new  HashSet<FacturaCabecera>();
	
	@Transient
    private boolean editable;
	
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

	

	public Usuario(String nombre, String apellido, String cedula, String correo, String contrasena, Rol rol) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.correo = correo;
		this.contrasena = contrasena;
		this.rol = rol;
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


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}


	public Set<FacturaCabecera> getListaFacturas() {
		return listaFacturas;
	}


	public void setListaFacturas(Set<FacturaCabecera> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}

	public void addFactura(FacturaCabecera Fcabecera) {
		this.listaFacturas.add(Fcabecera);
	}
	
	public void removeFactura(FacturaCabecera Fcabecera) {
		this.listaFacturas.remove(Fcabecera);
	}
	
	

	public boolean isEditable() {
		return editable;
	}


	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getCuenta() {
		return cuenta;
	}


	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
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
				+ ", correo=" + correo + ", contrasena=" + contrasena + ", estado=" + estado + ", cuenta=" + cuenta
				+ ", rol=" + rol + ", listaFacturas=" + listaFacturas + ", editable=" + editable + "]";
	}
	
	
   
}
