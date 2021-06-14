<%-- 
    Document   : index
    Created on : 12/01/2011, 09:54:46
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usando EL e TagLibs</title>

        <style type="text/css">
            .alinharDireita {
                text-align: right;
            }
        </style>

    </head>
    <body>

        <h1>Dados do Produto</h1>
        
        <form method="post" action="processaDadosProduto">
            <table>
                <tr>
                    <td class="alinharDireita">Código:</td>
                    <td><input type="text" name="codigo"/></td>
                </tr>
                <tr>
                    <td class="alinharDireita">Descrição:</td>
                    <td><input type="text" name="descricao"/></td>
                </tr>
                <tr>
                    <td class="alinharDireita">Unidade de Medida:</td>
                    <td>
                        <select name="unidade">
                            <option value="kg">Quilograma</option>
                            <option value="l">Litro</option>
                            <option value="un">Unidade</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Quant. em Estoque:</td>
                    <td><input type="text" name="quantidade"/></td>
                </tr>
                <tr>
                    <td class="alinharDireita" colspan="2">
                        <input type="submit" value="Enviar Dados"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>
</html>
