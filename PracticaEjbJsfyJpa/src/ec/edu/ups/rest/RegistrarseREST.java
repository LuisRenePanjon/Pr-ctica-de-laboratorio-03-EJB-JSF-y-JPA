package ec.edu.ups.rest;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.entidad.Usuario;

@Path("/Registrarse")
public class RegistrarseREST {
	@EJB
	private UsuarioFacade ejbUsuarioFacade;

	@POST 
	//@Produces(MediaType.APPLICATION_JSON)
	@Path("/registro")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response comprobarRegistro(@FormParam("cedula") String id ) {
		Jsonb jsonb = JsonbBuilder.create();
		Usuario usuario = ejbUsuarioFacade.buscarClienteByCC(id);
	
		usuario.setCuenta("r");
		
		ejbUsuarioFacade.edit(usuario);
		if (usuario != null) {
			return Response.status(201).entity("usuario registrado: " + usuario)
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, conten-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST , PUT, DELETE").build();
		}
		return null;
	}
}
