<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
  <head>
    
    <title>Nova Venda</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet"
          href="${cp}/css/estilos.css"/>
    <link rel="stylesheet"
          href="${cp}/css/estilosVenda.css"/>
    
    <script src="${cp}/js/libs/jquery/jquery.min.js"></script>
    <script src="${cp}/js/vendas.js"></script>
    
  </head>

  <body>

    <h1>Nova Venda</h1>

    <form method="post" action="${cp}/processaVendas">

      <input name="acao" type="hidden" value="inserir"/>

      <div id="divCliente">
        <jsp:useBean 
            id="servicosC" 
            scope="page" 
            class="vendaprodutos.servicos.ClienteServices"/>

        Cliente:
        <br>
        <select id="selectCliente" name="idCliente" required>
          <c:forEach items="${servicosC.todos}" var="cliente">
            <option value="${cliente.id}">
              ${cliente.nome} ${cliente.sobrenome}
            </option>
          </c:forEach>
        </select>
      </div>
      
      <div id="divItensVenda">
      <table>
        <tr>
          <td>

            <jsp:useBean 
                id="servicosP" 
                scope="page" 
                class="vendaprodutos.servicos.ProdutoServices"/>
            
            <p>
              Produto:
              <br>
              <select id="selectProduto">
                <c:forEach items="${servicosP.todos}" var="produto">
                  <option value="${produto.id}">
                    ${produto.descricao}
                    (R$
                    <fmt:formatNumber
                        pattern="#.##"
                        minIntegerDigits="1"
                        minFractionDigits="2"
                        maxFractionDigits="2">
                      ${produto.valorVenda}
                    </fmt:formatNumber>
                    por
                    ${produto.unidadeMedida.sigla})
                  </option>
                </c:forEach>
              </select>
            </p>
            
            <p>
            Quantidade:
            <br>
            <input id="txtQuantidade"
                   type="number"
                   size="3"
                   placeholder="9,99"
                   step="0.01"
                   min="0"/>
            </p>
            
          </td>
          <td class="btnsItensVenda">
            <p><button id="btnInserir">&#x2795;</button></p>
            <p><button id="btnRemover">&#x2796;</button></p>
            <p><button id="btnLimpar">&#x274C;</button></p>
          </td>
          <td>
            Itens da Venda:
            <br>
            <select id="selectItensVenda" size="10">
            </select>
            <br>
            <div>
              <div id="divTotal">Total: R$ 0,00</div>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <a href="${cp}/formularios/vendas/listagem.jsp">
              Voltar
            </a>
          </td>
          <td></td>
          <td class="alinharDireita">
            <input type="submit" value="Salvar"/>
          </td>
        </tr>
      </table>
      </div>

    </form>

  </body>

</html>
