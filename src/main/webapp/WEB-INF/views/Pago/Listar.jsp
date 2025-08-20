<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Pagos</title>
    <style>
        table { border-collapse: collapse; width: 80%; margin: 20px auto; }
        th, td { border: 1px solid #ddd; padding: 8px; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
<div align="center">
    <h3>💳 Listado de Pagos</h3>
    <a href="/senati/index">Inicio</a> |
    <a href="/senati/pago/registrar">Nuevo Pago</a>

    <table>
        <tr>
            <th>ID</th>
            <th>Monto</th>
            <th>Método</th>
            <th>ID Reserva</th>
            <th>Acciones</th>
        </tr>

        <c:forEach var="pago" items="${bPagos}">
            <tr>
                <td>${pago.pagoId}</td>
                <td>S/. ${pago.monto}</td>
                <td>${pago.metodoPago}</td>
                <td>${pago.reserva.reservaId}</td>
                <td>
                    <a href="/senati/pago/editar/${pago.pagoId}">Editar</a> |
                    <a href="/senati/pago/borrar/${pago.pagoId}">Borrar</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
