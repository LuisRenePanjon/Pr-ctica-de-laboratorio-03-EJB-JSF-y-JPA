package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import com.sun.research.ws.wadl.Request;

import ec.edu.ups.ejb.RolFacade;
import ec.edu.ups.entidad.Rol;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class RolBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private RolFacade rolFacade;
	private List<Rol> list;
	private String cargo;

	public RolBean() {
		// TODO Auto-generated constructor stub
		
	}
	
	
	@PostConstruct
	public void init() {
		list = rolFacade.findAll();
	}
	
	
	public Rol[] getList() {
		return list.toArray(new Rol[0]);
	}
	
	public void setList(List<Rol> list) {
		this.list=list;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String add() {
		rolFacade.create(new Rol(this.cargo));
		list = rolFacade.findAll();
		return null;
	}
	
	public String delete (Rol rol) {
		rolFacade.remove(rol);
		list = rolFacade.findAll();
		return null;
	}
	
	public String edit(Rol rol) {
		rol.setEditable(true);
		return null;
	}
	
	public String save(Rol rol) {
		rolFacade.edit(rol);
		rol.setEditable(false);
		return null;
	}

}
