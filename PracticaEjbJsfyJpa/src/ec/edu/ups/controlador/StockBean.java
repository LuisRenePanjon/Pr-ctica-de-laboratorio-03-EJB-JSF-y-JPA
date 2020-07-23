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
	
	private String nombreB;
	private String nombreP;

	@EJB
	private StockFacade ejbStockFacade;

	private List<Stock> list;
	

	private int codigo;
	private int cantidad;


	@EJB
	private ProductoFacade ejbProductoFacade;
	
	private List<Producto> listProducto;
	private Set<Producto> listaProducto = new HashSet<Producto>();

	@EJB
	private BodegaFacade ejbBodegaFacade;
	private Bodega bo;
	private List<Bodega> listBodega;
	private Set<Bodega> listaBodegas = new HashSet<Bodega>();

	public StockBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		list = ejbStockFacade.findAll();
		listProducto = ejbProductoFacade.findAll();
		listBodega = ejbBodegaFacade.findAll();

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
	
	

	public String getNombreB() {
		return nombreB;
	}

	public void setNombreB(String nombreB) {
		this.nombreB = nombreB;
	}

	public String getNombreP() {
		return nombreP;
	}

	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
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

	
	public ProductoFacade getEjbProductoFacade() {
		return ejbProductoFacade;
	}

	public void setEjbProductoFacade(ProductoFacade ejbProductoFacade) {
		this.ejbProductoFacade = ejbProductoFacade;
	}

	
	public Set<Producto> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(Set<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}

	public BodegaFacade getEjbBodegaFacade() {
		return ejbBodegaFacade;
	}

	public void setEjbBodegaFacade(BodegaFacade ejbBodegaFacade) {
		this.ejbBodegaFacade = ejbBodegaFacade;
	}

	

	public List<Producto> getListProducto() {
		return listProducto;
	}

	public void setListProducto(List<Producto> listProducto) {
		this.listProducto = listProducto;
	}

	public List<Bodega> getListBodega() {
		return listBodega;
	}

	public void setListBodega(List<Bodega> listBodega) {
		this.listBodega = listBodega;
	}
	
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String addStock() {

		Bodega bodega = ejbBodegaFacade.readBodega(this.nombreB);
		Producto producto= ejbProductoFacade.readProducto(this.nombreP);
		
		ejbStockFacade.create(new Stock(this.cantidad, producto, bodega));
		list = ejbStockFacade.findAll();
		return null;
	}

	public String delete(Stock b) {
		ejbStockFacade.remove(b);
		list = ejbStockFacade.findAll();
		return null;
	}

	public String edit(Stock b) {
		b.setEditable(true);
		return null;
	}

	public Bodega getBo() {
		return bo;
	}

	public void setBo(Bodega bo) {
		this.bo = bo;
	}

	public String save(Stock b) {
		ejbStockFacade.edit(b);
		b.setEditable(false);
		return null;
	}
	
	public Bodega bode() {
		System.out.println(nombreB);
		bo = ejbStockFacade.nombreBodega(nombreB);
		System.out.println(bo);
		return bo;
	}
	
	public List<Stock> listado() {
		list = ejbStockFacade.listaInventario(bode());
		return list;
	}

}
