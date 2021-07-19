var contadorExemplo07 = 1;

function executarExemplo07( event ) {
    
    let div = $( "#divExemplo07" );
    let p = $( "<p></p>" )
            .html( `Contador: ${contadorExemplo07++}` )
            .addClass( "pDOM" );
    
    div.append( p );
    
}