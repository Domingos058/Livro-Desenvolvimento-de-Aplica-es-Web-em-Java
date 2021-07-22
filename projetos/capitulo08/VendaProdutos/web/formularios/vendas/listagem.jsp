<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<c:set var="prefixo" value="processaVendas?acao=preparar"/>
<!DOCTYPE html>

<html>
  <head>
    <title>Vendas Cadastradas</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
          href="${cp}/css/estilos.css"/>
  </head>

  <body>

    <h1>Vendas Cadastradas</h1>

    <p>
      <a href="${cp}/formularios/vendas/novo.jsp">
        Nova Venda
      </a>
    </p>

    <table class="tabelaListagem">
      <thead>
        <tr>
          <th>Id</th>
          <th>Data</th>
          <th>Cliente</th>
          <th>Alterar</th>
          <th>Excluir</th>
        </tr>
      </thead>
      <tbody>

        <jsp:useBean 
            id="servicos"
            scope="page"
            class="vendaprodutos.servicos.VendaServices"/>

        <c:forEach items="${servicos.todos}" var="un">
          <tr>
            <td>${venda.id}</td>
            <td>
              <fmt:formatDate 
                pattern="yyyy-MM-dd"
                value="${requestScope.venda.data}"/>
            </td>
            <td>${venda.cliente.nome} ${venda.cliente.sobrenome}</td>
            <td>
              <a href="${cp}/${prefixo}Alteracao&id=${venda.id}">
                Alterar
              </a>
            </td>
            <td>
              <a href="${cp}/${prefixo}Exclusao&id=${venda.id}">
                Excluir
              </a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
      
    </table>

    <p>
      <a href="${cp}/formularios/vendas/novo.jsp">
        Nova Venda
      </a>
    </p>

    <p><a href="${cp}/index.jsp">Tela Principal</a></p>

  </body>

</html>
