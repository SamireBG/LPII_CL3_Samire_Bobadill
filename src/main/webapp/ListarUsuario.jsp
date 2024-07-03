<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="model.TblUsuariocl3"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Usuarios</title>
<style type="text/css">
    body {
        background-image: url('imagenes/log.jpg'); /* URL de tu imagen de fondo */
        background-size: cover; /* Cubrir toda el área del cuerpo */
        background-repeat: no-repeat; /* No repetir la imagen */
        background-attachment: fixed; /* Fijar la imagen para que no se desplace con el contenido */
        background-position: center; /* Centrar la imagen */
        font-family: Arial, sans-serif; /* Tipo de fuente para el cuerpo del documento */
        padding: 20px; /* Espaciado interior */
        margin: 0; /* Eliminar margen exterior */
        color: white; /* Color de texto blanco para todo el documento */
    }
    .titulo {
        text-align: center;
        color: white;
    }
    .tabla-usuarios {
        background-color: rgba(255, 255, 255, 0.5); /* Fondo semitransparente */
        border-collapse: collapse; /* Colapsar bordes de celda */
        width: 40%; /* Ancho de la tabla */
        margin: 50px auto 0; /* Margen superior 50px, centrado horizontalmente */
        padding: 20px; /* Espaciado interno */
    }
    .tabla-usuarios th, .tabla-usuarios td {
        padding: 10px; /* Espaciado interno de celda */
        text-align: center; /* Alineación centrada del texto */
        color: black; /* Color de texto negro */
    }
    .tabla-usuarios th {
        background-color: #ffffff; /* Fondo blanco para encabezados */
    }
    .tabla-usuarios a {
        text-decoration: none; /* Sin subrayado para los enlaces */
        color: blue; /* Color azul para los enlaces */
    }
    .boton-reg {
        background-color: rgba(0, 0, 0, 0.7); /* Botón semitransparente */
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

<h1 class="titulo">LISTA DE USUARIOS REGISTRADOS</h1>

<button class="boton-reg" onclick="window.location.href = 'RegistrarUsuario.jsp';">REGISTRAR USUARIO</button>

<table class="tabla-usuarios" border="2" align="center">
    <tr>
        <td>Código</td>
        <td>Nombre</td>
        <td>Contraseña</td>
    </tr>

    <% 
    List<TblUsuariocl3> listadousuario = (List<TblUsuariocl3>) request.getAttribute("listadousuario");
    if (listadousuario != null) {
        for (TblUsuariocl3 listar : listadousuario) {
    %>
    <tr>
        <td><%=listar.getIdusuariocl3()%></td>
        <td><%=listar.getUsuariocl3()%></td>
        <td><%=listar.getPasswordcl3()%></td>
    </tr>
    <%
        } // fin del bucle for
    }
    %>

</table>

<button class="boton-reg" onclick="window.location.href = 'ListarProductos.jsp';">LISTA DE PRODUCTOS</button>

</body>
</html>
