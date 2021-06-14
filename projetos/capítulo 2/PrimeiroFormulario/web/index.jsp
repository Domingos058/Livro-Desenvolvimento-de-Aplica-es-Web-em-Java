<%-- 
    Document   : index
    Created on : 10/01/2011, 12:19:40
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Meu Primeiro Formulário</title>
    </head>

    <body>

        <h1>Dados Pessoais do Cliente</h1>

        <form method="post"
              action="http://localhost:8084/PrimeiroFormulario/processaDadosCliente">
            
            <label>Nome: </label>
            <input type="text" size="20" name="nome"/>
            <br/>
            
            <label>Sobrebome: </label>
            <input type="text" size="20" name="sobrenome"/>
            <br/>
            
            <label>CPF: </label>
            <input type="text" size="15" name="cpf"/>
            <br/>
            
            <label>Data de Nascimento: </label>
            <input type="text" size="10" name="dataNasc"/>
            <br/>
            
            <label>Sexo: </label>
            <input type="radio" name="sexo" value="M"/> Masculino
            <input type="radio" name="sexo" value="F"/> Feminino
            <br/>
            
            <label>Observações: </label>
            <br/>
            <textarea cols="40" rows="10" name="observacoes"></textarea>
            <br/>

            <input type="submit" value="Enviar Dados"/>
            
        </form>

    </body>

</html>
