function executarExemplo04( event ) {
    
    // um array de uma dimensão
    let a1 = [ 1, 2, 3, 4 ];
    
    // um array de arrays
    let a2 = [ [ 1, 2 ], [ 3, 4 ] ];
    
    // um array vazio
    let a3 = [];
    a3["a"] = 2; // array associativo!
    a3["b"] = 4; // análogo à uma tabela de símbolos
    a3["c"] = 6;
    a3["d"] = 8;
    
    // arrays em JavaScript podem crescer e diminuir
    // livremente usando os métodos:
    //      push (insere no fim)
    //       pop (remove do fim)
    //   unshift (insere no início)
    //     shift (remove do início)
    //    splice (remove de uma posição fornecida)
    
    for ( let i = 0; i < a1.length; i++ ) {
        console.log( `a1[${i}] = ${a1[i]}` );
    }
    
    // iterando usando a função forEach do
    // objeto Array
    a1.forEach( function( valor, indice ) {
        console.log( `a1[${indice}] = ${valor}` );
    });
    
    for ( let i = 0; i < a2.length; i++ ) {
        console.log( `a2[${i}] = ${a2[i]}` );
    }
    
    // notação de closure
    a2.forEach( ( valor, indice ) => {
        console.log( `a2[${indice}] = ${valor}` );
    });
    
    // arrays associativos não têm tamanho!
    for ( let i = 0; i < a3.length; i++ ) {
        // não entra aqui...
        console.log( `a3[${i}] = ${a3[i]}` );
    }
    
    for ( let chave in a3 ) {
        console.log( `a3[${chave}] = ${a3[chave]}` );
    }
    
    // ou
    Object.keys( a3 ).forEach( chave => {
        console.log( `a3[${chave}] = ${a3[chave]}` );
    });
    
    // while e do while são análogos a C, C++, Java etc.
    
}