<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Cliente</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .container { width: 70%; margin: 0 auto; }
        .form-group { margin-bottom: 15px; }
        label { display: inline-block; width: 150px; font-weight: bold; }
        input[type="text"], input[type="email"] {
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
        <h3>👤 Registrar Nuevo Cliente</h3>
        
        <a href="/senati/cliente/listar">← Volver al listado</a>
        <br><br>
        
        <form:form method="post" modelAttribute="cliente">
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <form:input path="nombre" required="true" />
            </div>
            
            <div class="form-group">
                <label for="email">Email:</label>
                <form:input path="email" type="email" required="true" />
            </div>
            
            <div class="form-group">
                <label for="telefono">Teléfono:</label>
                <form:input path="telefono" required="true" />
            </div>
            
            <div class="form-group">
                <button type="submit">Guardar</button>
                <button type="button" onclick="location.href='/senati/cliente/listar'">Cancelar</button>
            </div>
        </form:form>
    </div>
</body>
</html>