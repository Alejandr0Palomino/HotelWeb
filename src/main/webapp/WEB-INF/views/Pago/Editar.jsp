<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Pago</title>
    <style>
        .form-container {
            max-width: 500px;
            margin: 20px auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input, select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .btn {
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-right: 10px;
        }
        .btn-save {
            background-color: #4CAF50;
            color: white;
        }
        .btn-cancel {
            background-color: #f44336;
            color: white;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Editar Pago #${pago.pagoId}</h2>
        
        <form method="post" action="/senati/pago/editar/${pago.pagoId}">
            <div class="form-group">
                <label for="monto">Monto:</label>
                <input type="number" id="monto" name="monto" step="0.01" 
                       value="${pago.monto}" required>
            </div>
            
            <div class="form-group">
                <label for="metodoPago">Método de Pago:</label>
                <select id="metodoPago" name="metodoPago" required>
                    <option value="Efectivo" ${pago.metodoPago == 'Efectivo' ? 'selected' : ''}>Efectivo</option>
                    <option value="Tarjeta" ${pago.metodoPago == 'Tarjeta' ? 'selected' : ''}>Tarjeta</option>
                    <option value="Transferencia" ${pago.metodoPago == 'Transferencia' ? 'selected' : ''}>Transferencia</option>
                </select>
            </div>
            
            <div class="form-group">
                <label>Reserva asociada:</label>
                <p>Reserva #${pago.reserva.reservaId} - ${pago.reserva.cliente.nombre}</p>
                <input type="hidden" name="reservaId" value="${pago.reserva.reservaId}">
            </div>
            
            <button type="submit" class="btn btn-save">Guardar Cambios</button>
            <a href="/senati/pago/listar" class="btn btn-cancel">Cancelar</a>
        </form>
    </div>
</body>
</html>