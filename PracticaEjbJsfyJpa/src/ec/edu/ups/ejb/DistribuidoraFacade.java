package ec.edu.ups.ejb;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import ec.edu.ups.entidad.Distribuidora;
import ec.edu.ups.entidad.FacturaCabecera;

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
	
	
	public void hola(int cod) {
		String codigo = String.valueOf(cod);
		String qu = "SELECT d FROM Distribuidora d WHERE d.codigo = "+codigo;
		List<Distribuidora> query = em.createQuery(qu).getResultList();
		System.out.println("------Entro al query------");
		
		for (Distribuidora distribuidora : query) {
			System.out.println(distribuidora.getCodigo());
		
			
			
		}
	}
	
	

	

}
