<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmar Eliminación</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .container { width: 50%; margin: 0 auto; text-align: center; }
        .confirmation-box { 
            border: 1px solid #ddd; 
            padding: 20px; 
            border-radius: 5px;
            margin-top: 20px;
        }
        button {
            padding: 8px 15px;
            margin: 0 10px;
            cursor: pointer;
        }
        .btn-confirm {
            background-color: #f44336;
            color: white;
            border: none;
        }
        .btn-cancel {
            background-color: #ccc;
            border: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <h3>👤 Eliminar Cliente</h3>
        
        <div class="confirmation-box">
            <p>¿Está seguro que desea eliminar este cliente?</p>
            <p><strong>${cliente.nombre}</strong></p>
            <p>Email: ${cliente.email}</p>
            <p>Teléfono: ${cliente.telefono}</p>
            
            <form:form method="post">
                <button type="submit" class="btn-confirm">Confirmar Eliminación</button>
                <a href="/senati/cliente/listar">
                    <button type="button" class="btn-cancel">Cancelar</button>
                </a>
            </form:form>
        </div>
    </div>
</body>
</html>