<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Hotel</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .container { width: 70%; margin: 0 auto; }
        .form-group { margin-bottom: 15px; }
        label { display: inline-block; width: 150px; font-weight: bold; }
        input[type="text"], input[type="number"] {
            padding: 8px;
            width: 300px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 8px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h3>🏨 Editar Hotel</h3>
        
        <form:form method="post" modelAttribute="hotel">
            <div class="form-group">
                <label>ID:</label>
                <form:input path="hotelId" readonly="true" />
            </div>
            
            <div class="form-group">
                <label>Nombre:</label>
                <form:input path="nombre" required="true" />
            </div>
            
            <div class="form-group">
                <label>Dirección:</label>
                <form:input path="direccion" required="true" />
            </div>
            
            <div class="form-group">
                <label>Estrellas:</label>
                <form:input path="estrellas" type="number" min="1" max="5" required="true" />
            </div>
            
            <div class="form-group">
                <button type="submit">Guardar Cambios</button>
                <button type="button" onclick="location.href='/senati/hotel/listar'">Cancelar</button>
            </div>
        </form:form>
    </div>
</body>
</html>