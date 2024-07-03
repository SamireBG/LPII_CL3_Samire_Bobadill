package TestEntidades;

import java.util.List;

import Dao.ClassProductoImp;
import model.TblProductocl3;

public class TestEntidadProducto {

	public static void main(String[] args) {
		
		//hacemos la respectiva instancia
		TblProductocl3 producto = new TblProductocl3();
		ClassProductoImp crud = new ClassProductoImp();
		
		//asignamos valores
				/*-------------------- U N O ---------- R E G I S T R O S --------------------*/
					
				/*
							
				//--- I N S E R T A R --- D A T O S ---
								
				producto.setNombrecl3("Gaseosa Coca-Cola 500 ml");
				producto.setPrecioventacl3(3.00);
				producto.setPreciocompcl3(3.00);
				producto.setEstadocl3("En Stock");
				producto.setDescripcl3("Gaseosa Coca-Cola sabor original de 500 ml");
								
				//--- I N V O C A M O S --- M E T O D O ---
								
				crud.RegistrarProductos(producto);
					
				*/
						
				/*-------------------- F I N ---------- R E G I S T R O S --------------------*/

						
						
						
						
						
						
				/*-------------------- U N O ---------- L I S T A R --------------------*/
					
					
				//--- I N V O C A M O S --- M E T O D O --- L I S T A R ---
								
				List<TblProductocl3> listadoprod=crud.ListadoProducto();
					//--- A P L I C A M O S --- B U C L E --- F O R ---
				for(TblProductocl3 listar:listadoprod){
									
				//--- I M P R I M I M O S --- L O S --- D A T O S ---
									
				System.out.print(
					"-----------------------------------------------" + "\n\n" +
					"-------------------- U N O --------------------" + "\n\n" +
					"Codigo" + "\t\t: "+listar.getIdproductocl3()+ "\n" +
					"Nombre" + "\t\t: "+listar.getNombrecl3()+ "\n" +
					"P. de venta" + "\t: "+listar.getPrecioventacl3()+ "\n" +
					"P. de compra" + "\t: "+listar.getPreciocompcl3()+ "\n" +
					"Estado" + "\t\t: "+listar.getEstadocl3()+ "\n" +
					"Descripcion" + "\t: "+listar.getDescripcl3()+ "\n\n" +
					"-------------------- F I N --------------------" + "\n\n");
				}
								
						
								
				/*-------------------- F I N ---------- L I S T A R --------------------*/		
						
		}//fin del metodo main

}//fin de la clase