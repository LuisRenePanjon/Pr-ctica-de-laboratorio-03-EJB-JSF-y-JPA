package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Rol
 *
 */
@NamedQuery(name = "getByCargo", query = "SELECT r FROM Rol r WHERE r.cargo = :cargo")


@Entity

public class Rol implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	
	private String cargo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
	private Set<Usuario> listaUsuarios = new  HashSet<Usuario>();
	
	@Transient
    private boolean editable;
	
	public Rol() {
		super();
	}


	public Rol(int codigo, String cargo) {
		super();
		this.codigo = codigo;
		this.cargo = cargo;
	}

	

	public Rol(String cargo) {
		super();
		this.cargo = cargo;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void addUsuario(Usuario usuario) {
		this.listaUsuarios.add(usuario);
	}
	
	public void removeUsuario(Usuario usuario) {
		this.listaUsuarios.remove(usuario);
	}
	
	
	
	public Set<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}


	public void setListaUsuarios(Set<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
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
		Rol other = (Rol) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Rol [codigo=" + codigo + ", cargo=" + cargo + "]";
	}
	
   
}
