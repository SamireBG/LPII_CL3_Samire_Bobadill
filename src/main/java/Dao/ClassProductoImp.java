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
		//recuperamos el listado de cliente de la BD
		//aplicamos consultas JPQL, el metodo createquery(), sirve para hacer consultas dinamicas
		List<TblProductocl3> listado=em.createQuery("select c from TblProductocl3 c",TblProductocl3.class).getResultList();
		//confirmamos
		em.getTransaction().commit();
		//cerramos
		em.close();
		//recuperamos el cliente buscado de la BD
		return listado;
		
	}

}
