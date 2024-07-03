package Interface;

import java.util.List;

import model.TblProductocl3;

public interface InterfaceProductocl3 {

	public void RegistrarProductos(TblProductocl3 producto);
	public List<TblProductocl3> ListadoProducto();
	public TblProductocl3 BuscarProducto(TblProductocl3 producto);
	public void EliminarProducto(TblProductocl3 producto);
	public void ActualizarProducto(TblProductocl3 producto);
}
