<%-- 
    Document   : testesTags
    Created on : 12/01/2011, 13:33:25
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Testes Tags JSP</title>
    </head>

    <body>

        <%-- Criando um objeto do tipo produto usando a tag <jsp:useBean --%>
        <jsp:useBean id="meuProduto" class="entidades.Produto" scope="page"/>
        <jsp:setProperty name="meuProduto" property="codigo" value="4"/>
        <jsp:setProperty name="meuProduto" property="descricao" value="Arroz"/>
        <jsp:setProperty name="meuProduto" property="unidadeMedida" value="kg"/>
        <jsp:setProperty name="meuProduto" property="quantidade" value="100"/>

        <h1>Produto Criado:</h1>
        ${pageScope.meuProduto.codigo},
        ${pageScope.meuProduto.descricao},
        ${pageScope.meuProduto.unidadeMedida}, 
        ${pageScope.meuProduto.quantidade}

    </body>

</html>
