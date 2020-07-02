package ec.edu.ups.controlador;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.FacturaCabeceraFacade;
import ec.edu.ups.entidad.Distribuidora;
import ec.edu.ups.entidad.FacturaCabecera;


@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class FacturaCabeceraBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private FacturaCabeceraFacade facturaCabeceraFacade;
	
	private Date fecha;
	private String estado;
	
	private List<FacturaCabecera> facturas;
	private List<FacturaCabecera> facturasNulas;
	
	

	public FacturaCabeceraBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		facturas = facturaCabeceraFacade.buscarFacturasNoNulas();
		facturasNulas = facturaCabeceraFacade.buscarFacturasNulas();
		
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
	
	
	
	
	public List<FacturaCabecera> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<FacturaCabecera> facturas) {
		this.facturas = facturas;
	}

	
	
	
	
	
	public List<FacturaCabecera> getFacturasNulas() {
		return facturasNulas;
	}

	public void setFacturasNulas(List<FacturaCabecera> facturasNulas) {
		this.facturasNulas = facturasNulas;
	}

	/*****************************************************************/
	
	
	
	public String edit(FacturaCabecera fac) {
		fac.setEditable(true);
		return null;
	}
	
	public String save (FacturaCabecera fac) {
		
		facturaCabeceraFacade.edit(fac);
		facturas = facturaCabeceraFacade.buscarFacturasNoNulas();
		facturasNulas = facturaCabeceraFacade.buscarFacturasNulas();
		fac.setEditable(false);
		return null;
		
	}
	

	public Distribuidora imprimir() {
		
		facturaCabeceraFacade.buscarFacturasNoNulas();
		
		
		return null;
	}
	
	
	
	

}
