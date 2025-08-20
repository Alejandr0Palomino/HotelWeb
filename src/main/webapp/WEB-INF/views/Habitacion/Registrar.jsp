<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrar Habitación</title>
    <style>
        .form-container { max-width: 600px; margin: 20px auto; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input, select { width: 100%; padding: 8px; border: 1px solid #ddd; border-radius: 4px; }
        .checkbox-group { margin: 10px 0; }
        .btn { padding: 10px 15px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer; }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Registrar Nueva Habitación</h2>
        <form method="post" action="/senati/habitacion/registrar">
            <div class="form-group">
                <label for="numero">Número:</label>
                <input type="text" id="numero" name="numero" required>
            </div>
            
            <div class="form-group">
                <label for="tipo">Tipo:</label>
                <input type="text" id="tipo" name="tipo" required>
            </div>
            
            <div class="form-group">
                <label for="precio">Precio:</label>
                <input type="number" id="precio" name="precio" step="0.01" required>
            </div>
            
            <div class="form-group">
                <label for="hotelId">Hotel:</label>
                <select id="hotelId" name="hotelId" required>
                    <c:forEach items="${hoteles}" var="hotel">
                        <option value="${hotel.hotelId}">${hotel.nombre}</option>
                    </c:forEach>
                </select>
            </div>
            
            <div class="form-group">
                <label>Servicios:</label>
                <div class="checkbox-group">
                    <c:forEach items="${servicios}" var="servicio">
                        <input type="checkbox" name="servicios" value="${servicio.servicioId}">
                        ${servicio.nombre}<br>
                    </c:forEach>
                </div>
            </div>
            
            <button type="submit" class="btn">Guardar</button>
            <a href="/senati/habitacion/listar" class="btn">Cancelar</a>
        </form>
    </div>
</body>
</html>