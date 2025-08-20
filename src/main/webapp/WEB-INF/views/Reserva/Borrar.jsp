<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Confirmar Eliminación</title>
    <style>
        .confirmation-container { max-width: 500px; margin: 30px auto; padding: 20px; text-align: center; border: 1px solid #ddd; border-radius: 5px; }
        .btn-confirm { background-color: #f44336; color: white; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; }
        .btn-cancel { background-color: #ccc; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; }
    </style>
</head>
<body>
    <div class="confirmation-container">
        <h2>¿Confirmar eliminación?</h2>
        <p>Está a punto de eliminar la siguiente reserva:</p>
        
        <p><strong>Reserva #${reserva.reservaId}</strong></p>
        <p>Cliente: ${reserva.cliente.nombre}</p>
        <p>Habitación: ${reserva.habitacion.numero} (${reserva.habitacion.tipo})</p>
        <p>Fechas: <fmt:formatDate value="${reserva.fechaEntrada}" pattern="dd/MM/yyyy"/> a 
                  <fmt:formatDate value="${reserva.fechaSalida}" pattern="dd/MM/yyyy"/></p>
        
        <form method="post" action="/senati/reserva/borrar/${reserva.reservaId}" style="display: inline;">
            <button type="submit" class="btn-confirm">Confirmar Eliminación</button>
        </form>
        
        <a href="/senati/reserva/listar" class="btn-cancel">Cancelar</a>
    </div>
</body>
</html>