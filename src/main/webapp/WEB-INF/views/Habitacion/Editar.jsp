<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Habitación</title>
    <style>
        .form-container { max-width: 600px; margin: 20px auto; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input, select { width: 100%; padding: 8px; border: 1px solid #ddd; border-radius: 4px; }
        .btn-save { background-color: #4CAF50; color: white; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Editar Habitación #${habitacion.habitacionId}</h2>
        <form method="post" action="/senati/habitacion/editar/${habitacion.habitacionId}">
            <div class="form-group">
                <label for="numero">Número:</label>
                <input type="text" id="numero" name="numero" value="${habitacion.numero}" required>
            </div>
            
            <div class="form-group">
                <label for="tipo">Tipo:</label>
                <input type="text" id="tipo" name="tipo" value="${habitacion.tipo}" required>
            </div>
            
            <div class="form-group">
                <label for="precio">Precio:</label>
                <input type="number" id="precio" name="precio" step="0.01" value="${habitacion.precio}" required>
            </div>
            
            <div class="form-group">
                <label for="hotelId">Hotel:</label>
                <select id="hotelId" name="hotelId" required>
                    <c:forEach items="${hoteles}" var="hotel">
                        <option value="${hotel.hotelId}" ${hotel.hotelId == habitacion.hotel.hotelId ? 'selected' : ''}>
                            ${hotel.nombre}
                        </option>
                    </c:forEach>
                </select>
            </div>
            
            <div class="form-group">
                <label>Servicios:</label>
                <c:forEach items="${servicios}" var="servicio">
                    <c:set var="contains" value="false" />
                    <c:forEach items="${habitacion.servicios}" var="habServicio">
                        <c:if test="${servicio.servicioId eq habServicio.servicioId}">
                            <c:set var="contains" value="true" />
                        </c:if>
                    </c:forEach>
                    <input type="checkbox" name="servicios" value="${servicio.servicioId}" ${contains ? 'checked' : ''}>
                    ${servicio.nombre}<br>
                </c:forEach>
            </div>
            
            <button type="submit" class="btn-save">Guardar Cambios</button>
            <a href="/senati/habitacion/listar" style="margin-left: 10px;">Cancelar</a>
        </form>
    </div>
</body>
</html>