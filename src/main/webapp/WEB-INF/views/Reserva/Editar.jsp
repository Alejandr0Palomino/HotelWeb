<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Reserva</title>
    <style>
        .form-container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #f8f9fa;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
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
            border: 1px solid #ced4da;
            border-radius: 4px;
        }
        .btn {
            padding: 8px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn-primary {
            background-color: #007bff;
            color: white;
        }
        .btn-danger {
            background-color: #dc3545;
            color: white;
        }
        .info-box {
            background-color: #e9ecef;
            padding: 10px;
            border-radius: 4px;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Editar Reserva #${reserva.reservaId}</h2>
        
        <div class="info-box">
            <p><strong>Estado actual:</strong> 
               ${reserva.pago != null ? 'Pagado' : 'Pendiente de pago'}</p>
        </div>
        
        <form method="post" action="/senati/reserva/editar/${reserva.reservaId}">
            <div class="form-group">
                <label for="fechaEntrada">Fecha de Entrada:</label>
                <input type="date" id="fechaEntrada" name="fechaEntrada" 
                       value="${reserva.fechaEntrada}" required> <!-- Usar valor directo -->
            </div>
            
            <div class="form-group">
                <label for="fechaSalida">Fecha de Salida:</label>
                <input type="date" id="fechaSalida" name="fechaSalida"
                       value="${reserva.fechaSalida}" required> <!-- Usar valor directo -->
            </div>
            
            <div class="form-group">
                <label for="clienteId">Cliente:</label>
                <select id="clienteId" name="clienteId" required>
                    <c:forEach items="${clientes}" var="cliente">
                        <option value="${cliente.clienteId}" 
                            ${cliente.clienteId == reserva.cliente.clienteId ? 'selected' : ''}>
                            ${cliente.nombre} (${cliente.email})
                        </option>
                    </c:forEach>
                </select>
            </div>
            
            <div class="form-group">
                <label for="habitacionId">Habitación:</label>
                <select id="habitacionId" name="habitacionId" required>
                    <c:forEach items="${habitaciones}" var="habitacion">
                        <option value="${habitacion.habitacionId}"
                            ${habitacion.habitacionId == reserva.habitacion.habitacionId ? 'selected' : ''}>
                            ${habitacion.numero} - ${habitacion.tipo} (S/${habitacion.precio})
                        </option>
                    </c:forEach>
                </select>
            </div>
            
            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
            <a href="/senati/reserva/listar" class="btn btn-danger">Cancelar</a>
        </form>
    </div>
</body>
</html>