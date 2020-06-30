package ec.edu.ups.entidad;

import java.io.Serializable;
import java.sql.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FacturaCabecera implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;

	private Date fecha;
	private String estado;
	
	@ManyToOne
	@JoinColumn
	private Distribuidora distribuidora;
	

	@ManyToOne
	@JoinColumn
	private Usuario usuario;
	
	public FacturaCabecera() {
		// TODO Auto-generated constructor stub
	}

	

	public FacturaCabecera(Usuario usuario, Date fecha, String estado, Distribuidora distribuidora) {
		super();
		this.usuario = usuario;
		this.fecha = fecha;
		this.estado = estado;
		this.distribuidora = distribuidora;
	}



	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
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
		FacturaCabecera other = (FacturaCabecera) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "FacturaCabecera [codigo=" + codigo + ", usuario=" + usuario + ", fecha=" + fecha + ", estado=" + estado
				+ ", distribuidora=" + distribuidora + "]";
	}
	
	
	
	

}
