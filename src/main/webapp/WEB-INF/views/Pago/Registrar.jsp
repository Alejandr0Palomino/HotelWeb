<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Pago</title>
    <style>
        .container { width: 70%; margin: 0 auto; }
        .form-group { margin-bottom: 15px; }
        label { display: inline-block; width: 150px; font-weight: bold; }
        input, select {
            padding: 8px;
            width: 300px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        button {
            padding: 8px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<div class="container">
    <h3>💳 Registrar Pago</h3>
    <a href="/senati/pago/listar">← Volver al listado</a>
    <br><br>

    <form:form method="post" modelAttribute="pago">
        <div class="form-group">
            <label>Monto:</label>
            <form:input path="monto" required="true"/>
        </div>

        <div class="form-group">
            <label>Método de Pago:</label>
            <form:input path="metodoPago" required="true"/>
        </div>

        <div class="form-group">
            <label>ID de Reserva:</label>
            <form:input path="reserva.reservaId" required="true"/>
        </div>

        <div class="form-group">
            <button type="submit">Guardar</button>
            <button type="button" onclick="location.href='/senati/pago/listar'">Cancelar</button>
        </div>
    </form:form>
</div>
</body>
</html>
