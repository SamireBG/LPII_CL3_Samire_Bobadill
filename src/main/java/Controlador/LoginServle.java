package Controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ClassUsuarioImp;
import model.TblUsuariocl3;

/**
 * Servlet implementation class LoginServle
 */
public class LoginServle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Hola desde LoginServle!");
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String contrase�a = request.getParameter("contrase�a");

        ClassUsuarioImp crud = new ClassUsuarioImp();
        TblUsuariocl3 usu = crud.ValidarUsuario(usuario, contrase�a);

        if (usu != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usu);
            response.sendRedirect("RegistrarProducto.jsp");
        } else {
            request.setAttribute("errorMessage", "Usuario o contrase�a incorrectos");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

}
