<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Servicio</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .container { width: 70%; margin: 0 auto; }
        .form-group { margin-bottom: 15px; }
        label { display: inline-block; width: 150px; font-weight: bold; }
        input[type="text"], textarea {
            padding: 8px;
            width: 300px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        textarea { height: 100px; }
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
        <h3>🔧 Registrar Nuevo Servicio</h3>
        
        <a href="/senati/servicio/listar">← Volver al listado</a>
        <br><br>
        
        <form:form method="post" modelAttribute="servicio">
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <form:input path="nombre" required="true" />
            </div>
            
            <div class="form-group">
                <label for="descripcion">Descripción:</label>
                <form:textarea path="descripcion" />
            </div>
            
            <div class="form-group">
                <button type="submit">Guardar</button>
                <button type="button" onclick="location.href='/senati/servicio/listar'">Cancelar</button>
            </div>
        </form:form>
    </div>
</body>
</html>