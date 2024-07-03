package Interface;

import java.util.List;

import model.TblUsuariocl3;

public interface InterfaceUsuariocl3 {

	public void RegistrarUsuario(TblUsuariocl3 usuario);
	public List<TblUsuariocl3> ListadoUsuario();
	public TblUsuariocl3 ValidarUsuario(String usuario, String contraseña);
	
}//fin de la interface
