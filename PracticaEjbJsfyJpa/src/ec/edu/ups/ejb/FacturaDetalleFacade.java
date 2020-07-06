package ec.edu.ups.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.FacturaDetalle;

public class FacturaDetalleFacade extends AbstractFacade<FacturaDetalle> {

	@PersistenceContext(unitName = "PracticaEjbJsfyJpa")
	private EntityManager em;

	public FacturaDetalleFacade() {
		super(FacturaDetalle.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

}