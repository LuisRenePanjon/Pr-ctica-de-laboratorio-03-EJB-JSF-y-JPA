package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.entidad.Bodega;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class BodegaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private BodegaFacade ejbBodegaFacade;
	private List<Bodega> list;
	private String nombre;
	
	public BodegaBean() {
		
	}
	
	@PostConstruct
	private void init() {
		// TODO Auto-generated method stub
		//ejbBodegaFacade.create(new Bodega("Bodega1"));
		list = ejbBodegaFacade.findAll();
	}
	
	public Bodega[] getList() {
		return list.toArray(new Bodega[0]);
	}
	
	
	public void setList(List<Bodega> list) {
		this.list= list;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre= nombre;
	}
	
	public String add() {
		ejbBodegaFacade.create(new Bodega(this.nombre));
		list = ejbBodegaFacade.findAll();
		return null;
	}
	
	public String delete(Bodega b) {
		ejbBodegaFacade.remove(b);
		list= ejbBodegaFacade.findAll();
		return null;
	}
	
	
}
