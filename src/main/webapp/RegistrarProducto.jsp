<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Productos</title>
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
        color: white; /* Color de texto blanco para todo el documento */
    }
    .titulo {
    	text-align: center;
    }
    .tabla-productos {
        background-color: rgba(255, 255, 255, 0.5); /* Fondo semitransparente */
        border-collapse: collapse; /* Colapsar bordes de celda */
        width: 30%; /* Ancho reducido de la tabla */
        margin: 50px auto 0; /* Margen superior 50px, centrado horizontalmente */
        padding: 20px; /* Espaciado interno */
    }
    .tabla-productos th, .tabla-productos td {
        padding: 10px; /* Espaciado interno de celda */
        text-align: left; /* Alineación del texto a la izquierda */
        color: black; /* Color de texto negro */
        font-size: 18px; /* Tamaño de fuente */
    }
    .tabla-productos th {
        background-color: #ffffff; /* Fondo blanco para encabezados */
    }
    .tabla-productos input[type="text"] {
        width: 100%; /* Ancho completo del campo de entrada */
        padding: 8px; /* Espaciado interno del campo de entrada */
        box-sizing: border-box; /* Incluir el padding en el ancho total */
        text-align: right; /* Alinear texto a la derecha */
    }
    .tabla-productos input[type="submit"] {
        background-color: rgba(0, 0, 0, 0.5); /* Botón semitransparente negro */
        color: white; /* Texto blanco */
        border: none; /* Sin borde */
        border-radius: 20px; /* Bordes redondeados */
        padding: 15px 30px; /* Espaciado interno */
        font-size: 20px; /* Tamaño de fuente más grande para el botón */
        cursor: pointer; /* Cambio de cursor */
        display: block; /* Hace que el botón ocupe toda la anchura disponible */
        margin: 20px auto; /* Margen superior e inferior de 20px, centrado horizontalmente */
        text-align: center; /* Alineación centrada del texto */
        text-decoration: none; /* Sin subrayado */
    }
</style>
</head>
<body>

<h1 class="titulo">REGISTRAR PRODUCTOS</h1>

<form action="ControladorProducto" method="post">

	<table class="tabla-productos">
		<tr>
			<td>NOMBRE</td>
			<td><input type="text" name="nombre"></td>
		</tr>
		<tr>
			<td>P. VENTA</td>
			<td><input type="text" name="venta"></td>
		</tr>
		<tr>
			<td>P. COMPRA</td>
			<td><input type="text" name="compra"></td>
		</tr>
		<tr>
			<td>ESTADO</td>
			<td><input type="text" name="estado"></td>
		</tr>
		<tr>
			<td>DESCRIPCION</td>
			<td><input type="text" name="descripcion"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="Registrar Producto">
			</td>
		</tr>
		
	</table>

</form>
</body>
</html>
