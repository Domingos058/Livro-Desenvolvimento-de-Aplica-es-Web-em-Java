<%-- 
    Document   : index
    Created on : 18/01/2011, 12:18:00
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema para Cadastro de Clientes</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>

        <h1>Sistema para Cadastro de Clientes</h1>

        <p>
            <a href="${pageContext.request.contextPath}/formularios/clientes/listagem.jsp">Clientes</a>
        </p>
        <p>
            <a href="${pageContext.request.contextPath}/formularios/cidades/listagem.jsp">Cidades</a>
        </p>
        <p>
            <a href="${pageContext.request.contextPath}/formularios/estados/listagem.jsp">Estados</a>
        </p>

    </body>

</html>
