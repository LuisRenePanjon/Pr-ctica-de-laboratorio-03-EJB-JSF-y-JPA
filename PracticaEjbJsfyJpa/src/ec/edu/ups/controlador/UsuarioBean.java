package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.RolFacade;
import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.entidad.Rol;
import ec.edu.ups.entidad.Usuario;


@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class UsuarioBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UsuarioFacade ejbUsuarioFacade;
	@EJB
	private RolFacade ejbRolFacade;
	private List<Usuario> list; 
	private List<Usuario> listEmpleados;
	private List<Usuario> listClientes;
	private String nombre;
	private String apellido;
	private String cedula;
	private String correo;
	private String passw;
	
	
	
	public UsuarioBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		list = ejbUsuarioFacade.findAll();
		listEmpleados = ejbUsuarioFacade.listarPorCargo(2);
		listClientes = ejbUsuarioFacade.listarPorCargo(3);
	}

	

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassw() {
		return passw;
	}

	public void setPassw(String passw) {
		this.passw = passw;
	}
	
	public Usuario[] getlist(){
		return list.toArray(new Usuario[0]);
	}
	
	public void setList(List<Usuario> list) {
		this.list=list;
	}

	
	public Usuario[] getListEmpleados() {
		return listEmpleados.toArray(new Usuario[0]);
	}

	public void setListEmpleados(List<Usuario> listEmpleados) {
		this.listEmpleados = listEmpleados;
	}

	public Usuario[] getListClientes() {
		return listClientes.toArray(new Usuario[0]);
	}

	public void setListClientes(List<Usuario> listClientes) {
		this.listClientes = listClientes;
	}

	//CRUD
	public String addCliente() {
		
		Rol cliente=ejbRolFacade.readRol("cliente");
		ejbUsuarioFacade.create(new Usuario(this.nombre,this.apellido,this.cedula,this.correo,this.passw,cliente));
		listClientes = ejbUsuarioFacade.listarPorCargo(3);
		return null;
	}
	
	
	public String addEmpleado() {
		Rol empleado=ejbRolFacade.readRol("empleado");
		ejbUsuarioFacade.create(new Usuario(this.nombre,this.apellido,this.cedula,this.correo,this.passw,empleado));
		listEmpleados = ejbUsuarioFacade.listarPorCargo(2);
		return null;
	}
	
	public String addAdmin() {
		Rol admin=ejbRolFacade.readRol("admin");
		ejbUsuarioFacade.create(new Usuario(this.nombre,this.apellido,this.cedula,this.correo,this.passw,admin));
		listClientes = ejbUsuarioFacade.listarPorCargo(1);
		return null;
	}
	
	
	public String iniciarSesion() {
		Usuario usuario = ejbUsuarioFacade.readCorreo(this.correo, this.passw);
		if(usuario != null) {
			if(usuario.getRol().getCodigo()==2) {
				return "crearEmpleados";
			}
		}
		return null;
	}
	
	public String delete(Usuario usuario) {
		ejbUsuarioFacade.remove(usuario);
		list = ejbUsuarioFacade.findAll();
		return null;
	}
	
	public String deleteEmpleado(Usuario usuario) {
		ejbUsuarioFacade.remove(usuario);
		listEmpleados = ejbUsuarioFacade.listarPorCargo(2);
		return null;
	}
	
	public String deleteCliente(Usuario usuario) {
		ejbUsuarioFacade.remove(usuario);
		listClientes = ejbUsuarioFacade.listarPorCargo(3);
		return null;
	}
	
	
	
	public String edit (Usuario usuario) {
		usuario.setEditable(true);
		return null;
	}
	
	public String save (Usuario usuario) {
		ejbUsuarioFacade.edit(usuario);
		usuario.setEditable(false);
		return null;
	}
	
	
	
	
}
