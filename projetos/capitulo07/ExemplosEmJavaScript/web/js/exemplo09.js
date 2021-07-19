function registrarEventosExemplo09() {
    
    // JavaScript puro
    document.getElementById( "campoExemplo09" ).onkeydown = event => {
        console.log( `Digitou '${event.key}'` );
    };
    
    // jQuery
    $( "#selectExemplo09" ).on( "change", function( event ) {
        // nesse conexto, this é a mesma coisa que event.target
        // ou seja, o elemento que disparou o evento
        let select = $( this );
        alert( `Valor: ${select.val()}` );
    });
    
}