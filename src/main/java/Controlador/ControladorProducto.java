package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ClassProductoImp;
import model.TblProductocl3;

/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
	    if (session == null || session.getAttribute("usuario") == null) {
	        response.sendRedirect("login.jsp");
	        return;
	    }
		TblProductocl3 producto=new TblProductocl3();
		ClassProductoImp crud=new ClassProductoImp();
		
		//recuperamos la accion y codigo
		String accion=request.getParameter("accion");
		//aplicamos una condicion
		if(accion!=null){
			switch(accion){
			
			case "Modificar":
				int codigo=Integer.parseInt(request.getParameter("cod"));
				//asignar el codigo
				producto.setIdproductocl3(codigo);
				TblProductocl3 buscarprod=crud.BuscarProducto(producto);
				//enviar los valores buscados por codigo de la BD al fomrulario Actualizar
				request.setAttribute("codigo", buscarprod.getIdproductocl3());
				request.setAttribute("nombre", buscarprod.getNombrecl3());
				request.setAttribute("venta", buscarprod.getPrecioventacl3());
				request.setAttribute("compra", buscarprod.getPreciocompcl3());
				request.setAttribute("estado", buscarprod.getEstadocl3());
				request.setAttribute("descripcion", buscarprod.getDescripcl3());
				//redirecciono
				request.getRequestDispatcher("/ActualizarProducto.jsp").forward(request, response);
				//salimos
				break;
				
			case "Eliminar":
				int codeliminar=Integer.parseInt(request.getParameter("cod"));
				//asignamos el codigo a eliminar
				producto.setIdproductocl3(codeliminar);
				//invocamos al metodo eliminar
				crud.EliminarProducto(producto);
				//refrescar el listado
				List<TblProductocl3> listadoprod=crud.ListadoProducto();
				//invocamos el listado de productos para la vista
				request.setAttribute("listadoproducto", listadoprod);
				//redirecionamos
				request.getRequestDispatcher("/ListarProductos.jsp").forward(request, response);
				//salimos
				break;
				
			case "Listar":
				
				List<TblProductocl3> listadoproducto=crud.ListadoProducto();
				//invocamos el listado de productos para la vista
				request.setAttribute("listadoproducto", listadoproducto);
				//redirecionamos
				request.getRequestDispatcher("/ListarProductos.jsp").forward(request, response);
			
			}
		}
		
				
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
	    if (session == null || session.getAttribute("usuario") == null) {
	        response.sendRedirect("login.jsp");
	        return;
	    }
	    String codigo=request.getParameter("codigo");
		String nombre=request.getParameter("nombre");
		String pventa=request.getParameter("venta");
		String pcompra=request.getParameter("compra");
		String estado=request.getParameter("estado");
		String descripcion=request.getParameter("descripcion");
		
		Double venta = null;
		Double compra = null;
		try{
			venta=Double.parseDouble(pventa);
			compra=Double.parseDouble(pcompra);
		}
		catch(Exception e){
			e.fillInStackTrace();
			
			request.setAttribute("erroMessage", "Los valores de venta y compra deben ser números válidos.");
			request.getRequestDispatcher("/RegistrarProducto.jsp").forward(request, response);
	        return;
		}
		
		List<TblProductocl3> listadoproducto=null;
		
		//instanciar las respectivas entidades
		TblProductocl3 productos=new TblProductocl3();
		ClassProductoImp crud=new ClassProductoImp();
		//asignamos valores
		productos.setNombrecl3(nombre);
		productos.setPrecioventacl3(venta);
		productos.setPreciocompcl3(compra);
		productos.setEstadocl3(estado);
		productos.setDescripcl3(descripcion);
		if(codigo!=null){
			//recupero el codigo a actualiar
			int cod=Integer.parseInt(codigo);
			//asigno el codigo a actualizar
			productos.setIdproductocl3(cod);
			//invocamos al metodo actualizar
			crud.ActualizarProducto(productos);
			//actualizar listado productos
			listadoproducto=crud.ListadoProducto();
		}else{
		
		//invocamos al metodo registrar
		crud.RegistrarProductos(productos);
		//actualizar listado productos
		listadoproducto=crud.ListadoProducto();
		
		}
		
		//invocamos el listado de productos para la vista
		request.setAttribute("listadoproducto", listadoproducto);
		//redirecionamos
		request.getRequestDispatcher("/ListarProductos.jsp").forward(request, response);
		
	}

}
