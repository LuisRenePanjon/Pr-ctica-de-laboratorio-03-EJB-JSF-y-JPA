package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.ejb.DistribuidoraFacade;
import ec.edu.ups.ejb.UbicacionFacade;
import ec.edu.ups.entidad.Bodega;
import ec.edu.ups.entidad.Distribuidora;
import ec.edu.ups.entidad.Ubicacion;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class BodegaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private BodegaFacade ejbBodegaFacade;
	private List<Bodega> list;
	private String nombre;
	@EJB
	private UbicacionFacade ejbUbicacionfacade;
	private List<Ubicacion> ubicaciones;
	private String ciudad;
	@EJB
	private DistribuidoraFacade ejbDistribuidoraFacade;
	private List<Distribuidora> distribuidoras;
	private String nombreD;
	
	

	public BodegaBean() {

	}

	@PostConstruct
	private void init() {
		// TODO Auto-generated method stub
		// ejbBodegaFacade.create(new Bodega("Bodega1"));
		list = ejbBodegaFacade.findAll();
		ubicaciones= ejbUbicacionfacade.findAll();
		distribuidoras = ejbDistribuidoraFacade.findAll();
		
	}

	public BodegaFacade getEjbBodegaFacade() {
		return ejbBodegaFacade;
	}

	public List<Distribuidora> getDistribuidoras() {
		return distribuidoras;
	}

	public void setDistribuidoras(List<Distribuidora> distribuidoras) {
		this.distribuidoras = distribuidoras;
	}

	public String getNombreD() {
		return nombreD;
	}

	public void setNombreD(String nombreD) {
		this.nombreD = nombreD;
	}

	public void setEjbBodegaFacade(BodegaFacade ejbBodegaFacade) {
		this.ejbBodegaFacade = ejbBodegaFacade;
	}

	public UbicacionFacade getEjbUbicacionfacade() {
		return ejbUbicacionfacade;
	}

	public void setEjbUbicacionfacade(UbicacionFacade ejbUbicacionfacade) {
		this.ejbUbicacionfacade = ejbUbicacionfacade;
	}


	public List<Ubicacion> getUbicaciones() {
		return ubicaciones;
	}

	public void setUbicaciones(List<Ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public DistribuidoraFacade getEjbDistribuidoraFacade() {
		return ejbDistribuidoraFacade;
	}

	public void setEjbDistribuidoraFacade(DistribuidoraFacade ejbDistribuidoraFacade) {
		this.ejbDistribuidoraFacade = ejbDistribuidoraFacade;
	}


	public Bodega[] getList() {
		return list.toArray(new Bodega[0]);
	}

	public void setList(List<Bodega> list) {
		this.list = list;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	/*public String add() {
		for(Ubicacion ubi : ubicacion) {
			ubi.setPais(pais);
		}
		ejbBodegaFacade.create(new Bodega(this.nombre));
		list = ejbBodegaFacade.findAll();
		return null;
	}*/
	
	public String addBodega() {
		
		Ubicacion ubicacion=ejbUbicacionfacade.readUbicacion(ciudad);
		Distribuidora distribuidora = ejbDistribuidoraFacade.readDistribuidora(nombreD);
		ejbBodegaFacade.create(new Bodega(this.nombre, ubicacion, distribuidora));
		list = ejbBodegaFacade.findAll();
		return null;
	}

	public String delete(Bodega b) {
		ejbBodegaFacade.remove(b);
		list = ejbBodegaFacade.findAll();
		return null;
	}

	public String edit(Bodega b) {
		b.setEditable(true);
		return null;
	}

	public String save(Bodega b) {
		ejbBodegaFacade.edit(b);
		b.setEditable(false);
		return null;
	}

}
