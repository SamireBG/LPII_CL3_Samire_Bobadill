package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interface.InterfaceProductocl3;
import model.TblProductocl3;

public class ClassProductoImp implements InterfaceProductocl3{

	

	@Override
	public void RegistrarProductos(TblProductocl3 producto) {
		
		//establecer la cadena de conexion con la unidad de persistencia
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL3_Samire_Bobadilla");
		//gestionar las entidades
		EntityManager em=fabr.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		//registramos
		em.persist(producto);
		//emitimos mensaje por consola
		System.out.print("Producto registrado en la BD");
		//configuramos
		em.getTransaction().commit();
		//cerramos
		em.close();
		
	}

	@Override
	public List<TblProductocl3> ListadoProducto() {
		
		//establecemos conexion con la unidad de persistencia
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL3_Samire_Bobadilla");
		//gestionar las entidades
		EntityManager em=fabr.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		//recuperamos el listado de producto de la BD
		//aplicamos consultas JPQL, el metodo createquery(), sirve para hacer consultas dinamicas
		List<TblProductocl3> listado=em.createQuery("select c from TblProductocl3 c",TblProductocl3.class).getResultList();
		//confirmamos
		em.getTransaction().commit();
		//cerramos
		em.close();
		//recuperamos el producto buscado de la BD
		return listado;
		
	}

	
	@Override
	public void ActualizarProducto(TblProductocl3 producto) {
	    EntityManagerFactory emf = null;
	    EntityManager em = null;
	    try {
	        emf = Persistence.createEntityManagerFactory("LPII_CL3_Samire_Bobadilla");
	        em = emf.createEntityManager();
	        em.getTransaction().begin();
	        
	        // Realizar la actualización usando merge
	        em.merge(producto);
	        
	        em.getTransaction().commit();
	        System.out.println("Producto Actualizado en BD");
	    } catch (Exception e) {
	        if (em != null && em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        if (em != null) {
	            em.close();
	        }
	        if (emf != null) {
	            emf.close();
	        }
	    }
	}


	
	
	@Override
	public TblProductocl3 BuscarProducto(TblProductocl3 producto) {

		//establecer la conexion con la unidad de persistencia
        EntityManagerFactory farb= Persistence.createEntityManagerFactory("LPII_CL3_Samire_Bobadilla");
        //gestionar las entidades
        EntityManager em= farb.createEntityManager();
        //inicar la transaccion
        em.getTransaction().begin();
        //recuperamos en codigo a buscar
        TblProductocl3 buscarprod=em.find(TblProductocl3.class, producto.getIdproductocl3());
        //confirmamos
        em.getTransaction().commit();
        //cerramos
        em.close();
        //retornamos el producto buscado en la BD
        return buscarprod;

	}

	@Override
	public void EliminarProducto(TblProductocl3 producto) {

		//establecemos conexion con la unidad de persistencia
		EntityManagerFactory farb=Persistence.createEntityManagerFactory("LPII_CL3_Samire_Bobadilla");
		//gestionar las entidades
		EntityManager em=farb.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		//recuperamos el codigo eliminar
		TblProductocl3 elim=em.merge(producto);
		//procedemos a eliminar
		em.remove(elim);
		//emitimos el mensaje por consola
		System.out.print("Cliente Eliminado de la BD");
		//confirmamos
		em.getTransaction().commit();
		//cerramos
		em.close();
		
	}

	

}
