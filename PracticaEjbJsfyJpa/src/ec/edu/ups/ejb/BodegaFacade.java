package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.entidad.Bodega;
import ec.edu.ups.entidad.Ubicacion;

@Stateless
public class BodegaFacade extends AbstractFacade<Bodega>{
	
	@PersistenceContext(unitName = "PracticaEjbJsfyJpa")
	private EntityManager em;
	
	public BodegaFacade() {
		super(Bodega.class);
	}
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public Bodega readBodega(String nombre) {
		Query query = em.createNamedQuery("getByBodega");
		query.setParameter("nombre", nombre);
		List result = query.getResultList();
		Bodega respuesta = null;
		if (!result.isEmpty()) {
			respuesta = (Bodega)result.get(0);
		}
		return respuesta;
	}

}
