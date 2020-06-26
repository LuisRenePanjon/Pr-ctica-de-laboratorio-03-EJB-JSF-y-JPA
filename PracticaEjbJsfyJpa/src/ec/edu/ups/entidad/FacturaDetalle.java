package ec.edu.ups.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class FacturaDetalle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;

	private FacturaCabecera fcabecera;

	private double precio;

	private double subtotal;

	private double iva;

	private double total;

	private List<Pedido> pedidos;

	public FacturaDetalle() {
		pedidos = new ArrayList<Pedido>();
		// TODO Auto-generated constructor stub
	}

	public FacturaDetalle(FacturaCabecera fcabecera, double precio, double subtotal, double iva, double total,
			List<Pedido> pedidos) {
		super();
		this.fcabecera = fcabecera;
		this.precio = precio;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
		this.pedidos = pedidos;

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public FacturaCabecera getFcabecera() {
		return fcabecera;
	}

	public void setFcabecera(FacturaCabecera fcabecera) {
		this.fcabecera = fcabecera;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
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
		FacturaDetalle other = (FacturaDetalle) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FacturaDetalle [codigo=" + codigo + ", fcabecera=" + fcabecera + ", precio=" + precio + ", subtotal="
				+ subtotal + ", iva=" + iva + ", total=" + total + ", pedidos=" + pedidos + "]";
	}

}