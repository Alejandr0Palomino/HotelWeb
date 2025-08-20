<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Confirmar Eliminación de Pago</title>
    <style>
        .confirmation-box {
            max-width: 500px;
            margin: 30px auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #fff8f8;
            text-align: center;
        }
        .payment-details {
            margin: 20px 0;
            padding: 15px;
            background-color: #f8f9fa;
            border-radius: 4px;
        }
        .btn {
            padding: 10px 20px;
            margin: 0 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
        }
        .btn-delete {
            background-color: #dc3545;
            color: white;
        }
        .btn-cancel {
            background-color: #6c757d;
            color: white;
        }
        .warning-message {
            color: #dc3545;
            font-weight: bold;
            margin: 15px 0;
        }
    </style>
</head>
<body>
    <div class="confirmation-box">
        <h2>Confirmar Eliminación de Pago</h2>
        
        <div class="payment-details">
            <p><strong>Pago #${pago.pagoId}</strong></p>
            <p>Monto: <fmt:formatNumber value="${pago.monto}" type="currency"/></p>
            <p>Método: ${pago.metodoPago}</p>
            <p>Reserva asociada: #${pago.reserva.reservaId}</p>
            <p>Cliente: ${pago.reserva.cliente.nombre}</p>
        </div>
        
        <div class="warning-message">
            ¿Está seguro que desea eliminar este registro de pago?
        </div>
        
        <form method="post" action="/senati/pago/borrar/${pago.pagoId}" style="display: inline;">
            <button type="submit" class="btn btn-delete">Eliminar Pago</button>
        </form>
        
        <a href="/senati/pago/listar" class="btn btn-cancel">Cancelar</a>
    </div>
</body>
</html>