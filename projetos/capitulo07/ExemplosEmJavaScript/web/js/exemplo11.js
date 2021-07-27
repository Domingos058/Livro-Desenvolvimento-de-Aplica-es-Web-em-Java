function executarExemplo11jQuery( event ) {
    
    let n = prompt( "Calcular a tabuada de:" );
    
    $.ajax( "calcularTabuada", {
        data: {
            numero: n
        },
        dataType: "text"
    }).done( ( data, textStatus ) =>{
        $( "#divExemplo11" ).html( data );
    }).fail( ( jqXHR, textStatus, errorThrown ) => {
        alert( "Erro: " + errorThrown + "\n" +
               "Status: " + textStatus );
    });
    
}

function executarExemplo11Fetch( event ) {
    
    let n = prompt( "Calcular a tabuada de:" );
    
    let parametros = new URLSearchParams();
    parametros.append( "numero", n );
    
    fetch( "calcularTabuada", {
        method: "POST",
        body: parametros
    }).then( response => {
        return response.text();
    }).then( text => {
        $( "#divExemplo11" ).html( text );
    }).catch( error => {
        alert( "Erro: " + error );
    });
    
}