<%-- 
    Document   : exibeDados
    Created on : 12/01/2011, 11:46:41
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produto Obtido</title>

        <style type="text/css">
            .alinharDireita {
                text-align: right;
            }
        </style>
        
    </head>

    <body>

        <h1>Produto Obtido</h1>

        <table>
            <tr>
                <td class="alinharDireita">Código:</td>
                <td>${requestScope.produtoObtido.codigo}</td>
            </tr>
            <tr>
                <td class="alinharDireita">Descrição:</td>
                <td>${requestScope.produtoObtido.descricao}</td>
            </tr>
            <tr>
                <td class="alinharDireita">Unidade de Medida:</td>
                <td>${requestScope.produtoObtido.unidadeMedida}</td>
            </tr>
            <tr>
                <td class="alinharDireita">Quant. em Estoque:</td>
                <td>${requestScope.produtoObtido.quantidade}</td>
            </tr>
            <tr>
                <td colspan="2">
                    <a href="index.jsp">Voltar</a>
                </td>
            </tr>
        </table>

    </body>

</html>
