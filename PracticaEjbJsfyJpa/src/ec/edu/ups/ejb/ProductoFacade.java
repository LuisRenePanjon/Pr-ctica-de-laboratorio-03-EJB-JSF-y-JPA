package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.entidad.Bodega;
import ec.edu.ups.entidad.Producto;


@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {
	
	
	
	
	@PersistenceContext(unitName = "PracticaEjbJsfyJpa")
	private EntityManager em;
	
	public ProductoFacade() {
		super(Producto.class);
		
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public Producto readProducto(String nombre) {
		Query query = em.createNamedQuery("getByProducto");
		query.setParameter("nombre", nombre);
		List result = query.getResultList();
		Producto respuesta = null;
		if (!result.isEmpty()) {
			respuesta = (Producto)result.get(0);
		}
		return respuesta;
	}

}
