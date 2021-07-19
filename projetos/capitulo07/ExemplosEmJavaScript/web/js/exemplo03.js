function executarExemplo03( event ) {
    
    let v0 = 0;
    let v1 = 2;
    let v2 = "2";
    let v3 = true;
    let v4 = null;
    let v5 = undefined;
    let v6 = NaN; // Not a Number
    
    // 0 vira false!
    if ( v0 ) {
        console.log( "não devia chegar aqui" )  // ; não obrigatório,
                                                // mas é padrão usar
    }
    
    if ( v1 ) {
        console.log( "aqui sim :)" );
    }
    
    // converte os tipos e testa igualdade de valor!
    if ( v1 == v2 ) {
        console.log( "como assim???" );
    }
    
    // mesmo tipo e mesmo valor!
    if ( v1 === v2 ) {
        console.log( "aqui não!" );
    }
    
    if ( v3 ) {
        console.log( "óbvio!" );
    }
    
    if ( v4 ) {
        console.log( "não!" );
    }
    
    if ( v5 ) {
        console.log( "não tbm!" );
    }
    
    if ( v6 ) {
        console.log( "não tbm!" );
    }
    
    if ( v6 == NaN ) {
        console.log( "pq não?" );
    }
    
    if ( v6 === NaN ) {
        console.log( "uai!?" );
    }
    
    if ( isNaN( NaN ) ) {
        console.log( "pra NaN, só assim..." );
    }
    
    // 0, false (óbvio), null e undefined
    // são avaliados como falso
    
    switch ( v1 ) {
        case 1:
            console.log( "v1 vale 1" );
            break;
        case 2:
            console.log( "v1 vale 2" );
            break;
        default:
            console.log( "v1 vale alguma coisa..." );
            break;
    }
    
    // sem conversão automática!
    switch ( v1 ) {
        case "1":
            console.log( "v1 vale 1" );
            break;
        case "2":
            console.log( "v1 vale 2" );
            break;
        default:
            console.log( "v1 vale alguma coisa..." );
            break;
    }
    
    switch ( v2 ) {
        case "1":
            console.log( "v2 vale \"1\"" );
            break;
        case "2":
            console.log( "v2 vale \"2\"" );
            break;
        default:
            console.log( "v2 vale alguma coisa..." );
            break;
    }
    
}