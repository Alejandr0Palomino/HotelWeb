<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Confirmar Eliminación de Habitación</title>
    <style>
        .confirmation-container {
            max-width: 500px;
            margin: 30px auto;
            padding: 20px;
            text-align: center;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #fff3f3;
        }
        .btn {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin: 0 10px;
            text-decoration: none;
            display: inline-block;
        }
        .btn-confirm {
            background-color: #dc3545;
            color: white;
        }
        .btn-cancel {
            background-color: #6c757d;
            color: white;
        }
        .habitacion-info {
            margin: 20px 0;
            padding: 15px;
            background-color: #f8f9fa;
            border-radius: 4px;
        }
    </style>
</head>
<body>
    <div class="confirmation-container">
        <h2>¿Confirmar eliminación?</h2>
        
        <div class="habitacion-info">
            <p><strong>Habitación #${habitacion.habitacionId}</strong></p>
            <p>Número: ${habitacion.numero}</p>
            <p>Tipo: ${habitacion.tipo}</p>
            <p>Precio: S/${habitacion.precio}</p>
            <p>Hotel: ${habitacion.hotel.nombre}</p>
        </div>
        
        <p style="color: #dc3545; font-weight: bold;">
            ¡Advertencia! Esta acción no se puede deshacer.
        </p>
        
        <form method="post" action="/senati/habitacion/borrar/${habitacion.habitacionId}" style="display: inline;">
            <button type="submit" class="btn btn-confirm">Confirmar Eliminación</button>
        </form>
        
        <a href="/senati/habitacion/listar" class="btn btn-cancel">Cancelar</a>
    </div>
</body>
</html>