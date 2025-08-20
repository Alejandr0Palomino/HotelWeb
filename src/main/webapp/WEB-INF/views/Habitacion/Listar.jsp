<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listado de Habitaciones</title>
    <style>
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 12px; text-align: left; border-bottom: 1px solid #ddd; }
        th { background-color: #f2f2f2; }
        .actions a { margin-right: 10px; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Listado de Habitaciones</h2>
        <a href="/senati/habitacion/registrar" class="btn">Nueva Habitación</a>
        
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Número</th>
                    <th>Tipo</th>
                    <th>Precio (S/)</th>
                    <th>Hotel</th>
                    <th>Servicios</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${habitaciones}" var="habitacion">
                <tr>
                    <td>${habitacion.habitacionId}</td>
                    <td>${habitacion.numero}</td>
                    <td>${habitacion.tipo}</td>
                    <td>${habitacion.precio}</td>
                    <td>${habitacion.hotel.nombre}</td>
                    <td>
                        <c:forEach items="${habitacion.servicios}" var="servicio" varStatus="loop">
                            ${servicio.nombre}${!loop.last ? ',' : ''}
                        </c:forEach>
                    </td>
                    <td class="actions">
                        <a href="/senati/habitacion/editar/${habitacion.habitacionId}" class="btn-edit">Editar</a>
                        <a href="/senati/habitacion/borrar/${habitacion.habitacionId}" class="btn-delete">Borrar</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>