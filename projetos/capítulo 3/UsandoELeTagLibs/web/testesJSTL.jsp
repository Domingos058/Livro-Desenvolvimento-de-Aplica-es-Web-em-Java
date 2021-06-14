<%-- 
    Document   : testesJSTL
    Created on : 12/01/2011, 14:28:47
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Testes Tags JSTL</title>

        <style type="text/css">

            .linhaPar {
                background: #00bbee;
            }

            .linhaImpar {
                background: #eeeeee;
            }

        </style>

    </head>

    <body>

        <table>
            <c:forEach begin="1" end="10" varStatus="i">
                <c:choose>
                    <c:when test="${i.count % 2 == 0}">
                        <tr class="linhaPar">
                            <td>Linha ${i.count} JSTL é animal!</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <tr class="linhaImpar">
                            <td>Linha ${i.count} JSTL é show!</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </table>

    </body>

</html>
