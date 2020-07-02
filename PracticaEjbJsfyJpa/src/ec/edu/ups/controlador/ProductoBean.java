package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.entidad.Producto;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped

public class ProductoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ProductoFacade ejbProductoFacade;

	private List<Producto> list;

	private String nombre;
	private String categoria;
	private double precio;

	public ProductoBean() {

		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		ejbProductoFacade.create(new Producto("Yogurt", "Lacteos", 12.45));
		ejbProductoFacade.create(new Producto("Queso", "Lacteos", 14.45));
		list = ejbProductoFacade.findAll();

	}

	public Producto[] getList() {
		return list.toArray(new Producto[0]);
	}

	public void setList(List<Producto> list) {
		this.list = list;
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

	public String add() {
		ejbProductoFacade.create(new Producto(this.nombre, this.categoria, this.precio));
		list = ejbProductoFacade.findAll();
		return null;
	}

	public String delete(Producto c) {
		ejbProductoFacade.remove(c);
		list = ejbProductoFacade.findAll();
		return null;
	}

	public String edit(Producto c) {
		c.setEditable(true);
		return null;
	}

	public String save(Producto c) {
		ejbProductoFacade.edit(c);
		c.setEditable(false);
		return null;
	}

}
