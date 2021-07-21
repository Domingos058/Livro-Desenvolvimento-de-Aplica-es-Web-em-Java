<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
  <head>
    <title>Excluir Produto</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
          href="${cp}/css/estilos.css"/>
  </head>

  <body>

    <h1>Excluir Produto</h1>

    <form method="post" action="${cp}/processaProdutos">

      <input name="acao" type="hidden" value="excluir"/>
      <input name="id" type="hidden" value="${requestScope.produto.id}"/>

      <table>
        <tr>
          <td class="alinharDireita">Nome:</td>
          <td>${requestScope.produto.nome}</td>
        </tr>
        <tr>
          <td class="alinharDireita">Sobrenome:</td>
          <td>${requestScope.produto.sobrenome}</td>
        </tr>
        <tr>
          <td class="alinharDireita">
            Data de Nascimento:
          </td>
          <td>
            <fmt:formatDate 
                pattern="dd/MM/yyyy"
                value="${requestScope.produto.dataNascimento}"/>
          </td>
        </tr>
        <tr>
          <td class="alinharDireita">CPF:</td>
          <td>${requestScope.produto.cpf}</td>
        </tr>
        <tr>
          <td class="alinharDireita">E-mail:</td>
          <td>${requestScope.produto.email}</td>
        </tr>
        <tr>
          <td class="alinharDireita">Logradouro:</td>
          <td>${requestScope.produto.logradouro}</td>
        </tr>
        <tr>
          <td class="alinharDireita">Número:</td>
          <td>${requestScope.produto.numero}</td>
        </tr>
        <tr>
          <td class="alinharDireita">Bairro:</td>
          <td>${requestScope.produto.bairro}</td>
        </tr>
        <tr>
          <td class="alinharDireita">CEP:</td>
          <td>${requestScope.produto.cep}</td>
        </tr>
        <tr>
          <td class="alinharDireita">Cidade:</td>
          <td>${requestScope.produto.cidade.nome}</td>
        </tr>
        <tr>
          <td>
            <a href="${cp}/formularios/produtos/listagem.jsp">
              Voltar
            </a>
          </td>
          <td class="alinharDireita">
            <input type="submit" value="Excluir"/>
          </td>
        </tr>
      </table>

    </form>

  </body>

</html>
