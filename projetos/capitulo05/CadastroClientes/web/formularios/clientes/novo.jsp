<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <title>Novo Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>
        
        <h1>Novo Cliente</h1>

        <form method="post"
              action="${pageContext.request.contextPath}/processaClientes">

            <input name="acao" type="hidden" value="inserir"/>

            <table>
                <tr>
                    <td class="alinharDireita">Nome:</td>
                    <td>
                        <input name="nome" type="text" size="20"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Sobrenome:</td>
                    <td>
                        <input name="sobrenome" type="text" size="20"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Data de Nascimento<br/>(dd/mm/aaaa):</td>
                    <td>
                        <input name="dataNascimento" type="text" size="8"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">CPF:</td>
                    <td>
                        <input name="cpf" type="text" size="13"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Email:</td>
                    <td>
                        <input name="email" type="text" size="20"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Logradouro:</td>
                    <td>
                        <input name="logradouro" type="text" size="25"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Número:</td>
                    <td>
                        <input name="numero" type="text" size="6"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Bairro:</td>
                    <td>
                        <input name="bairro" type="text" size="15"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">CEP:</td>
                    <td>
                        <input name="cep" type="text" size="7"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Cidade:</td>
                    <td>

                        <jsp:useBean id="servicos" scope="page" class="cadastroclientes.servicos.CidadeServices"/>
                        
                        <select name="idCidade">
                            <c:forEach items="${servicos.todos}" var="cidade">
                                <option value="${cidade.id}">${cidade.nome}</option>
                            </c:forEach>
                        </select>

                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/formularios/clientes/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Salvar"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>
