package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.FacturaCabecera;

@Stateless
public class FacturaCabeceraFacade extends AbstractFacade<FacturaCabecera> {
	
	@PersistenceContext(unitName = "PracticaEjbJsfyJpa")
	private EntityManager em;

	public FacturaCabeceraFacade() {
		super(FacturaCabecera.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	
	

}
