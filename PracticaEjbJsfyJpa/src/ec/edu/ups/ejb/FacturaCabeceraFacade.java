package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.FacturaCabecera;

@Stateless
public class FacturaCabeceraFacade extends AbstractFacade<FacturaCabecera> {
	
	@PersistenceContext(unitName = "PracticaEjbJsfyJpa")
	private EntityManager em1;

	public FacturaCabeceraFacade() {
		super(FacturaCabecera.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em1;
	}
	
	public List<FacturaCabecera> buscarFacturasNoNulas() {
		String qu = "SELECT f FROM FacturaCabecera f WHERE f.estado = 'V'";
		List<FacturaCabecera> query =  em1.createQuery(qu).getResultList();
		System.out.println("------Entro al query 2------");
		
		for (FacturaCabecera facturaCabecera : query) {
			System.out.println(facturaCabecera.getEstado());	
		}
		return query;
	}
	
	public List<FacturaCabecera> buscarFacturasNulas() {
		String qu = "SELECT f FROM FacturaCabecera f WHERE f.estado = 'F'";
		List<FacturaCabecera> query =  em1.createQuery(qu).getResultList();
		System.out.println("------Entro al query 2------");
		
		for (FacturaCabecera facturaCabecera : query) {
			System.out.println(facturaCabecera.getEstado());	
		}
		return query;
	}
	
	

}
