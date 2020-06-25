package ec.edu.ups.entidad;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bodega
 *
 */
@Entity

public class Bodega implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int codigo;
	private String nombre;

	public Bodega() {
		super();
	}
   
}
