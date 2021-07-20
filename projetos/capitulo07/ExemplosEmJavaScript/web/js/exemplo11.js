function executarExemplo11( event ) {
    
    let n = prompt( "Calcular a tabuada de:" );
    
                                 // objeto de configuração
            // URL                    |
    $.ajax( "calcularTabuada", { // <--
        data: {
            numero: n
        },
        dataType: "html"
        
        // se bem sucedido
    }).done( ( data, textStatus ) =>{
        $( "#divExemplo11" ).html( data );
        // se falhar
    }).fail( ( jqXHR, textStatus, errorThrown ) => {
        alert( "Erro: " + errorThrown + "\n" +
               "Status: " + textStatus );
    });
    
}