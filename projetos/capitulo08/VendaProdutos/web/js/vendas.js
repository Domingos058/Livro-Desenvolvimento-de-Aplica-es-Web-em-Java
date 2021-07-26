/**
 * Implementação das funções dor formulários de venda.
 */

// on document ready (quando o documento estiver pronto)
$( () => {
    
    // array para armazenar os itens da venda
    let itensVenda = [];
    
    // formatadores
    let fmtMoeda = new Intl.NumberFormat( 
        "pt-BR", {
            style: "currency",
            currency: "BRL"
        }
    );
    let fmtNumero = new Intl.NumberFormat( 
        "pt-BR", {
            minimumFractionDigits: 2,
            maximumFractionDigits: 2
        }
    );
    
    
    $( "#btnInserir" ).on( "click", event => {
        
        let $selectProduto = $( "#selectProduto" );
        let $txtQuantidade = $( "#txtQuantidade" );
        
        let idProduto = $selectProduto.val();
        let valorVenda = $selectProduto.find( ":selected" ).data( "valor" );
        let descricao = $selectProduto.find( ":selected" ).data( "descricao" );
        let quantidade = Number( $txtQuantidade.val() );
        
        if ( quantidade !== 0 ) {
            
            // há um item da venda igual?
            let itemIgual = null;
            itensVenda.some( item => {
                if ( item.idProduto === idProduto ) {
                    itemIgual = item;
                    return true; // para a iteração
                }
            });
            
            if ( itemIgual !== null ) {
                // soma a quantidade
                itemIgual.quantidade += quantidade;
            } else {
                itensVenda.push({
                    idProduto: idProduto,
                    valorVenda: valorVenda,
                    descricao: descricao,
                    quantidade: quantidade
                });
            }
            
            montarSelectItensVenda();
            $txtQuantidade.val( "" );
            
        } else {
            alert( "Forneça uma quantidade!" );
        }
        
    });
    
    $( "#btnRemover" ).on( "click", event => {
        
        let $select = $( "#selectItensVenda" );
        let itemSelecionado = $select.prop( "selectedIndex" );
        
        if ( itemSelecionado === -1 ) {
            alert( "Selecione um item da venda para remover!" );
        } else if ( confirm( "Deseja remover o item da venda selecionado?" ) ) {
            itensVenda.splice( itemSelecionado, 1 );
            montarSelectItensVenda();
        }
        
    });
    
    $( "#btnLimpar" ).on( "click", event => {
        if ( confirm( "Deseja remover todos os itens da venda?" ) ) {
            $( "#selectItensVenda" ).html( "" );
            itensVenda = [];
            montarSelectItensVenda();
        }
    });
    
    $( "#formNovaVenda" ).on( "submit", event => {
        
        if ( $( "#selectItensVenda > option" ).length === 0 ) {
            alert( "Uma venda precisa conter pelo menos um item!" );
            return false;
        }
        
        return true;
    });
    
    // evita que, ao teclar enter dentro do campo
    // de texto, o formulário seja submetido
    $( "#txtQuantidade" ).on( "keydown", event => {
        if ( event.keyCode === 13 ) {
            event.preventDefault();
        }
    });
    
    let montarSelectItensVenda = () => {
        
        let $select = $( "#selectItensVenda" );
        let total = 0;
        let primeiro = true;
        let valorHidden = "";
        
        $select.html( "" );
        
        for ( let k in itensVenda ) {
            
            let item = itensVenda[k];
            let idProduto = item.idProduto;
            let valorVenda = item.valorVenda;
            let descricao = item.descricao;
            let quantidade = item.quantidade;
            let valorItem = Number( valorVenda ) * Number( quantidade );
            
            $opt = $( "<option></option>" ).
                    html( `${descricao} - ` + 
                    `${fmtMoeda.format( valorVenda )} x ` + 
                    `${fmtNumero.format(quantidade)} = ` + 
                    `${fmtMoeda.format( valorItem )}` ).
                    val( `${idProduto}-${quantidade}` );
            
            $select.append( $opt );
            total += valorItem;
            
            // montando os valores do campo escondido
            if ( !primeiro ) {
               valorHidden += "|";
            }
            valorHidden += `${idProduto}-${quantidade}`;
            primeiro = false;
            
        }
        
        $( "#divTotal" ).html( "Total: " + fmtMoeda.format( total ) );
        $( "#hiddenItensVenda" ).val( valorHidden );
        
    };
    
});
