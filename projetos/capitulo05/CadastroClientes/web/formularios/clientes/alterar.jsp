<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html>
    <head>
        <title>Alterar Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>

        <h1>Alterar Cliente</h1>

        <form method="post"
              action="${pageContext.request.contextPath}/processaClientes">

            <input name="acao" type="hidden" value="alterar"/>
            <input name="id" type="hidden" value="${requestScope.cliente.id}"/>

            <table>
                <tr>
                    <td class="alinharDireita">Nome:</td>
                    <td>
                        <input name="nome" type="text" size="20"
                               value="${requestScope.cliente.nome}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Sobrenome:</td>
                    <td>
                        <input name="sobrenome" type="text" size="20"
                               value="${requestScope.cliente.sobrenome}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Data de Nascimento<br/>(dd/mm/aaaa):</td>
                    <td>

                        <fmt:formatDate pattern="dd/MM/yyyy"
                                        value="${requestScope.cliente.dataNascimento}"
                                        var="data" scope="page"/>

                        <input name="dataNascimento" type="text" size="8"
                               value="${data}"/>

                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">CPF:</td>
                    <td>
                        <input name="cpf" type="text" size="13"
                               value="${requestScope.cliente.cpf}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Email:</td>
                    <td>
                        <input name="email" type="text" size="20"
                               value="${requestScope.cliente.email}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Logradouro:</td>
                    <td>
                        <input name="logradouro" type="text" size="25"
                               value="${requestScope.cliente.logradouro}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Número:</td>
                    <td>
                        <input name="numero" type="text" size="6"
                               value="${requestScope.cliente.numero}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Bairro:</td>
                    <td>
                        <input name="bairro" type="text" size="15"
                               value="${requestScope.cliente.bairro}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">CEP:</td>
                    <td>
                        <input name="cep" type="text" size="7"
                               value="${requestScope.cliente.cep}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Cidade:</td>
                    <td>

                        <jsp:useBean id="servicos" scope="page" class="cadastroclientes.servicos.CidadeServices"/>

                        <select name="idCidade">
                            <c:forEach items="${servicos.todos}" var="cidade">
                                <c:choose>
                                    <c:when test="${requestScope.cliente.cidade.id eq cidade.id}">
                                        <option value="${cidade.id}" selected="true">${cidade.nome}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${cidade.id}">${cidade.nome}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>

                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/formularios/clientes/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Alterar"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>
