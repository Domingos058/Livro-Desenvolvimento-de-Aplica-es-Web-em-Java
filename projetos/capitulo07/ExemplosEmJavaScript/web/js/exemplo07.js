var contadorExemplo07 = 1;

function executarExemplo07( event ) {
    
    // selecionada a div com id divExemplo07
    // a jQuery usa a sintaxe os seletores do CSS
    let div = $( "#divExemplo07" );
    
    // cria um novo elemento do tipo p (tag <p>)
    // e configura os atributos
    let p = $( "<p></p>" )
            .html( `Contador: ${contadorExemplo07++}` )
            .addClass( "pDOM" );
    
    // adiciona na div
    div.append( p );
    
}