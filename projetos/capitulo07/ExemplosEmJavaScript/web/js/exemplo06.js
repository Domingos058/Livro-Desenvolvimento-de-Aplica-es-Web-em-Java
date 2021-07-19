var contadorExemplo06 = 1;

function executarExemplo06( event ) {
    
    let div = document.getElementById( "divExemplo06" );
    let p = document.createElement( "p" );
    p.innerHTML = `Contador: ${contadorExemplo06++}`;
    p.className = "pDOM";
    
    div.append( p );
    
}