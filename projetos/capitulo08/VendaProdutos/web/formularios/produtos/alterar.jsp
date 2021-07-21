<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
  <head>
    <title>Alterar Produto</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
          href="${cp}/css/estilos.css"/>
  </head>

  <body>

    <h1>Alterar Produto</h1>

    <form method="post" action="${cp}/processaProdutos">

      <input name="acao" type="hidden" value="alterar"/>
      <input name="id" type="hidden" value="${requestScope.produto.id}"/>

      <table>
        <tr>
          <td class="alinharDireita">Nome:</td>
          <td>
            <input name="nome"
                   type="text"
                   size="20"
                   maxlength="45"
                   required
                   value="${requestScope.produto.nome}"/>
          </td>
        </tr>
        <tr>
          <td class="alinharDireita">Sobrenome:</td>
          <td>
            <input name="sobrenome"
                   type="text"
                   size="20"
                   maxlength="45"
                   required
                   value="${requestScope.produto.sobrenome}"/>
          </td>
        </tr>
        <tr>
          <td class="alinharDireita">
            Data de Nascimento:
          </td>
          <td>

            <fmt:formatDate 
                pattern="yyyy-MM-dd"
                value="${requestScope.produto.dataNascimento}"
                var="data" scope="page"/>

            <input name="dataNascimento"
                   type="date"
                   size="8"
                   placeholder="dd/mm/yyyy"
                   required
                   value="${data}"/>

          </td>
        </tr>
        <tr>
          <td class="alinharDireita">CPF:</td>
          <td>
            <input name="cpf"
                   type="text"
                   size="13"
                   pattern="\d{3}.\d{3}.\d{3}-\d{2}"
                   placeholder="###.###.###-##"
                   required
                   value="${requestScope.produto.cpf}"/>
          </td>
        </tr>
        <tr>
          <td class="alinharDireita">E-mail:</td>
          <td>
            <input name="email"
                   type="email"
                   size="20"
                   maxlength="60"
                   required
                   value="${requestScope.produto.email}"/>
          </td>
        </tr>
        <tr>
          <td class="alinharDireita">Logradouro:</td>
          <td>
            <input name="logradouro"
                   type="text"
                   size="25"
                   maxlength="50"
                   required
                   value="${requestScope.produto.logradouro}"/>
          </td>
        </tr>
        <tr>
          <td class="alinharDireita">Número:</td>
          <td>
            <input name="numero"
                   type="text"
                   size="6"
                   maxlength="6"
                   required
                   value="${requestScope.produto.numero}"/>
          </td>
        </tr>
        <tr>
          <td class="alinharDireita">Bairro:</td>
          <td>
            <input name="bairro"
                   type="text"
                   size="15"
                   maxlength="30"
                   value="${requestScope.produto.bairro}"/>
          </td>
        </tr>
        <tr>
          <td class="alinharDireita">CEP:</td>
          <td>
            <input name="cep"
                   type="text"
                   size="7"
                   pattern="\d{5}-\d{3}"
                   placeholder="#####-###"
                   required
                   value="${requestScope.produto.cep}"/>
          </td>
        </tr>
        <tr>
          <td class="alinharDireita">Cidade:</td>
          <td>

            <jsp:useBean
                id="servicos"
                scope="page"
                class="vendaprodutos.servicos.CidadeServices"/>

            <select name="idCidade" required>
              <c:forEach items="${servicos.todos}" var="cidade">
                <c:choose>
                  <c:when test="${requestScope.produto.cidade.id eq cidade.id}">
                    <option value="${cidade.id}" selected>
                      ${cidade.nome}
                    </option>
                  </c:when>
                  <c:otherwise>
                    <option value="${cidade.id}">
                      ${cidade.nome}
                    </option>
                  </c:otherwise>
                </c:choose>
              </c:forEach>
            </select>

          </td>
        </tr>
        <tr>
          <td>
            <a href="${cp}/formularios/produtos/listagem.jsp">Voltar</a>
          </td>
          <td class="alinharDireita">
            <input type="submit" value="Alterar"/>
          </td>
        </tr>
      </table>

    </form>

  </body>

</html>