<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrar Reserva</title>
    <style>
        .form-container { max-width: 600px; margin: 20px auto; padding: 20px; border: 1px solid #ddd; border-radius: 5px; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input, select { width: 100%; padding: 8px; border: 1px solid #ddd; border-radius: 4px; }
        .btn-submit { background-color: #4CAF50; color: white; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Registrar Nueva Reserva</h2>
        <form method="post" action="/senati/reserva/registrar">
            <div class="form-group">
                <label for="fechaEntrada">Fecha Entrada:</label>
                <input type="date" id="fechaEntrada" name="fechaEntrada" required>
            </div>
            
            <div class="form-group">
                <label for="fechaSalida">Fecha Salida:</label>
                <input type="date" id="fechaSalida" name="fechaSalida" required>
            </div>
            
            <div class="form-group">
                <label for="clienteId">Cliente:</label>
                <select id="clienteId" name="clienteId" required>
                    <option value="">Seleccionar cliente</option>
                    <c:forEach items="${clientes}" var="cliente">
                        <option value="${cliente.clienteId}">${cliente.nombre} - ${cliente.email}</option>
                    </c:forEach>
                </select>
            </div>
            
            <div class="form-group">
                <label for="habitacionId">Habitación:</label>
                <select id="habitacionId" name="habitacionId" required>
                    <option value="">Seleccionar habitación</option>
                    <c:forEach items="${habitaciones}" var="habitacion">
                        <option value="${habitacion.habitacionId}">
                            ${habitacion.numero} - ${habitacion.tipo} (S/${habitacion.precio}/noche)
                        </option>
                    </c:forEach>
                </select>
            </div>
            
            <button type="submit" class="btn-submit">Guardar Reserva</button>
            <a href="/senati/reserva/listar" style="margin-left: 10px;">Cancelar</a>
        </form>
    </div>
</body>
</html>