<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de Hoteles</title>
<style>
    table { border-collapse: collapse; width: 80%; margin: 20px auto; }
    th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
    th { background-color: #f2f2f2; }
    .actions { white-space: nowrap; }
</style>
</head>
<body>
    <div align="center">
        <h3>🏨 Listado de Hoteles</h3>
        <a href="/senati/index">Inicio</a> | 
        <a href="/senati/hotel/registrar">Nuevo Hotel</a>
        
        <table>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Dirección</th>
                <th>Estrellas</th>
                <th>Acciones</th>
            </tr>
            
            <c:forEach var="hotel" items="${bHoteles}">
                <tr>
                    <td>${hotel.hotelId}</td>
                    <td>${hotel.nombre}</td>
                    <td>${hotel.direccion}</td>
                    <td>${hotel.estrellas} ★</td>
                    <td class="actions">
                        <a href="/senati/hotel/editar/${hotel.hotelId}">Editar</a> |
                        <a href="/senati/hotel/borrar/${hotel.hotelId}">Borrar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>