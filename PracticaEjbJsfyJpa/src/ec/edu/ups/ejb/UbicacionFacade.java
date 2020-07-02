package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.entidad.Ubicacion;

@Stateless
public class UbicacionFacade extends AbstractFacade<Ubicacion> {

	@PersistenceContext(unitName = "PracticaEjbJsfyJpa")
	private EntityManager em;

	public UbicacionFacade() {
		super(Ubicacion.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public Ubicacion readUbicacion(String ciudad) {
		Query query = em.createNamedQuery("getByCiudad");
		query.setParameter("ciudad", ciudad);
		List result = query.getResultList();
		Ubicacion respuesta = null;
		if (!result.isEmpty()) {
			respuesta = (Ubicacion)result.get(0);
		}
		return respuesta;
	}

}
