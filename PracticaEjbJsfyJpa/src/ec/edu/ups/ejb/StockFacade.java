package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Stock;

@Stateless
public class StockFacade extends AbstractFacade<Stock> {

	
	
	
	@PersistenceContext(unitName = "PracticaEjbJsfyJpa")
	private EntityManager em;
	
	public StockFacade() {
		super(Stock.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

}
