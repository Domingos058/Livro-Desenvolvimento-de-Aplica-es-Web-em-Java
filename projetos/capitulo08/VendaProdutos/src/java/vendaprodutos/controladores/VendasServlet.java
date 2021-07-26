package vendaprodutos.controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vendaprodutos.dao.ClienteDAO;
import vendaprodutos.dao.ItemVendaDAO;
import vendaprodutos.dao.ProdutoDAO;
import vendaprodutos.dao.VendaDAO;
import vendaprodutos.entidades.Cliente;
import vendaprodutos.entidades.ItemVenda;
import vendaprodutos.entidades.Produto;
import vendaprodutos.entidades.Venda;
import vendaprodutos.utils.Utils;

/**
 * Servlet para tratar Vendas.
 *
 * @author Prof. Dr. David Buzatto
 */
@WebServlet( name = "VendasServlet", 
             urlPatterns = { "/processaVendas" } )
public class VendasServlet extends HttpServlet {

    protected void processRequest( 
            HttpServletRequest request, 
            HttpServletResponse response )
            throws ServletException, IOException {
        
        String acao = request.getParameter( "acao" );
        RequestDispatcher disp = null;
        
        try ( VendaDAO daoVenda = new VendaDAO();
              ClienteDAO daoCliente = new ClienteDAO();
              ItemVendaDAO daoItemVenda = new ItemVendaDAO();
              ProdutoDAO daoProduto = new ProdutoDAO() ) {

            if ( acao.equals( "inserir" ) ) {

                Long idCliente = Utils.getLong( request, "idCliente" );
                String itensVenda = request.getParameter( "itensVenda" );
                
                Cliente c = daoCliente.obterPorId( idCliente );
                
                Venda v = new Venda();
                v.setData( Date.valueOf( LocalDate.now() ) );
                v.setCancelada( false );
                v.setCliente( c );
                
                Utils.validar( v, "id" );
                daoVenda.salvar( v );

                // processando os itens de venda!
                // cada item da venda é separado por um pipe
                for ( String item : itensVenda.split( "[|]" ) ) {
                    
                    String[] dados = item.split( "[-]" );
                    
                    Long idProduto = Utils.getLong( dados[0] );
                    BigDecimal quantidade = new BigDecimal( dados[1] );
                    
                    // obtém o produto e atualiza o estoque
                    Produto p = daoProduto.obterPorId( idProduto );
                    p.setEstoque( p.getEstoque().subtract( quantidade ) );
                    
                    // cria um item da venda
                    ItemVenda iv = new ItemVenda();
                    iv.setVenda( v );
                    iv.setProduto( p );
                    iv.setValor( p.getValorVenda() );
                    iv.setQuantidade( quantidade );
                    
                    // não validaremos o produto, pois
                    // permitiremos estoque negativo na venda
                    daoProduto.atualizar( p );
                    daoItemVenda.salvar( iv );
                    
                }
                
                disp = request.getRequestDispatcher(
                        "/formularios/vendas/listagem.jsp" );

            } else if ( acao.equals( "cancelar" ) ) {

                Long id = Utils.getLong( request, "id" );
                
                Venda v = daoVenda.obterPorId( id );
                v.setCancelada( true );
                daoVenda.atualizar( v );
                
                for ( ItemVenda iv : daoItemVenda.obterPorIdVenda( id ) ) {
                    Produto p = iv.getProduto();
                    p.setEstoque( p.getEstoque().add( iv.getQuantidade() ) );
                    daoProduto.atualizarEstoque( p );
                }
                
                response.setContentType( "text/json;charset=UTF-8" );
                
                try ( PrintWriter out = response.getWriter() ) {
                    out.print( "{ \"status\": true }" );
                }

            }

        } catch ( SQLException exc ) {
            exc.printStackTrace();
        }

        if ( disp != null ) {
            disp.forward( request, response );
        }
        
    }

    @Override
    protected void doGet( 
            HttpServletRequest request, 
            HttpServletResponse response )
            throws ServletException, IOException {
        processRequest( request, response );
    }

    @Override
    protected void doPost( 
            HttpServletRequest request, 
            HttpServletResponse response )
            throws ServletException, IOException {
        processRequest( request, response );
    }

    @Override
    public String getServletInfo() {
        return "ProdutosServlet";
    }

}
