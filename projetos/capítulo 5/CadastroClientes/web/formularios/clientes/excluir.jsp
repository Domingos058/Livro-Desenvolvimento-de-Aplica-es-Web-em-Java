<%-- 
    Document   : novo
    Created on : 18/01/2011, 15:21:38
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Excluir Cliente</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>

        <h1>Excluir Cliente</h1>

        <form method="post"
              action="${pageContext.request.contextPath}/processaClientes">

            <input name="acao" type="hidden" value="excluir"/>
            <input name="id" type="hidden" value="${requestScope.cliente.id}"/>

            <table>
                <tr>
                    <td class="alinharDireita">Nome:</td>
                    <td>${requestScope.cliente.nome}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Sobrenome:</td>
                    <td>${requestScope.cliente.sobrenome}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Data de Nascimento<br/>(dd/mm/aaaa):</td>
                    <td>
                        <fmt:formatDate pattern="dd/MM/yyyy"
                                        value="${requestScope.cliente.dataNascimento}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">CPF:</td>
                    <td>${requestScope.cliente.cpf}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Email:</td>
                    <td>${requestScope.cliente.email}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Logradouro:</td>
                    <td>${requestScope.cliente.logradouro}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Número:</td>
                    <td>${requestScope.cliente.numero}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Bairro:</td>
                    <td>${requestScope.cliente.bairro}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">CEP:</td>
                    <td>${requestScope.cliente.cep}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Cidade:</td>
                    <td>${requestScope.cliente.cidade.nome}</td>
                </tr>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/formularios/clientes/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Excluir"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>
