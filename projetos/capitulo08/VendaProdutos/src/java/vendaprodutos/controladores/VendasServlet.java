package vendaprodutos.controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vendaprodutos.dao.ItemVendaDAO;
import vendaprodutos.dao.ProdutoDAO;
import vendaprodutos.dao.VendaDAO;
import vendaprodutos.entidades.Cliente;
import vendaprodutos.entidades.ItemVenda;
import vendaprodutos.entidades.Produto;
import vendaprodutos.entidades.Venda;

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
        
        VendaDAO daoVenda = null;
        ItemVendaDAO daoItemVenda = null;
        ProdutoDAO daoProduto = null;
        RequestDispatcher disp = null;
        
        try {

            daoVenda = new VendaDAO();
            daoItemVenda = new ItemVendaDAO();
            daoProduto = new ProdutoDAO();

            if ( acao.equals( "inserir" ) ) {

                int idCliente = Integer.parseInt( 
                        request.getParameter( "idCliente" ) );
                String itensVenda = request.getParameter( "itensVenda" );
                System.out.println( itensVenda );
                
                Cliente c = new Cliente();
                c.setId( idCliente );
                
                Venda v = new Venda();
                v.setData( Date.valueOf( LocalDate.now() ) );
                v.setCancelada( false );
                v.setCliente( c );
                
                // ao salvar, venda receberá seu identificador
                daoVenda.salvar( v );

                // processando os itens de venda!
                for ( String item : itensVenda.split( "[|]" ) ) {
                    
                    System.out.println( item );
                    String[] dados = item.split( "[-]" );
                    
                    int idProduto = Integer.parseInt( dados[0] );
                    BigDecimal quantidade = new BigDecimal( dados[1] );
                    
                    Produto p = daoProduto.obterPorId( idProduto );
                    p.setEstoque( p.getEstoque().subtract( quantidade ) );
                    
                    ItemVenda iv = new ItemVenda();
                    iv.setVenda( v );
                    iv.setProduto( p );
                    iv.setValor( p.getValorVenda() );
                    iv.setQuantidade( quantidade );
                    
                    daoProduto.atualizar( p );
                    daoItemVenda.salvar( iv );
                    
                }
                
                disp = request.getRequestDispatcher(
                        "/formularios/vendas/listagem.jsp" );

            } else if ( acao.equals( "cancelar" ) ) {

                int idVenda = Integer.parseInt( 
                        request.getParameter( "idVenda" ) );
                
                Venda v = daoVenda.obterPorId( idVenda );
                v.setCancelada( true );
                daoVenda.atualizar( v );
                
                for ( ItemVenda iv : daoItemVenda.obterPorIdVenda( idVenda ) ) {
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
        } finally {
            if ( daoVenda != null ) {
                try {
                    daoVenda.fecharConexao();
                } catch ( SQLException exc ) {
                    exc.printStackTrace();
                }
            }
            if ( daoItemVenda != null ) {
                try {
                    daoItemVenda.fecharConexao();
                } catch ( SQLException exc ) {
                    exc.printStackTrace();
                }
            }
            if ( daoProduto != null ) {
                try {
                    daoProduto.fecharConexao();
                } catch ( SQLException exc ) {
                    exc.printStackTrace();
                }
            }
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
