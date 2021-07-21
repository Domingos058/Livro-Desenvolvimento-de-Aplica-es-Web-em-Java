function executarExemplo12( event ) {
    
    let q = prompt( "Quantidade de pessoas:" );
    
    $.ajax( "listarPessoas", {
        data: {
            quantidade: q
        },
        dataType: "json"
    }).done( ( data, textStatus ) =>{
        
        let $div = $( "#divExemplo12" );
        $div.html( "" );
        
        // data chega como json e é 
        // processado para gerar um objeto
        // (automaticamente)
        
        data.forEach( pessoa => {
            let t = `<div class="dadosPessoa">Pessoa:<p>Nome: ${pessoa.nome}</p>` +
                    `<p>Data de Nascimento: ${pessoa.dataNasc}</p>` +
                    `<p>Salário: R$ ${pessoa.salario}</p></div>`;
            $div.append( t );
        });
        
    }).fail( ( jqXHR, textStatus, errorThrown ) => {
        alert( "Erro: " + errorThrown + "\n" +
               "Status: " + textStatus );
    });
    
}