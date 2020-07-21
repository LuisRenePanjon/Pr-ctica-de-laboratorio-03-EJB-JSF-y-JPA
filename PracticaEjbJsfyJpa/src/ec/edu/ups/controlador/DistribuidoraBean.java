package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.DistribuidoraFacade;
import ec.edu.ups.entidad.Bodega;
import ec.edu.ups.entidad.Distribuidora;
import ec.edu.ups.entidad.FacturaCabecera;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class DistribuidoraBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private DistribuidoraFacade distribuidoraFacade;
	
	private Distribuidora distribuidora;
	
	private List<FacturaCabecera> listaDeFacturas;
	
	private Set<Bodega> listaDeBodegas;
	
	private List<Distribuidora> list;
	
	private String nombre;
	private String direccion;
	private String ruc;
	
	
	public DistribuidoraFacade getDistribuidoraFacade() {
		return distribuidoraFacade;
	}

	public void setDistribuidoraFacade(DistribuidoraFacade distribuidoraFacade) {
		this.distribuidoraFacade = distribuidoraFacade;
	}

	public List<Distribuidora> getList() {
		return list;
	}

	public void setList(List<Distribuidora> list) {
		this.list = list;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public DistribuidoraBean() {
		
	}
	
	@PostConstruct
	private void init() {
		// TODO Auto-generated method stub
		list = distribuidoraFacade.findAll();
	}
	
	
	public Distribuidora getDistribuidora() {
		return distribuidora;
	}

	public void setDistribuidora(Distribuidora distribuidora) {
		this.distribuidora = distribuidora;
	}
	
	
	

	public List<FacturaCabecera> getListaDeFacturas() {
		return listaDeFacturas;
	}

	public void setListaDeFacturas(List<FacturaCabecera> listaDeFacturas) {
		this.listaDeFacturas = listaDeFacturas;
	}
	
	
	
	

	public Set<Bodega> getListaDeBodegas() {
		return listaDeBodegas;
	}

	public void setListaDeBodegas(Set<Bodega> listaDeBodegas) {
		this.listaDeBodegas = listaDeBodegas;
	}
	
	/***********************************************************/

	
	
	
	
	
	
	public Distribuidora imprimir() {
		/*
		distribuidora = distribuidoraFacade.find(1);
		System.out.println("-------------------------------");
		System.out.println(distribuidora);
		*/
		
		distribuidoraFacade.hola(1);
		//distribuidoraFacade.buscarFacturasNoNulas();
		
		return null;
	}
	
	
	
	
	public String add() {
		distribuidoraFacade.create(new Distribuidora(this.nombre, this.direccion, this.ruc));
		list = distribuidoraFacade.findAll();
		return null;
	}
	
	public String delete(Distribuidora d) {
		distribuidoraFacade.remove(d);
		list = distribuidoraFacade.findAll();
		return null;
	}

	public String edit(Distribuidora d) {
		d.setEditable(true);
		return null;
	}

	public String save(Distribuidora d) {
		distribuidoraFacade.edit(d);
		d.setEditable(false);
		return null;
	}

	
	


}
