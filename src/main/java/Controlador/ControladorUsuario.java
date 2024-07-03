package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassUsuarioImp;
import model.TblUsuariocl3;

/**
 * Servlet implementation class ControladorUsuario
 */
public class ControladorUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TblUsuariocl3 usuario=new TblUsuariocl3();
		ClassUsuarioImp crud=new ClassUsuarioImp();
		List<TblUsuariocl3> listadousuario=crud.ListadoUsuario();
		//invocamos el listado de productos para la vista
		request.setAttribute("listadousuario", listadousuario);
		//redirecionamos
		request.getRequestDispatcher("/ListarUsuario.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String usuario=request.getParameter("usuario");
		String contrase�a=request.getParameter("contrase�a");
				
		//instanciar las respectivas entidades
		TblUsuariocl3 usu=new TblUsuariocl3();
		ClassUsuarioImp crud=new ClassUsuarioImp();
		//asignamos valores
		usu.setUsuariocl3(usuario);
		usu.setPasswordcl3(contrase�a);
		//invocamos al metodo registrar
		crud.RegistrarUsuario(usu);
				
		List<TblUsuariocl3> listadousuario=crud.ListadoUsuario();
		//invocamos el listado de productos para la vista
		request.setAttribute("listadousuario", listadousuario);
		//redirecionamos
		request.getRequestDispatcher("/ListarUsuario.jsp").forward(request, response);
		
		
		
	}

}
