package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.ejb.StockFacade;
import ec.edu.ups.entidad.Bodega;
import ec.edu.ups.entidad.Distribuidora;
import ec.edu.ups.entidad.Producto;
import ec.edu.ups.entidad.Stock;
import ec.edu.ups.entidad.Ubicacion;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class StockBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private StockFacade ejbStockFacade;

	private List<Stock> list;

	private int codigo;
	private int cantidad;
	
	
	@EJB
	private ProductoFacade ejbProductoFacade;
	private Set<Producto> listaProducto = new HashSet<Producto>();
	
	@EJB
	private BodegaFacade ejbBodegaFacade;
	private Set<Bodega> listaBodegas = new HashSet<Bodega>();

	public StockBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		ejbStockFacade.create(new Stock());
		list = ejbStockFacade.findAll();

	}

	public StockFacade getEjbStockFacade() {
		return ejbStockFacade;
	}

	public void setEjbStockFacade(StockFacade ejbStockFacade) {
		this.ejbStockFacade = ejbStockFacade;
	}

	public List<Stock> getList() {
		return list;
	}

	public void setList(List<Stock> list) {
		this.list = list;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Set<Bodega> getListaBodegas() {
		return listaBodegas;
	}

	public void setListaBodegas(Set<Bodega> listaBodegas) {
		this.listaBodegas = listaBodegas;
	}

	

}
