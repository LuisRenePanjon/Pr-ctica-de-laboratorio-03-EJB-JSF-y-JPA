package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.entidad.Bodega;
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
	
	public List<Stock> listaInventario(Bodega bodega) {
		System.out.println("ya llego");

		String sql = "SELECT s FROM Stock s where  s.bodega.nombre='" + bodega.getNombre() + "'";
		System.out.println(sql);
		
		List<Stock> list = em.createQuery(sql).getResultList();
		
		for (Stock stock : list) {
			System.out.println("Nombre  bodega" + stock.getBodega().getNombre());
			System.out.println("Stock" + stock.getCantidad());
			System.out.println("Nombre producto" + stock.getProducto().getNombre());
			System.out.println("Precio Unitario" + stock.getProducto().getPrecio());
		}
	
		System.out.println(list);
		return list;
	}
	
	public Bodega nombreBodega(String bodega) {
		Bodega cat = new Bodega();
		
		try {
			String sql = "SELECT b FROM Bodega b where b.nombre='" + bodega + "'";
			System.out.println(sql);
			Query query = em.createQuery(sql);
			cat = (Bodega) query.getSingleResult();

		} catch (Exception e) {
			System.out.println("bodega" + e.getMessage());
		}
		return cat;
	}

}
