class Forma {
    
    // só pode haver um construtor
    constructor( xIni, yIni, xFim, yFim ) {
        this.xIni = xIni;
        this.yIni = yIni;
        this.xFim = xFim;
        this.yFim = yFim;
    }
    
    calcularArea() {
        return 0;
    }
    
}

class Retangulo extends Forma {
    
    calcularArea() {
        let largura = Math.abs( this.xFim - this.xIni );
        let altura = Math.abs( this.yFim - this.yIni );
        return largura * altura;
    }
    
}

class Circulo extends Forma {
    
    constructor( xCentro, yCentro, raio ) {
        super( xCentro, yCentro, 0, 0 );
        this.raio = raio;
    }
    
    calcularArea() {
        return Math.PI * this.raio * this.raio;
    }
    
}

function executarExemplo05( event ) {
    
    let r = new Retangulo( 0, 0, 10, 20 );
    let c = new Circulo( 5, 10, 10 );
    
    console.log( r );
    console.log( r.calcularArea() );
    
    r.xIni = 5;
    console.log( r );
    console.log( r.calcularArea() );
    
    
    console.log( c );
    console.log( c.calcularArea() );
    
    c.raio = 5;
    console.log( c );
    console.log( c.calcularArea() );
    
}