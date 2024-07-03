<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="model.TblProductocl3"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Productos</title>
<style type="text/css">
    body {
        background-image: url('imagenes/sub.jpg'); /* URL de tu imagen de fondo */
        background-size: cover; /* Cubrir toda el área del cuerpo */
        background-repeat: no-repeat; /* No repetir la imagen */
        background-attachment: fixed; /* Fijar la imagen para que no se desplace con el contenido */
        background-position: center; /* Centrar la imagen */
        font-family: Arial, sans-serif; /* Tipo de fuente para el cuerpo del documento */
        padding: 20px; /* Espaciado interior */
        margin: 0; /* Eliminar margen exterior */
    }
    .titulo{
    	text-align: center;
    	color: white;
    }
    .tabla-productos {
        background-color: rgba(255, 255, 255, 0.7); /* Fondo semitransparente */
        border-collapse: collapse; /* Colapsar bordes de celda */
        width: 60%; /* Ancho de la tabla */
        margin: 50px auto 0; /* Margen superior 50px, centrado horizontalmente */
        padding: 20px; /* Espaciado interno */
    }
    .tabla-productos th, .tabla-productos td {
        padding: 10px; /* Espaciado interno de celda */
        text-align: center; /* Alineación centrada del texto */
        color: black; /* Color de texto negro */
    }
    .tabla-productos th {
        background-color: #ffffff; /* Fondo blanco para encabezados */
    }
    .boton-reg {
        background-color: rgba(255, 255, 255, 0.5); /* Botón semitransparente */
        color: white; /* Texto blanco */
        border: none; /* Sin borde */
        border-radius: 20px; /* Bordes redondeados */
        padding: 15px 30px; /* Espaciado interno */
        font-size: 16px; /* Tamaño de fuente */
        cursor: pointer; /* Cambio de cursor */
        display: block; /* Hace que el botón ocupe toda la anchura disponible */
        margin: 20px auto; /* Margen superior e inferior de 20px, centrado horizontalmente */
        text-align: center; /* Alineación centrada del texto */
        text-decoration: none; /* Sin subrayado */
    }
</style>
</head>
<body>

<h1 class="titulo">PRODUCTOS REGISTRADOS</h1>

<button class="boton-reg" onclick="window.location.href = 'RegistrarProducto.jsp';">REGISTRAR PRODUCTOS</button>
<table class="tabla-productos" border="2">
    <tr>
    	<th>CODIGO</th>
        <th>NOMBRE</th>
        <th>P. VENTA</th>
        <th>P. COMPRA</th>
        <th>ESTADO</th>
        <th>DESCRIPCION</th>
        <th colspan="2" align="center">ACCIONES</th>
    </tr>
    <% List<TblProductocl3> listadoproducto = (List<TblProductocl3>)request.getAttribute("listadoproducto");
    if(listadoproducto!=null){
        for(TblProductocl3 listar : listadoproducto){
    %>
    <tr>
    	<td><%=listar.getIdproductocl3()%></td>
        <td><%=listar.getNombrecl3()%></td>
        <td><%=listar.getPrecioventacl3()%></td>
        <td><%=listar.getPreciocompcl3()%></td>
        <td><%=listar.getEstadocl3()%></td>
        <td><%=listar.getDescripcl3()%></td>
        <td><a href="ControladorProducto?accion=Eliminar&cod=<%=listar.getIdproductocl3()%>">Eliminar</a></td>
		<td><a href="ControladorProducto?accion=Modificar&cod=<%=listar.getIdproductocl3()%>">Actualizar</a></td>
    </tr>
    <% }//fin del bucle for %> <% }//fin de la condicion %> </table>

</body>
</html>
