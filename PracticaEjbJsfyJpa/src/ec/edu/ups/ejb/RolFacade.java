package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.entidad.Rol;

@Stateless
public class RolFacade extends AbstractFacade<Rol>{

	@PersistenceContext(unitName = "PracticaEjbJsfyJpa")
	private EntityManager em;
	
	public RolFacade() {
		super(Rol.class);
	}
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

	
	public Rol readRol(String cargo) {
		Query query = em.createNamedQuery("getByCargo");
		query.setParameter("cargo", cargo);
		List result = query.getResultList();
		Rol respuesta = null;
		if(!result.isEmpty()){
			respuesta = (Rol)result.get(0);
		}
		return respuesta;
	}
}
