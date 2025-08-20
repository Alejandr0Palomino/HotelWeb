<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de Servicios</title>
<style>
    table { border-collapse: collapse; width: 80%; margin: 20px auto; }
    th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
    th { background-color: #f2f2f2; }
</style>
</head>
<body>
    <div align="center">
        <h3>🔧 Listado de Servicios</h3>
        <a href="/senati/index">Inicio</a> | 
        <a href="/senati/servicio/registrar">Nuevo Servicio</a>
        
        <table>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Acciones</th>
            </tr>
            
            <c:forEach var="servicio" items="${bServicios}">
                <tr>
                    <td>${servicio.servicioId}</td>
                    <td>${servicio.nombre}</td>
                    <td>${servicio.descripcion}</td>
                    <td>
                        <a href="/senati/servicio/editar/${servicio.servicioId}">Editar</a> |
                        <a href="/senati/servicio/borrar/${servicio.servicioId}">Borrar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>