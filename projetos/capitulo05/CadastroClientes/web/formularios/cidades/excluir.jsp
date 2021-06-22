<%-- 
    Document   : novo
    Created on : 18/01/2011, 15:21:38
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Excluir Cidade</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>

        <h1>Excluir Cidade</h1>

        <form method="post"
              action="${pageContext.request.contextPath}/processaCidades">

            <input name="acao" type="hidden" value="excluir"/>
            <input name="id" type="hidden" value="${requestScope.cidade.id}"/>

            <table>
                <tr>
                    <td class="alinharDireita">Nome:</td>
                    <td>${requestScope.cidade.nome}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Estado:</td>
                    <td>${requestScope.cidade.estado.nome} - ${requestScope.cidade.estado.sigla}</td>
                </tr>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/formularios/cidades/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Excluir"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>
