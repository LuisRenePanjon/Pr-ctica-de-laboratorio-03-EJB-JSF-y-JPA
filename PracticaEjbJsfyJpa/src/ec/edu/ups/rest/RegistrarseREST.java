package ec.edu.ups.rest;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
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
	
	
	
	@GET @Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response comprobarRegistro(@PathParam("id") String id ) {
		Jsonb jsonb = JsonbBuilder.create();
		Usuario usuario = ejbUsuarioFacade.buscarClienteByCC(id);
		if (usuario != null) {
			return Response.ok(jsonb.toJson(usuario)).build();
		}
		return null;
	}
}
