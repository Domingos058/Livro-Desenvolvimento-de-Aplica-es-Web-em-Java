<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <title>Cidades Cadastradas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                        <td><a href="${pageContext.request.contextPath}/processaCidades?acao=prepararAlteracao&id=${cidade.id}">Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/processaCidades?acao=prepararExclusao&id=${cidade.id}">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <p><a href="${pageContext.request.contextPath}/formularios/cidades/novo.jsp">Nova Cidade</a></p>
        
        <p><a href="${pageContext.request.contextPath}/index.jsp">Tela Principal</a></p>

    </body>

</html>
