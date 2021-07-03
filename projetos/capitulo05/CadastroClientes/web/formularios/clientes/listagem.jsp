<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <title>Clientes Cadastrados</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>
        
        <h1>Clientes Cadastrados</h1>

        <p><a href="${pageContext.request.contextPath}/formularios/clientes/novo.jsp">Novo Cliente</a></p>

        <table class="tabelaListagem">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nome</th>
                    <th>Sobrenome</th>
                    <th>Email</th>
                    <th>CPF</th>
                    <th>Cidade</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr>
            </thead>
            <tbody>

                <jsp:useBean id="servicos" scope="page" class="cadastroclientes.servicos.ClienteServices"/>

                <c:forEach items="${servicos.todos}" var="cliente">
                    <tr>
                        <td>${cliente.id}</td>
                        <td>${cliente.nome}</td>
                        <td>${cliente.sobrenome}</td>
                        <td>${cliente.email}</td>
                        <td>${cliente.cpf}</td>
                        <td>${cliente.cidade.nome}</td>
                        <td><a href="${pageContext.request.contextPath}/processaClientes?acao=prepararAlteracao&id=${cliente.id}">Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/processaClientes?acao=prepararExclusao&id=${cliente.id}">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <p><a href="${pageContext.request.contextPath}/formularios/clientes/novo.jsp">Novo Cliente</a></p>
        
        <p><a href="${pageContext.request.contextPath}/index.jsp">Tela Principal</a></p>

    </body>

</html>
