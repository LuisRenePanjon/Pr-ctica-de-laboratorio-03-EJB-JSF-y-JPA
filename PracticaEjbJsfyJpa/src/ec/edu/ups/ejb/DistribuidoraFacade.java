package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Distribuidora;

@Stateless
public class DistribuidoraFacade extends AbstractFacade<Distribuidora> {
	
	@PersistenceContext(unitName = "PracticaEjbJsfyJpa")
	private EntityManager em;

	public DistribuidoraFacade() {
		super(Distribuidora.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	

}
