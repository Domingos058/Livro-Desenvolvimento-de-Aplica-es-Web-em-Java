<%-- 
    Document   : listagem
    Created on : 18/01/2011, 14:26:29
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cidades Cadastradas</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>
        
        <h1>Cidades Cadastradas</h1>

        <p><a href="${pageContext.request.contextPath}/formularios/cidades/novo.jsp">Nova Cidade</a></p>

        <table class="tabelaListagem">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nome</th>
                    <th>Estado</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr>
            </thead>
            <tbody>

                <jsp:useBean id="servicos" scope="page" class="cadastroclientes.servicos.CidadeServices"/>

                <c:forEach items="${servicos.todos}" var="cidade">
                    <tr>
                        <td>${cidade.id}</td>
                        <td>${cidade.nome}</td>
                        <td>${cidade.estado.sigla}</td>
                        <td><a href="${pageContext.request.contextPath}/processaCidades?acao=prepAlteracao&id=${cidade.id}">Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/processaCidades?acao=prepExclusao&id=${cidade.id}">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <p><a href="${pageContext.request.contextPath}/formularios/cidades/novo.jsp">Nova Cidade</a></p>
        
        <p><a href="${pageContext.request.contextPath}/index.jsp">Tela Principal</a></p>

    </body>

</html>
