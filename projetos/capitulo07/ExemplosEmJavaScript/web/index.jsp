<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exemplos em JavaScript></title>
        <script src="${cp}/js/exemplo01.js"></script>
        <script src="${cp}/js/exemplo02.js"></script>
        <script src="${cp}/js/exemplo03.js"></script>
        <script src="${cp}/js/exemplo04.js"></script>
        <script src="${cp}/js/exemplo05.js"></script>
        <script src="${cp}/js/exemplo06.js"></script>
        <script src="${cp}/js/exemplo07.js"></script>
        <script src="${cp}/js/exemplo08.js"></script>
        <script src="${cp}/js/exemplo09.js"></script>
        <script src="${cp}/js/exemplo10.js"></script>
        <script src="${cp}/js/exemplo11.js"></script>
        <link rel="stylesheet" href="${cp}/css/estilos.css"/>
    </head>
    <body>
        <div>
            
            <h1>Construções da Linguagem</h1>
            
            <p>
                <button onclick="executarExemplo01(event)">Exemplo 01 - Operações</button>
            </p>
            
            <p>
                <button onclick="executarExemplo02(event)">Exemplo 02 - Condicionais</button>
            </p>
            
            <p>
                <button onclick="executarExemplo03(event)">Exemplo 03 - Repetição</button>
            </p>
            
        </div>
        
        <hr>
        
        <div>
            
            <h1>Manipulação do DOM</h1>
            
            <div>
                <div id="divExemplo4" class="divExemplo"></div>
                <p>
                    <button onclick="executarExemplo04(event)">Exemplo 04 - JavaScript puro</button>
                </p>
            </div>
            
            <div>
                <div id="divExemplo5" class="divExemplo"></div>
                <p>
                    <button onclick="executarExemplo05(event)">Exemplo 05 - jQuery</button>
                </p>
            </div>
            
            <div>
                <div id="divExemplo6" class="divExemplo"></div>
                <p>
                    <button onclick="executarExemplo06(event)">Exemplo 06 - Manipulando Formulários</button>
                </p>
            </div>
            
            <div>
                <div id="divExemplo7" class="divExemplo"></div>
                <p>
                    <button onclick="executarExemplo07(event)">Exemplo 07 - Eventos</button>
                </p>
            </div>
            
            <div>
                <div id="divExemplo8" class="divExemplo"></div>
                <p>
                    <button onclick="executarExemplo08(event)">Exemplo 08 - Canvas</button>
                </p>
            </div>
            
        </div>
        
        <hr>
        
        <div>
            <h1>Asincronia e Intercâmbio de Dados</h1>
            
            <div>
                <div id="divExemplo9"></div>
                <p>
                    <button onclick="executarExemplo09(event)">Exemplo 09 - Promises, async e await</button>
                </p>
            </div>
            
            <div>
                <div id="divExemplo10" class="divExemplo"></div>
                <p>
                    <button onclick="executarExemplo10(event)">Exemplo 10 - AJAX</button>
                </p>
            </div>
            
            <div>
                <div id="divExemplo11" class="divExemplo"></div>
                <p>
                    <button onclick="executarExemplo11(event)">Exemplo 11 - JSON</button>
                </p>
            </div>
            
        </div>
        
    </body>
</html>
