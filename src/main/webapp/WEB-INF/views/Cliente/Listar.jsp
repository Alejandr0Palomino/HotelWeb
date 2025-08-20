<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de Clientes</title>
<style>
    table { border-collapse: collapse; width: 80%; margin: 20px auto; }
    th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
    th { background-color: #f2f2f2; }
    .email { color: blue; }
</style>
</head>
<body>
    <div align="center">
        <h3>👤 Listado de Clientes</h3>
        <a href="/senati/index">Inicio</a> | 
        <a href="/senati/cliente/registrar">Nuevo Cliente</a>
        
        <table>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Email</th>
                <th>Teléfono</th>
                <th>Acciones</th>
            </tr>
            
            <c:forEach var="cliente" items="${bClientes}">
                <tr>
                    <td>${cliente.clienteId}</td>
                    <td>${cliente.nombre}</td>
                    <td class="email">${cliente.email}</td>
                    <td>${cliente.telefono}</td>
                    <td>
                        <a href="/senati/cliente/editar/${cliente.clienteId}">Editar</a> |
                        <a href="/senati/cliente/borrar/${cliente.clienteId}">Borrar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>