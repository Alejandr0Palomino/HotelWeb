<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listado de Reservas</title>
    <style>
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 12px; text-align: left; border-bottom: 1px solid #ddd; }
        .status-active { color: green; }
        .status-completed { color: blue; }
    </style>
</head>
<body>
    <h2>Listado de Reservas</h2>
    <a href="/senati/reserva/registrar">Nueva Reserva</a>
    <table>
        <tr>
            <th>ID</th>
            <th>Cliente</th>
            <th>Habitación</th>
            <th>Fecha Entrada</th>
            <th>Fecha Salida</th>
            <th>Estado</th>
            <th>Acciones</th>
        </tr>
        <c:forEach items="${reservas}" var="reserva">
        <tr>
            <td>${reserva.reservaId}</td>
            <td>${reserva.cliente.nombre}</td>
            <td>${reserva.habitacion.numero} (${reserva.habitacion.tipo})</td>
            <td>${reserva.fechaEntrada}</td> <!-- Mostrar como string -->
            <td>${reserva.fechaSalida}</td>   <!-- Mostrar como string -->
            <td class="${reserva.pago != null ? 'status-completed' : 'status-active'}">
                ${reserva.pago != null ? 'Pagado' : 'Pendiente'}
            </td>
            <td>
                <a href="/senati/reserva/editar/${reserva.reservaId}">Editar</a> |
                <a href="/senati/reserva/borrar/${reserva.reservaId}">Borrar</a>
                <c:if test="${reserva.pago == null}">
                    | <a href="/senati/pago/registrar?reservaId=${reserva.reservaId}">Pagar</a>
                </c:if>
            </td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>