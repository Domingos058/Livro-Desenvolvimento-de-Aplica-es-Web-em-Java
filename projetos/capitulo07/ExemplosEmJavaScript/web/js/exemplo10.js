function prepararCanvasExemplo10() {
    
    class Bolinha {
        
        // x e y são os centros da bolinha
        constructor( x, y, velocidadeX, velocidadeY, raio, cor ) {
            this.x = x;
            this.y = y;
            this.raio = raio;
            this.cor = cor;
            this.velocidadeX = velocidadeX;
            this.velocidadeY = velocidadeY;
            this.elasticidade = 0.9;
            this.atrito = 0.99;
            this.emArraste = false;
        }
        
        desenhar( ctx ) {
            ctx.fillStyle = this.cor;
            ctx.beginPath();
            ctx.arc( this.x, this.y, this.raio, 0, 2 * Math.PI );
            ctx.fill();
        }
        
        mover() {
            
            if ( !this.emArraste ) {
                
                this.x += this.velocidadeX * this.atrito;
                this.y += this.velocidadeY * this.atrito;

                if ( this.x + this.raio > larguraCanvas ) {
                    this.x = larguraCanvas - this.raio;
                    this.velocidadeX = -this.velocidadeX * this.elasticidade;
                }

                if ( this.x - this.raio < 0 ) {
                    this.x = this.raio;
                    this.velocidadeX = -this.velocidadeX * this.elasticidade;
                }

                if ( this.y + this.raio > alturaCanvas ) {
                    this.y = alturaCanvas - this.raio;
                    this.velocidadeY = -this.velocidadeY * this.elasticidade;
                }

                if ( this.y - this.raio < 0 ) {
                    this.y = this.raio;
                    this.velocidadeY = -this.velocidadeY * this.elasticidade;
                }

                this.velocidadeX *= this.atrito;
                this.velocidadeY *= this.atrito;
                this.velocidadeY += gravidade;
            
            }
            
        }
        
        intercepta( x, y ) {
            return Math.hypot( this.x - x, this.y - y ) <= this.raio;
        }
        
        gerarNovaVelocidade() {
            this.velocidadeX = gerarVelocidadeAleatoria( -30, 30 );
            this.velocidadeY = gerarVelocidadeAleatoria( -30, 30 );
        }
        
    }
    
    let canvas = document.getElementById( "canvasExemplo10" );
    let context = canvas.getContext( "2d" );
    let larguraCanvas = canvas.width;
    let alturaCanvas = canvas.height;
    
    let dx;
    let dy;
    let xAntigo;
    let yAntigo;
    let gravidade = 1;
    
    let bolinha = new Bolinha( 
            larguraCanvas / 2,
            alturaCanvas / 2,
            2.0,
            2.0,
            10, 
            "rgb(0,0,0)" );
    let bolinhaEmArraste = null;
    let bolinhas = [ bolinha ];
    
    setInterval( () => {
        context.clearRect( 0, 0, larguraCanvas, alturaCanvas );
        bolinhas.forEach( bolinha => {
            bolinha.mover();
            bolinha.desenhar( context );
        });
    }, 10 );
    
    canvas.onmousedown = event => {
        
        // botão esquerdo
        if ( event.button === 0 ) {
        
            for ( let i = bolinhas.length - 1; i >= 0; i-- ) {
                let bolinha = bolinhas[i];
                if ( bolinha.intercepta( event.offsetX, event.offsetY ) ) {
                    bolinha.emArraste = true;
                    dx = event.offsetX - bolinha.x;
                    dy = event.offsetY - bolinha.y;
                    bolinhaEmArraste = bolinha;
                    break;
                }
            }

            if ( bolinhaEmArraste === null ) {

                let novaBolinha = new Bolinha( 
                        event.offsetX,
                        event.offsetY,
                        gerarVelocidadeAleatoria( -3, 3 ),
                        2.0,
                        5 + Math.random() * 10, 
                        gerarCorAleatoria() );

                bolinhas.push( novaBolinha );

            }
            
        } else {
            bolinhas.forEach( bolinha => {
                bolinha.gerarNovaVelocidade();
            });
        }
        
    };
    
    canvas.onmouseup = event => {
        if ( bolinhaEmArraste !== null ) {
            bolinhaEmArraste.emArraste = false;
            bolinhaEmArraste = null;
        }
    };
    
    canvas.onmouseout = event => {
        if ( bolinhaEmArraste !== null ) {
            bolinhaEmArraste.emArraste = false;
            bolinhaEmArraste = null;
        }
    };
    
    canvas.onmousemove = event => {
        
        if ( bolinhaEmArraste !== null ) {
            xAntigo = bolinhaEmArraste.x;
            yAntigo = bolinhaEmArraste.y;
            bolinhaEmArraste.x = event.offsetX - dx;
            bolinhaEmArraste.y = event.offsetY - dy;
            bolinhaEmArraste.velocidadeX = ( bolinhaEmArraste.x - xAntigo ) / 2;
            bolinhaEmArraste.velocidadeY = ( bolinhaEmArraste.y - yAntigo ) / 2;
        }
        
    };
    
    // esconde o menu de contexto no clique
    // com o botão direito
    canvas.oncontextmenu = event => {
        // quebra a cadeia de propagação do evento
        event.preventDefault();
    };
    
}

function gerarCorAleatoria() {
    
    let r = Math.trunc( Math.random() * 256 );
    let g = Math.trunc( Math.random() * 256 );
    let b = Math.trunc( Math.random() * 256 );
    
    return `rgb(${r},${g},${b})`;
    
}

function gerarVelocidadeAleatoria( minimo, maximo ) {
    return minimo + Math.random() * ( maximo - minimo );
}